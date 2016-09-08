package br.ufc.quixada.npi.sinutri.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6651490753121518188L;

	@Id
	private Long id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "id")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="paciente")
	private List<Recordatorio> recordatorios;
	
	@OneToMany(mappedBy="paciente")
	private List<Prescricao> prescricoes;
	
	@OneToMany(mappedBy = "paciente")
	private List<Anamnese> anamneses;
	
	@OneToMany(mappedBy = "paciente")
	private List<InqueritoAlimentar> inqueritosAlimentares;

	@OneToMany(mappedBy = "paciente")
	private List<AvaliacaoAntropometrica> avaliacoesAntropometricas;
	
	@OneToMany(mappedBy = "paciente")
	private List<AvaliacaoLaboratorial> avaliacoesLaboratoriais;

	@OneToMany(mappedBy = "paciente")
	private List<CalculoGastoEnergetico> calculosGastosEnergeticos;
	
	@OneToMany(mappedBy = "paciente")
	private List<PlanoAlimentar> planosAlimentares;
	
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

	public List<Recordatorio> getRecordatorios() {
		return recordatorios;
	}

	public void setRecordatorios(List<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}
	
	public List<Anamnese> getAnamneses() {
		return anamneses;
	}

	public void setAnamneses(List<Anamnese> anamneses) {
		this.anamneses = anamneses;
	}

	public List<InqueritoAlimentar> getInqueritosAlimentares() {
		return inqueritosAlimentares;
	}

	public void setInqueritosAlimentares(List<InqueritoAlimentar> inqueritosAlimentares) {
		this.inqueritosAlimentares = inqueritosAlimentares;
	}

	public List<Prescricao> getPrescricoes() {
		return prescricoes;
	}

	public void setPrescricoes(List<Prescricao> prescricoes) {
		this.prescricoes = prescricoes;
	}

	public List<AvaliacaoAntropometrica> getAvaliacoesAntropometricas() {
		return avaliacoesAntropometricas;
	}

	public void setAvaliacoesAntropometricas(List<AvaliacaoAntropometrica> avaliacoesAntropometricas) {
		this.avaliacoesAntropometricas = avaliacoesAntropometricas;
	}


	public List<AvaliacaoLaboratorial> getAvaliacoesLaboratoriais() {
		return avaliacoesLaboratoriais;
	}

	public void setAvaliacoesLaboratoriais(List<AvaliacaoLaboratorial> avaliacoesLaboratoriais) {
		this.avaliacoesLaboratoriais = avaliacoesLaboratoriais;
	}

	public List<PlanoAlimentar> getPlanosAlimentares() {
		return planosAlimentares;
	}

	public void setPlanosAlimentares(List<PlanoAlimentar> planosAlimentares) {
		this.planosAlimentares = planosAlimentares;
	}
	
}
