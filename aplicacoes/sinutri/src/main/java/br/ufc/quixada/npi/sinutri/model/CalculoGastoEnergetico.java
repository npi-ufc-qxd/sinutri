package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CalculoGastoEnergetico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Especifique um peso.")
	private Double pesoSugerido;
	private Double vet;
	private Double ajuste;
	private Double lipidio;
	private Double proteina;
	private Double glicidio;
	private Double totalCalorias;
	@NotNull(message="Especifique um fator.")
	private Double fatorAtividade;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date criadoEm;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date atualizadoEm;
	
	@ManyToOne
	private Servidor nutricionista;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DistribuicaoAlimentar> distribuicoesAlimentares;
	
	@ManyToOne
	private Paciente paciente;
	
	public Double getPesoSugerido() {
		return pesoSugerido;
	}
	public void setPesoSugerido(Double pesoSugerido) {
		this.pesoSugerido = pesoSugerido;
	}
	public Double getVet() {
		return vet;
	}
	public void setVet(Double vet) {
		this.vet = vet;
	}
	public Double getAjuste() {
		return ajuste;
	}
	public void setAjuste(Double ajuste) {
		this.ajuste = ajuste;
	}
	public Double getLipidio() {
		return lipidio;
	}
	public void setLipidio(Double lipidio) {
		this.lipidio = lipidio;
	}
	public Double getProteina() {
		return proteina;
	}
	public void setProteina(Double proteina) {
		this.proteina = proteina;
	}
	public Double getGlicidio() {
		return glicidio;
	}
	public void setGlicidio(Double glicidio) {
		this.glicidio = glicidio;
	}
	public Double getTotalCalorias() {
		return totalCalorias;
	}
	public void setTotalCalorias(Double totalCalorias) {
		this.totalCalorias = totalCalorias;
	}
	public Servidor getNutricionista() {
		return nutricionista;
	}
	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
	}
	public List<DistribuicaoAlimentar> getDistribuicoesAlimentares() {
		return distribuicoesAlimentares;
	}
	public void setDistribuicoesAlimentares(
			List<DistribuicaoAlimentar> distribuicoesAlimentares) {
		this.distribuicoesAlimentares = distribuicoesAlimentares;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
	public Double getFatorAtividade() {
		return fatorAtividade;
	}
	public void setFatorAtividade(Double fatorAtividade) {
		this.fatorAtividade = fatorAtividade;
	}
	
}
