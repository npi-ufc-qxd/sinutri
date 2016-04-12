package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(PorcaoId.class)
public class Porcao {
	 
	@Id
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "calculos_dietas_id")
	private CalculoDieta calculoDieta;
	
	private Integer valor;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public CalculoDieta getCalculosDietas() {
		return calculoDieta;
	}

	public void setCalculosDietas(CalculoDieta calculosDietas) {
		this.calculoDieta = calculosDietas;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
}
