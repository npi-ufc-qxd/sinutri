package br.ufc.quixada.npi.sinutri.model.enuns;

public enum SistemaGastrointestinal {
		
	RIN("RIN"),
	RIL("RIL"),	
	RIA("RIA");

	private String tipo;
		
	private SistemaGastrointestinal(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}