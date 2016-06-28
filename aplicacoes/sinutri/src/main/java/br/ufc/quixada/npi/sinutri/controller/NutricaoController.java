package br.ufc.quixada.npi.sinutri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;

@Controller
@RequestMapping(value = "/Nutricao")
public class NutricaoController {
	@Inject
	private UsuarioService usuarioService;

	@RequestMapping(value = {"", "/", "/Buscar"}, method = RequestMethod.GET)
	public String paginaInicial(Model model) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("ultimaBusca", "");
		return "nutricao/buscar";
	}
	
	@RequestMapping(value="/Buscar", method = RequestMethod.POST)
	public String PaginaInicial(Model model, HttpServletRequest request){		
		String busca = request.getParameter("busca");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioService.getByCpfOrNome(busca);
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("ultimaBusca", busca);

		return "nutricao/buscar";
	}

}
