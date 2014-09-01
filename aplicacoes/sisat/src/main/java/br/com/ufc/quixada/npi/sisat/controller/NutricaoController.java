package br.com.ufc.quixada.npi.sisat.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


	@RequestMapping(value = {"/paciente/cadastrar"}, method = RequestMethod.GET)
	public String adicionarPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "nutricao/paciente/cadastrar";
	}
	//Cadastrar paciente
	@RequestMapping(value = "/paciente/cadastrar", method = RequestMethod.POST)
	public String adicionarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result, HttpSession session, ModelMap map) {
		if (result.hasErrors()) {
			return ("/paciente/cadastrar");
		}
		Pessoa pessoa = servicePessoa.getPessoaByCpf(paciente.getPessoa().getCpf());	//verifica se a pessoa já existe
		if(pessoa == null){
			System.out.println("ERROR!");
			map.addAttribute("erro", "Paciente não encontrado!!!");
		}else{
			paciente.setPessoa(pessoa);
			this.servicePaciente.save(paciente);

			map.addAttribute("info", "Paciente cadastrado com sucesso.");
		}
		//return "redirect:/nutricao/paciente/listar";		//ainda não existe essa view
		
		return "/nutricao/paciente/cadastrar";
	}
	
	@RequestMapping(value = {"/paciente/buscar"}, method = RequestMethod.GET)
	public String buscarPaciente(Model model) {
		System.out.println("Test get busca");
		
		List<Pessoa> p = servicePessoa.getPessoasByNome("a");
		
		for( Pessoa p2 : p){
			System.out.println(p2.getNome());
			System.out.println(p2.getEmail());
		}
		
		model.addAttribute("pessoa", new Pessoa());
		return "nutricao/paciente/buscar";
	}
	@RequestMapping(value = "/paciente/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, HttpSession session, ModelMap map) {
		

		if(!pessoa.getCpf().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByCpf(pessoa.getCpf()));
		}else if(!pessoa.getNome().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByNome(pessoa.getNome()));
		}
		//model.addAttribute("pessoa", new Pessoa());
		
		return "/nutricao/paciente/buscar";
	}
	

}
