package br.ufc.quixada.npi.sinutri.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;

@Entity
public class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double porcao;
	private Double valorCalorico;
	private Double proteinas;
	private Double carboidratos;
	private Double gordurasTotais;
	private Double acucar;
	private Double calcio;
	private Double colesterol;
	private Double ferro;
	private Double fibraAlimentar;
	private Double gMonoinsaturada;
	private Double gPoliinsaturada;
	private Double gSaturada;
	private Double gTrans;
	private Double fosforo;
	private Double magnesio;
	private Double potassio;
	private Double selenio;
	private Double sodio;
	private Double vitaminaARetinol;
	private Double vitaminaB1Tiamina;
	private Double vitaminaB2Riboflavina;
	private Double vitaminaB3Niacina;
	private Double vitaminaB6Piridoxina;
	private Double vitaminaB9AcidoFolico;
	private Double vitaminaB12Cobalamina;
	private Double vitaminaCAcidoAscorbico;
	private Double vitaminaDCalciferol;
	private Double vitaminaETocoferol;
	private Double zinco;
	
	@ManyToOne
	private Grupo grupo;
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<PorcaoAlimento> getRefeicoesPlanoAlimentar() {
		return refeicoesPlanoAlimentar;
	}

	public void setRefeicoesPlanoAlimentar(List<PorcaoAlimento> refeicoesPlanoAlimentar) {
		this.refeicoesPlanoAlimentar = refeicoesPlanoAlimentar;
	}

	@Enumerated(EnumType.STRING)
	private FonteAlimento fonte;
	
	@OneToMany
	@JoinColumn(name = "alimento_id")
	private List<MedidaCaseira> medidasCaseira;
	
	@OneToMany(mappedBy = "alimento")
	private List<PorcaoAlimento> refeicoesPlanoAlimentar;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPorcao() {
		return porcao;
	}

	public void setPorcao(Double porcao) {
		this.porcao = porcao;
	}

	public Double getValorCalorico() {
		return valorCalorico;
	}

	public void setValorCalorico(Double valorCalorico) {
		this.valorCalorico = valorCalorico;
	}

	public Double getProteinas() {
		return proteinas;
	}

	public void setProteinas(Double proteinas) {
		this.proteinas = proteinas;
	}

	public Double getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(Double carboidratos) {
		this.carboidratos = carboidratos;
	}

	public Double getGordurasTotais() {
		return gordurasTotais;
	}

	public void setGordurasTotais(Double gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	public Double getAcucar() {
		return acucar;
	}

	public void setAcucar(Double acucar) {
		this.acucar = acucar;
	}

	public Double getCalcio() {
		return calcio;
	}

	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}

	public Double getColesterol() {
		return colesterol;
	}

	public void setColesterol(Double colesterol) {
		this.colesterol = colesterol;
	}

	public Double getFerro() {
		return ferro;
	}

	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}

	public Double getFibraAlimentar() {
		return fibraAlimentar;
	}

	public void setFibraAlimentar(Double fibraAlimentar) {
		this.fibraAlimentar = fibraAlimentar;
	}

	public Double getgMonoinsaturada() {
		return gMonoinsaturada;
	}

	public void setgMonoinsaturada(Double gMonoinsaturada) {
		this.gMonoinsaturada = gMonoinsaturada;
	}

	public Double getgPoliinsaturada() {
		return gPoliinsaturada;
	}

	public void setgPoliinsaturada(Double gPoliinsaturada) {
		this.gPoliinsaturada = gPoliinsaturada;
	}

	public Double getgSaturada() {
		return gSaturada;
	}

	public void setgSaturada(Double gSaturada) {
		this.gSaturada = gSaturada;
	}

	public Double getgTrans() {
		return gTrans;
	}

	public void setgTrans(Double gTrans) {
		this.gTrans = gTrans;
	}

	public Double getFosforo() {
		return fosforo;
	}

	public void setFosforo(Double fosforo) {
		this.fosforo = fosforo;
	}

	public Double getMagnesio() {
		return magnesio;
	}

	public void setMagnesio(Double magnesio) {
		this.magnesio = magnesio;
	}

	public Double getPotassio() {
		return potassio;
	}

	public void setPotassio(Double potassio) {
		this.potassio = potassio;
	}

	public Double getSelenio() {
		return selenio;
	}

	public void setSelenio(Double selenio) {
		this.selenio = selenio;
	}

	public Double getSodio() {
		return sodio;
	}

	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}

	public Double getVitaminaARetinol() {
		return vitaminaARetinol;
	}

	public void setVitaminaARetinol(Double vitaminaARetinol) {
		this.vitaminaARetinol = vitaminaARetinol;
	}

	public Double getVitaminaB1Tiamina() {
		return vitaminaB1Tiamina;
	}

	public void setVitaminaB1Tiamina(Double vitaminaB1Tiamina) {
		this.vitaminaB1Tiamina = vitaminaB1Tiamina;
	}

	public Double getVitaminaB2Riboflavina() {
		return vitaminaB2Riboflavina;
	}

	public void setVitaminaB2Riboflavina(Double vitaminaB2Riboflavina) {
		this.vitaminaB2Riboflavina = vitaminaB2Riboflavina;
	}

	public Double getVitaminaB3Niacina() {
		return vitaminaB3Niacina;
	}

	public void setVitaminaB3Niacina(Double vitaminaB3Niacina) {
		this.vitaminaB3Niacina = vitaminaB3Niacina;
	}

	public Double getVitaminaB6Piridoxina() {
		return vitaminaB6Piridoxina;
	}

	public void setVitaminaB6Piridoxina(Double vitaminaB6Piridoxina) {
		this.vitaminaB6Piridoxina = vitaminaB6Piridoxina;
	}

	public Double getVitaminaB9AcidoFolico() {
		return vitaminaB9AcidoFolico;
	}

	public void setVitaminaB9AcidoFolico(Double vitaminaB9AcidoFolico) {
		this.vitaminaB9AcidoFolico = vitaminaB9AcidoFolico;
	}

	public Double getVitaminaB12Cobalamina() {
		return vitaminaB12Cobalamina;
	}

	public void setVitaminaB12Cobalamina(Double vitaminaB12Cobalamina) {
		this.vitaminaB12Cobalamina = vitaminaB12Cobalamina;
	}

	public Double getVitaminaCAcidoAscorbico() {
		return vitaminaCAcidoAscorbico;
	}

	public void setVitaminaCAcidoAscorbico(Double vitaminaCAcidoAscorbico) {
		this.vitaminaCAcidoAscorbico = vitaminaCAcidoAscorbico;
	}

	public Double getVitaminaDCalciferol() {
		return vitaminaDCalciferol;
	}

	public void setVitaminaDCalciferol(Double vitaminaDCalciferol) {
		this.vitaminaDCalciferol = vitaminaDCalciferol;
	}

	public Double getVitaminaETocoferol() {
		return vitaminaETocoferol;
	}

	public void setVitaminaETocoferol(Double vitaminaETocoferol) {
		this.vitaminaETocoferol = vitaminaETocoferol;
	}

	public Double getZinco() {
		return zinco;
	}

	public void setZinco(Double zinco) {
		this.zinco = zinco;
	}

	public FonteAlimento getFonte() {
		return fonte;
	}

	public void setFonte(FonteAlimento fonte) {
		this.fonte = fonte;
	}
	
	public List<MedidaCaseira> getMedidasCaseira() {
		return medidasCaseira;
	}

	public void setMedidasCaseira(List<MedidaCaseira> medidasCaseira) {
		this.medidasCaseira = medidasCaseira;
	}

}