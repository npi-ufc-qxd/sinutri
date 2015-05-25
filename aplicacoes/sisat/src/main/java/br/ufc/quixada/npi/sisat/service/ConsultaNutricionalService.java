package br.ufc.quixada.npi.sisat.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;

public interface ConsultaNutricionalService extends GenericService<ConsultaNutricional> {
	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id);
}
