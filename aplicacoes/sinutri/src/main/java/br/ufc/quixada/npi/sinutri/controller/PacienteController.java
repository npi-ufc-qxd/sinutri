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
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.Apetite;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaUrinario;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Mensagem;
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
		if(anamnese != null){
			model.addAttribute("anamnese",anamnese);
			return "/anamnese/visualizar";
		}else{
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Anamnese não encontrada.",Mensagem.Tipo.ERRO,Mensagem.Prioridade.ALTA));
			return "redirect:/Paciente/"+idPaciente;
		}
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

	private String getCpfPessoaLogada() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
