
package br.ufc.quixada.npi.sinutri.model.enuns;

public enum Refeicao {

	DESJEJUM("Desjejum"),
	COLACAO("Colação"), 
	ALMOCO("Almoço"),
	LANCHE("Lanche"), 
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