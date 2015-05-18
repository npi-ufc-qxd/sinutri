package br.ufc.quixada.npi.sisat.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Documento;

public interface DocumentoService extends GenericService<Documento>{	
	public abstract List<Documento> getDocumentosByIdConsultaNutricional(
			Long id);

}
