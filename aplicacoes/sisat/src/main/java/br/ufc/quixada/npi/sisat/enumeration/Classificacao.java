package br.ufc.quixada.npi.sisat.enumeration;

public enum Classificacao {
		
	DESEJAVEL("Desejavel"),
	LIMITROFE("Limitrofe"),
	ALTO("Alto"),
	BAIXO("Baixo"),
	MUITOALTO("Muito Alto"),	
	MUITOBAIXO("Muito Baixo");

	private String tipo;
		
	private Classificacao(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
