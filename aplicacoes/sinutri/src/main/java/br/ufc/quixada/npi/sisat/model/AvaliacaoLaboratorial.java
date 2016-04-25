package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AvaliacaoLaboratorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date criadoEm;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date atualizado;
	
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = "servidor_id")
	private Servidor nutricionista;
	
}
