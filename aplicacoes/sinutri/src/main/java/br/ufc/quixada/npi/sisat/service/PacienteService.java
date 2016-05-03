package br.ufc.quixada.npi.sisat.service;

import java.util.List;
import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.Prescricao;

public interface PacienteService extends GenericService<Paciente> {
	
	Map<Long, Object> getConsultasByPaciente(Long id);
	

	List<ConsultaNutricional> getHistoricoPeso(String cpf);
	

	void excluir(ConsultaNutricional consulta);
	
	void adicionarPrescricao(Prescricao prescricao);
	
	void excluirPrescricao(Prescricao prescricao);
	
	void editarPrescricao(Prescricao prescricao);
	
	Prescricao buscarPrescricao(Long id);

}
