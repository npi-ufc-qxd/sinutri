package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.service.DocumentoService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class DocumentoServiceImpl extends GenericServiceImpl<Documento>
		implements DocumentoService {

	@Override
	public List<Documento> getDocumentosByIdConsultaNutricional(Long id) {
		return find("Documento.findDocumentosByIdConsulta", new SimpleMap<String, Object>("id", id));
	}

}
