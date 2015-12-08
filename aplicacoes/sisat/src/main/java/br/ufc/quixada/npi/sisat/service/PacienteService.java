package br.ufc.quixada.npi.sisat.service;

import java.util.List;
import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Paciente;

public interface PacienteService extends GenericService<Paciente> {
	
	Map<Long, Object> getConsultasByPaciente(Long id);
	
	List<ConsultaNutricional> historicoPaciente(String cpf);
	

}
