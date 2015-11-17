package br.ufc.quixada.npi.sisat.model.enuns;

public enum TipoFrequencia {
	RECORDATORIO("Recordatório"),
	PLANOALIMENTAR("Plano Alimentar");	
	
	private String tipofrequencia;
		
	private TipoFrequencia(String tipo){
		this.tipofrequencia = tipo;
	}

	public String getTipo() {
		return tipofrequencia;
	}
}
