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

import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Mensagem;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Prioridade;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Tipo;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;
import br.ufc.quixada.npi.sinutri.model.enuns.Sexo;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;
import br.ufc.quixada.npi.sinutri.service.PacienteService;
import br.ufc.quixada.npi.sinutri.service.PessoaService;


@Controller
@RequestMapping(value = "/Paciente")
public class PacienteController {

	@Inject
	private ConsultaService consultaService;
	
	@Inject
	private PessoaService pessoaService;
	
	@Inject
	private PacienteService pacienteService;
	
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
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if(inqueritoAlimentar == null){
			mensagens.add(new Mensagem("Inquérito Alimentar não encontrado.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
		return "inquerito-alimentar/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Excluir", method = RequestMethod.GET)
	public String excluirInqueritoAlimentar(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, RedirectAttributes redirectAttributes){
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if(inqueritoAlimentar == null){
			mensagens.add(new Mensagem("Inquérito Alimentar não encontrado.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
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