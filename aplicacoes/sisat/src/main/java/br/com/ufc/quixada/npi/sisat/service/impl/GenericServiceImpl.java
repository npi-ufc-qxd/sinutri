package br.com.ufc.quixada.npi.sisat.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.quixada.npi.sisat.enumerator.QueryType;
import br.com.ufc.quixada.npi.sisat.repository.GenericRepository;
import br.com.ufc.quixada.npi.sisat.service.GenericService;

@Named
public class GenericServiceImpl<T> implements GenericService<T> {

	@Inject
	private GenericRepository<T> genericRepository;
	
	@Transactional
	public void save(T entity) {
		genericRepository.save(entity);

	}

	@Transactional
	public void update(T entity) {
		genericRepository.update(entity);

	}

	@Transactional
	public T find(Class<T> entityClass, Object id) {
		return (T) genericRepository.find(entityClass, id);

	}

	@Transactional
	public List<T> find(Class<T> entityClass) {
		List<T> l = genericRepository.find(entityClass);
		return l;
	}
	
	@Transactional
	public void delete(T entity) {
		genericRepository.delete(entity);

	}

	@Override
	public List<T> find(QueryType type, String query,
			Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return genericRepository.find(type, query, namedParams);
	}
}
