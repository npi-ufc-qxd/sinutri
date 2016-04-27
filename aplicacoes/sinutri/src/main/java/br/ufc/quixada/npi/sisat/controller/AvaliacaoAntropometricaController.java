package br.ufc.quixada.npi.sisat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.npi.sisat.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sisat.service.AvaliacaoAntropometricaService;

@Controller
public class AvaliacaoAntropometricaController {
	
	@Autowired
	private AvaliacaoAntropometricaService service;
	
	
	
	
}
 	