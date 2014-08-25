package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;

public class FrequenciaAlimentar {
	
	private long id;
	
	private Date horario;
	
	private String preparacaoAlmoco;
	
	private String alimento;
	
	private String porcaoteste;
	
	
	public enum Refeicao {
		 DESJEJUM("Desjejum"), LANCHE("Lanche"), ALMOCO("Almoço"), JANTAR("Jantar"), CEIA("Ceia");
		 
		 private final String nome;
		 
		 Refeicao(String nome){
			this.nome = nome;
			 
		 }
		 
		 public String getNome(){
			 return this.nome;
		 }
		 
	}
	
	private Refeicao refeicao;

	
	
	private String porcao;
	
	public FrequenciaAlimentar(Long id, Date horario, String preparacaoAlmoco, String porcao){
		this.id = id;
		this.horario = horario;
		this.preparacaoAlmoco = preparacaoAlmoco;
		this.porcao = porcao;
		
	}

	public FrequenciaAlimentar() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getPreparacaoAlmoco() {
		return preparacaoAlmoco;
	}

	public void setPreparacaoAlmoco(String preparacaoAlmoco) {
		this.preparacaoAlmoco = preparacaoAlmoco;
	}

	public String getPorcao() {
		return porcao;
	}

	public void setPorcao(String porcao) {
		this.porcao = porcao;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public String getPorcaoteste() {
		return porcaoteste;
	}

	public void setPorcaoteste(String porcaoteste) {
		this.porcaoteste = porcaoteste;
	}

	
	
	
	
}
