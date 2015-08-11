package br.ufc.quixada.npi.sisat.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Papel;
import br.ufc.quixada.npi.sisat.service.PapelService;

@Named
public class PapelServiceImpl extends GenericServiceImpl<Papel> implements	PapelService {

	@Inject
	GenericRepository<Papel> papelRepository;

	@Override
	public Papel getPapel(String papel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("papel", papel);

		Papel papelPessoa = (Papel) findFirst(QueryType.JPQL, "from Papel where nome = :papel", params);

		return papelPessoa;
	}

}
