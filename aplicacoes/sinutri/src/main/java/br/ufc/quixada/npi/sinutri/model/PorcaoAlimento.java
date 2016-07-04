package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PorcaoAlimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private RefeicaoPlanoAlimentar refeicaoPlanoAlimentar;
	
	@OneToOne
	private Alimento alimento;
	
	private Integer quantidade;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public RefeicaoPlanoAlimentar getRefeicaoPlanoAlimentar() {
		return refeicaoPlanoAlimentar;
	}

	public void setRefeicaoPlanoAlimentar(RefeicaoPlanoAlimentar refeicaoPlanoAlimentar) {
		this.refeicaoPlanoAlimentar = refeicaoPlanoAlimentar;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}