package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.Anamnese;

public interface ConsultaService {
	void adicionarAnamnese(Anamnese anamnese);
	
	void editarAnamnese(Anamnese anamnese);
	
	void excluirAnamnese(Anamnese anamnese);
	
	Anamnese buscarAnamnese(Long id);
}
