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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.ufc.quixada.npi.sisat.enumerator.Classificacao;
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
		
	@RequestMapping(value = "/{id}/editarConsulta", method = RequestMethod.GET)
	public String editarConsulta(@PathVariable("id") long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("get editarConsulta");
		ConsultaNutricional consultaNutricional = consultaNutricionalService.find(ConsultaNutricional.class, id);
		System.out.println("ididididididiididididid = " + consultaNutricional.getId());
		model.addAttribute("consultaNutricional", consultaNutricional);

		Classificacao[] cla= Classificacao.values();
		model.addAttribute("classificacao", cla);
		return "/nutricao/editarConsulta";
		
	}
	
	@RequestMapping(value = {"/{id}/editarConsulta"}, method = RequestMethod.POST)
	public String editarConsulta(@ModelAttribute("consultaNutricional") ConsultaNutricional consulta, @PathVariable("id") long id) {
		System.out.println("post editarConsulta" + consulta.getId());
		consultaNutricionalService.update(consulta);
		return "nutricao/detalhes";
	}

	@RequestMapping(value = {"/{id}/detalhes"})
	public String getDetalhes(Pessoa p, @PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
		Pessoa pessoa = servicePessoa.find(Pessoa.class, id);
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("erro", "Paciente não encontrado.");
			return "nutricao/buscar";
		}
		model.addAttribute("pessoa", pessoa);
		return "redirect:nutricao/"+ 1 +"/detalhes";
	}
	
	
	@RequestMapping(value = {"/consulta"}, method = RequestMethod.GET)
	public String consulta(Model model, HttpSession session) {
		System.out.println("consulta get");
		ConsultaNutricional consultaNutricional = new ConsultaNutricional();
		model.addAttribute("consulta", consultaNutricional);
		Classificacao[] cla= Classificacao.values();
		model.addAttribute("classificacao", cla);
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
