package br.ufc.quixada.npi.sisat.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Alimentacao;
import br.ufc.quixada.npi.sisat.model.Anamnese;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.PacienteExterno;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.model.enuns.Apetite;
import br.ufc.quixada.npi.sisat.model.enuns.ClassificacaoExame;
import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;
import br.ufc.quixada.npi.sisat.model.enuns.Refeicao;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaUrinario;
import br.ufc.quixada.npi.sisat.model.enuns.TipoFrequencia;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.sisat.service.PacienteExternoService;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.sisat.validation.ConsultaNutricionalValidator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("paciente")
public class PacienteController {

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
	
	@Inject
	private PacienteExternoService pacienteExternoService;
		

	@RequestMapping(value = "/{cpf}/verificar-paciente", method = RequestMethod.GET)
	public String getPaginaHistorico(@PathVariable("cpf") String cpf,@RequestParam("acao") String acao, Model model, RedirectAttributes redirectAttributes) {

		if(usuarioService.getByCpf(cpf) == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
		
		Paciente paciente = registrarPaciente(cpf);
		
		if(acao.equals("historico")){
			return "redirect:/paciente/"+paciente.getId()+"/historico";
		}else if(acao.equals("consulta")){
			return "redirect:/paciente/"+paciente.getId()+"/consulta";
		}else{
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
	}
	
	@RequestMapping(value = "/{id}/historico", method = RequestMethod.GET)
	public String getPaginaHistoricoPaciente(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

		Paciente paciente = pacienteService.find(Paciente.class, id);
		
//		if(usuarioService.getByCpf(cpf) == null){
//			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
//			return "redirect:/nutricao/buscar";
//		}
		
//		registrarPaciente(cpf);

		model.addAttribute("pessoa", pessoaService.getPessoaByCpf(paciente.getPessoa().getCpf()));

		return "nutricao/historico-paciente";
	}

	@RequestMapping(value = { "/consulta/{id}" }, method = RequestMethod.GET)
	public String getPaginaInformacoesConsulta(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		ConsultaNutricional consulta = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
						
		if (consulta == null) {
			redirectAttributes.addFlashAttribute("erro", "Consulta não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("consulta", consulta);
		return "nutricao/informacoes-consulta";
	}

	@RequestMapping(value = "/{id}/consulta", method = RequestMethod.GET)
	public String getPaginaRealizarConsulta(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		
		Paciente paciente = pacienteService.find(Paciente.class, id);
		
//		if(usuarioService.getByCpf(cpf) == null){
//			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça um nova pesquisa");
//			return "redirect:/nutricao/buscar";
//		}
		
		model.addAttribute("action", "cadastrar");

//		registrarPaciente(cpf);

		model.addAttribute("consultaNutricional", new ConsultaNutricional(paciente));
		model.addAttribute("sistemaGastrointestinal", SistemaGastrointestinal.values());
		model.addAttribute("classificacaoExames", ClassificacaoExame.values());
		model.addAttribute("sistemaUrinario", SistemaUrinario.values());
		model.addAttribute("classificacao", ClassificacaoExame.values());
		model.addAttribute("frequencia", Frequencia.values());
		model.addAttribute("refeicoes", Refeicao.values());

		return "nutricao/form-consulta";
	}

	@RequestMapping(value = { "/{cpf}/consulta" }, method = RequestMethod.POST)
	public String salvarConsulta(@PathVariable("cpf") String cpf, @Valid ConsultaNutricional consulta, Model model,  
			BindingResult result, RedirectAttributes redirectAttributes,
			@RequestParam("files") List<MultipartFile> files,
			@RequestParam(value = "enviar", required = false) boolean enviar) {

		model.addAttribute("action", "cadastrar");

		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);
		//InqueritoAlimentar inqueritoAlimentar = consulta.getInqueritoAlimentar();
		//inqueritoAlimentar.setConsultaNutricional(consulta);
		//consulta.setInqueritoAlimentar(inqueritoAlimentar);

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
	
		if (consulta.getAtividadeFisicaComentario() != null && consulta.getAtividadeFisicaComentario().isEmpty()) {
			consulta.setAtividadeFisicaComentario(null);
		}
		if (consulta.getBebidaAlcoolicaComentario() != null && consulta.getBebidaAlcoolicaComentario().isEmpty()) {
			consulta.setBebidaAlcoolicaComentario(null);
		}

		consultaNutricionalService.save(consulta);

		redirectAttributes.addFlashAttribute("success",
				"Consulta de <strong>id = " + consulta.getId() + "</strong> e paciente <strong>"
						+ consulta.getPaciente().getPessoa().getNome() + "</strong> realizada com sucesso.");

		return "redirect:/paciente/consulta/" + consulta.getId();
	}

	@RequestMapping(value = { "/{id}/consulta/{idConsulta}/editar" }, method = RequestMethod.GET)
	public String editarConsulta(@PathVariable("id") String id, @PathVariable("idConsulta") long idConsulta,
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
	

	@RequestMapping(value = { "/{cpf}/consulta/{idConsulta}/editar" }, method = RequestMethod.POST)
	public String editarConsulta(Model model, @PathVariable("cpf") String cpf, @PathVariable("idConsulta") Long idConsulta, @Valid ConsultaNutricional consulta,
			BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") List<MultipartFile> files,
			@RequestParam(value = "enviar", required = false) boolean enviar) {
		model.addAttribute("action", "editar");

		Paciente paciente = pacienteService.find(Paciente.class, consulta.getPaciente().getId());
		consulta.setPaciente(paciente);
		
		//InqueritoAlimentar inqueritoAlimentar = consulta.getInqueritoAlimentar();
		//inqueritoAlimentar.setConsultaNutricional(consulta);

		consultaNutricionalValidator.validate(consulta, result);

		if (result.hasErrors()) {
			model.addAttribute("documentosEnvio", documentoService.getDocumentosEnviar(idConsulta));
			model.addAttribute("documentosNutricionista", documentoService.getDocumentosNutricionista(idConsulta));
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
					model.addAttribute("consultaNutricional", consulta);
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
		
		//consulta.getInqueritoAlimentar().setConsultaNutricional(consulta);

		consultaNutricionalService.update(atualizarConsulta(consulta));
		redirectAttributes.addFlashAttribute("success", "Consulta do paciente <strong>"
				+ consulta.getPaciente().getPessoa().getNome() + "</strong> atualizada com sucesso.");

		return "redirect:/paciente/consulta/" + consulta.getId();
	}
	
	@RequestMapping(value = "/{cpf}/consulta/{id}/relatorio/orientacoes", method = RequestMethod.GET)
	public String relatorio(@PathVariable("id") Long id, Model model, HttpSession session) throws JRException {

		String cpf = consultaNutricionalService.getPacientePessoaCpfById(id);
		String nome = usuarioService.getByCpf(cpf).getNome();
		String nutricionista = getUsuarioLogado(session).getNome();

		model.addAttribute("format", "pdf");
		model.addAttribute("paciente", nome);
		model.addAttribute("nutricionista", nutricionista);
		model.addAttribute("datasource", new JREmptyDataSource());

		return "orientacoesIndividuais";
	}

	@RequestMapping(value = { "/consulta/refeicao/{idRefeicao}/excluir.json" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model deletarFrequenciaAlimentar(@PathVariable("idRefeicao") Long idRefeicao, Model model, RedirectAttributes redirectAttributes) {
		FrequenciaAlimentar frequenciaAlimentar = frequenciaAlimentarService.find(FrequenciaAlimentar.class, idRefeicao);
		
		if(frequenciaAlimentar != null){
			frequenciaAlimentarService.delete(frequenciaAlimentar);
			model.addAttribute("sucesso", "sucesso");
		}

		return model;
	}

	@RequestMapping(value = { "/consulta/alimento/{idAlimento}/excluir.json" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Model deletarAlimento(@PathVariable("idAlimento") Long idAlimento, Model model, RedirectAttributes redirectAttributes) {
		Alimentacao alimento = alimentacaoService.find(Alimentacao.class, idAlimento);

		if(alimento != null){
			alimento.getFrequenciaAlimentar().getAlimentos().remove(alimento);
			frequenciaAlimentarService.update(alimento.getFrequenciaAlimentar());
			model.addAttribute("sucesso", "sucesso");
		}

		return model;
	}

	@RequestMapping (value = { "consulta/{idConsulta}/plano-alimentar"}, method = RequestMethod.GET)
	public String getRecordatorio(@PathVariable("idConsulta") Long id, Model model){
		ConsultaNutricional consultaRecordatorio = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
		ConsultaNutricional consultaPlanoAlimentar = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
		model.addAttribute("consultaRecordatorio", consultaRecordatorio);
		model.addAttribute("consultaPlanoAlimentar", consultaPlanoAlimentar);
		
		List <FrequenciaAlimentar> frequencia = consultaNutricionalService.getFrequenciasByIdConsultaByTipo(id, TipoFrequencia.PLANOALIMENTAR);
		
		if(frequencia.isEmpty()){
			model.addAttribute("action", "cadastrar");
		}else{
			model.addAttribute("action", "editar");
		}
		
		return "nutricao/plano-alimentar";
	}
	
	@RequestMapping (value = { "consulta/{idConsulta}/form-plano-alimentar"}, method = RequestMethod.GET)
	public String getPlanoAlimentar(@PathVariable("idConsulta") Long id, Model model){
		ConsultaNutricional consultaRecordatorio = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
		
		ConsultaNutricional consultaPlanoAlimentar = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
		
		model.addAttribute("consultaRecordatorio", consultaRecordatorio);
		model.addAttribute("consultaPlanoAlimentar", consultaPlanoAlimentar);
		
		
		List <FrequenciaAlimentar> frequencia = consultaNutricionalService.getFrequenciasByIdConsultaByTipo(id, TipoFrequencia.PLANOALIMENTAR);
		if(frequencia.isEmpty()){
			model.addAttribute("action", "cadastrar");
		}else{
			model.addAttribute("action", "editar");
		}
	
		return "nutricao/form-planoalimentar";
	}
	@RequestMapping (value = { "consulta/{idConsulta}/plano-alimentar/atualizar"}, method = RequestMethod.POST)
	public String salvarPlanoAlimentar(@PathVariable("idConsulta") Long id, Model model, @ModelAttribute("consulta") ConsultaNutricional consultaAtual, RedirectAttributes redirectAttributes){
		
		ConsultaNutricional consulta = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(id);
				
		model.addAttribute("action", "cadastrar");
		model.addAttribute("consulta", consulta);
		
		consultaNutricionalService.update(consulta);
		
		return "redirect:/paciente/consulta/" + consulta.getId() +"/plano-alimentar";

	}

	
	@RequestMapping(value="/consulta/{idConsulta}/plano-alimentar/deletar", method = RequestMethod.GET)
	public String excluirPlanoAlimentar(@PathVariable("idConsulta") Long idConsulta){
		List<FrequenciaAlimentar> frequenciasAlimentares = consultaNutricionalService.getFrequenciasByIdConsultaByTipo(idConsulta, TipoFrequencia.PLANOALIMENTAR);
		for (FrequenciaAlimentar frequencia : frequenciasAlimentares) {
			frequenciaAlimentarService.delete(frequencia);
		}
		return "redirect:/paciente/consulta/" + idConsulta+"/plano-alimentar";
	}
	
	private Paciente registrarPaciente(String cpf) {
		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);

		if (pessoa == null) {
			pessoa = new Pessoa(cpf);

			pessoaService.save(pessoa);

			pessoa.setPaciente(new Paciente());
			pessoa.getPaciente().setPessoa(pessoa);
			pessoa.getPaciente().setAlturaAtual(1.0);
			pessoa.getPaciente().setCircunferenciaCinturaAtual(1.0);
			pessoa.getPaciente().setPesoAtual(1.0);
			
			pessoaService.update(pessoa);
		}
		
		return pessoaService.getPessoaByCpf(cpf).getPaciente();
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
	
	@RequestMapping(value = "cadastrar/paciente", method = RequestMethod.GET)
	public String formCadastrarPaciente(Model model)
	{
		model.addAttribute("pacienteExterno", new PacienteExterno());
		return "nutricao/cadastro-paciente";
	}
	
	@RequestMapping(value = "cadastrar/paciente", method = RequestMethod.POST)
	public String cadastrarPaciente(@Valid PacienteExterno paciente, Model model,  
			BindingResult result, RedirectAttributes redirectAttributes) {

		model.addAttribute("action", "cadastrar");
		pacienteExternoService.save(paciente);

		return "redirect:/paciente/cadastrar/paciente";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/",method = RequestMethod.GET)
	public String visualizarAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese,Model model){
		Anamnese anamnese = pacienteService.buscarAnamnese(idAnamnese);
		if(anamnese != null){
			model.addAttribute("anamnese",anamnese);
			return "/nutricao/anamnese/visualizar-anamnese";
		}
		return "/";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese",method = RequestMethod.GET)
	public String formAdicionarAnamnese(@PathVariable("idPaciente") Long idPaciente, Model model){
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		if(paciente != null){
			Anamnese anamnese =  new Anamnese();
			anamnese.setCriadoEm(new Date());
			anamnese.setPaciente(paciente);
			model.addAttribute("anamnese",anamnese);
			model.addAttribute("tiposApetite",Apetite.values());
			model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
			model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
			return "/nutricao/anamnese/cadastrar-anamnese";
		}
		return "/";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese",method = RequestMethod.POST)
	public String AdicionarAnamnese(@PathVariable("idPaciente") Long idPaciente, @Valid Anamnese anamnese, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("anamnese",anamnese);
			model.addAttribute("tiposApetite",Apetite.values());
			model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
			model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
			return "nutricao/anamnese/cadastrar-anamnese";
		}
		anamnese.setId(null);
		pacienteService.adicionarAnamnese(anamnese);
		return "redirect:/paciente/"+idPaciente+"/Anamnese/"+anamnese.getId()+"/";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Excluir")
	public String excluirAnamnese(@PathVariable("idPaciente") Long pacienteId,@PathVariable("idAnamnese") Long idAnamnese){
		Anamnese anamnese = pacienteService.buscarAnamnese(idAnamnese);
		if(anamnese != null){
			pacienteService.excluirAnamnese(anamnese);
			return "redirect:/";
		}else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Editar",method = RequestMethod.GET)
	public String formEditarAnamnese( Model model, @PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese){
		Anamnese anamnese = pacienteService.buscarAnamnese(idAnamnese);
		if(anamnese != null){
			anamnese.setAtualizadoEm(new Date());
			model.addAttribute("anamnese", anamnese);
			model.addAttribute("tiposApetite",Apetite.values());
			model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
			model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
			return "/nutricao/anamnese/editar-anamnese";
		}else
			return "redirect:/";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Editar",method=RequestMethod.POST)
	public String editarAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnanmese,
			@ModelAttribute("Ananmnese") @Valid Anamnese anamnese,
			BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("anamnese", anamnese);
			return "/nutricao/anamnese/editar-anamnese";
		}		
		pacienteService.editarAnamnese(anamnese);
		return "redirect:/paciente/"+idPaciente+"/Anamnese/"+anamnese.getId()+"/";
	}
		
}
