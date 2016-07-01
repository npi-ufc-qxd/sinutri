package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;

public interface PacienteService {
	
	void adicionarPaciente(Paciente paciente);

	void editarPaciente(Paciente paciente);
	
	Paciente buscarPacientePorId(Long idPaciente);
	
	Paciente buscarPacientePorCPF(String cpf);
	
	void excluirPaciente(Paciente paciente);
	

}
