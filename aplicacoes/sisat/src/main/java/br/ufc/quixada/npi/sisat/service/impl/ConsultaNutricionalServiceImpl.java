package br.ufc.quixada.npi.sisat.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class ConsultaNutricionalServiceImpl extends
		GenericServiceImpl<ConsultaNutricional> implements
		ConsultaNutricionalService {

	@Override
	public ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id) {
		return (ConsultaNutricional) findFirst(
				"ConsultaNutricional.findConsultaNutricionalWithDocumentosById",
				new SimpleMap<String, Object>("id", id));
	}

<<<<<<< HEAD
=======
	@Override
	public ConsultaNutricional getConsultaNutricionalWithFrequenciasById(Long id) {
		return (ConsultaNutricional) findFirst(
				"ConsultaNutricional.findConsultaNutricionalWithFrequenciasById",
				new SimpleMap<String, Object>("id", id));
	}
>>>>>>> 2f4051106d4391fa110e441498e1df4276d57536
}
