package br.ufc.quixada.npi.sisat.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PlanoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "planoalimentar_id")
	private List<FrequenciaAlimentar> frequenciasAlimentares;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FrequenciaAlimentar> getFrequenciasAlimentares() {
		return frequenciasAlimentares;
	}

	public void setFrequenciasAlimentares(
			List<FrequenciaAlimentar> frequenciasAlimentares) {
		this.frequenciasAlimentares = frequenciasAlimentares;
	}
}
