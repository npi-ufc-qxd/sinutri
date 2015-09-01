package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class DocumentoServiceImpl extends GenericServiceImpl<Documento>
		implements DocumentoService {

	@Override
	public Set<Documento> getDocumentosByIdConsultaNutricional(Long id) {
		return (Set<Documento>) find("Documento.findDocumentosByIdConsulta", new SimpleMap<String, Object>("id", id));
	}

	@Override
	public List<Documento> getDocumentosEnviar(Long id) {	
		return find("Documento.findDocumentosEnvio", new SimpleMap<String, Object>("id", id));
	}

	@Override
	public List<Documento> getDocumentosNutricionista(Long id) {
		return find("Documento.findDocumentosNutricionista", new SimpleMap<String, Object>("id", id));
	}
	
}
