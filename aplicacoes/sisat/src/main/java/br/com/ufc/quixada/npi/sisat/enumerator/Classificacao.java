package br.com.ufc.quixada.npi.sisat.enumerator;

public enum Classificacao {

		
		normal("normal"), baixo("baixo"), alto("alto");
		
	private String tipo;
		
	private Classificacao(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
	
	
}
