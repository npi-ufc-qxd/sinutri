package br.com.ufc.quixada.npi.sisat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufc.quixada.npi.sisat.enumerator.QueryType;
import br.com.ufc.quixada.npi.sisat.model.Papel;
import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.repository.PessoaRepository;
import br.com.ufc.quixada.npi.sisat.service.PessoaService;

@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	@Inject
	PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa getPessoaByLogin(String login) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "login", login);
		Pessoa usuariologado = pessoaRepository.find(QueryType.JPQL, "from Pessoa where login = :login", params).get(0);
		return usuariologado;
	}
	
	@Override
	public Pessoa getPessoaByCpf(String cpf) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "cpf", cpf);
		List<Pessoa> usuarios = pessoaRepository.find(QueryType.JPQL, "from Pessoa where cpf = :cpf", params);
		
		if(usuarios.isEmpty()){
			return null;
		}else{ 
			return usuarios.get(0);						
		}
	}
	
	@Override
	public List<Pessoa> getPessoasByCpf(String cpf) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "cpf", cpf);
		List<Pessoa> usuarios = pessoaRepository.find(QueryType.JPQL, "from Pessoa where cpf = :cpf", params);
		
		if(usuarios.isEmpty()){
			return null;
		}else{
			return usuarios;						
		}
	}
	
	@Override
	public Pessoa getPessoaByNome(String nome) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "nome", nome);
		List<Pessoa> usuarios = pessoaRepository.find(QueryType.JPQL, "from Pessoa where nome like :nome", params);
		
		if(usuarios.isEmpty()){
			return null;
		}else{
			return usuarios.get(0);			
		}
	}
	@Override
	public List<Pessoa> getPessoasByNome(String nome) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "nome", nome);
		List<Pessoa> usuarios = pessoaRepository.find(QueryType.JPQL, "FROM Pessoa WHERE UPPER(nome) LIKE '%' || UPPER(:nome) || '%' ORDER BY nome", params);	
		
		if(usuarios.isEmpty()){
			return null;
		}else{
			return usuarios;			
		}
	}

	@Override
	public List<Pessoa> getPareceristas(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "id", id);
		List<Pessoa> usuarios = pessoaRepository.find(QueryType.JPQL, "from Pessoa u where u.id != :id", params);
		return usuarios;
	}

	@Override
	public boolean isNutricao(Pessoa pessoa) {
		List<Papel> papeis = pessoa.getPapeis();
		for(Papel p: papeis){
			if(p.getNome().equals("ROLE_NUTRICAO")){
				return true;
			}
		}
		return false;
	}

}
