package br.ufc.quixada.npi.sinutri.model.enuns;

public enum FonteAlimento {

	MEUSALIMENTOS("Meus alimentos"),
	TACO("TACO"),
	TUCUNDUVA("TUCUNDUVA");

	private final String nome;

	FonteAlimento(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}
}