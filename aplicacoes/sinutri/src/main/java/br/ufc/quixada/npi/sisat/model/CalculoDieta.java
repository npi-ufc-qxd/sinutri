package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class CalculoDieta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCalculaDieta;
	
	private Double pesoSugerido;
	
	private Double fatorAtividade;
	
	private Double fatorAjuste;
	
	private Double glicidio;
	
	private Double lipidio;
	
	private Double proteinas;

	
	public Integer getIdCalculaDieta() {
		return idCalculaDieta;
	}

	public void setIdCalculaDieta(Integer idCalculaDieta) {
		this.idCalculaDieta = idCalculaDieta;
	}

	public Double getPesoSugerido() {
		return pesoSugerido;
	}

	public void setPesoSugerido(Double pesoSugerido) {
		this.pesoSugerido = pesoSugerido;
	}

	public Double getFatorAtividade() {
		return fatorAtividade;
	}

	public void setFatorAtividade(Double fatorAtividade) {
		this.fatorAtividade = fatorAtividade;
	}

	public Double getFatorAjuste() {
		return fatorAjuste;
	}

	public void setFatorAjuste(Double fatorAjuste) {
		this.fatorAjuste = fatorAjuste;
	}

	public Double getGlicidio() {
		return glicidio;
	}

	public void setGlicidio(Double glicidio) {
		this.glicidio = glicidio;
	}

	public Double getLipidio() {
		return lipidio;
	}

	public void setLipidio(Double lipidio) {
		this.lipidio = lipidio;
	}

	public Double getProteinas() {
		return proteinas;
	}

	public void setProteinas(Double proteinas) {
		this.proteinas = proteinas;
	}

	@Override
	public String toString() {
		return "CalculoDieta [idCalculaDieta=" + idCalculaDieta + ", pesoSugerido=" + pesoSugerido + ", fatorAtividade="
				+ fatorAtividade + ", fatorAjuste=" + fatorAjuste + ", glicidio=" + glicidio + ", lipidio=" + lipidio
				+ ", proteinas=" + proteinas + "]";
	}
	
}

