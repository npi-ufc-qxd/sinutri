package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(DistribuicaoId.class)
public class Distribuicao {
	@Id
    @ManyToOne
    @JoinColumn(name="grupo_id")
    private Grupo grupo;
	
	@Id
    @ManyToOne
    @JoinColumn(name="refeicao_id")
    private Refeicao refeicao;
	
	private Integer quantidade;
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
