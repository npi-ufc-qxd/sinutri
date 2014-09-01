package br.com.ufc.quixada.npi.sisat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//ismael - retorna a primeira página do sisat
	@RequestMapping(value = {"/buscar"}, method = RequestMethod.GET)
	public String buscarPaciente(Model model) {
		model.addAttribute("pessoa", new Pessoa());
//		model.addAttribute("tipoBusca", new String());
//		model.addAttribute("busca", new String());
		
		return "nutricao/buscar";
	}
	
	//ismael - retorna a primeira página do sisat com uma lista de pessoas
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, HttpSession session, ModelMap map) {
		if(!pessoa.getCpf().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByCpf(pessoa.getCpf()));
		}else if(!pessoa.getNome().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByNome(pessoa.getNome()));
		}
		return "/nutricao/buscar";
	}
	
	//ismael - detalhes do paciente
	@RequestMapping(value = {"/{id}/detalhes"})
	public String getDetalhes(Pessoa p, @PathVariable("id") Long id,
			Model model, RedirectAttributes redirectAttributes){
		Pessoa pessoa = servicePessoa.find(Pessoa.class, id);
		System.out.println("estou aqui!!!");
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}
		System.out.println(pessoa.getNome());
		model.addAttribute("pessoa", pessoa);
		return "nutricao/detalhes";
	}


	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model) {
		System.out.println("consulta");
		return "nutricao/consulta";
	}
	
	@RequestMapping(value = "/{id}/mostrar")
	public String getDetalhes(/*Consulta p, @PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes*/) {
			return "redirect:/projeto/listar";
	}

}
