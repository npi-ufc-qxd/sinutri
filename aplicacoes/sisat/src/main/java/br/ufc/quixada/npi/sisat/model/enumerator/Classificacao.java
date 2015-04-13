package br.ufc.quixada.npi.sisat.model.enumerator;

public enum Classificacao {
		
	VAZIO("Vazio"),
	MUITOALTO("Muito Alto"),	
	ALTO("Alto"),
	DESEJAVEL("Desejavel"),
	BAIXO("Baixo"),
	MUITOBAIXO("Muito Baixo");

	private String tipo;
		
	private Classificacao(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
