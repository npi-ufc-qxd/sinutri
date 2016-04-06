package br.ufc.quixada.npi.sisat.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.MedidaAntropometrica;
import br.ufc.quixada.npi.sisat.service.MedidaAntropometricaService;

@Named
public class MedidaAntropometricaServiceImpl extends GenericServiceImpl<MedidaAntropometrica> implements MedidaAntropometricaService{
	@Override
	public MedidaAntropometrica findMedidaAntropometricaByNome(String nome) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nome", nome);
		return (MedidaAntropometrica) findFirst(QueryType.JPQL, "from MedidaAntropometrica m where m.nome = :nome", map);
	}
}
