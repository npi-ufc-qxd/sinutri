package br.ufc.quixada.npi.sinutri.service;

import br.ufc.quixada.npi.sinutri.model.Papel;
import br.ufc.quixada.npi.sinutri.model.Servidor;

public interface PessoaService {

	Papel buscaPapelPorNome(String papel);
	
	Servidor buscarServidorPorCpf(String cpf);

}