package br.ufc.quixada.npi.sinutri.service.impl;

import javax.inject.Inject;

import br.ufc.quixada.npi.sinutri.model.Papel;
import br.ufc.quixada.npi.sinutri.repository.PapelRepository;
import br.ufc.quixada.npi.sinutri.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {

	@Inject
	private PapelRepository papelRepository;

	@Override
	public Papel getPapel(String nome) {
		return papelRepository.findByNome(nome);
	}
	
}
