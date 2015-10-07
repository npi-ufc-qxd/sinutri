package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Alimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String alimento;
	
	private String porcao;

	@ManyToOne
	@JsonIgnore
	private FrequenciaAlimentar frequenciaAlimentar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String getPorcao() {
		return porcao;
	}

	public void setPorcao(String porcao) {
		this.porcao = porcao;
	}

	public FrequenciaAlimentar getFrequenciaAlimentar() {
		return frequenciaAlimentar;
	}

	public void setFrequenciaAlimentar(FrequenciaAlimentar frequenciaAlimentar) {
		this.frequenciaAlimentar = frequenciaAlimentar;
	}

	@Override
	public String toString() {
		return "\n               Alimentacao [id=" + id + ", alimento=" + alimento + ", porcao="
				+ porcao + "]";
	}

}
