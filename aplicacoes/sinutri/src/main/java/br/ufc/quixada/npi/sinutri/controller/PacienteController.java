package br.ufc.quixada.npi.sinutri.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Mensagem;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Prioridade;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Tipo;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.Apetite;
import br.ufc.quixada.npi.sinutri.model.enuns.Exame;
import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;
import br.ufc.quixada.npi.sinutri.model.enuns.Sexo;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaUrinario;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;
import br.ufc.quixada.npi.sinutri.service.PacienteService;
import br.ufc.quixada.npi.sinutri.service.PessoaService;

@Controller
@RequestMapping(value = "/Paciente")
public class PacienteController {
	
	@Inject
	private ConsultaService consultaService;
	
	@Inject
	private PacienteService pacienteService;
	
	@Inject
	private PessoaService pessoaService;
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial", method = RequestMethod.GET)
	public String formAdicionarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){

		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexistente.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		
		AvaliacaoLaboratorial avaliacaoLaboratorial = new AvaliacaoLaboratorial();
		avaliacaoLaboratorial.setPaciente(paciente);
		avaliacaoLaboratorial.setCriadoEm(new Date());
		model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);

		return "avaliacao-laboratorial/cadastrar";
	}
	
	@ModelAttribute("exames")
	public Exame[] getExames(){
		return Exame.values();
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial", method = RequestMethod.POST)
	public String adicionarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @Valid AvaliacaoLaboratorial avaliacaoLaboratorial, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if (bindingResult.hasErrors()) {
			avaliacaoLaboratorial.setPaciente(paciente);
			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
			
			return "avaliacao-laboratorial/cadastrar";
		}
		
		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexistente.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		
		consultaService.adicionarAvaliacaoLaboratorial(avaliacaoLaboratorial, paciente);
		
		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Paciente/"+idPaciente+"/AvaliacaoLaboratorial/"+avaliacaoLaboratorial.getId()+"/Visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial/{idAvaliacaoLaboratorial}/Editar", method = RequestMethod.GET)
	public String formEditarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, Model model, RedirectAttributes redirectAttributes){
		
		AvaliacaoLaboratorial avaliacaoLaboratorial = consultaService.buscarAvaliacaoLaboratorialPorId(idAvaliacaoLaboratorial);
		
		if(avaliacaoLaboratorial == null){
			Mensagem mensagem = new Mensagem("Avaliação Laboratorial não encontrada.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
		
		model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
	
		return "avaliacao-laboratorial/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial/{idAvaliacaoLaboratorial}/Editar", method = RequestMethod.POST)
	public String editarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, @Valid AvaliacaoLaboratorial avaliacaoLaboratorial, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
			return "avaliacao-laboratorial/editar";
		}
		
		avaliacaoLaboratorial = consultaService.buscarAvaliacaoLaboratorialPorId(avaliacaoLaboratorial.getId());
		
		if(avaliacaoLaboratorial == null){
			Mensagem mensagem = new Mensagem("Avaliação Laboratorial não encontrada.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
				
		consultaService.editarAvaliacaoLaboratorial(avaliacaoLaboratorial);
		return "redirect:/Paciente/"+idPaciente+"/AvaliacaoLaboratorial/"+avaliacaoLaboratorial.getId()+"/Visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial/{idAvaliacaoLaboratorial}/Visualizar", method = RequestMethod.GET)
	public String visualizarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, RedirectAttributes redirectAttributes, Model model){
		
		AvaliacaoLaboratorial avaliacaoLaboratorial = consultaService.buscarAvaliacaoLaboratorialPorId(idAvaliacaoLaboratorial);
		
		if(avaliacaoLaboratorial == null){
			Mensagem mensagem = new Mensagem("Avaliação Laboratorial não encontrada.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
		
		model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
		return "avaliacao-laboratorial/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial/{idAvaliacaoLaboratorial}/Excluir", method = RequestMethod.GET)
	public String excluirAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, RedirectAttributes redirectAttributes){
		
		AvaliacaoLaboratorial avaliacaoLaboratorial = consultaService.buscarAvaliacaoLaboratorialPorId(idAvaliacaoLaboratorial);
		
		if(avaliacaoLaboratorial == null){
			Mensagem mensagem = new Mensagem("Avaliação Laboratorial não encontrada.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
		}else{
			consultaService.excluirAvaliacaoLaboratorial(avaliacaoLaboratorial);
		}

		return "redirect:/Paciente/"+idPaciente;
	}
	

	@RequestMapping(value= "/{idPaciente}/InqueritoAlimentar", method = RequestMethod.GET)
	public String formAdicionarInqueritoAlimentar(Model model, @PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes){
		Paciente paciente =  pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)) {
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Paciente inexistente", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "redirect:/Nutricao/Buscar";
		}
			
		InqueritoAlimentar inqueritoAlimentar = new InqueritoAlimentar();
		inqueritoAlimentar.setCriadoEm(new Date());
		
		inqueritoAlimentar.setPaciente(paciente);
		model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
		model.addAttribute("frequenciasSemanais", FrequenciaSemanal.values());

		return "inquerito-alimentar/cadastrar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar", method = RequestMethod.POST)
	public String adicionarInqueritoAlimentar(Model model, @PathVariable("idPaciente") Long idPaciente, @Valid @ModelAttribute("inqueritoAlimentar") InqueritoAlimentar inqueritoAlimentar, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Paciente inexistente", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "redirect:/Nutricao/Buscar";
		}
		if (result.hasErrors()) {
			return "inquerito-alimentar/cadastrar";
		}
		String cpfPessoaLogada = getCpfPessoaLogada();
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(cpfPessoaLogada);
		if(nutricionista == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Nutricionista inexistente", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "redirect:/Nutricao/Buscar";
		}
		inqueritoAlimentar.setNutricionista(nutricionista);
		consultaService.adicionarInqueritoAlimentar(inqueritoAlimentar, paciente);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.BAIXA));
		return "redirect:/Paciente/"+idPaciente+"/InqueritoAlimentar/"+inqueritoAlimentar.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Editar", method = RequestMethod.GET)
	public String formEditarInqueritoAlimentar(@PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes ){
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		if(inqueritoAlimentar == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Inquérito Alimentar não encontrado.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
		model.addAttribute("frequenciasSemanais", FrequenciaSemanal.values());
		return "inquerito-alimentar/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Editar", method = RequestMethod.POST)
	public String editarInqueritoAlimentar(Model model, @PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, @PathVariable("idPaciente") Long idPaciente, @Valid InqueritoAlimentar inqueritoAlimentar, BindingResult result, RedirectAttributes redirectAttributes){
		if (result.hasErrors()) {
			return "inquerito-alimentar/editar";
		}
		consultaService.editarInqueritoAlimentar(inqueritoAlimentar);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.BAIXA));
		return "redirect:/Paciente/"+inqueritoAlimentar.getPaciente().getId()+"/InqueritoAlimentar/"+idInqueritoAlimentar;
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}", method = RequestMethod.GET)
	public String visualizarInqueritoAlimentar(@PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes ){
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		if(inqueritoAlimentar == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Inquérito Alimentar não encontrado.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
		return "inquerito-alimentar/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Excluir", method = RequestMethod.GET)
	public String excluirInqueritoAlimentar(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, RedirectAttributes redirectAttributes){
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		if(inqueritoAlimentar == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Inquérito Alimentar não encontrado.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			return "redirect:/Paciente/"+idPaciente;
		}
		consultaService.excluirInqueritoAlimentar(inqueritoAlimentar);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Excluído com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.BAIXA));
		return "redirect:/Paciente/"+idPaciente;
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria"}, method = RequestMethod.GET)
	public String formAdicionarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		AvaliacaoAntropometrica avaliacaoAntropometrica = new AvaliacaoAntropometrica();
		avaliacaoAntropometrica.setPaciente(paciente);
		avaliacaoAntropometrica.setCriadoEm(new Date());
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/cadastrar";
	}

	@RequestMapping(value={"/{idPaciente}/Antropometria"}, method = RequestMethod.POST)
	public String adicionarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid AvaliacaoAntropometrica avaliacaoAntropometrica, BindingResult result, RedirectAttributes redirectAttributes){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "antropometria/cadastrar";
		}
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Erro ao adicionar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		if (avaliacaoAntropometrica.getId()!=null){
			mensagens.add(new Mensagem("Erro ao adicionar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();			
		} 
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		if(isInvalidoNutricionista(nutricionista)){
			mensagens.add(new Mensagem("Erro ao adicionar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Nutricionista não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		avaliacaoAntropometrica.setNutricionista(nutricionista);
		avaliacaoAntropometrica.setPaciente(paciente);
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		
		consultaService.adicionarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		mensagens.add(new Mensagem("Avaliação Antropométrica Adicionada!", Tipo.SUCESSO, Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Editar"}, method = RequestMethod.GET)
	public String formEditarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, Model model, RedirectAttributes redirectAttributes){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			mensagens.add(new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId();
		}
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/editar";
	}
	@RequestMapping(value={"/{idPaciente}/Antropometria/{idAntropometria}/Editar"}, method = RequestMethod.POST)
	public String editarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid AvaliacaoAntropometrica avaliacaoAntropometrica, BindingResult result, RedirectAttributes redirectAttributes){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "antropometria/cadastrar";
		}
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Erro ao editar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		consultaService.editarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			mensagens.add(new Mensagem("Erro ao editar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId();
		}
		mensagens.add(new Mensagem("Avaliação Antropométrica Editada!", Tipo.SUCESSO, Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}"}, method = RequestMethod.GET)
	public String visualizarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria, RedirectAttributes redirectAttributes, Model model){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);

		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}

		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			mensagens.add(new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId();
		}
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/visualizar";
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Excluir"}, method = RequestMethod.GET)
	public String excluirAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, RedirectAttributes redirectAttributes, Model model){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
			return "redirect:/Nutricao/Buscar";
		}
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			mensagens.add(new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId();
		}
		consultaService.excluirAvaliacaoAntropometrica(avaliacaoAntropometrica);
		mensagens.add(new Mensagem("Avaliação Antropométrica Excluida!", Tipo.SUCESSO, Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		return "redirect:/Paciente/"+paciente.getId();
	}
	@ModelAttribute("sexos")
	public Sexo[] getSexos(){
		return Sexo.values();
	}
	
	@RequestMapping(value= "/Cadastrar", method = RequestMethod.GET)
	public String formAdicionarPacienteExterno(Model model){
		model.addAttribute("pessoa", new Pessoa());
		
		return "/paciente/cadastrar";
	}
	
	@RequestMapping(value = "/Cadastrar", method = RequestMethod.POST)
	public String adicionarPacienteExterno(Model model, @Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, RedirectAttributes redirectAttributes){
		
		List<Mensagem> mensagens = new ArrayList<Mensagem>();

		model.addAttribute("pessoa", pessoa);
		
		Paciente paciente = new Paciente();
		
		paciente.setPessoa(pessoa);
		try{
			pacienteService.adicionarPaciente(paciente);
		}catch(Exception e){
			mensagens.add(new Mensagem("CPF inválido!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/Cadastrar";
		}
		
		model.addAttribute("pessoa", pessoa);
		
		mensagens.add(new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		
		return "redirect:/Paciente/"+pessoa.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/Editar", method = RequestMethod.GET)
	public String formEditarPaciente(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		
		Pessoa pessoa = pessoaService.buscarPessoaPorId(idPaciente);
		
		model.addAttribute("pessoa", pessoa);
		return "/paciente/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Editar", method = RequestMethod.POST)
	public String editarPaciente(Model model, @PathVariable("idPaciente") Long idPaciente, @Valid Pessoa pessoa, BindingResult result, RedirectAttributes redirectAttributes){
		
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		
		try{
			pessoaService.editarPessoa(pessoa);
		}catch(Exception e){
			mensagens.add(new Mensagem("CPF inválido!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/Cadastrar";
		}
		
		model.addAttribute("pessoa", pessoa);
		
		mensagens.add(new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);

		return "redirect:/Paciente/"+idPaciente; 
	}
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public String visualizarPaciente(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){

		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			mensagens.add(new Mensagem("Paciente inexistente!!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		
		Pessoa pessoa = pessoaService.buscarPessoaPorId(idPaciente);
		
		model.addAttribute("pessoa", pessoa);

		return "/paciente/visualizar"; 
	}
	
	/* A ação de excluir um paciente não será incluida nesta Sprint (4)
	 * 
	 * @RequestMapping(value= {"/{idPaciente}/Excluir"}, method = RequestMethod.GET)
	public String excluirPaciente(@PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes, Model model){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		Pessoa pessoa = paciente.getPessoa();
		
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
			return "redirect:/Nutricao/Buscar";
		}
		
		pacienteService.excluirPaciente(paciente);
		pessoaService.excluirPessoa(pessoa);
		
		
		return "redirect:/Nutricao/Buscar";
	}*/
	
	@RequestMapping(value = "/{idPaciente}/Anamnese",method = RequestMethod.GET)
	public String formAdicionarAnamnese(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente =null;
		paciente =  pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Paciente inexistente.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "redirect:/Nutricao/Buscar";			
		}
		Anamnese anamnese =  new Anamnese();
		anamnese.setCriadoEm(new Date());
		anamnese.setPaciente(paciente);
		model.addAttribute("anamnese",anamnese);
		model.addAttribute("tiposApetite",Apetite.values());
		model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
		model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
		return "/anamnese/cadastrar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese",method = RequestMethod.POST)
	public String adicionarAnamnese(@PathVariable("idPaciente") Long idPaciente, @Valid Anamnese anamnese, BindingResult result, Model model,
			RedirectAttributes redirectAttributes
			){
		if(result.hasErrors()){			
			model.addAttribute("anamnese",anamnese);
			model.addAttribute("tiposApetite",Apetite.values());
			model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
			model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
			return "/anamnese/cadastrar";
		}
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		anamnese.setNutricionista(nutricionista);
		consultaService.adicionarAnamnese(anamnese);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso.",Mensagem.Tipo.SUCESSO,Mensagem.Prioridade.MEDIA));
		return "redirect:/Paciente/"+idPaciente+"/Anamnese/"+anamnese.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Editar",method = RequestMethod.GET)
	public String formEditarAnamnese( Model model, @PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese, RedirectAttributes redirectAttributes){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
		if(anamnese == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Anamnese não encontrada.",Mensagem.Tipo.ERRO,Mensagem.Prioridade.ALTA));
			return "redirect:/Paciente/"+idPaciente;
		}
		anamnese.setAtualizadoEm(new Date());
		model.addAttribute("anamnese", anamnese);
		model.addAttribute("tiposApetite",Apetite.values());
		model.addAttribute("tiposSistemaUrinario",SistemaUrinario.values());
		model.addAttribute("tiposSistemaGastrointestinal", SistemaGastrointestinal.values());
		return "/anamnese/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Editar",method=RequestMethod.POST)
	public String editarAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnanmese,
			@ModelAttribute("Ananmnese") @Valid Anamnese anamnese,	BindingResult result, Model model,RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			model.addAttribute("anamnese", anamnese);
			return "/nutricao/anamnese/editar";
		}		
		consultaService.editarAnamnese(anamnese);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso.",Mensagem.Tipo.SUCESSO,Mensagem.Prioridade.MEDIA));
		return "redirect:/Paciente/"+idPaciente+"/Anamnese/"+anamnese.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}",method = RequestMethod.GET)
	public String visualizarAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese,Model model, RedirectAttributes redirectAttributes){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
		if(anamnese == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Anamnese não encontrada.",Mensagem.Tipo.ERRO,Mensagem.Prioridade.ALTA));
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("anamnese",anamnese);
		return "/anamnese/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Excluir")
	public String excluirAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese, RedirectAttributes redirectAttributes){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
		if(anamnese == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Anamnese não encontrada.",Mensagem.Tipo.ERRO,Mensagem.Prioridade.ALTA));
			return "redirect:/Paciente/"+idPaciente;			
		}
		consultaService.excluirAnamnese(anamnese);
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Excluído com sucesso!",Mensagem.Tipo.SUCESSO,Mensagem.Prioridade.ALTA));
		return "redirect:/Paciente/"+idPaciente;
		
	}
	
	private boolean isInvalido(Paciente paciente){
		return paciente == null;
	}

	private boolean isInvalidoAntropometria(AvaliacaoAntropometrica avaliacaoAntropometrica){
		return avaliacaoAntropometrica == null;
	}
	private boolean isInvalidoNutricionista(Servidor nutricionista){
		return nutricionista == null;
	}
	private String getCpfPessoaLogada() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
