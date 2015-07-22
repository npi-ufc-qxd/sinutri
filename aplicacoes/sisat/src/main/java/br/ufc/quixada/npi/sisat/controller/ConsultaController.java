package br.ufc.quixada.npi.sisat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	
	@RequestMapping(value = {"informacoes/{id}"})
	public String getDetalhesConsulta(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		ConsultaNutricional consulta = consultaNutricionalService.getConsultaNutricionalWithFrequenciasById(id);

		if(consulta == null){
			redirectAttributes.addFlashAttribute("erro", "Consulta não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		model.addAttribute("consulta", consulta);
		return "nutricao/informacoes-consulta";
	}

	@RequestMapping(value = {"paciente/{idPaciente}"}, method = RequestMethod.GET)
	public String realizarConsultaPaciente(Model model, @PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes) {

		model.addAttribute("action", "cadastrar");

		Pessoa pessoa = pessoaService.find(Pessoa.class, idPaciente);

		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}

		if( !isPaciente(pessoa)){
			pessoa.setPaciente(new Paciente());
			pessoa.getPaciente().setPessoa(pessoa);
			pessoa.getPaciente().setAlturaAtual(1.0);
			pessoa.getPaciente().setCircunferenciaCinturaAtual(1.0);
			pessoa.getPaciente().setPesoAtual(1.0);

			pessoaService.update(pessoa);
		}

		ConsultaNutricional consulta = new ConsultaNutricional();
		Paciente paciente = pessoa.getPaciente();
		consulta.setPaciente(paciente);

//		model.addAttribute("consultaNutricional", consulta);
		model.addAttribute("consultaNutricional", new ConsultaNutricional(pessoa.getPaciente()));
		
		
		model.addAttribute("sistemaGastrointestinal", SistemaGastrointestinal.values());		
		model.addAttribute("classificacaoExames", ClassificacaoExame.values());
		model.addAttribute("sistemaUrinario", SistemaUrinario.values());
		model.addAttribute("classificacao", ClassificacaoExame.values());
		model.addAttribute("frequencia", Frequencia.values());
		model.addAttribute("refeicoes", Refeicao.values());

		return "nutricao/consulta-layout";
	}
	
	@RequestMapping(value = {"paciente/{idPaciente}"}, method = RequestMethod.POST)
	public String salvarConsultaPaciente(Model model, @Valid ConsultaNutricional consulta, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") List<MultipartFile> files, @RequestParam(value = "enviar", required = false) boolean enviar) {		
		
		model.addAttribute("action", "cadastrar");

		if (result.hasErrors()) {
			return ("nutricao/consulta-layout");
		}

		Paciente paciente = pacienteService.find(Paciente.class, consulta.getPaciente().getId());
		Double altura = consulta.getAltura();
		Date data = new Date(System.currentTimeMillis());
		consulta.setData(data);
		consulta.setPaciente(paciente);
		consulta.getPaciente().setAlturaAtual(altura);
		consulta.getPaciente().setCircunferenciaCinturaAtual(consulta.getCircunferenciaCintura());
		consulta.getPaciente().setPesoAtual(consulta.getPeso());

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
	
	@RequestMapping(value = {"/editar-consulta/{idConsulta}/paciente/{idPaciente}"}, method = RequestMethod.GET)
	public String editarConsulta(@PathVariable("idConsulta") long idConsulta, @PathVariable("idPaciente") long idPaciente, Model model) {

		ConsultaNutricional consultaNutricional = consultaNutricionalService.getConsultaNutricionalWithDocumentosById(idConsulta);
		
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

		return "/nutricao/consulta";

	}

	@RequestMapping(value = {"/editar-consulta/{idConsulta}/paciente/{idPaciente}"}, method = RequestMethod.POST)
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
	
	private boolean isPaciente(Pessoa pessoa) {
		if(pessoa.getPaciente() != null)
			return true;
		return false;
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
