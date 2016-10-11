package br.ufc.quixada.npi.sinutri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.Grupo;
import br.ufc.quixada.npi.sinutri.model.Mensagem;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Prioridade;
import br.ufc.quixada.npi.sinutri.model.Mensagem.Tipo;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;
import br.ufc.quixada.npi.sinutri.service.PacienteService;
import br.ufc.quixada.npi.sinutri.service.PessoaService;

@Controller
@RequestMapping(value = "/Nutricao")
public class NutricaoController {

	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private PacienteService pacienteService;

	@Inject
	private PessoaService pessoaService;
	
	@Inject
	private ConsultaService consultaService;

	@RequestMapping(value = {"", "/", "/Buscar"}, method = RequestMethod.GET)
	public String paginaInicial(Model model) {
		Servidor servidor = pessoaService.buscarServidorPorCpf(getCpfPessoaLogada());

		if (servidor == null) {
			servidor = cadastrarServidor();
		}
		
		
		return "nutricao/buscar";
	}
	
	@RequestMapping(value="/Buscar", method = RequestMethod.POST)
	public String paginaInicial(Model model, @RequestParam("busca") String busca, @RequestParam(value ="buscarPacienteExterno", required=false) boolean buscarPacienteExterno){		
		
		if(!buscarPacienteExterno){	
			model.addAttribute("usuarios", usuarioService.getByCpfOrNome(busca));
		}
		else{			
			model.addAttribute("pacientes", pacienteService.buscarPacientePorCpfOuNome("%"+busca.toLowerCase()+"%"));
		}		
		model.addAttribute("ultimaBusca", busca);

		return "nutricao/buscar";
	}


	private Servidor cadastrarServidor() {
		Usuario usuario = usuarioService.getByCpf(getCpfPessoaLogada());

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(getCpfPessoaLogada());
		pessoa.setNome(usuario.getNome());
		pessoa.setTelefone(usuario.getTelefone());
		pessoa.setOcupacaoOuCargo(usuario.getCargo());
		pessoa.setVinculo(usuario.getCargo());

		//pessoa.setPapeis(new ArrayList<Papel>());
		//pessoa.getPapeis().add(pessoaService.buscarPapelPorNome("NUTRICAO"));

		pessoaService.adicionarPessoa(pessoa);

		Servidor servidor = new Servidor();
		servidor.setPessoa(pessoa);
		servidor.setSiape(usuario.getSiape());

		pessoaService.adicionarServidor(servidor);

		return servidor;
	}

	private String getCpfPessoaLogada() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = (Usuario) authentication.getPrincipal();
		return usuario.getCpf();
	}
	
	@RequestMapping(value= "/Listar/Alimentos", method = RequestMethod.GET)
	public String listaAlimento(Model model){
		
		List<Alimento> alimentos = consultaService.buscarAlimentosPorFonte(FonteAlimento.MEUSALIMENTOS);
		
		model.addAttribute("alimentos", alimentos);
		
		return "/alimento/listar";
	}
	
	@RequestMapping(value = "Alimento/{idAlimento}", method = RequestMethod.GET)
	public String visualizarPaciente(@PathVariable("idAlimento") Long idAlimento, Model model, RedirectAttributes redirectAttributes){
		
		model.addAttribute("alimento", consultaService.buscarAlimentoPorId(idAlimento));
	
		return "/alimento/visualizar"; 
	}

	@RequestMapping(value= "/Cadastrar/Alimento", method = RequestMethod.GET)
	public String formAdicionarAlimento(Model model){
		model.addAttribute("alimento", new Alimento());
		model.addAttribute("grupo", consultaService.getGrupos());
		
		return "/alimento/cadastrar";
	}
	
	@RequestMapping(value = "/Cadastrar/Alimento", method = RequestMethod.POST)
	public String adicionarAlimento(@ModelAttribute("alimento") Alimento alimento, @ModelAttribute("grupo") Grupo grupo, BindingResult bindingResult, RedirectAttributes redirectAttributes){

		alimento.setFonte(FonteAlimento.MEUSALIMENTOS);

		consultaService.cadastrarAlimento(alimento);

		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Nutricao/Alimento/"+ alimento.getId();
	}
	
	@RequestMapping(value = "Alimento/{idAlimento}/Editar", method = RequestMethod.GET)
	public String formEditarPaciente(@PathVariable("idAlimento") Long idAlimento, Model model, RedirectAttributes redirectAttributes){

		model.addAttribute("alimento", consultaService.buscarAlimentoPorId(idAlimento));
		model.addAttribute("grupo", consultaService.getGrupos());
		
		return "/alimento/editar";
	}
	
	@RequestMapping(value = "Alimento/{idAlimento}/Editar", method = RequestMethod.POST)
	public String editarPaciente(@PathVariable("idAlimento") Long idAlimento, Alimento alimento, Model model, RedirectAttributes redirectAttributes){

		alimento.setFonte(FonteAlimento.MEUSALIMENTOS);
		
		consultaService.editarAlimento(alimento);
		
		Mensagem mensagem = new Mensagem("Salvo com sucesso!", Mensagem.Tipo.SUCESSO, Mensagem.Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Nutricao/Alimento/"+ idAlimento;
	}
	
	
	@RequestMapping(value= {"Alimento/{idAlimento}/Excluir"}, method = RequestMethod.GET)
	public String excluirAlimento(@PathVariable("idAlimento") Long idAlimento, RedirectAttributes redirectAttributes, Model model){
		
		Alimento alimento = consultaService.buscarAlimentoPorId(idAlimento);
		consultaService.excluirAlimento(alimento);
		
		Mensagem mensagem = new Mensagem("Excluído com sucesso!", Tipo.SUCESSO, Prioridade.MEDIA);
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/Nutricao/Listar/Alimentos";
	}
	
	
}
