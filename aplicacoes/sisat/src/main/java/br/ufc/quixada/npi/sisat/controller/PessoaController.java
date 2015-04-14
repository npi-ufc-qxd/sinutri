package br.ufc.quixada.npi.sisat.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.sisat.util.Constant;

@Controller
public class PessoaController {
	@Inject
	private PessoaService pessoaService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuário e/ou senha inválidos!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "Usuário e/ou senha inválidos!");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		session.invalidate();

		return "login";

	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String acessoNegado(ModelMap model, Principal user) {
		if (user != null) {
			model.addAttribute("message", "Olá, " + user.getName() 
			+ ", você não tem permissão para acessar essa página!");
		} else {
			model.addAttribute("message", 
			"Você não tem permissão para acessar essa página!");
		}
		return "403";
	}
	private Pessoa getUsuarioLogado(HttpSession session) {
		if (session.getAttribute(Constant.USUARIO_LOGADO) == null) {
			Pessoa pessoa = pessoaService.getPessoaByCPF(SecurityContextHolder.getContext().getAuthentication().getName());
			session.setAttribute(Constant.USUARIO_LOGADO, pessoa);
		}
		return (Pessoa) session.getAttribute(Constant.USUARIO_LOGADO);
	}
}