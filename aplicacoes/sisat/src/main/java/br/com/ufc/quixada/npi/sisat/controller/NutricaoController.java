package br.com.ufc.quixada.npi.sisat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.quixada.npi.sisat.model.Paciente;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.service.PacienteService;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {
	
	@Inject
	private PacienteService servicePaciente;
	
	@Inject
	private PessoaService servicePessoa;

	@RequestMapping(value = {"/", "/index", "listar"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/listar";
	}


	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model) {
		System.out.println("consulta");
		return "nutricao/consulta";
	}

	//Cadastrar paciente
	@RequestMapping(value = "/paciente/cadastrar", method = RequestMethod.POST)
	public String adicionarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result, HttpSession session, ModelMap map) {
		System.out.println("aqui o/");
		
		if (result.hasErrors()) {
			return ("/paciente/cadastrar");
		}
		Pessoa pessoa = servicePessoa.getPessoaByCpf(paciente.getPessoa().getCpf());	//verifica se a pessoa já existe
		if(pessoa == null){
			System.out.println("ERROR!");
			map.addAttribute("erro", "Paciente não encontrado!!!");
		}else{
			System.out.println("OK ;)");
			paciente.setPessoa(pessoa);
			this.servicePaciente.save(paciente);

			map.addAttribute("info", "Paciente cadastrado com sucesso.");
		}
		//return "redirect:/nutricao/paciente/listar";		//ainda não existe essa view
		
		return "/nutricao/paciente/cadastrar";
	}
	
	@RequestMapping(value = "/{id}/mostrar")
	public String getDetalhes(/*Consulta p, @PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes*/) {
			return "redirect:/projeto/listar";
	}

}
