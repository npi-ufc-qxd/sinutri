package br.com.ufc.quixada.npi.sisat.repository.jpa;

import javax.inject.Named;

import br.com.ufc.quixada.npi.sisat.model.Pessoa;
import br.com.ufc.quixada.npi.sisat.repository.PessoaRepository;

@Named
public class JpaPessoaRepositoryImpl extends JpaGenericRepositoryImpl<Pessoa> implements PessoaRepository{

}
