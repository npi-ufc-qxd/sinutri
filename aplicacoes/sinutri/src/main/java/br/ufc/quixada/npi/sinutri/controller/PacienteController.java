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

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Prescricao;
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
	
	
	private boolean isInvalido(Paciente paciente){
		return paciente == null;
	}
	
	@RequestMapping(value="/{idPaciente}/Prescricao/", method = RequestMethod.GET)
	public String formAdicionarPrescricao(@PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes, 
			Model model){
	
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
//		System.out.println("\nid "+idPaciente);
		if(paciente==null){
//			System.out.println("paciente nulo");
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa.");
			return "redirect:/Nutricao/Buscar";
		}
	
		Prescricao prescricao = new Prescricao();
		prescricao.setPaciente(paciente);
		prescricao.setCriadoEm(new Date());
	 
		model.addAttribute("prescricao", prescricao);
		return "prescricao/cadastrar";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/", method = RequestMethod.POST)
	 public String adicionarPrescricao(Prescricao prescricao, @PathVariable("idPaciente") Long id, Model model,
			 		BindingResult result, RedirectAttributes redirectAttributes){
		
		 Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
	
		 prescricao.setNutricionista(nutricionista);
		 prescricao.setAtualizadoEm(new Date());
		 consultaService.adicionarPrescricao(prescricao);
		 
		 if(!result.hasErrors()){
//			 System.out.println("\n\n\nAQUI");
		 }
		 
		 return "redirect:/Paciente/"+id+"/Prescricao/"+prescricao.getId()+"/";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Excluir/", method = RequestMethod.GET)
	 public String excluirPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao, RedirectAttributes redirectAttributes){
		 
		 Prescricao prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);
		 
		 if(prescricao != null)
			 consultaService.excluirPrescricao(prescricao);
		 else{
			redirectAttributes.addFlashAttribute("erro", "Prescrição não encontrada. Faça uma nova pesquisa."); 
		 }
		
		 return "redirect:/Nutricao/Buscar";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Editar/", method = RequestMethod.GET)
	 public String formEditarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao,
		 Model model, RedirectAttributes redirectAttributes){
		
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 Prescricao prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);
		 if(paciente == null){
			 redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa.");
			 return "Nutricao/Buscar/";
		 }
		else if(prescricao == null){
			 redirectAttributes.addFlashAttribute("erro", "Prescrição não encontrada. Faça uma nova pesquisa.");
			 return "Nutricao/Buscar/";
		}
		 
		 prescricao.setAtualizadoEm(new Date());
		 prescricao.setPaciente(paciente);
		 model.addAttribute("prescricao", prescricao);
		
		 return "prescricao/editar";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Editar/", method = RequestMethod.POST)
	 public String editarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao,
			 @Valid Prescricao prescricao, BindingResult result, Model model, RedirectAttributes redirectAttributes){
	
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		 prescricao.setNutricionista(nutricionista);
		 
		 if(paciente==null){
				redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado. Faça uma nova pesquisa.");
				return "redirect:/Nutricao/Buscar";
		 }
		 
		 if(result.hasErrors()){
			 prescricao.setPaciente(paciente);
			 model.addAttribute("prescricao", prescricao);
		 }
		 prescricao.setAtualizadoEm(new Date());
//		 System.out.println("\n\n\n"+prescricao.toString());
		 consultaService.editarPrescricao(prescricao);
		
		 return "redirect:/Paciente/"+idPaciente+"/Prescricao/"+prescricao.getId()+"/";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/", method = RequestMethod.GET)
	 public String visualizarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao, Prescricao prescricao,
		 Model model){
		 prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);
		 model.addAttribute("prescricao", prescricao);
		 return "prescricao/detalhes";
	 }
	
	private String getCpfPessoaLogada() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
