package br.ufc.quixada.npi.sisat.model.enuns;

public enum SistemaUrinario {
		
	NORMAL("NORMAL"),
	ALTERADO("ALTERADO");

	private String tipo;
		
	private SistemaUrinario(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
