package br.ufc.quixada.npi.sinutri.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import br.ufc.quixada.npi.ldap.service.UsuarioService;

@Controller
@RequestMapping(value = "/Nutricao")
public class NutricaoController {
	@Inject
	private UsuarioService usuarioService;

	@RequestMapping(value = {"", "/", "/Buscar"}, method = RequestMethod.GET)
	public String paginaInicial(Model model) {
		return "nutricao/buscar";
	}
	
	@RequestMapping(value="/Buscar", method = RequestMethod.POST)
	public String paginaInicial(Model model, @RequestParam("busca") String busca){		
		
		model.addAttribute("usuarios", usuarioService.getByCpfOrNome(busca));		
		model.addAttribute("ultimaBusca", busca);

		return "nutricao/buscar";
	}

}
