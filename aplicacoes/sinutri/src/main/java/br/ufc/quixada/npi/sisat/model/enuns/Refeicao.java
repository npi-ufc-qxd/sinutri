package br.ufc.quixada.npi.sisat.model.enuns;

public enum Refeicao {

	DESJEJUM("Desjejum"),
	CAFEMANHA("Café da manhã"),
	COLACAO("Colação"), 
	ALMOCO("Almoço"),
	LANCHETARDE("Lanche da tarde"), 
	JANTAR("Jantar"), 
	CEIA("Ceia"),
	PRETREINO("Pré-treino"),
	POSTREINO("Pós-treino");

	private final String nome;

	Refeicao(String nome){
		this.nome = nome;

	}

	public String getNome(){
		return this.nome;
	}
}