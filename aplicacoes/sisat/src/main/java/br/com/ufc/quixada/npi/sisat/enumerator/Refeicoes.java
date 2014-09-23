package br.com.ufc.quixada.npi.sisat.enumerator;

public enum Refeicoes {

		 DESJEJUM("Desjejum"), LANCHEMANHA("Lanche da Manha"), ALMOCO("Almoço"), LANCHETARDE("Lanche da Tarde"), JANTAR("Jantar"), CEIA("Ceia");
		 
		 private final String nome;
		 
		 Refeicoes(String nome){
			this.nome = nome;
			 
		 }
		 
		 public String getNome(){
			 return this.nome;
		 }
	}
	

