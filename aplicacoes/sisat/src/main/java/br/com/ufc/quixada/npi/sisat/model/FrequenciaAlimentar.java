package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ufc.quixada.npi.sisat.enumerator.Refeicoes;

public class FrequenciaAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date horario;
	
	private Refeicoes refeicao;

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Refeicoes getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicoes refeicao) {
		this.refeicao = refeicao;
	}
}
