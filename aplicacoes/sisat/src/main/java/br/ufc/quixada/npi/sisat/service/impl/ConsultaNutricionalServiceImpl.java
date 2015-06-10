package br.ufc.quixada.npi.sisat.service.impl;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.util.SimpleMap;


@Named
public class ConsultaNutricionalServiceImpl extends GenericServiceImpl<ConsultaNutricional> implements ConsultaNutricionalService {

	@Override
	public ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id) {
		return (ConsultaNutricional) findFirst(
				"ConsultaNutricional.findConsultaNutricionalWithDocumentosById",
				new SimpleMap<String, Object>("id", id));
	}
	
	@Override
	public ConsultaNutricional getConsultaNutricionalWithFrequenciasById(Long id) {
		return (ConsultaNutricional) findFirst(
				"ConsultaNutricional.findConsultaNutricionalWithFrequenciasById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public String getOrientacoesIndividuaisById(Long id) {

		return (String) findFirst(
				"ConsultaNutricional.findOrientacoesIndividuaisById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public String getPacientePessoaNomeById(Long id) {
		return (String) findFirst(
				"ConsultaNutricional.findPacientePessoaNomeById",
				new SimpleMap<String, Object>("id", id));
	}
}
