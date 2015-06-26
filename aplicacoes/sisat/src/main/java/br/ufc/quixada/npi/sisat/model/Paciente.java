package br.ufc.quixada.npi.sisat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6651490753121518188L;

	@Id
	private Long id;

	@MapsId
	@OneToOne(mappedBy = "paciente")
	@JoinColumn(name = "id")
	@JsonIgnore
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ConsultaNutricional> consultas;

	@NotNull(message = "Informe a altura do paciente!")
	@Min(value = 1)
	private Double alturaAtual;

	@NotNull(message = "Informe o peso do paciente!")
	@Min(value = 1)
	private Double pesoAtual;

	@NotNull(message = "Informe a circunferencia da cintura do paciente!")
	@Min(value = 1)
	private Double circunferenciaCinturaAtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ConsultaNutricional> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaNutricional> consultas) {
		this.consultas = consultas;
	}

	public Double getAlturaAtual() {
		return alturaAtual;
	}

	public void setAlturaAtual(Double alturaAtual) {
		this.alturaAtual = alturaAtual;
	}

	public Double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(Double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public Double getCircunferenciaCinturaAtual() {
		return circunferenciaCinturaAtual;
	}

	public void setCircunferenciaCinturaAtual(Double circunferenciaCinturaAtual) {
		this.circunferenciaCinturaAtual = circunferenciaCinturaAtual;
	}

}
