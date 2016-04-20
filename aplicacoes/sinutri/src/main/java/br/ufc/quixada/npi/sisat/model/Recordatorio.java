package br.ufc.quixada.npi.sisat.model;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.ufc.quixada.npi.sisat.model.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id"}))
public class Recordatorio {
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy="recordatorio", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<FrequenciaAlimentar> refeicoes;
	
	@ManyToOne
	@JoinColumn(name = "consultaNutricional_id")
	private ConsultaNutricional consultaNutricional;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<FrequenciaAlimentar> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<FrequenciaAlimentar> refeicoes) {
		this.refeicoes = refeicoes;
	}

	public ConsultaNutricional getConsultaNutricional() {
		return consultaNutricional;
	}

	public void setConsultaNutricional(ConsultaNutricional consultaNutricional) {
		this.consultaNutricional = consultaNutricional;
	}
}
