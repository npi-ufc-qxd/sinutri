package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sinutri.model.enuns.Refeicao;

@Entity
public class RefeicaoPlanoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	private Date hora;
	
	@Enumerated(EnumType.STRING)
	private Refeicao descricao;
	
	@Size(max=256, message="Máximo de caracteres excedido")
	private String observacao;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "refeicaoPlanoAlimentar")
	private List<PorcaoAlimento> porcoesAlimentos;
	
	public List<PorcaoAlimento> getPorcoesAlimentos() {
		return this.porcoesAlimentos;
	}

	public void setPorcoesAlimentos(List<PorcaoAlimento> porcoesAlimentos) {
		this.porcoesAlimentos = porcoesAlimentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Refeicao getDescricao() {
		return descricao;
	}

	public void setDescricao(Refeicao descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}