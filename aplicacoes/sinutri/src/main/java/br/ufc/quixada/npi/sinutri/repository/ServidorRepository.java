package br.ufc.quixada.npi.sinutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.quixada.npi.sinutri.model.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {

	@Query("from Servidor s where s.pessoa.cpf = :cpf")
	Servidor findByCpf(@Param("cpf") String cpf);

}
