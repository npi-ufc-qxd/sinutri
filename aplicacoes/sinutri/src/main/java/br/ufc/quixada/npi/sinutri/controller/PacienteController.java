package br.ufc.quixada.npi.sinutri.controller;

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

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
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
	private PacienteService pacienteService;
	
	@Inject PessoaService pessoaService;
	
	@RequestMapping(value= "/{idPaciente}/InqueritoAlimentar/", method = RequestMethod.GET)
	public String formAdicionarInqueritoAlimentar(Model model, @PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes){
		Paciente paciente =  pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)) {
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "redirect:/Nutricao/Buscar";
		}
		
		InqueritoAlimentar inqueritoAlimentar = new InqueritoAlimentar();
		inqueritoAlimentar.setPaciente(paciente);
		model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
		model.addAttribute("FrequenciasSemanais", FrequenciaSemanal.values());

		return "/inquerito-alimentar/cadastrar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/", method = RequestMethod.POST)
	public String adicionarInqueritoAlimentar(Model model, @PathVariable("idPaciente") Long idPaciente, @Valid @ModelAttribute("inqueritoAlimentar") InqueritoAlimentar inqueritoAlimentar, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "redirect:/nutricao/buscar";
		}

		if (result.hasErrors()) {
			inqueritoAlimentar.setPaciente(paciente);
			model.addAttribute("frequenciasSemanais", FrequenciaSemanal.values());
			model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
			return "nutricao/inquerito/cadastrar";
		}
		
		consultaService.adicionarInqueritoAlimentar(inqueritoAlimentar, paciente);
		return "redirect:/paciente/"+idPaciente+"/InqueritoAlimentar"+inqueritoAlimentar.getId()+"/";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Editar/", method = RequestMethod.GET)
	public String formEditarInqueritoAlimentar(@PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes ){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		if(inqueritoAlimentar == null){
			redirectAttributes.addFlashAttribute("erro", "Inquérito Alimentar não encontrado. Faça uma nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
		model.addAttribute("inqueritoAlimenar", inqueritoAlimentar);
		model.addAttribute("FrequenciasSemanais", FrequenciaSemanal.values());
		return "nutricao/inqueritoAlimentar/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Editar/", method = RequestMethod.POST)
	public String editarInqueritoAlimentar(Model model, @PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, @PathVariable("idPaciente") Long idPaciente, @Valid InqueritoAlimentar inqueritoAlimentar, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
		if (result.hasErrors()) {
			inqueritoAlimentar.setPaciente(paciente);
			model.addAttribute("frequenciasSemanais", FrequenciaSemanal.values());
			model.addAttribute("inqueritoAlimentar", inqueritoAlimentar);
			return "nutricao/inquerito/editar";
		}
		consultaService.editarInqueritoAlimentar(inqueritoAlimentar);
		return "redirect:/paciente/"+idPaciente+"/Inquerito/"+idInqueritoAlimentar+"/";
	}
	
	@RequestMapping(value = "/{idPaciente}/InqueritoAlimentar/{idInqueritoAlimentar}/Excluir/", method = RequestMethod.GET)
	public String excluirInqueritoAlimentar(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idInqueritoAlimentar") Long idInqueritoAlimentar, RedirectAttributes redirectAttributes){
		InqueritoAlimentar inqueritoAlimentar = consultaService.buscarInqueritoAlimentarPorId(idInqueritoAlimentar);
		if(inqueritoAlimentar == null){
			redirectAttributes.addFlashAttribute("erro", "Inquérito Alimentar não encontrado. Faça uma nova pesquisa");
			return "redirect:/nutricao/buscar";
		}
		consultaService.excluirInqueritoAlimentar(inqueritoAlimentar);
		return "redirect:/Paciente/"+idPaciente+"/";
	}
	
	@ModelAttribute("sexos")
	Sexo[] getSexos()
	{
		return Sexo.values();
	}
	
	@RequestMapping(value= "/Cadastrar/", method = RequestMethod.GET)
	public String formCadastrarPacienteExterno(Model model){
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		
		return "/paciente/cadastrar";
	}
	
	@RequestMapping(value = "/Cadastrar/", method = RequestMethod.POST)
	public String cadastrarPacienteExterno(Model model, @Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			model.addAttribute("pessoa", pessoa);
			return "/paciente/cadastrar";
		}
		
		Paciente paciente = new Paciente();
		
		paciente.setPessoa(pessoa);
		pacienteService.adicionarPaciente(paciente);
		
		model.addAttribute("pessoa", pessoa);
		
		return "/paciente/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Editar/", method = RequestMethod.GET)
	public String formEditarPaciente(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "nutricao/buscar";
		}
		
		Pessoa pessoa = pessoaService.buscarPessoaPorId(idPaciente);
		
		model.addAttribute("pessoa", pessoa);
		return "/paciente/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Editar/", method = RequestMethod.POST)
	public String editarPaciente(Model model, @PathVariable("idPaciente") Long idPaciente, @Valid Pessoa pessoa, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "nutricao/buscar";
		}
		pessoaService.editarPessoa(pessoa);
		model.addAttribute("pessoa", pessoa);

		return "/paciente/visualizar"; //modificar
	}
	
	@RequestMapping(value = "/{idPaciente}/", method = RequestMethod.GET)
	public String visualizarPaciente(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){

		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "nutricao/buscar";
		}
		
		Pessoa pessoa = pessoaService.buscarPessoaPorId(idPaciente);
		
		model.addAttribute("pessoa", pessoa);

		return "/paciente/visualizar"; 
	}
	
	@RequestMapping(value= {"/{idPaciente}/Excluir/"}, method = RequestMethod.GET)
	public String ExcluirAntropometria(@PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes, Model model){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa");
			return "nutricao/buscar";
		}
		
		pessoaService.excluirPessoa(paciente.getPessoa());
		pacienteService.excluirPaciente(paciente);
		
		return "nutricao/buscar"; //modificar
	}
	
	private boolean isInvalido(Paciente paciente){
		return paciente == null;
	}

	private String getCpfPessoaLogada() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
