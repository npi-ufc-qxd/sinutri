package br.ufc.quixada.npi.sisat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Alimentacao;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.model.enuns.ClassificacaoExame;
import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;
import br.ufc.quixada.npi.sisat.model.enuns.Refeicao;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaUrinario;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.sisat.validation.ConsultaNutricionalValidator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("consulta")
public class ConsultaController {

	@Inject
	private PessoaService pessoaService;

	@Inject
	private ConsultaNutricionalService consultaNutricionalService;

	@Inject
	private PacienteService pacienteService;

	@Inject
	private DocumentoService documentoService;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ConsultaNutricionalValidator consultaNutricionalValidator;

	@Inject
	private GenericService<FrequenciaAlimentar> frequenciaAlimentarService; 

	@Inject
	private GenericService<Alimentacao> alimentacaoService; 

	@RequestMapping(value = "historico-paciente/{cpf}", method = RequestMethod.GET)
	public String getPaginaHistorico(@PathVariable("cpf") String cpf, Model model,
			RedirectAttributes redirectAttributes) {

		Pessoa pessoa = registrarPaciente(cpf);

		if (pessoa == null) {
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("pessoa", pessoa);

		return "nutricao/historico-paciente";
	}

	@RequestMapping(value = { "informacoes-consulta/{id}" }, method = RequestMethod.GET)
	public String getPaginaInformacoesConsulta(@PathVariable("id") Long id, Model model,
			RedirectAttributes redirectAttributes) {
		ConsultaNutricional consulta = consultaNutricionalService
				.getConsultaNutricionalWithDocumentosAndFrequenciasById(id);

		if (consulta == null) {
			redirectAttributes.addFlashAttribute("erro", "Consulta não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("consulta", consulta);
		return "nutricao/informacoes-consulta";
	}

	@RequestMapping(value = "realizar-consulta/{cpf}", method = RequestMethod.GET)
	public String getPaginaRealizarConsulta(@PathVariable("cpf") String cpf, Model model,
			RedirectAttributes redirectAttributes) {

		model.addAttribute("action", "cadastrar");

		Pessoa pessoa = registrarPaciente(cpf);

		if (pessoa == null) {
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
			return "redirect:/nutricao/buscar";
		}

		ConsultaNutricional consulta = new ConsultaNutricional();
		Paciente paciente = pessoa.getPaciente();
		consulta.setPaciente(paciente);

		model.addAttribute("consultaNutricional", new ConsultaNutricional(pessoa.getPaciente()));
		model.addAttribute("sistemaGastrointestinal", SistemaGastrointestinal.values());
		model.addAttribute("classificacaoExames", ClassificacaoExame.values());
		model.addAttribute("sistemaUrinario", SistemaUrinario.values());
		model.addAttribute("classificacao", ClassificacaoExame.values());
		model.addAttribute("frequencia", Frequencia.values());
		model.addAttribute("refeicoes", Refeicao.values());

		return "nutricao/form-consulta";
	}

	@RequestMapping(value = { "realizar-consulta/{cpf}" }, method = RequestMethod.POST)
	public String salvarConsulta(@PathVariable("cpf") String cpf, @Valid ConsultaNutricional consulta, Model model,  
			BindingResult result, RedirectAttributes redirectAttributes,
			@RequestParam("files") List<MultipartFile> files,
			@RequestParam(value = "enviar", required = false) boolean enviar) {

		model.addAttribute("action", "cadastrar");

		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);

		if (pessoa == null) {
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
			return "redirect:/nutricao/buscar";
		}

		Paciente paciente = pessoa.getPaciente();
		consulta.setPaciente(paciente);

		consultaNutricionalValidator.validate(consulta, result);
		if (result.hasErrors()) {
			model.addAttribute("consultaNutricional", consulta);
			return ("nutricao/form-consulta");
		}

		Double altura = consulta.getAltura();
		Date data = new Date(System.currentTimeMillis());
		consulta.setData(data);
		consulta.getPaciente().setAlturaAtual(altura);
		consulta.getPaciente().setCircunferenciaCinturaAtual(consulta.getCircunferenciaCintura());
		consulta.getPaciente().setPesoAtual(consulta.getPeso());

		Set<Documento> documentos = new HashSet<Documento>();
		if (files != null && !files.isEmpty() && files.get(0).getSize() > 0) {

			for (MultipartFile mfiles : files) {
				try {
					if (mfiles.getBytes() != null && mfiles.getBytes().length != 0) {
						Documento documento = new Documento();
						documento.setArquivo(mfiles.getBytes());
						documento.setNome(mfiles.getOriginalFilename());
						documento.setTipo(mfiles.getContentType());
						documento.setEnviar(enviar);
						documento.setConsultaNutricional(consulta);
						documento.setData(new Date());
						documentos.add(documento);
					}
				} catch (IOException e) {
					model.addAttribute("erro", "Não foi possivel salvar os documentos.");
					return ("nutricao/form-consulta");
				}
			}

			if (!documentos.isEmpty()) {
				consulta.setDocumentos(documentos);
			}
		} else {
			model.addAttribute("anexoError", "Adicione anexo a seleção");
		}

		if (consulta.getAgua().equals(0)) {
			consulta.setAgua(null);
		}
		if (consulta.getMedicamentoComentario() != null && consulta.getMedicamentoComentario().isEmpty()) {
			consulta.setMedicamentoComentario(null);
		}
		if (consulta.getMastigacaoComentario() != null && consulta.getMastigacaoComentario().isEmpty()) {
			consulta.setMastigacaoComentario(null);
		}
		if (consulta.getAlergiaComentario() != null && consulta.getAlergiaComentario().isEmpty()) {
			consulta.setAlergiaComentario(null);
		}
		if (consulta.getCarneVermelhaComentario() != null && consulta.getCarneVermelhaComentario().isEmpty()) {
			consulta.setCarneVermelhaComentario(null);
		}
		if (consulta.getAtividadeFisicaComentario() != null && consulta.getAtividadeFisicaComentario().isEmpty()) {
			consulta.setAtividadeFisicaComentario(null);
		}
		if (consulta.getBebidaAlcoolicaComentario() != null && consulta.getBebidaAlcoolicaComentario().isEmpty()) {
			consulta.setBebidaAlcoolicaComentario(null);
		}

		atualizarFrequenciaAlimentar(consulta.getFrequencias(), consulta);
		
		consultaNutricionalService.save(consulta);

		redirectAttributes.addFlashAttribute("success",
				"Consulta de <strong>id = " + consulta.getId() + "</strong> e paciente <strong>"
						+ consulta.getPaciente().getPessoa().getNome() + "</strong> realizada com sucesso.");

		return "redirect:/consulta/informacoes-consulta/" + consulta.getId();
	}

	@RequestMapping(value = { "/editar-consulta/{idConsulta}/paciente/{cpf}" }, method = RequestMethod.GET)
	public String editarConsulta(@PathVariable("idConsulta") long idConsulta, @PathVariable("cpf") String cpf,
			Model model) {

		ConsultaNutricional consultaNutricional = consultaNutricionalService
				.getConsultaNutricionalWithDocumentosById(idConsulta);

		List<Documento> documentosEnvio = documentoService.getDocumentosEnviar(idConsulta);

		List<Documento> documentosNutricionista = documentoService.getDocumentosNutricionista(idConsulta);

		model.addAttribute("action", "editar");
		model.addAttribute("documentosEnvio", documentosEnvio);
		model.addAttribute("documentosNutricionista", documentosNutricionista);
		model.addAttribute("consultaNutricional", consultaNutricional);
		model.addAttribute("sistemaGastrointestinal", SistemaGastrointestinal.values());
		model.addAttribute("classificacaoExames", ClassificacaoExame.values());
		model.addAttribute("sistemaUrinario", SistemaUrinario.values());
		model.addAttribute("classificacao", ClassificacaoExame.values());
		model.addAttribute("frequencia", Frequencia.values());
		model.addAttribute("refeicoes", Refeicao.values());

		return "nutricao/form-consulta";

	}

	@RequestMapping(value = { "/editar-consulta/{idConsulta}/paciente/{cpf}" }, method = RequestMethod.POST)
	public String editarConsulta(Model model, @Valid ConsultaNutricional consulta, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam("files") List<MultipartFile> files,
			@RequestParam(value = "enviar", required = false) boolean enviar) {
		model.addAttribute("action", "editar");

		Paciente paciente = pacienteService.find(Paciente.class, consulta.getPaciente().getId());
		consulta.setPaciente(paciente);

		consultaNutricionalValidator.validate(consulta, result);

		if (result.hasErrors()) {
			model.addAttribute("consultaNutricional", consulta);
			return ("nutricao/form-consulta");
		}

		Date data = consultaNutricionalService.find(ConsultaNutricional.class, consulta.getId()).getData();

		// verificar se os documentos foram anexados
		Set<Documento> documentos = new HashSet<Documento>();
		documentos = documentoService.getDocumentosByIdConsultaNutricional(consulta.getId());
		if (files != null && !files.isEmpty() && files.get(0).getSize() > 0) {

			for (MultipartFile mfiles : files) {
				try {
					if (mfiles.getBytes() != null && mfiles.getBytes().length != 0) {
						Documento documento = new Documento();
						documento.setArquivo(mfiles.getBytes());
						documento.setNome(mfiles.getOriginalFilename());
						documento.setTipo(mfiles.getContentType());
						documento.setEnviar(enviar);
						documento.setConsultaNutricional(consulta);
						documento.setData(new Date());
						documentos.add(documento);
					}
				} catch (IOException e) {
					model.addAttribute("erro", "Não foi possivel salvar os documentos.");
					return ("nutricao/form-consulta");
				}
			}

			if (!documentos.isEmpty()) {
				consulta.setDocumentos(documentos);
			}
		} else {
			model.addAttribute("anexoError", "Adicione anexo a seleção");
		}

		consulta.setData(data);
		
		if (consulta.getFrequencias() != null) {
			atualizarFrequenciaAlimentar(consulta.getFrequencias(), consulta);
		}

		consultaNutricionalService.update(atualizarConsulta(consulta));
		redirectAttributes.addFlashAttribute("success", "Consulta do paciente <strong>"
				+ consulta.getPaciente().getPessoa().getNome() + "</strong> atualizada com sucesso.");

		return "redirect:/consulta/informacoes-consulta/" + consulta.getId();
	}

	@RequestMapping(value = "/relatorio-orientacoes/{id}", method = RequestMethod.GET)
	public String relatorio(@PathVariable("id") Long id, Model model, HttpSession session) throws JRException {

		String orientacoesIndividuais = consultaNutricionalService.getOrientacoesIndividuaisById(id);
		String cpf = consultaNutricionalService.getPacientePessoaCpfById(id);
		String nome = usuarioService.getByCpf(cpf).getNome();
		String nutricionista = getUsuarioLogado(session).getNome();

		model.addAttribute("format", "pdf");
		model.addAttribute("orientacoesIndividuais", orientacoesIndividuais);
		model.addAttribute("paciente", nome);
		model.addAttribute("nutricionista", nutricionista);
		model.addAttribute("datasource", new JREmptyDataSource());

		return "orientacoesIndividuais";
	}

	@RequestMapping(value = { "{idConsulta}/excluir/refeicao/{idRefeicao}.json" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model deletarFrequenciaAlimentar(@PathVariable("idConsulta") Long idConsulta, @PathVariable("idRefeicao") Long idRefeicao, Model model, RedirectAttributes redirectAttributes) {
		FrequenciaAlimentar frequenciaAlimentar = frequenciaAlimentarService.find(FrequenciaAlimentar.class, idRefeicao);
		
		if(frequenciaAlimentar != null){
			frequenciaAlimentarService.delete(frequenciaAlimentar);
			model.addAttribute("sucesso", "sucesso");
		}

		return model;
	}

	@RequestMapping(value = { "{idConsulta}/excluir/alimento/{idAlimento}.json" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model deletarAlimento(@PathVariable("idConsulta") Long idConsulta, @PathVariable("idAlimento") Long idAlimento, Model model, RedirectAttributes redirectAttributes) {
		Alimentacao alimento = alimentacaoService.find(Alimentacao.class, idAlimento);

		if(alimento != null){
			alimento.getFrequenciaAlimentar().getAlimentos().remove(alimento);
			frequenciaAlimentarService.update(alimento.getFrequenciaAlimentar());
			model.addAttribute("sucesso", "sucesso");
		}

		return model;
	}
	private Pessoa registrarPaciente(String cpf) {
		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);

		if (pessoa == null) {
			Usuario usuario = usuarioService.getByCpf(cpf);

			if (usuario != null) {
				pessoa = new Pessoa(usuario.getCpf());

				pessoaService.save(pessoa);

				pessoa.setPaciente(new Paciente());
				pessoa.getPaciente().setPessoa(pessoa);
				pessoa.getPaciente().setAlturaAtual(1.0);
				pessoa.getPaciente().setCircunferenciaCinturaAtual(1.0);
				pessoa.getPaciente().setPesoAtual(1.0);

				pessoaService.update(pessoa);

				return pessoa;

			} else {

				return null;
			}
		}

		return pessoa;
	}

	private ConsultaNutricional atualizarConsulta(ConsultaNutricional consulta) {
		if (consulta.getDocumentos() != null) {
			for (Documento documento : consulta.getDocumentos()) {
				documento.setConsultaNutricional(consulta);
			}
		}
		return consulta;
	}

	private Pessoa getUsuarioLogado(HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			Pessoa pessoa = pessoaService .getPessoaByCpf(SecurityContextHolder.getContext().getAuthentication().getName());
			session.setAttribute("usuario", pessoa);
		}
		return (Pessoa) session.getAttribute("usuario");
	}

	private List<FrequenciaAlimentar> atualizarFrequenciaAlimentar(List<FrequenciaAlimentar> frequenciaAlimentars, ConsultaNutricional consultaNutricional) {
		List<FrequenciaAlimentar> frequencias = new ArrayList<FrequenciaAlimentar>();
		for (FrequenciaAlimentar frequenciaAlimentar : frequenciaAlimentars) {
			if (frequenciaAlimentar != null) {
				frequenciaAlimentar.setConsultaNutricional(consultaNutricional);
				frequenciaAlimentar.setAlimentos(atualizarAlimentacao(frequenciaAlimentar));
				frequencias.add(frequenciaAlimentar);
			}
		}
		return frequencias;
	}

	private List<Alimentacao> atualizarAlimentacao(FrequenciaAlimentar frequenciaAlimentar) {
		List<Alimentacao> alimentacaos = new ArrayList<Alimentacao>();
		for (Alimentacao alimentacao : frequenciaAlimentar.getAlimentos()) {
			if(alimentacao != null){
				alimentacao.setFrequenciaAlimentar(frequenciaAlimentar);
				alimentacaos.add(alimentacao);
			}
		}
		return alimentacaos;
	}
	
	
}
