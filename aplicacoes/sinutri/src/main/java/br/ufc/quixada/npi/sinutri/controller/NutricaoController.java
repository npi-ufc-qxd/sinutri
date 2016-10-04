package br.ufc.quixada.npi.sinutri.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.Servidor;
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
	
}
