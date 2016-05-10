package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prescricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrescricao;
	
	private String descricao;
	
	private String texto;
	
	/*
	@OneToOne
	private Servidor nutricionista;
	 */

	public Long getIdPrescricao() {
		return idPrescricao;
	}

	public void setIdPrescricao(Long idPrescricao) {
		this.idPrescricao = idPrescricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/*public Servidor getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
	}*/

	@Override
	public String toString() {
		return "Prescricao [id=" + idPrescricao + ", descricao=" + descricao + ", texto=" + texto+"]";
	}
	
}
