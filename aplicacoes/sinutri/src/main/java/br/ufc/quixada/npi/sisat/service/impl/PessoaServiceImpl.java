package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Pessoa;
import br.ufc.quixada.npi.sisat.model.Servidor;
import br.ufc.quixada.npi.sisat.service.PessoaService;
import br.ufc.quixada.npi.sisat.util.NamedParams;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	
	public Pessoa getPessoaByCpf(String cpf) {
		return (Pessoa) findFirst("Pessoa.findPessoaByCpf", new SimpleMap<String, Object>("cpf", cpf));
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

	@Override
	public Servidor buscarServidorByPessoa(Pessoa pessoa) {
		
		return (Servidor) find("Servidor.findServidorByPessoa", new SimpleMap<String, Object>("idPessoa", pessoa.getId())).get(0);
	}
}
