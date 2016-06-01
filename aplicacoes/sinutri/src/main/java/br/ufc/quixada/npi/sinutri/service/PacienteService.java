package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;

public interface PacienteService {
	
	Paciente buscarPacientePorId(Long idPaciente);
	
	void adicionarPaciente(Paciente paciente);

}
