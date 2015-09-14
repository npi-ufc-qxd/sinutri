package br.ufc.quixada.npi.sisat.service;

import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.Paciente;

public interface PacienteService extends GenericService<Paciente> {
	
	Map<Long, Object> getConsultasByPaciente(Long id);

}
