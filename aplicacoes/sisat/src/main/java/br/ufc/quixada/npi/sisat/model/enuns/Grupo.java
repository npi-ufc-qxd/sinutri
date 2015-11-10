package br.ufc.quixada.npi.sisat.model.enuns;

public enum Grupo {

	GRUPO_I("Leite"), 
	GRUPO_II("Pães"), 
	GRUPO_III("Arroz Cozido"), 
	GRUPO_IV("Leguminosas"), 
	GRUPO_V("Gorduras/Óleos"),
	GRUPO_VI("Carnes"),
	GRUPO_VII("Queijos"),
	GRUPO_VIII("Vegetal A, B e C"), 
	GRUPO_IX("Frutas A e B");

	private String tipo;

	private Grupo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
