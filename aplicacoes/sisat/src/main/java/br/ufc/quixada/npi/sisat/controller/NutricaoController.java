package br.ufc.quixada.npi.sisat.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.model.Attachment;
import br.ufc.quixada.npi.model.Email;
import br.ufc.quixada.npi.service.EmailService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.model.Papel;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.sisat.service.PapelService;
import br.ufc.quixada.npi.sisat.service.PessoaService;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {

	@Inject
	private PessoaService pessoaService;

	@Inject
	private ConsultaNutricionalService consultaNutricionalService;

	@Inject
	private DocumentoService documentoService;

	@Inject
	private EmailService emailService;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private PacienteService pacienteService;

	@Inject
	private PapelService papelService;

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String paginaBuscarPaciente(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		String cpf = SecurityContextHolder.getContext().getAuthentication().getName();

		Pessoa pessoa = registrarNutricionista(cpf);

		if (pessoa == null) {
			redirectAttributes.addFlashAttribute("info", "Usuario não encontrado.");
			return "redirect:/j_spring_security_logout";
		}

		return "nutricao/buscar";
	}

	@RequestMapping(value = "/informacoes-graficas", method = RequestMethod.GET)
	public String paginaInformacoesGraficas() {
		consultaNutricionalService.getFrequenciaPatologia();
		return "nutricao/informacoes-graficas";
	}

	@RequestMapping(value = "/informacoes-graficas/paciente/{cpf}/historico-peso.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model getPesoByConsulta(Model model, @PathVariable("cpf") String cpf) {
		
		List<ConsultaNutricional> consultas = pacienteService.getHistoricoPeso(cpf);

		model.addAttribute("pesos", consultas);

		return model;
	}

	@RequestMapping(value = "/informacoes-graficas/patologias-frequentes.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model getPatologiasFrequentes(Model model) {
		model.addAttribute("patologias", consultaNutricionalService.getFrequenciaPatologia());
		return model;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@RequestParam("busca") String busca, ModelMap map,
			RedirectAttributes redirectAttributes, Authentication authentication) {
		map.addAttribute("busca", busca);
		List<Usuario> usuarios = usuarioService.getByCpfOrNome(busca);
		Usuario usuario = usuarioService.getByCpf(authentication.getName());
		usuarios.remove(usuario);

		if (!usuarios.isEmpty()) {
			map.addAttribute("pessoas", usuarios);
		} else {
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		return "/nutricao/buscar";
	}

	@RequestMapping(value = "/frequencia-alimentar.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Set<FrequenciaAlimentar> getFrequencias(@RequestParam("id") Long id) {
		if (id != null) {
			Set<FrequenciaAlimentar> frequenciaAlimentars = new HashSet<FrequenciaAlimentar>();
			frequenciaAlimentars = consultaNutricionalService.getConsultaNutricionalWithFrequenciasById(id)
					.getFrequencias();
			return frequenciaAlimentars;
		}
		return null;
	}

	@RequestMapping(value = { "{idConsulta}/paciente/{cpf}/deletarDocumento/{id}" }, method = RequestMethod.GET)
	public String deletarDocumento(@PathVariable("idConsulta") Long idConsulta, @PathVariable("cpf") String cpf,
			@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		Documento documento = documentoService.find(Documento.class, id);
		documento.setConsultaNutricional(null);
		documentoService.delete(documento);
		redirectAttributes.addFlashAttribute("info", "Documento deletado com sucesso.");

		return "redirect:/consulta/editar-consulta/" + idConsulta + "/paciente/" + cpf;
	}

	@RequestMapping(value = { "enviarDocumento/{id}/{mensagem}" }, method = RequestMethod.GET)
	public String enviarDocumento(@PathVariable("id") Long id, @PathVariable("mensagem") String mensagem,
			RedirectAttributes redirectAttributes) {
		Documento documento = documentoService.find(Documento.class, id);
		Pessoa p = documento.getConsultaNutricional().getPaciente().getPessoa();

		final Email email = new Email();
		email.setFrom("nutricao@quixada.ufc.br");
		email.setTo(p.getEmail());
		email.setText(mensagem);
		Attachment anexo = new Attachment();
		anexo.setData(documento.getArquivo());
		anexo.setFilename(documento.getNome());
		anexo.setMimeType(documento.getTipo());
		email.addAttachment(anexo);
		email.setSubject("não-responda [Envio de documento]");

		Runnable enviarEmail = new Runnable() {

			@Override
			public void run() {

				try {
					emailService.sendEmail(email);
				} catch (MessagingException e) {
					System.out.println(e.getMessage());
				}

			}

		};

		Thread threadEnviarEmail = new Thread(enviarEmail);
		threadEnviarEmail.start();

		redirectAttributes.addFlashAttribute("success", "Documento enviado com sucesso");
		return "redirect:../../editarConsulta/" + documento.getConsultaNutricional().getId();
	}

	@RequestMapping(value = { "downloadDocumento/{id}" }, method = RequestMethod.GET)
	public HttpEntity<byte[]> downloadDocumento(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		Documento documento = documentoService.find(Documento.class, id);
		byte[] arquivo = documento.getArquivo();
		String[] tipo = documento.getTipo().split("/");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType(tipo[0], tipo[1]));
		headers.set("Content-Disposition", "attachment; filename=" + documento.getNome().replace(" ", "_"));
		headers.setContentLength(arquivo.length);

		redirectAttributes.addFlashAttribute("success", "Download do Documento realizado com sucesso");
		return new HttpEntity<byte[]>(arquivo, headers);

	}

	private Pessoa registrarNutricionista(String cpf) {
		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);

		if (pessoa == null) {
			Usuario usuario = usuarioService.getByCpf(cpf);

			if (usuario != null) {
				Papel papel = papelService.getPapel("ROLE_NUTRICAO");

				pessoa = new Pessoa(cpf);
				pessoa.setPapeis(new ArrayList<Papel>());
				pessoa.getPapeis().add(papel);
				pessoaService.save(pessoa);

				return pessoa;
			} else {
				return null;
			}
		}
		return pessoa;
	}

}
