package br.ufc.quixada.npi.sisat.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.ufc.quixada.npi.sisat.model.enumerator.Refeicoes;

@Entity
public class FrequenciaAlimentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String horario;
	
	@Enumerated(EnumType.STRING)
	private Refeicoes refeicao;
	
    @ManyToOne
    @JoinColumn(name = "consulta_id")
	private ConsultaNutricional consultaNutricional;
    
	@OneToMany(mappedBy = "frequenciaAlimentar", cascade = CascadeType.ALL)
	private List<Alimentacao> alimentos;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Alimentacao> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimentacao> alimentos) {
		this.alimentos = alimentos;
	}

	
	public ConsultaNutricional getConsultaNutricional() {
		return consultaNutricional;
	}

	public void setConsultaNutricional(ConsultaNutricional consultaNutricional) {
		this.consultaNutricional = consultaNutricional;
	}

	@Override
	public String toString() {
		return "FrequenciaAlimentar [id=" + id + ", horario=" + horario
				+ ", refeicao=" + refeicao + ", \n   alimentos=" + alimentos + "]";
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setRefeicao(Refeicoes refeicao) {
		this.refeicao = refeicao;
	}

	public Refeicoes getRefeicao() {
		return refeicao;
	}

	public String getHorario() {
		return horario;
	}   
}


