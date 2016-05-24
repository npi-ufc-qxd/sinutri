package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;

import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.repository.AnamneseRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;


public class ConsultaServiceImpl implements ConsultaService {
	@Inject
	AnamneseRepository anamneseRepository;
	
	@Override
	public void adicionarAnamnese(Anamnese anamnese) {
		anamnese.setAtualizadoEm(new Date());
		anamneseRepository.save(anamnese);
	}

	@Override
	public void editarAnamnese(Anamnese anamnese) {		
		anamneseRepository.save(anamnese);
		
	}

	@Override
	public void excluirAnamnese(Anamnese anamnese) {
		anamneseRepository.delete(anamnese);
	}

	@Override
	public Anamnese buscarAnamnese(Long id) {
		return anamneseRepository.findOne(id);		
	}
}
