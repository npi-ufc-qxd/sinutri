package br.ufc.quixada.npi.sinutri.service;

import java.util.List;

import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;

public interface ConsultaService {
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void adicionarPlanoAlimentar(PlanoAlimentar planoAlimentar);
	
	PlanoAlimentar buscarPlanoAlimentarPorId(Long idPlanoAlimentar);

	void editarPlanoAlimentar(PlanoAlimentar planoAlimentar);

	void excluirPlanoAlimentar(PlanoAlimentar planoAlimentar); 

	void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	AvaliacaoAntropometrica buscarAvaliacaoAntropometricaPorId(Long id);
	
	void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	List<Alimento> buscarAlimentosPorFonte(FonteAlimento fonte);
	
}
