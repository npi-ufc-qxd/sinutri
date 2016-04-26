package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(PorcaoAlimentoId.class)
public class PorcaoAlimento {
	@Id
	@ManyToOne
	@JoinColumn(name = "alimento_id")
	private Alimento alimento;

	@Id
	@ManyToOne
	@JoinColumn(name = "refeicao_plano_alimentar_id")
	private RefeicaoPlanoAlimentar refeicaoPlanoAlimentar;
	
	private Integer quantidade;
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public RefeicaoPlanoAlimentar getRefeicaoPlanoAlimentar() {
		return refeicaoPlanoAlimentar;
	}

	public void setRefeicaoPlanoAlimentar(
			RefeicaoPlanoAlimentar refeicaoPlanoAlimentar) {
		this.refeicaoPlanoAlimentar = refeicaoPlanoAlimentar;
	}

}
