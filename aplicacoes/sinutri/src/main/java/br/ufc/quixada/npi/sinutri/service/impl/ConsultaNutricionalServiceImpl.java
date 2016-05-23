package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoLaboratorialRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaNutricionalService;

public class ConsultaNutricionalServiceImpl implements ConsultaNutricionalService{
	
	@Inject
	private AvaliacaoLaboratorialRepository avaliacaoLaboratorialRepository;
	
	@Override
	public void adicionar(AvaliacaoLaboratorial avaliacaoLaboratorial) {
		
		avaliacaoLaboratorial.setAtualizado(new Date());
		avaliacaoLaboratorialRepository.saveAndFlush(avaliacaoLaboratorial);
	}

	@Override
	public AvaliacaoLaboratorial buscarAvaliacaoLaboratorial(Long id) {
		
		return avaliacaoLaboratorialRepository.getOne(id);
	}

	@Override
	public void atualizar(AvaliacaoLaboratorial avaliacaoLaboratorial) {
		
		avaliacaoLaboratorial.setAtualizado(new Date());
		avaliacaoLaboratorialRepository.save(avaliacaoLaboratorial);
	}

	@Override
	public void excluir(AvaliacaoLaboratorial avaliacaoLaboratorial) {
		
		avaliacaoLaboratorialRepository.delete(avaliacaoLaboratorial);
	}
	
}
