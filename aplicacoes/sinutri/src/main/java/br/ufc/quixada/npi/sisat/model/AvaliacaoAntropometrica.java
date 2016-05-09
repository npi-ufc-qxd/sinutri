package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.ManyToAny;
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
	
	@Transient
	@ManyToOne
	private Servidor nutricionista;

	@ManyToOne
	private Paciente paciente;
	
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
	private Double bracoRelaxadoDireito;
	private Double bracoRelaxadoEsquerdo;
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
	
	public AvaliacaoAntropometrica() {
		super();
	}
	public AvaliacaoAntropometrica(Paciente paciente) {
		super();
		setPaciente(paciente);
	}
	public AvaliacaoAntropometrica(Long id, Date criadoEm, Date atualizadoEm, Servidor nutricionista, Paciente paciente,
			Double peso, Double pesoDesejado, Double altura, Double ombro, Double peitoral, Double cintura,
			Double abdomen, Double quadril, Double panturrilhaDireita, Double panturrilhaEsquerda, Double pescoco,
			Double punho, Double coxaDireita, Double coxaEsquerda, Double coxaProximalDireita,
			Double coxaProximalEsquerda, Double bracoRelaxadoDireito, Double bracoRelaxadoEsquerdo,
			Double bracoContraidoDireito, Double bracoContraidoEsquerdo, Double antebraco, Double diametroPunho,
			Double diametroFemur, Double biceps, Double abdominal, Double triceps, Double suprailiaca,
			Double axilarMedia, Double subescapular, Double torax, Double coxa, Double panturrilhaMedial) {
		super();
		this.id = id;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
		this.nutricionista = nutricionista;
		this.paciente = paciente;
		this.peso = peso;
		this.pesoDesejado = pesoDesejado;
		this.altura = altura;
		this.ombro = ombro;
		this.peitoral = peitoral;
		this.cintura = cintura;
		this.abdomen = abdomen;
		this.quadril = quadril;
		this.panturrilhaDireita = panturrilhaDireita;
		this.panturrilhaEsquerda = panturrilhaEsquerda;
		this.pescoco = pescoco;
		this.punho = punho;
		this.coxaDireita = coxaDireita;
		this.coxaEsquerda = coxaEsquerda;
		this.coxaProximalDireita = coxaProximalDireita;
		this.coxaProximalEsquerda = coxaProximalEsquerda;
		this.bracoRelaxadoDireito = bracoRelaxadoDireito;
		this.bracoRelaxadoEsquerdo = bracoRelaxadoEsquerdo;
		this.bracoContraidoDireito = bracoContraidoDireito;
		this.bracoContraidoEsquerdo = bracoContraidoEsquerdo;
		this.antebraco = antebraco;
		this.diametroPunho = diametroPunho;
		this.diametroFemur = diametroFemur;
		this.biceps = biceps;
		this.abdominal = abdominal;
		this.triceps = triceps;
		this.suprailiaca = suprailiaca;
		this.axilarMedia = axilarMedia;
		this.subescapular = subescapular;
		this.torax = torax;
		this.coxa = coxa;
		this.panturrilhaMedial = panturrilhaMedial;
	}
	
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
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
	public Double getBracoRelaxadoDireito() {
		return bracoRelaxadoDireito;
	}
	public void setBracoRelaxadoDireito(Double bracoRelaxadoDireito) {
		this.bracoRelaxadoDireito = bracoRelaxadoDireito;
	}
	public Double getBracoRelaxadoEsquerdo() {
		return bracoRelaxadoEsquerdo;
	}
	public void setBracoRelaxadoEsquerdo(Double bracoRelaxadoEsquerdo) {
		this.bracoRelaxadoEsquerdo = bracoRelaxadoEsquerdo;
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
