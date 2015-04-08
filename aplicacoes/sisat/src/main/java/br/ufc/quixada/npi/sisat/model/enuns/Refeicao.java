package br.ufc.quixada.npi.sisat.model.enuns;

public enum Refeicao {

	DESJEJUM("Desjejum"), LANCHE_DA_MANHA("Lanche da Manhã"), ALMOCO("Almoço"), LANCHE_DA_TARDE("Lanche da Tarde"), JANTAR("Jantar"), CEIA("Ceia");

	private final String nome;

	Refeicao(String nome){
		this.nome = nome;

	}

	public String getNome(){
		return this.nome;
	}
}