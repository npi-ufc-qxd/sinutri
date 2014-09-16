package br.com.ufc.quixada.npi.sisat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.validation.Valid;
=======
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
=======
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
=======
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
=======
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
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
=======
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
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
<<<<<<< HEAD
=======
	
	@Inject
	private ConsultaNutricionalService consultaNutricionalService;
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		return "nutricao/buscar";
	}
	
	@RequestMapping(value = {"/buscar"}, method = RequestMethod.GET)
	public String buscarPaciente(Model model) {
		model.addAttribute("pessoa", new Pessoa());
		
		return "nutricao/buscar";
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPaciente(@ModelAttribute("pessoa") Pessoa pessoa, ModelMap map) {
		if(!pessoa.getCpf().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByCpf(pessoa.getCpf()));
		}else if(!pessoa.getNome().isEmpty()){
			map.addAttribute("pessoas", servicePessoa.getPessoasByNome(pessoa.getNome()));
		}
		return "/nutricao/buscar";
	}
	
	@RequestMapping(value = {"/{id}/detalhes"})
	public String getDetalhes(Pessoa p, @PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		Pessoa pessoa = servicePessoa.find(Pessoa.class, id);
		System.out.println("estou aqui!!!");
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "redirect:/nutricao/buscar";
		}
		System.out.println(pessoa.getNome());
		model.addAttribute("pessoa", pessoa);
		return "redirect:/nutricao/detalhes";
	}
	
	
	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model) {
<<<<<<< HEAD
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
=======
		System.out.println("consulta get");
		ConsultaNutricional consultaNutricional = new ConsultaNutricional();
		model.addAttribute("consulta", consultaNutricional);
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
		return "nutricao/consulta";
	}

	@RequestMapping(value = {"/consulta"}, method = RequestMethod.POST)
	public String consulta(@ModelAttribute("consulta") ConsultaNutricional consulta) {
		System.out.println("consulta post");
<<<<<<< HEAD
<<<<<<< HEAD
		
		if (result.hasErrors()) {
			return ("/paciente/cadastrar");
=======
		System.out.println(consulta);
		if(consulta.getAgua().length()==0){
			consulta.setAgua(null);
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
		}
		if(consulta.getMedicamentoComentario()!=null && consulta.getMedicamentoComentario().isEmpty()){
			consulta.setMedicamentoComentario(null);
		}
<<<<<<< HEAD
		//return "redirect:/nutricao/paciente/listar";		//ainda não existe essa view
		
=======
		System.out.println(consulta);
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
=======
		if(consulta.getMastigacaoComentario()!=null && consulta.getMastigacaoComentario().isEmpty()){
			consulta.setMastigacaoComentario(null);
		}
		if(consulta.getAlergiaComentario()!=null && consulta.getAlergiaComentario().isEmpty()){
			consulta.setAlergiaComentario(null);
		}
		if(consulta.getCarneVermelhaComentario()!=null && consulta.getCarneVermelhaComentario().isEmpty()){
			consulta.setCarneVermelhaComentario(null);
		}
		if(consulta.getAtividadeFisicaComentario()!=null && consulta.getAtividadeFisicaComentario().isEmpty()){
			consulta.setAtividadeFisicaComentario(null);
		}
		if(consulta.getBebidaAlcoolicaComentario()!=null && consulta.getBebidaAlcoolicaComentario().isEmpty()){
			consulta.setBebidaAlcoolicaComentario(null);
		}
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
		consultaNutricionalService.save(consulta);
		return "nutricao/consulta";
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> b89e50eef52631a7eb6a7082e39764f20a1c4686
