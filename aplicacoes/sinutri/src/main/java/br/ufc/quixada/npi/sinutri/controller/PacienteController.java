package br.ufc.quixada.npi.sinutri.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.enuns.Apetite;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaUrinario;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;
import br.ufc.quixada.npi.sinutri.service.PacienteService;

@Controller
@RequestMapping(value = "/Paciente")
public class PacienteController {
	
	@Inject
	ConsultaService consultaService;
	@Inject PacienteService pacienteService;
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/",method = RequestMethod.GET)
	public String visualizarAnamnese(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese,Model model){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
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
		consultaService.adicionarAnamnese(anamnese);
		return "redirect:/paciente/"+idPaciente+"/Anamnese/"+anamnese.getId()+"/";
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Excluir")
	public String excluirAnamnese(@PathVariable("idPaciente") Long pacienteId,@PathVariable("idAnamnese") Long idAnamnese){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
		if(anamnese != null){
			consultaService.excluirAnamnese(anamnese);
			return "redirect:/";
		}else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/{idPaciente}/Anamnese/{idAnamnese}/Editar",method = RequestMethod.GET)
	public String formEditarAnamnese( Model model, @PathVariable("idPaciente") Long idPaciente,@PathVariable("idAnamnese") Long idAnamnese){
		Anamnese anamnese = consultaService.buscarAnamnese(idAnamnese);
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
		consultaService.editarAnamnese(anamnese);
		return "redirect:/paciente/"+idPaciente+"/Anamnese/"+anamnese.getId()+"/";
	}	
}
