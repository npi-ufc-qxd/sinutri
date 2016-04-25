package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private br.ufc.quixada.npi.sisat.model.enuns.Exame nome;
	
	@NotNull
	private Double resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public br.ufc.quixada.npi.sisat.model.enuns.Exame getNome() {
		return nome;
	}

	public void setNome(br.ufc.quixada.npi.sisat.model.enuns.Exame nome) {
		this.nome = nome;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
}
