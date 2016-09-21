package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PorcaoAlimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private RefeicaoPlanoAlimentar refeicaoPlanoAlimentar;
	
	@ManyToOne
	private Alimento alimento;
	
	private Double quantidade;
	
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

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
}