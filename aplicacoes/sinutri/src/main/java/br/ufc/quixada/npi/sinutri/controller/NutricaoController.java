package br.ufc.quixada.npi.sinutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Nutricao")
public class NutricaoController {

	@RequestMapping(value = {"", "/", "/Buscar"}, method = RequestMethod.GET)
	public String paginaInicial() {
		return "nutricao/buscar";
	}

}
