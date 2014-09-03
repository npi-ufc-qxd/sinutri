package br.com.ufc.quixada.npi.sisat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.com.ufc.quixada.npi.sisat.service.PacienteService;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;

@Controller
@RequestMapping("nutricao")
public class NutricaoController {
	
	@Inject
	private PacienteService servicePaciente;
	
	@Inject
	private PessoaService servicePessoa;
	
	@Inject
	private ConsultaNutricionalService consultaNutricionalService;

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
		System.out.println("consulta get");
		ConsultaNutricional consultaNutricional = new ConsultaNutricional();
		model.addAttribute("consulta", consultaNutricional);
		return "nutricao/consulta";
	}

	@RequestMapping(value = {"/consulta"}, method = RequestMethod.POST)
	public String consulta(@ModelAttribute("consulta") ConsultaNutricional consulta) {
		System.out.println("consulta post");
		System.out.println(consulta);
		consultaNutricionalService.save(consulta);
		return "nutricao/consulta";
	}

}
