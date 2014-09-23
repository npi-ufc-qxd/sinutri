package br.com.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.repository.GenericRepository;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;
import br.com.ufc.quixada.npi.util.NamedParams;

@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	@Inject
	GenericRepository<Pessoa> repository;
	
	
	@Override
	public Pessoa getPessoaByLogin(String login) {
		return repository.findFirst("Pessoa.findPessoaByLogin", new NamedParams("login", login));
	}
	
	@Override
	public List<Pessoa> getPessoasByCpf(String cpf) {
		return repository.find("Pessoa.findPessoasByCpf", new NamedParams("cpf", cpf));
	}
	
	@Override
	public List<Pessoa> getPessoasByNome(String nome) {
		return repository.find("Pessoa.findPessoasByNome", new NamedParams("nome", "%" + nome.toUpperCase() + "%"));
	}

	@Override
	public List<Pessoa> getPareceristas(Long id) {
		return repository.find("Pessoa.findPareceristas", new NamedParams("id", id));
	}
}
