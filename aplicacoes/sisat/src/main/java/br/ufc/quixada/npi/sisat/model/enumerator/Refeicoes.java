package br.ufc.quixada.npi.sisat.model.enumerator;

public enum Refeicoes {

	DESJEJUM("Desjejum"), LANCHE_DA_MANHA("Lanche da Manha"), ALMOCO("Almoço"), LANCHE_DA_TARDE("Lanche da Tarde"), JANTAR("Jantar"), CEIA("Ceia");

	private final String nome;

	Refeicoes(String nome){
		this.nome = nome;

	}

	public String getNome(){
		return this.nome;
	}
}