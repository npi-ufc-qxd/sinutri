package br.ufc.quixada.npi.sisat.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Pessoa;

public interface PessoaService extends GenericService<Pessoa> {

	public abstract Pessoa getPessoaByLogin(String login);
	
	public abstract List<Pessoa> getPessoasByCpf(String cpf);

	public abstract List<Pessoa> getPessoasByNome(String nome);
	
	public abstract List<Pessoa> getPareceristas(Long id);

}
