package br.ufc.quixada.npi.sisat.service;

import java.util.List;
import java.util.Set;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Documento;

public interface DocumentoService extends GenericService<Documento>{	
	public abstract Set<Documento> getDocumentosByIdConsultaNutricional(Long id);
	public abstract List<Documento> getDocumentosEnviar(Long id);
	public abstract List<Documento> getDocumentosNutricionista(Long id);
}
