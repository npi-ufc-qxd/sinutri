package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DistribuicaoAlimentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer porcao;
	private Double valorLipidio;
	private Double valorGlicidio;
	private Double valorProteina;
	private Integer porcaoDesjejum;
	private Integer porcaoCafeManha;
	private Integer porcaoColacao;
	private Integer porcaoAlmoco;
	private Integer porcaoLancheTarde;
	private Integer porcaoJantar;
	private Integer preTreino;
	private Integer posTreino;
	
//	@ManyToOne
//	private CalculoGastoEnergetico calculoGastosEnergeticos;

	@OneToOne
	private Grupo grupo;
	
	
	public Integer getPorcao() {
		return porcao;
	}
	
	public void setPorcao(Integer porcao) {
		this.porcao = porcao;
	}
	
	public Double getValorLipidio() {
		return valorLipidio;
	}
	
	public void setValorLipidio(Double valorLipidio) {
		this.valorLipidio = valorLipidio;
	}
	
	public Double getValorGlicidio() {
		return valorGlicidio;
	}
	
	public Integer getPorcaoColacao() {
		return porcaoColacao;
	}

	public void setPorcaoColacao(Integer porcaoColacao) {
		this.porcaoColacao = porcaoColacao;
	}

	public void setValorGlicidio(Double valorGlicidio) {
		this.valorGlicidio = valorGlicidio;
	}
	
	public Double getValorProteina() {
		return valorProteina;
	}
	
	public void setValorProteina(Double valorProteina) {
		this.valorProteina = valorProteina;
	}
	
	public Integer getPorcaoDesjejum() {
		return porcaoDesjejum;
	}
	
	public void setPorcaoDesjejum(Integer porcaoDesjejum) {
		this.porcaoDesjejum = porcaoDesjejum;
	}
	
	public Integer getPorcaoCafeManha() {
		return porcaoCafeManha;
	}
	
	public void setPorcaoCafeManha(Integer porcaoCafeManha) {
		this.porcaoCafeManha = porcaoCafeManha;
	}
	
	public Integer getProcaoColacao() {
		return porcaoColacao;
	}
	
	public void setProcaoColacao(Integer procaoColacao) {
		this.porcaoColacao = procaoColacao;
	}
	
	public Integer getPorcaoAlmoco() {
		return porcaoAlmoco;
	}
	
	public void setPorcaoAlmoco(Integer porcaoAlmoco) {
		this.porcaoAlmoco = porcaoAlmoco;
	}
	
	public Integer getPorcaoLancheTarde() {
		return porcaoLancheTarde;
	}
	
	public void setPorcaoLancheTarde(Integer porcaoLancheTarde) {
		this.porcaoLancheTarde = porcaoLancheTarde;
	}
	
	public Integer getPorcaoJantar() {
		return porcaoJantar;
	}
	
	public void setPorcaoJantar(Integer porcaoJantar) {
		this.porcaoJantar = porcaoJantar;
	}
	
	public Integer getPreTreino() {
		return preTreino;
	}
	
	public void setPreTreino(Integer preTreino) {
		this.preTreino = preTreino;
	}
	
	public Integer getPosTreino() {
		return posTreino;
	}
	
	public void setPosTreino(Integer posTreino) {
		this.posTreino = posTreino;
	}                                              

//	public CalculoGastoEnergetico getCalculoGastosEnergeticos() {
//		return calculoGastosEnergeticos;
//	}
//	
//	public void setCalculoGastosEnergeticos(
//			CalculoGastoEnergetico calculoGastosEnergeticos) {
//		this.calculoGastosEnergeticos = calculoGastosEnergeticos;
//	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
}
