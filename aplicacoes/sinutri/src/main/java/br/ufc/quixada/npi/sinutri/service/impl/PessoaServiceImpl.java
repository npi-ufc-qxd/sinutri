package br.ufc.quixada.npi.sinutri.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import br.ufc.quixada.npi.sinutri.model.Papel;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.repository.PapelRepository;
import br.ufc.quixada.npi.sinutri.repository.PessoaRepository;
import br.ufc.quixada.npi.sinutri.repository.ServidorRepository;
import br.ufc.quixada.npi.sinutri.service.PessoaService;

@Named
public class PessoaServiceImpl implements PessoaService {

	@Inject
	private PapelRepository papelRepository;
	
	@Inject
	private ServidorRepository servidorRepository;
	
	@Inject 
	private PessoaRepository pessoaRepository;

	@Override
	public Papel buscaPapelPorNome(String papel) {
		return papelRepository.findByNome(papel);
	}

	@Override
	public Servidor buscarServidorPorCpf(String cpf) {
		return servidorRepository.findByCpf(cpf);
	}

	@Override
	public Pessoa buscarPessoaPorId(Long id) {
		return pessoaRepository.findOne(id);
	}

	@Override
	public void editarPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		
	}

	@Override
	public void excluirPessoa(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
		
	}
}
