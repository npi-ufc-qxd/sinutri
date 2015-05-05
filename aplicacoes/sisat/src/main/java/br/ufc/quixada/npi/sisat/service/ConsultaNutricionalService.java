package br.ufc.quixada.npi.sisat.service;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;

public interface ConsultaNutricionalService extends GenericService<ConsultaNutricional> {
	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentos();
}
