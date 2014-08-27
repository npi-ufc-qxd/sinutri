package br.com.ufc.quixada.npi.sisat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {

	@RequestMapping(value = {"/", "/index", "listar"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/listar";
	}

	

		@RequestMapping(value = {"/examesLaboratoriais"}, method = RequestMethod.GET)
		public String examesLaboratoriais() {
			return "nutricao/examesLaboratoriais";
		}
		
		@RequestMapping(value = {"/Avaliacaonutricional"}, method = RequestMethod.GET)
		public String avaliacaoNutricional() {
			return "nutricao/AvaliacaoNutricional";
		}

}
