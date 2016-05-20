package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface ConsultaService {
	
	boolean pacienteExiste(Long idPaciente);
	
	Paciente buscarPacientePorId(Long idPaciente);
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
}
