package br.com.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.com.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;
import br.com.ufc.quixada.npi.util.NamedParams;

@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	
	public Pessoa getPessoaByLogin(String login) {
		return findFirst("Pessoa.findPessoaByLogin", new NamedParams("login", login));
	}
	
	public List<Pessoa> getPessoasByCpf(String cpf) {
		return find("Pessoa.findPessoasByCpf", new NamedParams("cpf", cpf));
	}
	
	public List<Pessoa> getPessoasByNome(String nome) {
		return find("Pessoa.findPessoasByNome", new NamedParams("nome", "%" + nome.toUpperCase() + "%"));
	}

	public List<Pessoa> getPareceristas(Long id) {
		return find("Pessoa.findPareceristas", new NamedParams("id", id));
	}
}
