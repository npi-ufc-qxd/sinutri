package br.ufc.quixada.npi.sinutri.controller;

import java.util.Date;

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
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;
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
	
	@RequestMapping(value= "/{idPaciente}/InqueritoAlimentar/", method = RequestMethod.GET)
	public String formAdicionarInqueritoAlimentar(Model model, @PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes){
		Paciente paciente =  pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)) {
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
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
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
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
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
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
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
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
		return "redirect:/paciente/"+idPaciente+"/";
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria"}, method = RequestMethod.GET)
	public String formAdicionarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
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
		avaliacaoAntropometrica.setId(null);
		if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "antropometria/cadastrar";
		}
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			redirectAttributes.addFlashAttribute("erro", "Paciente inexistente.");
			return "redirect:/Nutricao/Buscar";
		}
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		if(isInvalidoNutricionista(nutricionista)){
			redirectAttributes.addFlashAttribute("erro", "Nutricionista inexistente.");
			return "redirect:/Nutricao/Buscar";
		}
		avaliacaoAntropometrica.setNutricionista(nutricionista);
		avaliacaoAntropometrica.setPaciente(paciente);
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		
		consultaService.adicionarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Editar"}, method = RequestMethod.GET)
	public String formEditarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, Model model, RedirectAttributes redirectAttributes){
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			redirectAttributes.addFlashAttribute("erro", "Avaliação Antropométrica não encontrada.");
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/editar";
	}
	@RequestMapping(value={"/{idPaciente}/Antropometria/{idAntropometria}/Editar"}, method = RequestMethod.POST)
	public String editarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid AvaliacaoAntropometrica avaliacaoAntropometrica, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "antropometria/cadastrar";
		}
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		consultaService.editarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			redirectAttributes.addFlashAttribute("erro", "Avaliação Antropométrica não encontrada.");
			return "redirect:/Paciente/"+idPaciente;
		}
		return "redirect:/Paciente/"+idPaciente+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}"}, method = RequestMethod.GET)
	public String visualizarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria, RedirectAttributes redirectAttributes, Model model){
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			redirectAttributes.addFlashAttribute("erro", "Avaliação Antropométrica não encontrada.");
			return "redirect:/Paciente/"+idPaciente;
		}
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/visualizar";
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Excluir"}, method = RequestMethod.GET)
	public String excluirAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, RedirectAttributes redirectAttributes, Model model){
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			redirectAttributes.addFlashAttribute("erro", "Avaliação Antropométrica não encontrada.");
			return "redirect:/Paciente/"+idPaciente;
		}
		consultaService.excluirAvaliacaoAntropometrica(avaliacaoAntropometrica);
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

