package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.util.NamedParams;

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

	@Override
	public List<Pessoa> getPessoasByNomeOuCpf(String busca) {
		return find("Pessoa.findPessoasByNomeOrCpf", new NamedParams("busca", "%" + busca.toUpperCase() + "%", "cpf", busca));
	}
}
