package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;

@Entity
public class InqueritoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "consultaNutricional_id")
	@JsonIgnore
	private ConsultaNutricional consultaNutricional;

	private boolean bovinaGosta;
	@Enumerated(EnumType.STRING)
	private Frequencia bovinaFrequenciaSemanal;
	private double bovinaQuantidade;

	private boolean avesGosta;
	private boolean peixeGosta;
	private boolean viscerasGosta;
	private boolean leiteDerivadosGosta;
	private boolean ovosGosta;
	private boolean leguminosasGosta;
	private boolean cereaisGosta;
	private boolean massasGosta;
	private boolean vegetaisCrusGosta;
	private boolean vegetaisCozidosGosta;
	private boolean frutasGosta;
	private boolean docesGosta;
	private boolean oleoGosta;
	private boolean margarinaGosta;
	private boolean manteigaGosta;
	private boolean toucinhoBaconGosta;
	private boolean aguaGosta;
	private boolean sucoGosta;
	private boolean bebidasAlcoolicasGosta;
	private boolean gaseificadasGosta;
	private boolean infusoesGosta;

	@Enumerated(EnumType.STRING)
	private Frequencia avesFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia peixeFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia viscerasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia leiteDerivadosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia ovosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia massasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia vegetaisCrusFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia vegetaisCozidosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia frutasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia docesFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia oleoFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia margarinaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia manteigaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia toucinhoBaconFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia aguaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia sucoFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia bebidasAlcoolicasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia gaseificadasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private Frequencia infusoesFrequenciaSemanal;

	private String avesQuantidade;
	private String peixeQuantidade;
	private String viscerasQuantidade;
	private String leiteDerivadosQuantidade;
	private String ovosQuantidade;
	private String leguminosasQuantidade;
	private String cereaisQuantidade;
	private String massasQuantidade;
	private String vegetaisCrusQuantidade;
	private String vegetaisCozidosQuantidade;
	private String frutasQuantidade;
	private String docesQuantidade;
	private String oleoQuantidade;
	private String margarinaQuantidade;
	private String manteigaQuantidade;
	private String toucinhoBaconQuantidade;
	private String aguaQuantidade;
	private String sucoQuantidade;
	private String bebidasAlcoolicasQuantidade;
	private String gaseificadasQuantidade;
	private String infusoesQuantidade;

	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConsultaNutricional getConsultaNutricional() {
		return consultaNutricional;
	}

	public void setConsultaNutricional(ConsultaNutricional consultaNutricional) {
		this.consultaNutricional = consultaNutricional;
	}

	public boolean isBovinaGosta() {
		return bovinaGosta;
	}

	public void setBovinaGosta(boolean bovinaGosta) {
		this.bovinaGosta = bovinaGosta;
	}

	public double getBovinaQuantidade() {
		return bovinaQuantidade;
	}

	public void setBovinaQuantidade(double bovinaQuantidade) {
		this.bovinaQuantidade = bovinaQuantidade;
	}

	public boolean isAvesGosta() {
		return avesGosta;
	}

	public void setAvesGosta(boolean avesGosta) {
		this.avesGosta = avesGosta;
	}

	public boolean isPeixeGosta() {
		return peixeGosta;
	}

	public void setPeixeGosta(boolean peixeGosta) {
		this.peixeGosta = peixeGosta;
	}

	public boolean isViscerasGosta() {
		return viscerasGosta;
	}

	public void setViscerasGosta(boolean viscerasGosta) {
		this.viscerasGosta = viscerasGosta;
	}

	public boolean isLeiteDerivadosGosta() {
		return leiteDerivadosGosta;
	}

	public void setLeiteDerivadosGosta(boolean leiteDerivadosGosta) {
		this.leiteDerivadosGosta = leiteDerivadosGosta;
	}

	public boolean isOvosGosta() {
		return ovosGosta;
	}

	public void setOvosGosta(boolean ovosGosta) {
		this.ovosGosta = ovosGosta;
	}

	public boolean isLeguminosasGosta() {
		return leguminosasGosta;
	}

	public void setLeguminosasGosta(boolean leguminosasGosta) {
		this.leguminosasGosta = leguminosasGosta;
	}

	public boolean isCereaisGosta() {
		return cereaisGosta;
	}

	public void setCereaisGosta(boolean cereaisGosta) {
		this.cereaisGosta = cereaisGosta;
	}

	public boolean isMassasGosta() {
		return massasGosta;
	}

	public void setMassasGosta(boolean massasGosta) {
		this.massasGosta = massasGosta;
	}

	public boolean isVegetaisCrusGosta() {
		return vegetaisCrusGosta;
	}

	public void setVegetaisCrusGosta(boolean vegetaisCrusGosta) {
		this.vegetaisCrusGosta = vegetaisCrusGosta;
	}

	public boolean isVegetaisCozidosGosta() {
		return vegetaisCozidosGosta;
	}

	public void setVegetaisCozidosGosta(boolean vegetaisCozidosGosta) {
		this.vegetaisCozidosGosta = vegetaisCozidosGosta;
	}

	public boolean isFrutasGosta() {
		return frutasGosta;
	}

	public void setFrutasGosta(boolean frutasGosta) {
		this.frutasGosta = frutasGosta;
	}

	public boolean isDocesGosta() {
		return docesGosta;
	}

	public void setDocesGosta(boolean docesGosta) {
		this.docesGosta = docesGosta;
	}

	public boolean isOleoGosta() {
		return oleoGosta;
	}

	public void setOleoGosta(boolean oleoGosta) {
		this.oleoGosta = oleoGosta;
	}

	public boolean isMargarinaGosta() {
		return margarinaGosta;
	}

	public void setMargarinaGosta(boolean margarinaGosta) {
		this.margarinaGosta = margarinaGosta;
	}

	public boolean isManteigaGosta() {
		return manteigaGosta;
	}

	public void setManteigaGosta(boolean manteigaGosta) {
		this.manteigaGosta = manteigaGosta;
	}

	public boolean isToucinhoBaconGosta() {
		return toucinhoBaconGosta;
	}

	public void setToucinhoBaconGosta(boolean toucinhoBaconGosta) {
		this.toucinhoBaconGosta = toucinhoBaconGosta;
	}

	public boolean isAguaGosta() {
		return aguaGosta;
	}

	public void setAguaGosta(boolean aguaGosta) {
		this.aguaGosta = aguaGosta;
	}

	public boolean isSucoGosta() {
		return sucoGosta;
	}

	public void setSucoGosta(boolean sucoGosta) {
		this.sucoGosta = sucoGosta;
	}

	public boolean isBebidasAlcoolicasGosta() {
		return bebidasAlcoolicasGosta;
	}

	public void setBebidasAlcoolicasGosta(boolean bebidasAlcoolicasGosta) {
		this.bebidasAlcoolicasGosta = bebidasAlcoolicasGosta;
	}

	public boolean isGaseificadasGosta() {
		return gaseificadasGosta;
	}

	public void setGaseificadasGosta(boolean gaseificadasGosta) {
		this.gaseificadasGosta = gaseificadasGosta;
	}

	public boolean isInfusoesGosta() {
		return infusoesGosta;
	}

	public void setInfusoesGosta(boolean infusoesGosta) {
		this.infusoesGosta = infusoesGosta;
	}

	public Frequencia getAguaFrequenciaSemanal() {
		return aguaFrequenciaSemanal;
	}

	public void setAguaFrequenciaSemanal(Frequencia aguaFrequenciaSemanal) {
		this.aguaFrequenciaSemanal = aguaFrequenciaSemanal;
	}

	public Frequencia getAvesFrequenciaSemanal() {
		return avesFrequenciaSemanal;
	}

	public void setAvesFrequenciaSemanal(Frequencia avesFrequenciaSemanal) {
		this.avesFrequenciaSemanal = avesFrequenciaSemanal;
	}

	public Frequencia getBebidasAlcoolicasFrequenciaSemanal() {
		return bebidasAlcoolicasFrequenciaSemanal;
	}

	public void setBebidasAlcoolicasFrequenciaSemanal(Frequencia bebidasAlcoolicasFrequenciaSemanal) {
		this.bebidasAlcoolicasFrequenciaSemanal = bebidasAlcoolicasFrequenciaSemanal;
	}

	public Frequencia getBovinaFrequenciaSemanal() {
		return bovinaFrequenciaSemanal;
	}

	public void setBovinaFrequenciaSemanal(Frequencia bovinaFrequenciaSemanal) {
		this.bovinaFrequenciaSemanal = bovinaFrequenciaSemanal;
	}

	public Frequencia getCereaisFrequenciaSemanal() {
		return cereaisFrequenciaSemanal;
	}

	public void setCereaisFrequenciaSemanal(Frequencia cereaisFrequenciaSemanal) {
		this.cereaisFrequenciaSemanal = cereaisFrequenciaSemanal;
	}

	public Frequencia getDocesFrequenciaSemanal() {
		return docesFrequenciaSemanal;
	}

	public void setDocesFrequenciaSemanal(Frequencia docesFrequenciaSemanal) {
		this.docesFrequenciaSemanal = docesFrequenciaSemanal;
	}

	public Frequencia getFrutasFrequenciaSemanal() {
		return frutasFrequenciaSemanal;
	}

	public void setFrutasFrequenciaSemanal(Frequencia frutasFrequenciaSemanal) {
		this.frutasFrequenciaSemanal = frutasFrequenciaSemanal;
	}

	public Frequencia getGaseificadasFrequenciaSemanal() {
		return gaseificadasFrequenciaSemanal;
	}

	public void setGaseificadasFrequenciaSemanal(Frequencia gaseificadasFrequenciaSemanal) {
		this.gaseificadasFrequenciaSemanal = gaseificadasFrequenciaSemanal;
	}

	public Frequencia getInfusoesFrequenciaSemanal() {
		return infusoesFrequenciaSemanal;
	}

	public void setInfusoesFrequenciaSemanal(Frequencia infusoesFrequenciaSemanal) {
		this.infusoesFrequenciaSemanal = infusoesFrequenciaSemanal;
	}

	public Frequencia getLeguminosasFrequenciaSemanal() {
		return leguminosasFrequenciaSemanal;
	}

	public void setLeguminosasFrequenciaSemanal(Frequencia leguminosasFrequenciaSemanal) {
		this.leguminosasFrequenciaSemanal = leguminosasFrequenciaSemanal;
	}

	public Frequencia getLeiteDerivadosFrequenciaSemanal() {
		return leiteDerivadosFrequenciaSemanal;
	}

	public void setLeiteDerivadosFrequenciaSemanal(Frequencia leiteDerivadosFrequenciaSemanal) {
		this.leiteDerivadosFrequenciaSemanal = leiteDerivadosFrequenciaSemanal;
	}

	public Frequencia getManteigaFrequenciaSemanal() {
		return manteigaFrequenciaSemanal;
	}

	public void setManteigaFrequenciaSemanal(Frequencia manteigaFrequenciaSemanal) {
		this.manteigaFrequenciaSemanal = manteigaFrequenciaSemanal;
	}

	public Frequencia getMargarinaFrequenciaSemanal() {
		return margarinaFrequenciaSemanal;
	}

	public void setMargarinaFrequenciaSemanal(Frequencia margarinaFrequenciaSemanal) {
		this.margarinaFrequenciaSemanal = margarinaFrequenciaSemanal;
	}

	public Frequencia getMassasFrequenciaSemanal() {
		return massasFrequenciaSemanal;
	}

	public void setMassasFrequenciaSemanal(Frequencia massasFrequenciaSemanal) {
		this.massasFrequenciaSemanal = massasFrequenciaSemanal;
	}

	public Frequencia getOleoFrequenciaSemanal() {
		return oleoFrequenciaSemanal;
	}

	public void setOleoFrequenciaSemanal(Frequencia oleoFrequenciaSemanal) {
		this.oleoFrequenciaSemanal = oleoFrequenciaSemanal;
	}

	public Frequencia getOvosFrequenciaSemanal() {
		return ovosFrequenciaSemanal;
	}

	public void setOvosFrequenciaSemanal(Frequencia ovosFrequenciaSemanal) {
		this.ovosFrequenciaSemanal = ovosFrequenciaSemanal;
	}

	public Frequencia getPeixeFrequenciaSemanal() {
		return peixeFrequenciaSemanal;
	}

	public void setPeixeFrequenciaSemanal(Frequencia peixeFrequenciaSemanal) {
		this.peixeFrequenciaSemanal = peixeFrequenciaSemanal;
	}

	public Frequencia getSucoFrequenciaSemanal() {
		return sucoFrequenciaSemanal;
	}

	public void setSucoFrequenciaSemanal(Frequencia sucoFrequenciaSemanal) {
		this.sucoFrequenciaSemanal = sucoFrequenciaSemanal;
	}

	public Frequencia getToucinhoBaconFrequenciaSemanal() {
		return toucinhoBaconFrequenciaSemanal;
	}

	public void setToucinhoBaconFrequenciaSemanal(Frequencia toucinhoBaconFrequenciaSemanal) {
		this.toucinhoBaconFrequenciaSemanal = toucinhoBaconFrequenciaSemanal;
	}

	public Frequencia getVegetaisCozidosFrequenciaSemanal() {
		return vegetaisCozidosFrequenciaSemanal;
	}

	public void setVegetaisCozidosFrequenciaSemanal(Frequencia vegetaisCozidosFrequenciaSemanal) {
		this.vegetaisCozidosFrequenciaSemanal = vegetaisCozidosFrequenciaSemanal;
	}

	public Frequencia getVegetaisCrusFrequenciaSemanal() {
		return vegetaisCrusFrequenciaSemanal;
	}

	public void setVegetaisCrusFrequenciaSemanal(Frequencia vegetaisCrusFrequenciaSemanal) {
		this.vegetaisCrusFrequenciaSemanal = vegetaisCrusFrequenciaSemanal;
	}

	public Frequencia getViscerasFrequenciaSemanal() {
		return viscerasFrequenciaSemanal;
	}

	public void setViscerasFrequenciaSemanal(Frequencia viscerasFrequenciaSemanal) {
		this.viscerasFrequenciaSemanal = viscerasFrequenciaSemanal;
	}

	

	public String getAvesQuantidade() {
		return avesQuantidade;
	}

	public void setAvesQuantidade(String avesQuantidade) {
		this.avesQuantidade = avesQuantidade;
	}

	public String getPeixeQuantidade() {
		return peixeQuantidade;
	}

	public void setPeixeQuantidade(String peixeQuantidade) {
		this.peixeQuantidade = peixeQuantidade;
	}

	public String getViscerasQuantidade() {
		return viscerasQuantidade;
	}

	public void setViscerasQuantidade(String viscerasQuantidade) {
		this.viscerasQuantidade = viscerasQuantidade;
	}

	public String getLeiteDerivadosQuantidade() {
		return leiteDerivadosQuantidade;
	}

	public void setLeiteDerivadosQuantidade(String leiteDerivadosQuantidade) {
		this.leiteDerivadosQuantidade = leiteDerivadosQuantidade;
	}

	public String getOvosQuantidade() {
		return ovosQuantidade;
	}

	public void setOvosQuantidade(String ovosQuantidade) {
		this.ovosQuantidade = ovosQuantidade;
	}

	public String getLeguminosasQuantidade() {
		return leguminosasQuantidade;
	}

	public void setLeguminosasQuantidade(String leguminosasQuantidade) {
		this.leguminosasQuantidade = leguminosasQuantidade;
	}

	public String getCereaisQuantidade() {
		return cereaisQuantidade;
	}

	public void setCereaisQuantidade(String cereaisQuantidade) {
		this.cereaisQuantidade = cereaisQuantidade;
	}

	public String getMassasQuantidade() {
		return massasQuantidade;
	}

	public void setMassasQuantidade(String massasQuantidade) {
		this.massasQuantidade = massasQuantidade;
	}

	public String getVegetaisCrusQuantidade() {
		return vegetaisCrusQuantidade;
	}

	public void setVegetaisCrusQuantidade(String vegetaisCrusQuantidade) {
		this.vegetaisCrusQuantidade = vegetaisCrusQuantidade;
	}

	public String getVegetaisCozidosQuantidade() {
		return vegetaisCozidosQuantidade;
	}

	public void setVegetaisCozidosQuantidade(String vegetaisCozidosQuantidade) {
		this.vegetaisCozidosQuantidade = vegetaisCozidosQuantidade;
	}

	public String getFrutasQuantidade() {
		return frutasQuantidade;
	}

	public void setFrutasQuantidade(String frutasQuantidade) {
		this.frutasQuantidade = frutasQuantidade;
	}

	public String getDocesQuantidade() {
		return docesQuantidade;
	}

	public void setDocesQuantidade(String docesQuantidade) {
		this.docesQuantidade = docesQuantidade;
	}

	public String getOleoQuantidade() {
		return oleoQuantidade;
	}

	public void setOleoQuantidade(String oleoQuantidade) {
		this.oleoQuantidade = oleoQuantidade;
	}

	public String getMargarinaQuantidade() {
		return margarinaQuantidade;
	}

	public void setMargarinaQuantidade(String margarinaQuantidade) {
		this.margarinaQuantidade = margarinaQuantidade;
	}

	public String getManteigaQuantidade() {
		return manteigaQuantidade;
	}

	public void setManteigaQuantidade(String manteigaQuantidade) {
		this.manteigaQuantidade = manteigaQuantidade;
	}

	public String getToucinhoBaconQuantidade() {
		return toucinhoBaconQuantidade;
	}

	public void setToucinhoBaconQuantidade(String toucinhoBaconQuantidade) {
		this.toucinhoBaconQuantidade = toucinhoBaconQuantidade;
	}

	public String getAguaQuantidade() {
		return aguaQuantidade;
	}

	public void setAguaQuantidade(String aguaQuantidade) {
		this.aguaQuantidade = aguaQuantidade;
	}

	public String getSucoQuantidade() {
		return sucoQuantidade;
	}

	public void setSucoQuantidade(String sucoQuantidade) {
		this.sucoQuantidade = sucoQuantidade;
	}

	public String getBebidasAlcoolicasQuantidade() {
		return bebidasAlcoolicasQuantidade;
	}

	public void setBebidasAlcoolicasQuantidade(String bebidasAlcoolicasQuantidade) {
		this.bebidasAlcoolicasQuantidade = bebidasAlcoolicasQuantidade;
	}

	public String getGaseificadasQuantidade() {
		return gaseificadasQuantidade;
	}

	public void setGaseificadasQuantidade(String gaseificadasQuantidade) {
		this.gaseificadasQuantidade = gaseificadasQuantidade;
	}

	public String getInfusoesQuantidade() {
		return infusoesQuantidade;
	}

	public void setInfusoesQuantidade(String infusoesQuantidade) {
		this.infusoesQuantidade = infusoesQuantidade;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

}
