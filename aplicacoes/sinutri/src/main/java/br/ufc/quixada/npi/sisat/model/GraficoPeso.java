package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

public class GraficoPeso {

	private Date data;

	private Double peso;

	public GraficoPeso(Date data, Double peso) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
