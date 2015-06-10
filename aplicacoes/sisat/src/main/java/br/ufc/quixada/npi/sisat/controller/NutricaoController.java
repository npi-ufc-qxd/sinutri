package br.ufc.quixada.npi.sisat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.model.Attachment;
import br.ufc.quixada.npi.model.Email;
import br.ufc.quixada.npi.service.EmailService;
import br.ufc.quixada.npi.sisat.model.Alimentacao;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.model.enuns.Classificacao;
import br.ufc.quixada.npi.sisat.model.enuns.Refeicao;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.sisat.service.PessoaService;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {
	
	@Inject
	private PacienteService pacienteService;

	@Inject
	private PessoaService pessoaService;

	@Inject
	private ConsultaNutricionalService consultaNutricionalService;

	@Inject	
	private DocumentoService documentoService;

	@Inject
	private EmailService emailService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/buscar";
	}


	//Buscar paciente (get)
	@RequestMapping(value = {"/buscar"}, method = RequestMethod.GET)
	public String buscarPaciente(Model model, HttpSession session) {
		getUsuarioLogado(session);
		return "nutricao/buscar";
	}

	//Buscar paciente (post)
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@RequestParam("busca") String busca, ModelMap map, RedirectAttributes redirectAttributes, Authentication authentication) {
		map.addAttribute("busca", busca);
		List<Pessoa> pessoas = pessoaService.getPessoasByNomeOuCpf(busca);

		Pessoa pessoa = pessoaService.getPessoaByLogin(authentication.getName());;		

		pessoas.remove(pessoa);

		if(!pessoas.isEmpty()){
			map.addAttribute("pessoas", pessoas); 
		}else{
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		return "/nutricao/buscar";
	}


	@RequestMapping(value = "editarConsulta/{id}", method = RequestMethod.GET)
	public String editarConsulta(@PathVariable("id") long id, Model model) {
		ConsultaNutricional consultaNutricional = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
		List<Documento> documentosEnvio = documentoService.getDocumentosEnviar(id);
		List<Documento> documentosNutricionista = documentoService.getDocumentosNutricionista(id);
		model.addAttribute("documentosEnvio", documentosEnvio);
		model.addAttribute("documentosNutricionista", documentosNutricionista);
		model.addAttribute("action", "editar");
		model.addAttribute("consultaNutricional", consultaNutricional);
		Classificacao[] cla= Classificacao.values();
		model.addAttribute("classificacao", cla);		
		return "/nutricao/consulta";
	}
	
	
	@RequestMapping(value = {"/editarConsulta"}, method = RequestMethod.POST)
	public String editarConsulta(Model model, @Valid ConsultaNutricional consulta, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") List<MultipartFile> files, @RequestParam(value = "enviar", required = false) boolean enviar) {
		model.addAttribute("action", "editar");

		if (result.hasErrors()) {
			return ("nutricao/consulta");
		}		
		Paciente paciente = pacienteService.find(Paciente.class, consulta.getPaciente().getId());		
		Date data = consultaNutricionalService.find(ConsultaNutricional.class, consulta.getId()).getData();

		// verificar se os documentos foram anexados
		List<Documento> documentos = new ArrayList<Documento>();
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
					return ("nutricao/consulta");
				}
			}

			if(!documentos.isEmpty()){
				consulta.setDocumentos(documentos);
			}
		}else{
			model.addAttribute("anexoError", "Adicione anexo a seleção");					
		}

		consulta.setData(data);
		consulta.setPaciente(paciente);		

		consultaNutricionalService.update(atualizarConsulta(consulta));	
		redirectAttributes.addFlashAttribute("success", "Consulta do paciente <strong>" + consulta.getPaciente().getPessoa().getNome() + "</strong> atualizada com sucesso.");
		return "redirect:/nutricao/detalhes/" + consulta.getPaciente().getId();
	}

	@RequestMapping(value = "/frequencia-alimentar.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FrequenciaAlimentar> getFrequencias(HttpServletRequest request) {
		long id = Long.parseLong(request.getParameter("id"));
		List<FrequenciaAlimentar> frequenciaAlimentars = new ArrayList<FrequenciaAlimentar>();
		frequenciaAlimentars = consultaNutricionalService.getConsultaNutricionalWithFrequenciasById(id).getFrequencias();
		return frequenciaAlimentars;
	}

	private ConsultaNutricional atualizarConsulta(ConsultaNutricional consulta) {
		if (consulta.getFrequencias() != null) {
			for (FrequenciaAlimentar frequencia : consulta.getFrequencias()) {
				frequencia.setConsultaNutricional(consulta);
				if (frequencia.getAlimentos() != null) {
					for (Alimentacao alimentacao : frequencia.getAlimentos()) {
						alimentacao.setFrequenciaAlimentar(frequencia);
					}
				}
			}
		}

		if(consulta.getDocumentos() != null){
			for(Documento documento : consulta.getDocumentos()){
				documento.setConsultaNutricional(consulta);
			}
		}

		return consulta;
	}

	//Detalhes de paciente
	@RequestMapping(value = {"detalhes/{id}"})
	public String getDetalhes(Pessoa p, @PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		Pessoa pessoa = pessoaService.find(Pessoa.class, id);
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("pessoa", pessoa);
		return "nutricao/detalhes";
	}



	//=========================== Consulta Nutricional ===========================
	//Consulta Nutricional --> Create
	@RequestMapping(value = {"consulta/{id}"}, method = RequestMethod.GET)
	public String realizarConsulta(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

		model.addAttribute("action", "cadastrar");

		Pessoa pessoa = pessoaService.find(Pessoa.class, id);		


		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		if(pessoa.getPaciente() == null){
			pessoa.setPaciente(new Paciente());
			pessoa.getPaciente().setPessoa(pessoa);
			pessoa.getPaciente().setAltura(1.0);

			pessoaService.update(pessoa);
		}

		ConsultaNutricional consulta = new ConsultaNutricional();
		Paciente paciente = pessoa.getPaciente();
		consulta.setPaciente(paciente);
		model.addAttribute("consultaNutricional", consulta);
		model.addAttribute("classificacao", Classificacao.values());
		model.addAttribute("refeicoes", Refeicao.values());		

		return "nutricao/consulta";
	}

	@RequestMapping(value = {"/consultar"}, method = RequestMethod.POST)
	public String consulta(Model model, @Valid ConsultaNutricional consulta, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") List<MultipartFile> files, @RequestParam(value = "enviar", required = false) boolean enviar) {		
		model.addAttribute("action", "cadastrar");

		if (result.hasErrors()) {
			return ("nutricao/consulta");
		}

		Paciente paciente = pacienteService.find(Paciente.class, consulta.getPaciente().getId());
		double altura = consulta.getPaciente().getAltura();
		Date data = new Date(System.currentTimeMillis());
		consulta.setData(data);
		consulta.setPaciente(paciente);
		consulta.getPaciente().setAltura(altura);

		// verificar se os documentos foram anexados
		List<Documento> documentos = new ArrayList<Documento>();
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
					return ("nutricao/consulta");
				}
			}

			if(!documentos.isEmpty()){
				consulta.setDocumentos(documentos);
			}
		}else{
			model.addAttribute("anexoError", "Adicione anexo a seleção");					
		}


		if(consulta.getAgua().equals(0)){
			consulta.setAgua(null);
		}
		if(consulta.getMedicamentoComentario()!=null && consulta.getMedicamentoComentario().isEmpty()){
			consulta.setMedicamentoComentario(null);
		}
		if(consulta.getMastigacaoComentario()!=null && consulta.getMastigacaoComentario().isEmpty()){
			consulta.setMastigacaoComentario(null);
		}
		if(consulta.getAlergiaComentario()!=null && consulta.getAlergiaComentario().isEmpty()){
			consulta.setAlergiaComentario(null);
		}
		if(consulta.getCarneVermelhaComentario()!=null && consulta.getCarneVermelhaComentario().isEmpty()){
			consulta.setCarneVermelhaComentario(null);
		}
		if(consulta.getAtividadeFisicaComentario()!=null && consulta.getAtividadeFisicaComentario().isEmpty()){
			consulta.setAtividadeFisicaComentario(null);
		}
		if(consulta.getBebidaAlcoolicaComentario()!=null && consulta.getBebidaAlcoolicaComentario().isEmpty()){
			consulta.setBebidaAlcoolicaComentario(null);
		}
		consultaNutricionalService.save(consulta);

		redirectAttributes.addFlashAttribute("success", "Consulta de <strong>id = " + consulta.getId() + "</strong> e paciente <strong>" + consulta.getPaciente().getPessoa().getNome() + "</strong> realizada com sucesso.");
		return "redirect:/nutricao/buscar";

	}

	//Consulta Nutricional --> Read
	@RequestMapping(value = {"detalhesConsulta/{id}"})
	public String getDetalhesConsulta(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		ConsultaNutricional consulta = consultaNutricionalService.getConsultaNutricionalWithFrequenciasById(id);

		if(consulta == null){
			redirectAttributes.addFlashAttribute("erro", "Consulta não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("consulta", consulta);
		return "nutricao/detalhesConsulta";
	}


	@RequestMapping(value = {"deletarDocumento/{id}"}, method = RequestMethod.GET)
	public String deletarDocumento(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
		Documento documento = documentoService.find(Documento.class, id);
		documentoService.delete(documento);
		redirectAttributes.addFlashAttribute("success", "Documento deletado com sucesso");
		return "redirect:../../nutricao/editarConsulta/" + documento.getConsultaNutricional().getId();
	}


	@RequestMapping(value = {"enviarDocumento/{id}/{mensagem}"}, method = RequestMethod.GET)
	public String enviarDocumento(@PathVariable("id") Long id, @PathVariable("mensagem") String mensagem, RedirectAttributes redirectAttributes){
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

	@RequestMapping(value = {"downloadDocumento/{id}"}, method = RequestMethod.GET)
	public HttpEntity<byte[]> downloadDocumento(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
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
	
	@RequestMapping(value = "/relatorio-orientacoes-individuais/{id}", method = RequestMethod.GET)
	public String relatorio(@PathVariable("id") Long id, Model model, HttpSession session) throws JRException {
		
		String orientacoesIndividuais = consultaNutricionalService.getOrientacoesIndividuaisById(id);	
		String nome = consultaNutricionalService.getPacientePessoaNomeById(id);
		String nutricionista = getNomeUsuarioLogado(session);
				
		model.addAttribute("format", "pdf");
		model.addAttribute("orientacoesIndividuais", orientacoesIndividuais);
		model.addAttribute("paciente", nome);
		model.addAttribute("nutricionista", nutricionista);
		model.addAttribute("datasource", new JREmptyDataSource());
		
		return "orientacoesIndividuais";
	}

	private Pessoa getUsuarioLogado(HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			Pessoa pessoa = pessoaService.getPessoaByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
			session.setAttribute("usuario", pessoa);
		}
		return (Pessoa) session.getAttribute("usuario");
	}
	
	private String getNomeUsuarioLogado(HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			Pessoa pessoa = pessoaService.getPessoaByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
			session.setAttribute("usuario", pessoa);
		}
		Pessoa pessoa = (Pessoa) session.getAttribute("usuario");
		return pessoa.getNome();
	}
}
