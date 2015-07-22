package br.ufc.quixada.npi.sisat.model.enuns;

public enum Refeicao {

	DESJEJUM("Desjejum"), COLACAO("Colacão"), ALMOCO("Almoço"), LANCHE("Lanche"), JANTAR("Jantar"), CEIA("Ceia");

	private final String nome;

	Refeicao(String nome){
		this.nome = nome;

	}

	public String getNome(){
		return this.nome;
	}
}