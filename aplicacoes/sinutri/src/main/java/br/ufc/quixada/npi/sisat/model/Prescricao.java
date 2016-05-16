package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prescricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrescricao;
	
	private String descricao;
	
	private String texto;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date criadoEm;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date atualizadoEm;
	
	
	@OneToOne
	private Servidor nutricionista;
	

	public Long getIdPrescricao() {
		return idPrescricao;
	}

	public Prescricao(Long idPrescricao, String descricao, String texto, Date criadoEm, Date atualizadoEm) {
		super();
		this.idPrescricao = idPrescricao;
		this.descricao = descricao;
		this.texto = texto;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
	}
	

	public Prescricao() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public Servidor getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
	}

	@Override
	public String toString() {
		return "Prescricao [id=" + idPrescricao + ", descricao=" + descricao + ", texto=" + texto+"]";
	}

}
