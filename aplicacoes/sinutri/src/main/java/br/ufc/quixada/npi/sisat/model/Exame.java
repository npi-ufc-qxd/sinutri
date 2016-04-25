package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private br.ufc.quixada.npi.sisat.model.enuns.Exame nome;
	
	private Double resultado;

}
