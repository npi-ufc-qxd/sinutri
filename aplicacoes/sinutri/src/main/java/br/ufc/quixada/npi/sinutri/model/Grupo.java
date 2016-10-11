package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Double valorProteina;
	private Double valorGlicidio;
	private Double valorLipidio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorProteina() {
		return valorProteina;
	}
	public void setValorProteina(Double valorProteina) {
		this.valorProteina = valorProteina;
	}
	public Double getValorGlicidio() {
		return valorGlicidio;
	}
	public void setValorGlicidio(Double valorGlicidio) {
		this.valorGlicidio = valorGlicidio;
	}
	public Double getValorLipidio() {
		return valorLipidio;
	}
	public void setValorLipidio(Double valorLipidio) {
		this.valorLipidio = valorLipidio;
	}	
	
}
