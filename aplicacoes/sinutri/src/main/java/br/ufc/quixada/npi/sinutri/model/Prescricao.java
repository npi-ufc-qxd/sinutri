package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 05201719341
 *
 */
@Entity
public class Prescricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrescricao;
	
	@Size(max=256, message="A descrição deve ter no máximo 256 caracteres.")
	private String descricao;
	
	@Size(max=256, message="O texto da prescrição deve ter no máximo 256 caracteres.")
	private String texto;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date criadoEm;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date atualizadoEm;
	
	@ManyToOne
	private Servidor nutricionista;
	
	@ManyToOne
	private Paciente paciente;
	
	public Prescricao() {
		super();
	}

	public Long getIdPrescricao() {
		return idPrescricao;
	}

	public void setIdPrescricao(Long idPrescricao) {
		this.idPrescricao = idPrescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	@Override
	public String toString() {
		return "Prescricao [id=" + idPrescricao
				+ ", descricao=" + descricao + ", texto=" + texto + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + ", nutricionista=" + nutricionista + ", paciente=" + paciente
				+ "]";
	}
	
	

}
