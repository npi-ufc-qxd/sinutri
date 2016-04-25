package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(DistribuicaoAlimentarId.class)
public class DistribuicaoAlimentar {

	@Id
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
 
    @Id
    @ManyToOne
    @JoinColumn(name = "calculo_gastos_energeticos_id")
    private CalculoGastosEnergeticos calculoGastosEnergeticos;
    
    private Integer porcao;
    
    private Integer valorLipidio;
    
    private Integer valorGlicidio;
    
    private Integer valorProteina;
    
    private Integer porcaoDesjejum;
    
    private Integer porcaoCafeManha;
    
    private Integer porcaoColacao;
    
    private Integer porcaoAlmoco;
    
    private Integer porcaoLanceTarde;
    
    private Integer porcaoJantar;
    
    private Integer porcaoCeia;
    
    private Integer porcaoPreTreino;
    
    private Integer porcaoPosTreino;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public CalculoGastosEnergeticos getCalculoGastosEnergeticos() {
		return calculoGastosEnergeticos;
	}

	public void setCalculoGastosEnergeticos(CalculoGastosEnergeticos calculoGastosEnergeticos) {
		this.calculoGastosEnergeticos = calculoGastosEnergeticos;
	}

	public Integer getPorcao() {
		return porcao;
	}

	public void setPorcao(Integer porcao) {
		this.porcao = porcao;
	}

	public Integer getValorLipidio() {
		return valorLipidio;
	}

	public void setValorLipidio(Integer valorLipidio) {
		this.valorLipidio = valorLipidio;
	}

	public Integer getValorGlicidio() {
		return valorGlicidio;
	}

	public void setValorGlicidio(Integer valorGlicidio) {
		this.valorGlicidio = valorGlicidio;
	}

	public Integer getValorProteina() {
		return valorProteina;
	}

	public void setValorProteina(Integer valorProteina) {
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

	public Integer getPorcaoColacao() {
		return porcaoColacao;
	}

	public void setPorcaoColacao(Integer porcaoColacao) {
		this.porcaoColacao = porcaoColacao;
	}

	public Integer getPorcaoAlmoco() {
		return porcaoAlmoco;
	}

	public void setPorcaoAlmoco(Integer porcaoAlmoco) {
		this.porcaoAlmoco = porcaoAlmoco;
	}

	public Integer getPorcaoLanceTarde() {
		return porcaoLanceTarde;
	}

	public void setPorcaoLanceTarde(Integer porcaoLanceTarde) {
		this.porcaoLanceTarde = porcaoLanceTarde;
	}

	public Integer getPorcaoJantar() {
		return porcaoJantar;
	}

	public void setPorcaoJantar(Integer porcaoJantar) {
		this.porcaoJantar = porcaoJantar;
	}

	public Integer getPorcaoCeia() {
		return porcaoCeia;
	}

	public void setPorcaoCeia(Integer porcaoCeia) {
		this.porcaoCeia = porcaoCeia;
	}

	public Integer getPorcaoPreTreino() {
		return porcaoPreTreino;
	}

	public void setPorcaoPreTreino(Integer porcaoPreTreino) {
		this.porcaoPreTreino = porcaoPreTreino;
	}

	public Integer getPorcaoPosTreino() {
		return porcaoPosTreino;
	}

	public void setPorcaoPosTreino(Integer porcaoPosTreino) {
		this.porcaoPosTreino = porcaoPosTreino;
	}
}
