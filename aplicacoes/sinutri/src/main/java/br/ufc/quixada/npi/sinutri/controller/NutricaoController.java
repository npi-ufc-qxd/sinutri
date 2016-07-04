package br.ufc.quixada.npi.sinutri.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.mockito.internal.matchers.CompareTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.service.PacienteService;

@Controller
@RequestMapping(value = "/Nutricao")
public class NutricaoController {
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private PacienteService pacienteService;

	@RequestMapping(value = {"", "/", "/Buscar"}, method = RequestMethod.GET)
	public String paginaInicial(Model model) {
		return "nutricao/buscar";
	}
	
	@RequestMapping(value="/Buscar", method = RequestMethod.POST)
	public String paginaInicial(Model model, @RequestParam("busca") String busca, @RequestParam(value ="buscarPacienteExterno", required=false) boolean buscarPacienteExterno){		
		
		if(!buscarPacienteExterno){
			List<Usuario> usuarios = usuarioService.getByCpfOrNome(busca);			
			model.addAttribute("usuarios", usuarios);
		}
		else{
			List<Paciente> pacientes = pacienteService.buscarPacientePorCpfOuNome(busca);
			Collections.sort(pacientes);
			model.addAttribute("pacientes", pacientes);
		}
		
		model.addAttribute("ultimaBusca", busca);

		return "nutricao/buscar";
	}

}
