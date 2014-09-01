package br.com.ufc.quixada.npi.sisat.repository.jpa;

import javax.inject.Named;

import br.com.ufc.quixada.npi.sisat.model.Paciente;
import br.com.ufc.quixada.npi.sisat.repository.PacienteRepository;

@Named
public class JpaPacienteRepositoryImpl extends JpaGenericRepositoryImpl<Paciente> implements PacienteRepository{

}