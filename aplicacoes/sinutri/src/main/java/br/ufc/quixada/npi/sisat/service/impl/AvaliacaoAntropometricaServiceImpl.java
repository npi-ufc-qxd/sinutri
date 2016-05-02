package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.sisat.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sisat.service.AvaliacaoAntropometricaService;

@Named
public class AvaliacaoAntropometricaServiceImpl implements AvaliacaoAntropometricaService{
	
	@PersistenceContext
	private EntityManager mager;
	
	@Override
	public void save(AvaliacaoAntropometrica entity) {
		this.mager.persist(entity);
		// TODO Auto-generated method stub
	}

	@Override
	public void update(AvaliacaoAntropometrica entity) {
		this.mager.merge(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AvaliacaoAntropometrica entity) {
		// TODO Auto-generated method stub
		this.mager.remove(this.mager.getReference(AvaliacaoAntropometrica.class, entity.getId()));
		
	}

	@Override
	public AvaliacaoAntropometrica find(Class<AvaliacaoAntropometrica> entityClass, Object id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<AvaliacaoAntropometrica> find(Class<AvaliacaoAntropometrica> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaliacaoAntropometrica> find(Class<AvaliacaoAntropometrica> entityClass, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String queryName, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(QueryType type, String query, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String queryName, Map<String, Object> namedParams, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(QueryType type, String query, Map<String, Object> namedParams, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findFirst(String query, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findFirst(QueryType type, String query, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String sql, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return 0;
	}
}
