package br.ufc.quixada.npi.sisat.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sisat.model.enuns.Refeicao;
import br.ufc.quixada.npi.sisat.model.enuns.TipoFrequencia;

@Entity
public class FrequenciaAlimentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	private Date horario;
	
	@Enumerated(EnumType.STRING)
	private Refeicao refeicao;
	
	@Enumerated(EnumType.STRING)
	private TipoFrequencia tipofrequencia;
	
	/**
	 * A classe ConsultaNutricional não está mais diretamente com FrequenciaAlimentar 
	*/
	/*@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "consultaNutricional_id")
	private ConsultaNutricional consultaNutricional;
    */
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name= "frequenciaalimentar_id")
	private List<Alimentacao> alimentos;
	
	
	@Override
	public String toString() {
		return "FrequenciaAlimentar [id=" + id + ", horario=" + horario
				+ ", refeicao=" + refeicao + ", \n   alimentos=" + alimentos + "]";
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
	/**
	 * A classe ConsultaNutricional não está mais diretamente com FrequenciaAlimentar 
	*/
/*	public ConsultaNutricional getConsultaNutricional() {
		return consultaNutricional;
	}

	public void setConsultaNutricional(ConsultaNutricional consultaNutricional) {
		this.consultaNutricional = consultaNutricional;
	}
*/

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}
	
	public void setTipo(TipoFrequencia tipofrequencia){
		this.tipofrequencia = tipofrequencia;
	}
	public TipoFrequencia getTipo(){
		return tipofrequencia;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	   
}


