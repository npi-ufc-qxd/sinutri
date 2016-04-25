package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;

@Entity
public class InqueritoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean bovinaGosta;
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
	private Frequencia bovinaFrequenciaSemanal;
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
	
	private String bovinaAnotacao;
	private String avesAnotacao;
	private String peixeAnotacao;
	private String viscerasAnotacao;
	private String leiteDerivadosAnotacao;
	private String ovosAnotacao;
	private String leguminosasAnotacao;
	private String cereaisAnotacao;
	private String massasAnotacao;
	private String vegetaisCrusAnotacao;
	private String vegetaisCozidosAnotacao;
	private String frutasAnotacao;
	private String docesAnotacao;
	private String oleoAnotacao;
	private String margarinaAnotacao;
	private String manteigaAnotacao;
	private String toucinhoBaconAnotacao;
	private String aguaAnotacao;
	private String sucoAnotacao;
	private String bebidasAlcoolicasAnotacao;
	private String gaseificadasAnotacao;
	private String infusoesAnotacao;
	private String observacoes;
	
	@DateTimeFormat
	private Date criadoEm;
	@DateTimeFormat
	private Date atualizadoEm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBovinaGosta() {
		return bovinaGosta;
	}

	public void setBovinaGosta(boolean bovinaGosta) {
		this.bovinaGosta = bovinaGosta;
	}

	public String getBovinaAnotacao() {
		return bovinaAnotacao;
	}

	public void setBovinaAnotacao(String bovinaQuantidade) {
		this.bovinaAnotacao = bovinaQuantidade;
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


	public String getAvesAnotacao() {
		return avesAnotacao;
	}

	public void setAvesAnotacao(String avesAnotacao) {
		this.avesAnotacao = avesAnotacao;
	}

	public String getPeixeAnotacao() {
		return peixeAnotacao;
	}

	public void setPeixeAnotacao(String peixeAnotacao) {
		this.peixeAnotacao = peixeAnotacao;
	}

	public String getViscerasAnotacao() {
		return viscerasAnotacao;
	}

	public void setViscerasAnotacao(String viscerasAnotacao) {
		this.viscerasAnotacao = viscerasAnotacao;
	}

	public String getLeiteDerivadosAnotacao() {
		return leiteDerivadosAnotacao;
	}

	public void setLeiteDerivadosAnotacao(String leiteDerivadosAnotacao) {
		this.leiteDerivadosAnotacao = leiteDerivadosAnotacao;
	}

	public String getOvosAnotacao() {
		return ovosAnotacao;
	}

	public void setOvosAnotacao(String ovosAnotacao) {
		this.ovosAnotacao = ovosAnotacao;
	}

	public String getLeguminosasAnotacao() {
		return leguminosasAnotacao;
	}

	public void setLeguminosasAnotacao(String leguminosasAnotacao) {
		this.leguminosasAnotacao = leguminosasAnotacao;
	}

	public String getCereaisAnotacao() {
		return cereaisAnotacao;
	}

	public void setCereaisAnotacao(String cereaisAnotacao) {
		this.cereaisAnotacao = cereaisAnotacao;
	}

	public String getMassasAnotacao() {
		return massasAnotacao;
	}

	public void setMassasAnotacao(String massasAnotacao) {
		this.massasAnotacao = massasAnotacao;
	}

	public String getVegetaisCrusAnotacao() {
		return vegetaisCrusAnotacao;
	}

	public void setVegetaisCrusAnotacao(String vegetaisCrusAnotacao) {
		this.vegetaisCrusAnotacao = vegetaisCrusAnotacao;
	}

	public String getVegetaisCozidosAnotacao() {
		return vegetaisCozidosAnotacao;
	}

	public void setVegetaisCozidosAnotacao(String vegetaisCozidosAnotacao) {
		this.vegetaisCozidosAnotacao = vegetaisCozidosAnotacao;
	}

	public String getFrutasAnotacao() {
		return frutasAnotacao;
	}

	public void setFrutasAnotacao(String frutasAnotacao) {
		this.frutasAnotacao = frutasAnotacao;
	}

	public String getDocesAnotacao() {
		return docesAnotacao;
	}

	public void setDocesAnotacao(String docesAnotacao) {
		this.docesAnotacao = docesAnotacao;
	}

	public String getOleoAnotacao() {
		return oleoAnotacao;
	}

	public void setOleoAnotacao(String oleoAnotacao) {
		this.oleoAnotacao = oleoAnotacao;
	}

	public String getMargarinaAnotacao() {
		return margarinaAnotacao;
	}

	public void setMargarinaAnotacao(String margarinaAnotacao) {
		this.margarinaAnotacao = margarinaAnotacao;
	}

	public String getManteigaAnotacao() {
		return manteigaAnotacao;
	}

	public void setManteigaAnotacao(String manteigaAnotacao) {
		this.manteigaAnotacao = manteigaAnotacao;
	}

	public String getToucinhoBaconAnotacao() {
		return toucinhoBaconAnotacao;
	}

	public void setToucinhoBaconAnotacao(String toucinhoBaconAnotacao) {
		this.toucinhoBaconAnotacao = toucinhoBaconAnotacao;
	}

	public String getAguaAnotacao() {
		return aguaAnotacao;
	}

	public void setAguaAnotacao(String aguaAnotacao) {
		this.aguaAnotacao = aguaAnotacao;
	}

	public String getSucoAnotacao() {
		return sucoAnotacao;
	}

	public void setSucoAnotacao(String sucoAnotacao) {
		this.sucoAnotacao = sucoAnotacao;
	}

	public String getBebidasAlcoolicasAnotacao() {
		return bebidasAlcoolicasAnotacao;
	}

	public void setBebidasAlcoolicasAnotacao(String bebidasAlcoolicasAnotacao) {
		this.bebidasAlcoolicasAnotacao = bebidasAlcoolicasAnotacao;
	}

	public String getGaseificadasAnotacao() {
		return gaseificadasAnotacao;
	}

	public void setGaseificadasAnotacao(String gaseificadasAnotacao) {
		this.gaseificadasAnotacao = gaseificadasAnotacao;
	}

	public String getInfusoesAnotacao() {
		return infusoesAnotacao;
	}

	public void setInfusoesAnotacao(String infusoesAnotacao) {
		this.infusoesAnotacao = infusoesAnotacao;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getObservacoes() {
		return observacoes;
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

}
