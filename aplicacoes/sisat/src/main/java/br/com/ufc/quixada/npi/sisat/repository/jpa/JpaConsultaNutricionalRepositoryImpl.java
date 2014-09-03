package br.com.ufc.quixada.npi.sisat.repository.jpa;

import javax.inject.Named;

import br.com.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.com.ufc.quixada.npi.sisat.repository.ConsultaNutricionalRepository;

@Named
public class JpaConsultaNutricionalRepositoryImpl extends JpaGenericRepositoryImpl<ConsultaNutricional> implements ConsultaNutricionalRepository {

}