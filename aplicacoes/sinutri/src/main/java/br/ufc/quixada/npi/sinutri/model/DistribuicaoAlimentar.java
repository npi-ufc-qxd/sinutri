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
	
	private Long porcao;
	private Long valorLipidio;
	private Long valorGlicidio;
	private Long valorProteina;
	private Long porcaoDesjejum;
	private Long porcaoCafeManha;
	private Long porcaoColacao;
	private Long porcaoAlmoco;
	private Long porcaoLancheTarde;
	private Long porcaoJantar;
	private Long preTreino;
	private Long posTreino;
	
	@ManyToOne
	private CalculoGastoEnergetico calculoGastosEnergeticos;
	
	@OneToOne
	private Grupo grupo;
	
	
	public Long getPorcao() {
		return porcao;
	}
	
	public void setPorcao(Long porcao) {
		this.porcao = porcao;
	}
	
	public Long getValorLipidio() {
		return valorLipidio;
	}
	
	public void setValorLipidio(Long valorLipidio) {
		this.valorLipidio = valorLipidio;
	}
	
	public Long getValorGlicidio() {
		return valorGlicidio;
	}
	
	public void setValorGlicidio(Long valorGlicidio) {
		this.valorGlicidio = valorGlicidio;
	}
	
	public Long getValorProteina() {
		return valorProteina;
	}
	
	public void setValorProteina(Long valorProteina) {
		this.valorProteina = valorProteina;
	}
	
	public Long getPorcaoDesjejum() {
		return porcaoDesjejum;
	}
	
	public void setPorcaoDesjejum(Long porcaoDesjejum) {
		this.porcaoDesjejum = porcaoDesjejum;
	}
	
	public Long getPorcaoCafeManha() {
		return porcaoCafeManha;
	}
	
	public void setPorcaoCafeManha(Long porcaoCafeManha) {
		this.porcaoCafeManha = porcaoCafeManha;
	}
	
	public Long getProcaoColacao() {
		return porcaoColacao;
	}
	
	public void setProcaoColacao(Long procaoColacao) {
		this.porcaoColacao = procaoColacao;
	}
	
	public Long getPorcaoAlmoco() {
		return porcaoAlmoco;
	}
	
	public void setPorcaoAlmoco(Long porcaoAlmoco) {
		this.porcaoAlmoco = porcaoAlmoco;
	}
	
	public Long getPorcaoLancheTarde() {
		return porcaoLancheTarde;
	}
	
	public void setPorcaoLancheTarde(Long porcaoLancheTarde) {
		this.porcaoLancheTarde = porcaoLancheTarde;
	}
	
	public Long getPorcaoJantar() {
		return porcaoJantar;
	}
	
	public void setPorcaoJantar(Long porcaoJantar) {
		this.porcaoJantar = porcaoJantar;
	}
	
	public Long getPreTreino() {
		return preTreino;
	}
	
	public void setPreTreino(Long preTreino) {
		this.preTreino = preTreino;
	}
	
	public Long getPosTreino() {
		return posTreino;
	}
	
	public void setPosTreino(Long posTreino) {
		this.posTreino = posTreino;
	}                                              

	public CalculoGastoEnergetico getCalculoGastosEnergeticos() {
		return calculoGastosEnergeticos;
	}
	
	public void setCalculoGastosEnergeticos(
			CalculoGastoEnergetico calculoGastosEnergeticos) {
		this.calculoGastosEnergeticos = calculoGastosEnergeticos;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
}
