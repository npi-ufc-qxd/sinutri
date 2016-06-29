package br.ufc.quixada.npi.sinutri.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PorcaoAlimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private RefeicaoPlanoAlimentar refeicaoPlanoAlimentar;
	
	@OneToMany(mappedBy = "porcaoAlimentar")
	private List<Alimento> alimentos;
	
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

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}