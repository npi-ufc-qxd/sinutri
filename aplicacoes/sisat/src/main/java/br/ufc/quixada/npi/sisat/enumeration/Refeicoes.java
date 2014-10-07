package br.ufc.quixada.npi.sisat.enumeration;

public enum Refeicoes {
	
	DESJEJUM("Desjejum"), 
	LANCHEMANHA("Lanche da Manhã"), 
	ALMOCO("Almoço"),
	LANCHETARDE("Lanche da Tarde"), 
	JANTA("Jantar"), 
	CEIA("Ceia"); 
	
	private String tipo;
	
	private Refeicoes(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
}
