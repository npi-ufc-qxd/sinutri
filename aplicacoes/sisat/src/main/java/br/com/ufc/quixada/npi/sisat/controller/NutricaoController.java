package br.com.ufc.quixada.npi.sisat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.quixada.npi.sisat.model.Exemplo;
import br.com.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {

	@RequestMapping(value = {"/", "/index", "listar"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/listar";
	}
	
	@RequestMapping(value = "/frequenciaAlimentar", method = RequestMethod.GET)
	public String formulario(Model model){
		System.out.println("/frequenciaAlimentar");
		model.addAttribute("frequenciaAlimentar", new FrequenciaAlimentar());
		return "nutricao/formulario_frequencia_alimentar";
	}

	@RequestMapping(value = "/exemplo", method = RequestMethod.GET)
	public String formHorarios(Model model) {
		System.out.println("/formHorarioAtendimento");
		model.addAttribute("exemplo", new Exemplo());
		return "nutricao/exemplo";
	}

}
