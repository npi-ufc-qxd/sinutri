package br.ufc.quixada.npi.sinutri.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id"}))
public class Recordatorio {
	
	@Id
	@GeneratedValue
	private long id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date criadoEm;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date atualizadoEm;
	
	@OneToOne
	private Servidor nutricionista;
	
	@ManyToOne
	private Paciente paciente;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="recordatorio_id")
	private List<RefeicaoRecordatorio> refeicoes = new ArrayList<RefeicaoRecordatorio>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	
	public List<RefeicaoRecordatorio> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<RefeicaoRecordatorio> refeicoes) {
		this.refeicoes = refeicoes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Recordatorio [id=" + id + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm
				+ ", nutricionista=" + nutricionista + ", refeicoes=" + refeicoes + "]";
	}
	
}