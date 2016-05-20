package br.ufc.quixada.npi.sinutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.quixada.npi.sinutri.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {

	@Query("from Papel p where p.nome = :nome")
	Papel findByNome(@Param("nome") String nome);

}
