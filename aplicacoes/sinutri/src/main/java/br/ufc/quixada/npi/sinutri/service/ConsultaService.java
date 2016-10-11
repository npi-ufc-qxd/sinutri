package br.ufc.quixada.npi.sinutri.service;

import java.util.List;

import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.CalculoGastoEnergetico;
import br.ufc.quixada.npi.sinutri.model.DistribuicaoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Grupo;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Prescricao;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;

public interface ConsultaService {
	
	void adicionarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial, Paciente paciente);

	void editarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial);
	
	AvaliacaoLaboratorial buscarAvaliacaoLaboratorialPorId(Long idAvaliacaoLaboratorial);

	void excluirAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial);
	
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
	
	void adicionarCalculoGastoEnergetico(CalculoGastoEnergetico calculoEnergetico);
	
	void editarCalculoGastoEnergetico(CalculoGastoEnergetico calculoEnergetico);
	
	void excluirCalculoGastoEnergetico(CalculoGastoEnergetico calculoEnergetico);
	
	CalculoGastoEnergetico buscarCalculoGastoEnergeticoPorId(Long id);
	
	void adicionarDistribuicaoAlimentar(DistribuicaoAlimentar distribuicaoAlimentar);
	
	void editarDistribuicaoAlimentar(DistribuicaoAlimentar distribuicaoAlimentar);
	
	void excluirDistribuicaoAlimentar(DistribuicaoAlimentar distribuicaoAlimentar);
	
	DistribuicaoAlimentar buscarDistribuicaoAlimentar(Long id);
	
	List<Grupo> getGrupos();
	
	void cadastrarAlimento(Alimento alimento);
	
	Alimento buscarAlimentoPorId(Long idAlimento);
	
	void editarAlimento(Alimento alimento);
	
	void excluirAlimento(Alimento alimento);

}
