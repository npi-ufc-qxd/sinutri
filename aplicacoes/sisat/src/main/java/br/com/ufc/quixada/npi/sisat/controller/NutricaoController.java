package br.com.ufc.quixada.npi.sisat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.quixada.npi.sisat.model.Exemplo;
import br.com.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.com.ufc.quixada.npi.sisat.model.FrequenciaAlimentar.Refeicao;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {
	
	//private List<FrequenciaAlimentar> frequenciasAlimentares = new ArrayList<FrequenciaAlimentar>();

	@RequestMapping(value = {"/", "/index", "listar"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/listar";
	}
	
	@RequestMapping(value = "/frequenciaAlimentar", method = RequestMethod.GET)
	public String formulario(Model model){
		System.out.println("/frequenciaAlimentar");
		model.addAttribute("frequenciaAlimentar", new FrequenciaAlimentar());
		//model.addAttribute("frequenciasAlimentares", frequenciasAlimentares);
		model.addAttribute("refeicoes",Refeicao.values());
		return "nutricao/formulario_frequencia_alimentar";
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String teste(Model model) {
		System.out.println("/teste");
		model.addAttribute("exemplo", new Exemplo());
		return "nutricao/teste";
	}
	
	

}
