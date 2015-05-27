package br.ufc.quixada.npi.sisat.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Documento;

<<<<<<< HEAD
public interface ConsultaNutricionalService extends GenericService<ConsultaNutricional> {
	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id);
=======
public interface ConsultaNutricionalService extends
		GenericService<ConsultaNutricional> {
	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosById(
			Long id);
	public abstract ConsultaNutricional getConsultaNutricionalWithFrequenciasById(
			Long id);
>>>>>>> 2f4051106d4391fa110e441498e1df4276d57536
}
