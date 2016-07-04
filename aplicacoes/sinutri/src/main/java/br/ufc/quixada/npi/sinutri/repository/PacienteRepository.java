package br.ufc.quixada.npi.sinutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	@Query("from Paciente p where p.pessoa.cpf = :cpf")
	Paciente findByCPF(@Param("cpf") String cpf);
}
