package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;

public class FrequenciaAlimentar {
	
	private long id;
	
	private Date horario;
	
	private String preparacaoAlmoco;
	
	public enum Refeicao {
		 DESJEJUM, LANCHE, ALMOCO, JANTAR, CEIA;
		
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

	
	
	
}
