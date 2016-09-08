package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PlanoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Campo Obrigatório")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date criadoEm;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date atualizadoEm;
	
	@ManyToOne
	@JoinColumn(name = "nutricionista_id")
	private Servidor nutricionista;
	
	@ManyToOne
	private Paciente paciente;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "plano_alimentar_id")
	private List<RefeicaoPlanoAlimentar> refeicoes;
	
	public PlanoAlimentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanoAlimentar(Paciente paciente) {
		super();
		this.paciente = paciente;
	}

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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<RefeicaoPlanoAlimentar> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<RefeicaoPlanoAlimentar> refeicoes) {
		this.refeicoes = refeicoes;
	}

	
}
