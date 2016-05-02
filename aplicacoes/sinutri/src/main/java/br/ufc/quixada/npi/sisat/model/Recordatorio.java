package br.ufc.quixada.npi.sisat.model;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sisat.model.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id"}))
public class Recordatorio {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date criadoEm;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date atualizadoEm;
	
	@OneToOne
	private Servidor nutricionista;
	
	@OneToMany
	@JoinColumn(name="recordatorio_id")
	private List<RefeicaoRecordatorio> refeicoes;
	
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

	@Override
	public String toString() {
		return "Recordatorio [id=" + id + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm
				+ ", nutricionista=" + nutricionista + ", refeicoes=" + refeicoes + "]";
	}
	
}
