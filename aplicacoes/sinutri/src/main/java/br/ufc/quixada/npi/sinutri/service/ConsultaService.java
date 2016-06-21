package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface ConsultaService {
	
	void adicionarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial, Paciente paciente);

	void editarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial);
	
	AvaliacaoLaboratorial buscarAvaliacaoLaboratorialPorId(Long idAvaliacaoLaboratorial);

	void excluirAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial);
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);

}
