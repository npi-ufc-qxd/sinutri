package br.ufc.quixada.npi.sisat.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PlanoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date criadoEm;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date atualizadoEm;
	
	@ManyToOne
	@JoinColumn(name = "nutricionista_id")
	private Servidor nutricionista;
	
	@OneToMany
	@JoinColumn(name = "plano_alimentar_id")
	private List<RefeicaoPlanoAlimentar> refeicoesPlanoAlimentar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
