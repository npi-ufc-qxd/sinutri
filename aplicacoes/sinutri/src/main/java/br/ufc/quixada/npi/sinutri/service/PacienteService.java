package br.ufc.quixada.npi.sinutri.service;

import java.util.List;

import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;

public interface PacienteService {
	
	void adicionarPaciente(Paciente paciente);

	void editarPaciente(Paciente paciente);
	
	Paciente buscarPacientePorId(Long idPaciente);
	
	Paciente buscarPacientePorCPF(String cpf);
	
	List<Paciente> buscarPacientePorCpfOuNome(String busca);
	
	void excluirPaciente(Paciente paciente);
	

}
