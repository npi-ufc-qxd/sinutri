package br.ufc.quixada.npi.sisat.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prescricao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	private String texto;
	
	private Byte[] arquivo;
	
	@OneToOne
	private Servidor nutricionista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(Byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Servidor getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
	}

	@Override
	public String toString() {
		return "Prescricao [id=" + id + ", descricao=" + descricao + ", texto=" + texto + ", arquivo="
				+ Arrays.toString(arquivo) + ", nutricionista=" + nutricionista + "]";
	}

}
