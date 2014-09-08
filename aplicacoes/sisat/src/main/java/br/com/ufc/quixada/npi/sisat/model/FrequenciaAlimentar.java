package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FrequenciaAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat
	private Date horario;	
	
    @ManyToOne
    @JoinColumn(name = "consulta_id")
	private ConsultaNutricional consultaNutricional;
    
	@OneToMany(mappedBy = "frequenciaAlimentar")
	private List<Alimentacao> alimentos;    
	
	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

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

	
}


