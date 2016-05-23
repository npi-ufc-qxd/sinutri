package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;

public interface ConsultaNutricionalService {
	
	void adicionar(AvaliacaoLaboratorial avaliacaoLaboratorial);

	AvaliacaoLaboratorial buscarAvaliacaoLaboratorial(Long id);

	void atualizar(AvaliacaoLaboratorial avaliacaoLaboratorial);

	void excluir(AvaliacaoLaboratorial avaliacaoLaboratorial);
}
