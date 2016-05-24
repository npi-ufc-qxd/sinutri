package br.ufc.quixada.npi.sinutri.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.sinutri.service.PacienteService;

@Controller
@RequestMapping(value = "/Paciente")
public class PacienteController {
	
	@Inject
	private PacienteService pacienteService;
	
	@Inject
	private ConsultaNutricionalService consultaNutricionalService;
	
//	@RequestMapping(value = "{id}/avalicao-laboratorial", method = RequestMethod.GET)
//	public String formAdicionarAvaliacaoLaboratorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
//
//		Paciente paciente = pacienteService.
//		
//		if(paciente != null){
//						
//			model.addAttribute("paciente", paciente);
//			
//			AvaliacaoLaboratorial avaliacaoLaboratorial = new AvaliacaoLaboratorial();
//			
//			avaliacaoLaboratorial.setCriadoEm(new Date());
//			
//			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
//			
//			return "nutricao/cadastrar-avaliacao-laboratorial";
//		}else{
//			//decidir pra onde retornar
//			return "redirect:/paciente/"+id+"/listar";
//		}
//	}
//	
//	@RequestMapping(value = "{id}/avalicao-laboratorial", method = RequestMethod.POST)
//	public String adicionarAvaliacaoLaboratorial(@PathVariable("id") Long id, @Valid AvaliacaoLaboratorial avaliacaoLaboratorial, BindingResult bindingResult, Model model){
//		
//		Paciente paciente = pacienteService.find(Paciente.class, id);
//		
//		if(paciente != null){
//			
//			if (bindingResult.hasErrors()) {
//				
//				model.addAttribute("paciente", paciente);
//				model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
//				//decidir pra onde retornar
//				return "nutricao/cadastrar-avaliacao-laboratorial";
//			}
//			
//			avaliacaoLaboratorial.setPaciente(paciente);
//			
//			pacienteService.adicionar(avaliacaoLaboratorial);
//		}
//		
//		//decidir pra onde retornar
//		return "redirect:/paciente/"+id+"/listar";
//	}
//	
//	@RequestMapping(value = "/{idPaciente}/avalicao-laboratorial/{idAvaliacaoLaboratorial}/visualizar", method = RequestMethod.GET)
//	public String visualizarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, Model model){
//		
//		AvaliacaoLaboratorial avaliacaoLaboratorial = pacienteService.buscarAvaliacaoLaboratorial(idAvaliacaoLaboratorial);
//		
//		if(avaliacaoLaboratorial != null){
//			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
//			
//			return "nutricao/visualizar-avaliacao-laboratorial";
//		}
//		//decidir pra onde retornar
//		return "redirect:/paciente/"+idPaciente+"/listar";
//	}
//	
//	@RequestMapping(value = "/{idPaciente}/avalicao-laboratorial/{idAvaliacaoLaboratorial}/editar", method = RequestMethod.GET)
//	public String formEditarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, Model model){
//		
//		AvaliacaoLaboratorial avaliacaoLaboratorial = pacienteService.buscarAvaliacaoLaboratorial(idAvaliacaoLaboratorial);
//		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
//		
//		if(avaliacaoLaboratorial != null && paciente != null){
//			
//			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
//			model.addAttribute("paciente", paciente);
//			
//			return "nutricao/editar-avaliacao-laboratorial";
//		}else{
//			//decidir pra onde retornar
//			return "redirect:/paciente/"+idPaciente+"/listar";
//		}
//	}
//	
//	@RequestMapping(value = "/{idPaciente}/avalicao-laboratorial/{idAvaliacaoLaboratorial}/editar", method = RequestMethod.POST)
//	public String editarAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial, @Valid AvaliacaoLaboratorial avaliacaoLaboratorialAtual, Model model, BindingResult bindingResult){
//		
//		AvaliacaoLaboratorial avaliacaoLaboratorialExistente = pacienteService.buscarAvaliacaoLaboratorial(idAvaliacaoLaboratorial);
//		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
//		
//		if(avaliacaoLaboratorialExistente != null && paciente != null){
//			
//			if (bindingResult.hasErrors()) {
//				model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorialAtual);
//				model.addAttribute("paciente", paciente);
//				
//				return "nutricao/editar-avaliacao-laboratorial";
//			}
//			
//			avaliacaoLaboratorialAtual.setId(idAvaliacaoLaboratorial);
//			pacienteService.atualizar(avaliacaoLaboratorialAtual);
//		}
//		
//		//decidir pra onde retornar
//		return "redirect:/paciente/"+idPaciente+"/listar";
//	}
//	
//	@RequestMapping(value = "/{idPaciente}/avalicao-laboratorial/{idAvaliacaoLaboratorial}/excluir", method = RequestMethod.GET)
//	public String excluirAvaliacaoLaboratorial(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAvaliacaoLaboratorial") Long idAvaliacaoLaboratorial){
//		
//		AvaliacaoLaboratorial avaliacaoLaboratorial = pacienteService.buscarAvaliacaoLaboratorial(idAvaliacaoLaboratorial);
//		
//		if(avaliacaoLaboratorial != null){
//			
//			pacienteService.excluir(avaliacaoLaboratorial);
//			//decidir pra onde retornar
//			return "redirect:/paciente/"+idPaciente+"/listar";
//		}
//		//decidir pra onde retornar
//		return "redirect:/paciente/"+idPaciente+"/listar";
//	}

}
