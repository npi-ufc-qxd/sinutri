package br.ufc.quixada.npi.sinutri.model.enuns;

public enum Apetite {
	NORMAL("NORMAL"),
	AUMENTADO("AUMENTADO"),
	DIMIDUIDO("DIMIDUIDO");
	
	private String tipo;
	
	private Apetite(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
}