package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.sisat.util.NamedParams;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	
	public Pessoa getPessoaByLogin(String login) {
		return (Pessoa) findFirst("Pessoa.findPessoaByLogin", new SimpleMap<String, Object>("login", login));
	}
	
	public List<Pessoa> getPessoasByCpf(String cpf) {
		return find("Pessoa.findPessoasByCpf", new SimpleMap<String, Object>("cpf", cpf));
	}
	
	public List<Pessoa> getPessoasByNome(String nome) {
		return find("Pessoa.findPessoasByNome", new SimpleMap<String, Object>("nome", "%" + nome.toUpperCase() + "%"));
	}

	public List<Pessoa> getPareceristas(Long id) {
		return find("Pessoa.findPareceristas", new SimpleMap<String, Object>("id", id));
	}

	@Override
	public List<Pessoa> getPessoasByNomeOuCpf(String busca) {
		return find("Pessoa.findPessoasByNomeOrCpf", new NamedParams("busca", "%" + busca.toUpperCase() + "%", "cpf", busca));
	}
}
