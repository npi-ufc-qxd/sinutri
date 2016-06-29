package br.ufc.quixada.npi.sinutri.service;

import java.util.List;

import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Prescricao;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;

public interface ConsultaService {
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void adicionarPlanoAlimentar(PlanoAlimentar planoAlimentar);
	
	PlanoAlimentar buscarPlanoAlimentarPorId(Long idPlanoAlimentar);

	void editarPlanoAlimentar(PlanoAlimentar planoAlimentar);

	void excluirPlanoAlimentar(PlanoAlimentar planoAlimentar); 
	
	//Recordatorio
	void adicionarRecordatorio(Recordatorio recordatorio);
	
	void excluirRecordatorio(Recordatorio recordatorio);
	
	Recordatorio buscarRecordatorio(Long id);
	
	void editarRecordatorio(Recordatorio recordatorio);
	
	void excluirRefeicaoRecordatorio(RefeicaoRecordatorio refeicaoRecordatorio);
	
	RefeicaoRecordatorio buscarRefeicaoRecordatorio(Long id);

	void adicionarPrescricao(Prescricao prescricao);
	
	void editarPrescricao(Prescricao prescricao);
	
	Prescricao buscarPrescricaoPorId(Long idPrescricao);
	
	void excluirPrescricao(Prescricao prescricao);
	
	void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	AvaliacaoAntropometrica buscarAvaliacaoAntropometricaPorId(Long id);
	
	void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria);
	
	List<Alimento> buscarAlimentosPorFonte(FonteAlimento fonte);

	void adicionarAnamnese(Anamnese anamnese);
	
	void editarAnamnese(Anamnese anamnese);
	
	void excluirAnamnese(Anamnese anamnese);
	
	Anamnese buscarAnamnese(Long id);

}
