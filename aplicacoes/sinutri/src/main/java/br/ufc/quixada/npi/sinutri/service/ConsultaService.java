package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface ConsultaService {
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);

	void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente);
	
	void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente);
	
	AvaliacaoAntropometrica buscarAvaliacaoAntropometricaById(Long id);
	
	void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente);
}
