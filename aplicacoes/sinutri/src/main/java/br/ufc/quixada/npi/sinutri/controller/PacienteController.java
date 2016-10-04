package br.ufc.quixada.npi.sinutri.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.CalculoGastoEnergetico;
import br.ufc.quixada.npi.sinutri.model.DistribuicaoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Grupo;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Mensagem;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Prioridade;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Tipo;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Prescricao;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.enuns.Apetite;
import br.ufc.quixada.npi.sinutri.model.enuns.Exame;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;
import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;
import br.ufc.quixada.npi.sinutri.model.enuns.Refeicao;
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
	private PacienteService pacienteService;
	
	@Inject
	private PessoaService pessoaService;
	
	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ConsultaService consultaService;
		
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
		
		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexistente.", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA);
			
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		
		if (bindingResult.hasErrors()) {
			avaliacaoLaboratorial.setPaciente(paciente);
			model.addAttribute("avaliacaoLaboratorial", avaliacaoLaboratorial);
		
			return "avaliacao-laboratorial/cadastrar";
		}
		
		String cpfPessoaLogada = getCpfPessoaLogada();
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(cpfPessoaLogada);
		
		if(nutricionista == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Nutricionista inexistente", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "redirect:/Nutricao/Buscar";
		}
		
		avaliacaoLaboratorial.setNutricionista(nutricionista);
		consultaService.adicionarAvaliacaoLaboratorial(avaliacaoLaboratorial, paciente);
		
		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Paciente/"+idPaciente+"/AvaliacaoLaboratorial/"+avaliacaoLaboratorial.getId();
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
				
		consultaService.editarAvaliacaoLaboratorial(avaliacaoLaboratorial);
		
		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Paciente/"+idPaciente+"/AvaliacaoLaboratorial/"+avaliacaoLaboratorial.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/AvaliacaoLaboratorial/{idAvaliacaoLaboratorial}", method = RequestMethod.GET)
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
		}
		
		consultaService.excluirAvaliacaoLaboratorial(avaliacaoLaboratorial);
			
		Mensagem mensagem = new Mensagem("Excluído com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);

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
	
//************************************************************************************************************ INICIO PLANO ALIMENTAR	
	@RequestMapping(value= "/{idPaciente}/PlanoAlimentar", method = RequestMethod.GET)
	public String formAdicionarPlanoAlimentar(@PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if (paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:Nutricao/Buscar";
		}
		
		PlanoAlimentar planoAlimentar = new PlanoAlimentar(paciente);
		planoAlimentar.setCriadoEm(new Date());
		model.addAttribute("planoAlimentar", planoAlimentar);
		return "/plano-alimentar/cadastrar";
	}
	
	@RequestMapping(value = "/{idPaciente}/PlanoAlimentar", method = RequestMethod.POST)
	public String adicionarPlanoAlimentar(@PathVariable("idPaciente") Long idPaciente, @Valid PlanoAlimentar planoAlimentar, BindingResult result, Model model, RedirectAttributes redirectAttributes){
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(paciente==null){
			mensagens.add(new Mensagem("Erro ao adicionar Plano alimentar!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		
		if(result.hasErrors()){
			planoAlimentar.setPaciente(paciente);
			model.addAttribute("planoAlimentar", planoAlimentar);
			return "/plano-alimentar/cadastrar";
		}
		
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		
		if(nutricionista==null){
			mensagens.add(new Mensagem("Erro ao adicionar Plano alimentar!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Nutricionista não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		
		
		planoAlimentar.setNutricionista(nutricionista);
		planoAlimentar.setPaciente(paciente);
		mensagens.add(new Mensagem("Salvo com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA));
		consultaService.adicionarPlanoAlimentar(planoAlimentar);
		
		return "redirect:/Paciente/"+paciente.getId()+"/PlanoAlimentar/"+planoAlimentar.getId();
	}
	
	@RequestMapping(value = "/{idPaciente}/PlanoAlimentar/{idPlanoAlimentar}/Editar", method = RequestMethod.GET)
	public String formEditarPlanoAlimentar(@PathVariable("idPlanoAlimentar") Long idPlanoAlimentar, @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		PlanoAlimentar planoAlimentar = consultaService.buscarPlanoAlimentarPorId(idPlanoAlimentar);
		
		if(planoAlimentar==null){
			Mensagem mensagem = new Mensagem("Plano Alimentar não encontrada!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Paciente/"+paciente.getId();
		}
		model.addAttribute("planoAlimentar", planoAlimentar);
		
		return "plano-alimentar/editar";
	}
	
	@RequestMapping(value = "/{idPaciente}/PlanoAlimentar/{idPlanoAlimentar}/Editar", method = RequestMethod.POST)
	public String editarPlanoAlimentar(Model model, @PathVariable("idPlanoAlimentar") Long idPlanoAlimentar, @PathVariable("idPaciente") Long idPaciente, @Valid PlanoAlimentar planoAlimentar, BindingResult result, RedirectAttributes redirectAttributes){		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(result.hasErrors()){
			model.addAttribute("planoAlimentar", planoAlimentar);
			return "/plano-alimentar/editar";
		}
		if(paciente == null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "/plano-alimentar/cadastrar";
		}
		if (planoAlimentar.getId()==null){
			Mensagem mensagem = new Mensagem("Erro ao editar Plano Alimentar!", Tipo.ERRO, Prioridade.ALTA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Paciente/"+paciente.getId();			
		} 
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		if(isInvalidoNutricionista(nutricionista)){
			List <Mensagem> mensagens = new ArrayList<Mensagem>();
			mensagens.add(new Mensagem("Erro ao editar Plano Alimentar!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Nutricionista não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		Mensagem mensagem = new Mensagem("Editado com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagens", mensagem);
		consultaService.editarPlanoAlimentar(planoAlimentar);
		return "redirect:/Paciente/"+paciente.getId()+"/PlanoAlimentar/"+planoAlimentar.getId();
	}
	
	@RequestMapping(value= {"/{idPaciente}/PlanoAlimentar/{idPlanoAlimentar}"}, method = RequestMethod.GET)
	public String visualizarPlanoAlimentar(@PathVariable("idPlanoAlimentar") Long idPlanoAlimentar, @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		PlanoAlimentar planoAlimentar = consultaService.buscarPlanoAlimentarPorId(idPlanoAlimentar);
		
		if(planoAlimentar==null){
			Mensagem mensagem = new Mensagem("Plano Alimentar não encontrada!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Paciente/"+paciente.getId();
		}
		model.addAttribute("paciente", paciente);
		model.addAttribute("planoAlimentar", planoAlimentar);
		
		return "plano-alimentar/visualizar";
	}
	@RequestMapping(value= {"/{idPaciente}/PlanoAlimentar/{idPlanoAlimentar}/Excluir"}, method = RequestMethod.GET)
	public String excluirPlanoAlimentar(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPlanoAlimentar") Long idPlanoAlimentar, RedirectAttributes redirectAttributes, Model model){
		PlanoAlimentar planoAlimentar = consultaService.buscarPlanoAlimentarPorId(idPlanoAlimentar);
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente == null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagens", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		consultaService.excluirPlanoAlimentar(planoAlimentar);
		return "redirect:/Paciente/"+paciente.getId();
	}

	@RequestMapping(value= "/{idPaciente}/PlanoAlimentar/Alimentos", params = {"fonte"}, method = RequestMethod.GET)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ResponseBody
	public List<Alimento> pegarAlimentos(@RequestParam("fonte") FonteAlimento fonte){
		return consultaService.buscarAlimentosPorFonte(fonte);
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
		mensagens.add(new Mensagem("Salvo com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Editar"}, method = RequestMethod.GET)
	public String formEditarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, Model model, RedirectAttributes redirectAttributes){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		
		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			Mensagem mensagem = new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
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
		if (avaliacaoAntropometrica.getId()==null){
			mensagens.add(new Mensagem("Erro ao editar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Paciente/"+paciente.getId();			
		} 
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		if(isInvalidoNutricionista(nutricionista)){
			mensagens.add(new Mensagem("Erro ao editar Avaliação Antropométrica!", Tipo.ERRO, Prioridade.ALTA));
			mensagens.add(new Mensagem("Nutricionista não encontrada!", Tipo.ERRO, Prioridade.MEDIA));
			redirectAttributes.addFlashAttribute("mensagens", mensagens);
			return "redirect:/Nutricao/Buscar";
		}
		mensagens.add(new Mensagem("Salvo com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA));
		redirectAttributes.addFlashAttribute("mensagens", mensagens);
		avaliacaoAntropometrica.setNutricionista(nutricionista);
		avaliacaoAntropometrica.setPaciente(paciente);
		avaliacaoAntropometrica.setAtualizadoEm(new Date());
		consultaService.adicionarAvaliacaoAntropometrica(avaliacaoAntropometrica);
		return "redirect:/Paciente/"+paciente.getId()+"/Antropometria/"+avaliacaoAntropometrica.getId();
	}
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}"}, method = RequestMethod.GET)
	public String visualizarAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria, RedirectAttributes redirectAttributes, Model model){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);

		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}

		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			Mensagem mensagem = new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+paciente.getId();
		}
		model.addAttribute("avaliacaoAntropometrica", avaliacaoAntropometrica);
		return "antropometria/visualizar";
	}
	
	@RequestMapping(value= {"/{idPaciente}/Antropometria/{idAntropometria}/Excluir"}, method = RequestMethod.GET)
	public String excluirAvaliacaoAntropometrica(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idAntropometria") Long idAntropometria
			, RedirectAttributes redirectAttributes, Model model){
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(isInvalido(paciente)){
			Mensagem mensagem = new Mensagem("Paciente inexestente", Tipo.SUCESSO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		AvaliacaoAntropometrica avaliacaoAntropometrica = consultaService.buscarAvaliacaoAntropometricaPorId(idAntropometria);
		if(isInvalidoAntropometria(avaliacaoAntropometrica)){
			Mensagem mensagem = new Mensagem("Avaliação Antropométrica não encontrada!", Tipo.ERRO, Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+paciente.getId();
		}
		consultaService.excluirAvaliacaoAntropometrica(avaliacaoAntropometrica);
		Mensagem mensagem = new Mensagem("Excluído com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
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
	public String adicionarPacienteExterno(Model model, @Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("pessoa", pessoa);
		
			return "/paciente/cadastrar";
		}
		
		pessoa.setExterno(true);
		pessoaService.adicionarPessoa(pessoa);
		
		Paciente paciente = new Paciente();
		paciente.setPessoa(pessoa);
		pacienteService.adicionarPaciente(paciente);

		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Paciente/" + paciente.getId();
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
		
		model.addAttribute("paciente", paciente);

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

	@RequestMapping(value="/{idPaciente}/Prescricao", method = RequestMethod.GET)
	public String formAdicionarPrescricao(@PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes, 
			Model model){
	
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
	
		Prescricao prescricao = new Prescricao();
		prescricao.setPaciente(paciente);
		prescricao.setCriadoEm(new Date());
	 
		model.addAttribute("prescricao", prescricao);
		return "/prescricao/cadastrar";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao", method = RequestMethod.POST)
	 public String adicionarPrescricao(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid Prescricao prescricao,
			 		BindingResult result, RedirectAttributes redirectAttributes){
		
		 if(result.hasErrors()){
			 model.addAttribute("prescricao", prescricao);
			 Mensagem mensagem = new Mensagem("Erro ao adicionar prescrição!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "/prescricao/cadastrar";
		 }
		 
		 Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		 
		 if(nutricionista == null){
			 Mensagem mensagem = new Mensagem("Nutricionista não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Nutricao/Buscar";
		 }
		 
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 
		 if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		 }
	
		 prescricao.setNutricionista(nutricionista);
		 prescricao.setAtualizadoEm(new Date());
		 consultaService.adicionarPrescricao(prescricao);
		 Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		 redirectAttributes.addFlashAttribute("mensagem", mensagem);
		 
		 return "redirect:/Paciente/"+paciente.getId()+"/Prescricao/"+prescricao.getId();
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Editar", method = RequestMethod.GET)
	 public String formEditarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao,
		 Model model, RedirectAttributes redirectAttributes){		 
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 Prescricao prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);
		 if(paciente == null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		 }
		else if(prescricao == null){
			Mensagem mensagem = new Mensagem("Prescrição não encontrada!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
		 
		 prescricao.setPaciente(paciente);
		 model.addAttribute("prescricao", prescricao);
		 return "prescricao/editar";
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Editar", method = RequestMethod.POST)
	 public String editarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao,
			 @Valid Prescricao prescricao, BindingResult result, Model model, RedirectAttributes redirectAttributes){
		 
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
	
		 if(result.hasErrors()){
			 model.addAttribute("prescricao", prescricao);
			 return "/prescricao/editar";
		 }
		 
		 Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		 
		 if(nutricionista == null){
			 Mensagem mensagem = new Mensagem("Nutricionista não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Nutricao/Buscar";
		 }
		 
		 prescricao.setNutricionista(nutricionista);
		 prescricao.setPaciente(paciente);
		 prescricao.setAtualizadoEm(new Date());
		 
		 if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		 }
		 
		 prescricao.setAtualizadoEm(new Date());
		 consultaService.editarPrescricao(prescricao);
		 Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		 redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		 return "redirect:/Paciente/"+idPaciente+"/Prescricao/"+prescricao.getId();
	 }
	
	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}", method = RequestMethod.GET)
	 public String visualizarPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao, 
			 RedirectAttributes redirectAttributes, Model model){
		 
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
		    return "redirect:/Nutricao/Buscar";
		 }
		 Prescricao prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);
		 if(prescricao==null){
			 Mensagem mensagem = new Mensagem("Prescrição não encontrada!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Paciente/"+idPaciente;
		 }

		 model.addAttribute("prescricao", prescricao);
		 return "prescricao/visualizar";
	 }

	 @RequestMapping(value="/{idPaciente}/Prescricao/{idPrescricao}/Excluir", method = RequestMethod.GET)
	 public String excluirPrescricao(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idPrescricao") Long idPrescricao, RedirectAttributes redirectAttributes){

		 Prescricao prescricao = consultaService.buscarPrescricaoPorId(idPrescricao);

		 if(prescricao == null){
			 Mensagem mensagem = new Mensagem("Prescrição não encontrada!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Paciente/"+idPaciente;
		 }
		 consultaService.excluirPrescricao(prescricao);
		 Mensagem mensagem = new Mensagem("Excluído com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		 redirectAttributes.addFlashAttribute("mensagem", mensagem);
		 return "redirect:/Paciente/"+idPaciente;
	}

	@RequestMapping(value = "/{idPaciente}/Recordatorio", method = RequestMethod.GET)
    public String formAdicionarRecordatorio( @PathVariable("idPaciente") Long idPaciente, Model model,
    		RedirectAttributes redirect) {		
        
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);	        	        
        if( paciente == null ){
        	redirect.addFlashAttribute("mensagem", new Mensagem("Paciente inexistente.", Tipo.ERRO, Prioridade.MEDIA));
        	return "redirect:/Nutricao/Buscar";
	    }	        
        
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setPaciente(paciente);
        model.addAttribute("paciente", paciente);
        model.addAttribute("recordatorio", recordatorio);
        
        return "recordatorio/cadastrar";
        
	}
	    
    @RequestMapping(value = "/{idPaciente}/Recordatorio", method = RequestMethod.POST)
    public String adicionarRecordatorio( @ModelAttribute("recordatorio") Recordatorio recordatorio,
            @PathVariable("idPaciente") Long idPaciente, Model model, RedirectAttributes redirect ) {
    	
    	Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
    	if( nutricionista == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Nutricionista inexistente.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Nutricao/Buscar";
    	}
    	
    	Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
    	if( paciente == null ){
        	redirect.addFlashAttribute("mensagem", new Mensagem("Paciente inexistente.", Tipo.ERRO, Prioridade.MEDIA));
        	return "redirect:/Nutricao/Buscar";
	    }
    	
    	if( recordatorio.getRefeicoes().isEmpty() ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório deve possuir refeições.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente+"/Recordatorio";
    	}
    		
    	recordatorio.setNutricionista(nutricionista);
    	recordatorio.setPaciente(paciente);
    	
        consultaService.adicionarRecordatorio(recordatorio);
        redirect.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso!", Tipo.SUCESSO, Prioridade.BAIXA));
        
        return "redirect:/Paciente/" + idPaciente + "/Recordatorio/" + recordatorio.getId();
        
    }	
	
    @RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Editar", method = RequestMethod.GET )
    public String formEditarRecordatorio( @PathVariable("idRecordatorio") Long idRecordatorio,
    		@PathVariable("idPaciente") Long idPaciente,  
    		Model model, RedirectAttributes redirect) {
    	
    	Paciente paciente = this.pacienteService.buscarPacientePorId(idPaciente);
    	if( paciente == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Paciente não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Nutricao/Buscar";
    	}
    	
    	Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
    	if( recordatorio == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente;
    	}
    	
    	if( recordatorio.getRefeicoes().isEmpty() ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório deve possuir refeições.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente+"/Recordatorio";
    	}
    	
    	model.addAttribute("paciente", paciente);
    	model.addAttribute("recordatorio", recordatorio);
    	
    	return "recordatorio/editar";
    	
    }
    
    @RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Editar", method = RequestMethod.POST )
    public String editarRecordatorio( @ModelAttribute("recordatorio") Recordatorio recordatorio,
    		@PathVariable("idRecordatorio") Long idRecordatorio,
    		@PathVariable("idPaciente") Long idPaciente,  
    		Model model, RedirectAttributes redirect) {
    	
    	
    	if( recordatorio == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente;
    	}
    	
    	Paciente paciente = this.pacienteService.buscarPacientePorId(idPaciente);
    	if( paciente == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Paciente não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Nutricao/Buscar";
    	}
    	
    	if( recordatorio.getRefeicoes().isEmpty() ){
    		model.addAttribute("paciente", paciente);
    		model.addAttribute("recordatorio", recordatorio);
    		model.addAttribute("mensagem", new Mensagem("Recordatório deve possuir refeições.", Tipo.ERRO, Prioridade.MEDIA));
    		return "recordatorio/editar";
    	}
    	
    	
    	consultaService.editarRecordatorio(recordatorio);
    	
    	redirect.addFlashAttribute("mensagem", new Mensagem("Salvo com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA));
    	
    	return "redirect:/Paciente/"+idPaciente+"/Recordatorio/"+idRecordatorio;
    	
    }
    
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}", method = RequestMethod.GET)
	public String visulizarRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio, 
			Model model, RedirectAttributes redirect){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if( paciente == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Paciente não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Nutricao/Buscar";
    	}
		
		Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
    	if( recordatorio == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente;
    	}
		
        model.addAttribute("paciente", paciente);
		model.addAttribute("recordatorio", recordatorio);
		
		return "recordatorio/visualizar";
	}
	
	@RequestMapping(value = "/{idPaciente}/Recordatorio/{idRecordatorio}/Excluir", method = RequestMethod.GET)
	public String excluirRecordatorio(@PathVariable("idPaciente") Long idPaciente, 
			@PathVariable("idRecordatorio") Long idRecordatorio,
			RedirectAttributes redirect){
		
		Recordatorio recordatorio = this.consultaService.buscarRecordatorio(idRecordatorio);
		
		if( recordatorio == null ){
    		redirect.addFlashAttribute("mensagem", new Mensagem("Recordatório não encontrado.", Tipo.ERRO, Prioridade.MEDIA));
    		return "redirect:/Paciente/"+idPaciente;
    	}
		
		this.consultaService.excluirRecordatorio(recordatorio);
		
		redirect.addFlashAttribute("mensagem", new Mensagem("Excluído com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA));
		
		return "redirect:/Paciente/" + idPaciente;
	}

	@RequestMapping(value="/{idPaciente}/CalculoEnergetico", method = RequestMethod.GET)
	public String formAdicionarCalculosGastosEnergeticos(@PathVariable("idPaciente") Long idPaciente, RedirectAttributes redirectAttributes, 
			Model model){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		List<DistribuicaoAlimentar> distribuicoesAlimentares = new ArrayList<DistribuicaoAlimentar>();
		
		for(Grupo grupo: consultaService.getGrupos()){
			DistribuicaoAlimentar distribuicaoAlimentar = new DistribuicaoAlimentar();
			distribuicaoAlimentar.setGrupo(grupo);			
			distribuicoesAlimentares.add(distribuicaoAlimentar);
		}
		CalculoGastoEnergetico calculoEnergetico = new CalculoGastoEnergetico();
		calculoEnergetico.setPaciente(paciente);
		calculoEnergetico.setCriadoEm(new Date());
		calculoEnergetico.setCriadoEm(new Date());
		calculoEnergetico.setDistribuicoesAlimentares(distribuicoesAlimentares);
		
		model.addAttribute("calculoEnergetico",calculoEnergetico);
		
		return "/calculo-energetico/cadastrar";	
	}
	
	@RequestMapping(value="/{idPaciente}/CalculoEnergetico", method = RequestMethod.POST)
	public String adicionarCalculoGastosEnergeticos(@PathVariable("idPaciente") Long idPaciente, Model model, @Valid CalculoGastoEnergetico calculoEnergetico,
	 		BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			model.addAttribute("calculoEnergetico", calculoEnergetico);
			Mensagem mensagem = new Mensagem("Erro ao adicionar cálculo energético!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "/calculo-energetico/cadastrar";
		}
		
		
		Servidor nutricionista = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());
		 
		 if(nutricionista == null){
			 Mensagem mensagem = new Mensagem("Nutricionista não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Nutricao/Buscar";
		 }
		 
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 
		 if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		 }
		 calculoEnergetico.setNutricionista(nutricionista);
		 consultaService.adicionarCalculoGastoEnergetico(calculoEnergetico);
		 Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		 redirectAttributes.addFlashAttribute("mensagem", mensagem);
		 return "redirect:/Paciente/"+paciente.getId()+"/CalculoEnergetico/"+calculoEnergetico.getId();
	}
	
	@RequestMapping(value="/{idPaciente}/CalculoEnergetico/{idCalculoEnergetico}/Editar", method = RequestMethod.GET)
	public String formEditarCalculoGastosEnergeticos(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idCalculoEnergetico") 
			Long idCalculoEnergetico, Model model, RedirectAttributes redirectAttributes){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente == null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		
		CalculoGastoEnergetico calculoEnergetico = consultaService.buscarCalculoGastoEnergeticoPorId(idCalculoEnergetico);
		if(calculoEnergetico == null){
			Mensagem mensagem = new Mensagem("Cálculo energético não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
		
		calculoEnergetico.setPaciente(paciente);
		model.addAttribute("calculoEnergetico", calculoEnergetico);
		return "calculo-energetico/editar";
	}
	
	@RequestMapping(value="/{idPaciente}/CalculoEnergetico/{idCalculoEnergetico}/Editar", method = RequestMethod.POST)
	public String editarCalculoGastosEnergeticos(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idCalculoEnergetico") Long idCalculoEnergetico,
			@Valid CalculoGastoEnergetico calculoEnergetico ,Model model, RedirectAttributes redirectAttributes){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente == null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Nutricao/Buscar";
		}
		
		if(calculoEnergetico == null){
			Mensagem mensagem = new Mensagem("Cálculo energético não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente+"/CalculoEnergetico/"+idCalculoEnergetico;
		}
		
		consultaService.editarCalculoGastoEnergetico(calculoEnergetico);
		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		return "redirect:/Paciente/"+idPaciente+"/CalculoEnergetico/"+idCalculoEnergetico;
	}
	@RequestMapping(value="/{idPaciente}/CalculoEnergetico/{idCalculoEnergetico}", method = RequestMethod.GET)
	public String visualizarCalculoGastoEnergetico(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idCalculoEnergetico") Long idCalculoEnergetico, 
			Model model, RedirectAttributes redirectAttributes){
		
		 Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		 if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente inexistente!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
		    return "redirect:/Nutricao/Buscar";
		 }
		 
		 CalculoGastoEnergetico calculoEnergetico = consultaService.buscarCalculoGastoEnergeticoPorId(idCalculoEnergetico);
		 if(calculoEnergetico == null){
			 Mensagem mensagem = new Mensagem("Cálculo energético não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			 redirectAttributes.addFlashAttribute("mensagem", mensagem);
			 return "redirect:/Paciente/"+idPaciente;
		 }
		
		model.addAttribute("calculoEnergetico", calculoEnergetico);
		return "calculo-energetico/visualizar";
	}
	
	@RequestMapping(value="/{idPaciente}/CalculoEnergetico/{idCalculoEnergetico}/Excluir", method = RequestMethod.GET)
	public String excluirCalculoGastoEnergetico(@PathVariable("idPaciente") Long idPaciente, @PathVariable("idCalculoEnergetico") Long idCalculoEnergetico, 
			 RedirectAttributes redirectAttributes, Model model){
		
		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
		if(paciente==null){
			Mensagem mensagem = new Mensagem("Paciente não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "Nutricao/Buscar";
		}
		
		CalculoGastoEnergetico calculoEnergetico = consultaService.buscarCalculoGastoEnergeticoPorId(idCalculoEnergetico);
		
		if(calculoEnergetico==null){
			Mensagem mensagem = new Mensagem("Cálculo energético não encontrado!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.MEDIA);
			redirectAttributes.addFlashAttribute("mensagem", mensagem);
			return "redirect:/Paciente/"+idPaciente;
		}
		
		consultaService.excluirCalculoGastoEnergetico(calculoEnergetico);
		Mensagem mensagem = new Mensagem("Excluído com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		return "redirect:/Paciente/"+idPaciente;
	}
	
	@RequestMapping(value ="/Registrar/{cpf}", method = RequestMethod.GET)
	public String registrarPaciente(@PathVariable("cpf") String cpf, RedirectAttributes redirectAttributes){
		
		Usuario usuario = usuarioService.getByCpf(cpf);
		if (usuario == null){
			redirectAttributes.addFlashAttribute("mensagem", new Mensagem("CPF invalido!", Mensagem.Tipo.ERRO, Mensagem.Prioridade.ALTA));
			return "Nutricao/Buscar";
		}
		
		Paciente paciente  = pacienteService.buscarPacientePorCPF(cpf);
		if (isInvalido(paciente)) {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(usuario.getNome());
			pessoa.setCpf(usuario.getCpf());
			pessoa.setDataNascimento(usuario.getNascimento());
			pessoa.setEmail(usuario.getEmail());
			pessoa.setSexo(null);
			pessoa.setOcupacaoOuCargo(usuario.getCargo());
			pessoa.setTelefone(usuario.getTelefone());
			pessoa.setVinculo(null);
			pessoa.setExterno(false);
			
			paciente  = new Paciente();
			paciente.setPessoa(pessoa);
			pacienteService.adicionarPaciente(paciente);
		}
		return "redirect:/Paciente/"+paciente.getId();
	}

	@ModelAttribute("tiposRefeicao")
	public Refeicao[] getTiposRefeicao(){
		return Refeicao.values();
	}
	
	private boolean isInvalidoNutricionista(Servidor nutricionista){
		return nutricionista == null;
	}
	
	private String getCpfPessoaLogada() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = (Usuario) authentication.getPrincipal();
		return usuario.getCpf();
	}
	
	private boolean isInvalido(Paciente paciente){
		return paciente == null;
	}

	private boolean isInvalidoAntropometria(AvaliacaoAntropometrica avaliacaoAntropometrica){
		return avaliacaoAntropometrica == null;
	}
	
	@RequestMapping(value = "/prototipo", method = RequestMethod.GET)
	public String visulizarRecordatorio(){
		
		
		return "prototipo";
	}
	
}
