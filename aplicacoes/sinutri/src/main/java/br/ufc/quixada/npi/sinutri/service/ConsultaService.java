package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface ConsultaService {
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);

	void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	AvaliacaoAntropometrica buscarAvaliacaoAntropometricaPorId(Long id);
	
	void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	void adicionarAnamnese(Anamnese anamnese);
	
	void editarAnamnese(Anamnese anamnese);
	
	void excluirAnamnese(Anamnese anamnese);
	
	Anamnese buscarAnamnese(Long id);
}
