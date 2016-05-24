package br.ufc.quixada.npi.sinutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.quixada.npi.sinutri.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
