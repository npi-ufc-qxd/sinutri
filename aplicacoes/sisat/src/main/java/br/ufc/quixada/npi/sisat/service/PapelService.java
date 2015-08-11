package br.ufc.quixada.npi.sisat.service;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Papel;

public interface PapelService extends GenericService<Papel> {

	Papel getPapel(String papel);

}
