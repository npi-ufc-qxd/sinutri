package br.ufc.quixada.npi.sisat.service;

import java.util.List;
import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sisat.model.Paciente;

public interface PacienteService extends GenericService<Paciente> {
	
	void excluirInqueritoAlimentar(Long idInquerito);
	
	boolean adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Long id);
	
	boolean editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Long idPaciente);
	
	Map<Long, Object> getConsultasByPaciente(Long id);
	
	List<ConsultaNutricional> getHistoricoPeso(String cpf);
	
	void excluir(ConsultaNutricional consulta);
	
	InqueritoAlimentar getInqueritoAlimentarById(Long id);

}
