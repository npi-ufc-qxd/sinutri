package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;

public interface ConsultaService {
	
	void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente);
	
	InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar);
	
	void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar);
	
	//Recordatorio
	void adicionarRecordatorio(Recordatorio recordatorio);
	
	void excluirRecordatorio(Recordatorio recordatorio);
	
	Recordatorio buscarRecordatorio(Long id);
	
	void editarRecordatorio(Recordatorio recordatorio);
	
	void excluirRefeicaoRecordatorio(RefeicaoRecordatorio refeicaoRecordatorio);
	
	RefeicaoRecordatorio buscarRefeicaoRecordatorio(Long id);

}
