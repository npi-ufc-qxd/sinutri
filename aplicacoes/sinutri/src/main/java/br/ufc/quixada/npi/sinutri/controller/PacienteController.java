package br.ufc.quixada.npi.sinutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;


@Controller
@RequestMapping(value = "/Paciente")
public class PacienteController {
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/"}, method = RequestMethod.GET)
	public String getAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, HttpSession session){
		Pessoa pessoa = getUsuarioLogado(session);
		Servidor nutricionista = pessoaService.buscarServidorByPessoa(pessoa);
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		AvaliacaoAntropometrica avaliacaoAntropometrica = new AvaliacaoAntropometrica(paciente);
		
		avaliacaoAntropometrica.setNutricionista(nutricionista);
		avaliacaoAntropometrica.setCriadoEm(new Date());
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		model.addAttribute("action","cadastrar");
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "nutricao/antropometria/form-cadastrar";
	}
	
	@RequestMapping(value={"/{idPaciente}/Antropometria/"}, method = RequestMethod.POST)
	public String adicionarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid AvaliacaoAntropometrica avaliacaoAntropometrica, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		if(paciente == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente inválido. Tente novamente!");
			return "nutricao/antropometria/form-cadastrar";
		}else if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "nutricao/antropometria/form-cadastrar";
		}
		pacienteService.adicionarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		return "redirect:/paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId()+"/";
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Editar/"}, method = RequestMethod.GET)
	public String getEditarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, Model model){
		AvaliacaoAntropometrica avaliacaoAntropometrica = pacienteService.buscarAvaliacaoAntropometricaById(idAntropometria);
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "nutricao/antropometria/form-editar";
	}
	@RequestMapping(value={"/{idPaciente}/Antropometria/{idAntropometria}/Editar/"}, method = RequestMethod.POST)
	public String editarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid AvaliacaoAntropometrica avaliacaoAntropometrica, BindingResult result, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		if(paciente == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente inválido. Tente novamente!");
			return "nutricao/antropometria/form-cadastrar";
		}else if(result.hasErrors()){
			model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
			return "nutricao/antropometria/form-cadastrar";
		}
		pacienteService.editarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		return "redirect:/paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId()+"/";
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/"}, method = RequestMethod.GET)
	public String getVisualizarAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, RedirectAttributes redirectAttributes, Model model){
		
		AvaliacaoAntropometrica avaliacaoAntropometrica = pacienteService.buscarAvaliacaoAntropometricaById(idAntropometria);
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		if(paciente == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente inválido. Tente novamente!");
			return "nutricao/antropometria/form-cadastrar";
		}	
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "nutricao/antropometria/visualizar-antropometria";
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Excluir/"}, method = RequestMethod.GET)
	public String getExcluirAntropometria(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, RedirectAttributes redirectAttributes, Model model){
		
		AvaliacaoAntropometrica avaliacaoAntropometrica = pacienteService.buscarAvaliacaoAntropometricaById(idAntropometria);
		Paciente paciente = pacienteService.find(Paciente.class, idPaciente);
		if(paciente == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente inválido. Tente novamente!");
			return "nutricao/antropometria/form-cadastrar";
		}
		pacienteService.excluirAvaliacaoAntropometrica(avaliacaoAntropometrica);
		return "redirect:/paciente/"+paciente.getId()+"/Antropometria/";
	}	
}

