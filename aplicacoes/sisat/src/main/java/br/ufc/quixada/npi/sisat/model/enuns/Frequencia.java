package br.ufc.quixada.npi.sisat.model.enuns;

public enum Frequencia {
		
	RARAMENTE("Raramente"),
	UMA_VEZ_POR_SEMANA("Uma vez por semana"),	
	POUCAS_VEZES_POR_SEMANA("Poucas vez por semana"),	
	DIARIAMENTE("Diariamente");

	private String tipo;
		
	private Frequencia(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
