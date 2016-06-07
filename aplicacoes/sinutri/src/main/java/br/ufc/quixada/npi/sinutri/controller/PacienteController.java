package br.ufc.quixada.npi.sinutri.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;
import br.ufc.quixada.npi.sinutri.model.enuns.Refeicao;
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

	
	//Recordatorio	
	@RequestMapping(value = "/{idPaciente}/Recordatorio", method = RequestMethod.GET)
    public String formAdicionarRecordatorio( @PathVariable("idPaciente") Long idPaciente, Model model ) {		
        System.out.println("aksjdhalskdh");
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);	        	        
        if(paciente==null){
        	return "redirect:/Nutricao/buscar";
	    }	        
        model.addAttribute("paciente", paciente);
        model.addAttribute("recordatorio", new Recordatorio());
        
        return "recordatorio/adicionar-recordatorio";
	}
	    
    @RequestMapping(value = "/{idPaciente}/Recordatorio", method = RequestMethod.POST)
    public String adicionarRecordatorio( @ModelAttribute("recordatorio") Recordatorio recordatorio,
            @PathVariable("idPaciente") Long idPaciente, Model model ) {
    	
    	Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
    	Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
    	
    	recordatorio.setNutricionista(nutricionista);
    	recordatorio.setPaciente(paciente);
    	
        consultaService.adicionarRecordatorio(recordatorio);
        return "redirect:/Paciente/" + idPaciente + "/Recordatorio/" + recordatorio.getId();
    }	
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Refeicao/{idRefeicao}/Editar/", method = RequestMethod.GET)
	public String formEditarRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio, 
			Model model){
		
		Paciente paciente = this.pacienteService.buscarPacientePorId(idPaciente);
		if(paciente==null){
        	return "redirect:/Nutricao/buscar";
        }					
		Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
		model.addAttribute("paciente", paciente);
		model.addAttribute("recordatorio", recordatorio);
		
		return "recordatorio/editar-recordatorio";
	}
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Refeicao/{idRefeicao}/Editar/", method = RequestMethod.POST)
	public String editarRecordatorio(@Valid @ModelAttribute("recordatorio") Recordatorio recordatorio,
			@PathVariable("idPaciente") Long idPaciente,BindingResult result, Model model){
		
		if( result.hasErrors() ){
			model.addAttribute("recordatorio", recordatorio);
			return "recordatorio/editar-recordatorio";
		}
		
		this.consultaService.editarRecordatorio(recordatorio);
		
		return "redirect:/Paciente/" + idPaciente + "/Recordatorio/" + recordatorio.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Excluir", method = RequestMethod.POST)
	public String excluirRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio){
		
		Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
		if (recordatorio!=null){
			this.consultaService.excluirRecordatorio(recordatorio);
		}
		
		return "redirect:/Paciente/" + idPaciente;
	}	
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/", method = RequestMethod.GET)
	public String visulizarRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio, 
			Model model){
		
		Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente==null){
			return "redirect:/Nutricao/buscar";
        }
		
        model.addAttribute("paciente", paciente);
		model.addAttribute("recordatorio", recordatorio);
		
		return "recordatorio/visualizar-recordatorio";
	}			

	@ModelAttribute("tiposRefeicao")
	public Refeicao[] getTiposRefeicao(){
		return Refeicao.values();
	}
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Refeicao/{idRefeicao}/Excluir", method = RequestMethod.POST)
	public String excluirRefeicaoRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio,
			@PathVariable("idRefeicao") Long idRefeicao){
		
		RefeicaoRecordatorio refeicao = consultaService.buscarRefeicaoRecordatorio(idRefeicao);
		
		this.consultaService.excluirRefeicaoRecordatorio(refeicao);
		
		return "redirect:/Paciente/" + idPaciente + "/Recordatorio/" + idRecordatorio;
	}		

	private String getCpfPessoaLogada() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
