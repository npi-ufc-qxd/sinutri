package br.com.ufc.quixada.npi.sisat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import javax.validation.Valid;
=======
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
=======
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ufc.quixada.npi.sisat.enumerator.Classificacao;
import br.com.ufc.quixada.npi.sisat.model.ConsultaNutricional;
<<<<<<< HEAD
import br.com.ufc.quixada.npi.sisat.model.Paciente;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
=======
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
import br.com.ufc.quixada.npi.sisat.service.PacienteService;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {
	
	@Inject
	private PacienteService servicePaciente;
	
	@Inject
	private PessoaService servicePessoa;
<<<<<<< HEAD

	@RequestMapping(value = {"/", "/index", "listar"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/listar";
	}


	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model) {
		System.out.println("consulta");
=======
	
	@Inject
	private ConsultaNutricionalService consultaNutricionalService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/buscar";
	}
	
	@RequestMapping(value = {"/buscar"}, method = RequestMethod.GET)
	public String buscarPaciente(Model model) {
		return "nutricao/buscar";
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@RequestParam("tipoPesquisa") String tipoPesquisa, @RequestParam("campo") String campo, ModelMap map) {
		if(tipoPesquisa.equals("cpf")){
			map.addAttribute("pessoas", servicePessoa.getPessoasByCpf(campo));
		}else if(tipoPesquisa.equals("nome")){
			map.addAttribute("pessoas", servicePessoa.getPessoasByNome(campo));
		}
		return "/nutricao/buscar";
	}
	
	@RequestMapping(value = {"/{id}/detalhes"})
	public String getDetalhes(Pessoa p, @PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		Pessoa pessoa = servicePessoa.find(Pessoa.class, id);
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "nutricao/buscar";
		}
		model.addAttribute("pessoa", pessoa);
		return "nutricao/detalhes";
	}
	
	
	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model, HttpSession session) {
		System.out.println("consulta get");
		ConsultaNutricional consultaNutricional = new ConsultaNutricional();
		model.addAttribute("consulta", consultaNutricional);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
=======
		Classificacao[] cla= Classificacao.values();
		model.addAttribute("classificacao", cla);
>>>>>>> 529617fb93702199d51fe6a94f6f6b4e85592e64
=======
		Classificacao[] cla= Classificacao.values();
		model.addAttribute("classificacao", cla);
>>>>>>> 11c921d8889917ea0a87247423e36bcae6ce4ced
		return "nutricao/consulta";
	}

	@RequestMapping(value = {"/consulta"}, method = RequestMethod.POST)
	public String consulta(@ModelAttribute("consulta") ConsultaNutricional consulta) {
		System.out.println("consulta post");
<<<<<<< HEAD
		
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
		
=======
		System.out.println(consulta);
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
		consultaNutricionalService.save(consulta);
		return "nutricao/consulta";
	}

}
