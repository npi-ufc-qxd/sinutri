package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AvaliacaoAntropometrica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date criadoEm;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date atualizadoEm;
	
	@ManyToOne
	private Servidor nutricionista;
		
	private Double peso; 
	private Double pesoDesejado;
	private Double altura;
	private Double ombro;
	private Double peitoral;
	private Double cintura;
	private Double abdomen;
	private Double quadril;
	private Double panturrilhaDireita;
	private Double panturrilhaEsquerda;
	private Double pescoco;
	private Double punho;
	private Double coxaDireita;
	private Double coxaEsquerda;
	private Double coxaProximalDireita;
	private Double coxaProximalEsquerda;
	private Double bracoRelaxadoDireita;
	private Double bracoRelaxadoEsquerda;
	private Double bracoContraidoDireito;
	private Double bracoContraidoEsquerdo;
	private Double antebraco;
	private Double diametroPunho;
	private Double diametroFemur;
	private Double biceps;
	private Double abdominal;
	private Double triceps;
	private Double suprailiaca;
	private Double axilarMedia;
	private Double subescapular;
	private Double torax;
	private Double coxa;
	private Double panturrilhaMedial;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getPesoDesejado() {
		return pesoDesejado;
	}
	public void setPesoDesejado(Double pesoDesejado) {
		this.pesoDesejado = pesoDesejado;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getOmbro() {
		return ombro;
	}
	public void setOmbro(Double ombro) {
		this.ombro = ombro;
	}
	public Double getPeitoral() {
		return peitoral;
	}
	public void setPeitoral(Double peitoral) {
		this.peitoral = peitoral;
	}
	public Double getCintura() {
		return cintura;
	}
	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}
	public Double getAbdomen() {
		return abdomen;
	}
	public void setAbdomen(Double abdomen) {
		this.abdomen = abdomen;
	}
	public Double getQuadril() {
		return quadril;
	}
	public void setQuadril(Double quadril) {
		this.quadril = quadril;
	}
	public Double getPanturrilhaDireita() {
		return panturrilhaDireita;
	}
	public void setPanturrilhaDireita(Double panturrilhaDireita) {
		this.panturrilhaDireita = panturrilhaDireita;
	}
	public Double getPanturrilhaEsquerda() {
		return panturrilhaEsquerda;
	}
	public void setPanturrilhaEsquerda(Double panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}
	public Double getPescoco() {
		return pescoco;
	}
	public void setPescoco(Double pescoco) {
		this.pescoco = pescoco;
	}
	public Double getPunho() {
		return punho;
	}
	public void setPunho(Double punho) {
		this.punho = punho;
	}
	public Double getCoxaDireita() {
		return coxaDireita;
	}
	public void setCoxaDireita(Double coxaDireita) {
		this.coxaDireita = coxaDireita;
	}
	public Double getCoxaEsquerda() {
		return coxaEsquerda;
	}
	public void setCoxaEsquerda(Double coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}
	public Double getCoxaProximalDireita() {
		return coxaProximalDireita;
	}
	public void setCoxaProximalDireita(Double coxaProximalDireita) {
		this.coxaProximalDireita = coxaProximalDireita;
	}
	public Double getCoxaProximalEsquerda() {
		return coxaProximalEsquerda;
	}
	public void setCoxaProximalEsquerda(Double coxaProximalEsquerda) {
		this.coxaProximalEsquerda = coxaProximalEsquerda;
	}
	public Double getBracoRelaxadoDireita() {
		return bracoRelaxadoDireita;
	}
	public void setBracoRelaxadoDireita(Double bracoRelaxadoDireita) {
		this.bracoRelaxadoDireita = bracoRelaxadoDireita;
	}
	public Double getBracoRelaxadoEsquerda() {
		return bracoRelaxadoEsquerda;
	}
	public void setBracoRelaxadoEsquerda(Double bracoRelaxadoEsquerda) {
		this.bracoRelaxadoEsquerda = bracoRelaxadoEsquerda;
	}
	public Double getBracoContraidoDireito() {
		return bracoContraidoDireito;
	}
	public void setBracoContraidoDireito(Double bracoContraidoDireito) {
		this.bracoContraidoDireito = bracoContraidoDireito;
	}
	public Double getBracoContraidoEsquerdo() {
		return bracoContraidoEsquerdo;
	}
	public void setBracoContraidoEsquerdo(Double bracoContraidoEsquerdo) {
		this.bracoContraidoEsquerdo = bracoContraidoEsquerdo;
	}
	public Double getAntebraco() {
		return antebraco;
	}
	public void setAntebraco(Double antebraco) {
		this.antebraco = antebraco;
	}
	public Double getDiametroPunho() {
		return diametroPunho;
	}
	public void setDiametroPunho(Double diametroPunho) {
		this.diametroPunho = diametroPunho;
	}
	public Double getDiametroFemur() {
		return diametroFemur;
	}
	public void setDiametroFemur(Double diametroFemur) {
		this.diametroFemur = diametroFemur;
	}
	public Double getBiceps() {
		return biceps;
	}
	public void setBiceps(Double biceps) {
		this.biceps = biceps;
	}
	public Double getAbdominal() {
		return abdominal;
	}
	public void setAbdominal(Double abdominal) {
		this.abdominal = abdominal;
	}
	public Double getTriceps() {
		return triceps;
	}
	public void setTriceps(Double triceps) {
		this.triceps = triceps;
	}
	public Double getSuprailiaca() {
		return suprailiaca;
	}
	public void setSuprailiaca(Double suprailiaca) {
		this.suprailiaca = suprailiaca;
	}
	public Double getAxilarMedia() {
		return axilarMedia;
	}
	public void setAxilarMedia(Double axilarMedia) {
		this.axilarMedia = axilarMedia;
	}
	public Double getSubescapular() {
		return subescapular;
	}
	public void setSubescapular(Double subescapular) {
		this.subescapular = subescapular;
	}
	public Double getTorax() {
		return torax;
	}
	public void setTorax(Double torax) {
		this.torax = torax;
	}
	public Double getCoxa() {
		return coxa;
	}
	public void setCoxa(Double coxa) {
		this.coxa = coxa;
	}
	public Double getPanturrilhaMedial() {
		return panturrilhaMedial;
	}
	public void setPanturrilhaMedial(Double panturrilhaMedial) {
		this.panturrilhaMedial = panturrilhaMedial;
	}
	
}
