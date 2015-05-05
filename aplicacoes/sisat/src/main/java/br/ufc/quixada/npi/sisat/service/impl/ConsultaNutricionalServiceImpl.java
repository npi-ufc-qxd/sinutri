package br.ufc.quixada.npi.sisat.service.impl;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class ConsultaNutricionalServiceImpl extends GenericServiceImpl<ConsultaNutricional> implements ConsultaNutricionalService {

	@Override
	public ConsultaNutricional getConsultaNutricionalWithFrequenciaByID(Long id) {
		return (ConsultaNutricional) findFirst("ConsultaNutricional.findConsultaNutricionalWithFrequenciaByID", new SimpleMap<String, Object>("id",id));
	}

	

}
