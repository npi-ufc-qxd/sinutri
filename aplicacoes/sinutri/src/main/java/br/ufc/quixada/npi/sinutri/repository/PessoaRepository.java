package br.ufc.quixada.npi.sinutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.quixada.npi.sinutri.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
