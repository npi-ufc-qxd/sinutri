package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "nome do exame deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	private br.ufc.quixada.npi.sinutri.model.enuns.Exame nome;
	
	@NotNull(message = "resultado do exame deve ser preenchido.")
	private Double resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public br.ufc.quixada.npi.sinutri.model.enuns.Exame getNome() {
		return nome;
	}

	public void setNome(br.ufc.quixada.npi.sinutri.model.enuns.Exame nome) {
		this.nome = nome;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
}