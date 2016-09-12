package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sinutri.model.enuns.FrequenciaSemanal;

@Entity
public class InqueritoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Campo Obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date criadoEm;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date atualizadoEm;

	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Servidor nutricionista;
	
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
	private boolean embutidosGosta;
	
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal bovinaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal avesFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal peixeFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal viscerasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal leiteDerivadosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal ovosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal leguminosasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal cereaisFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal massasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal vegetaisCrusFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal vegetaisCozidosFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal frutasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal docesFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal oleoFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal margarinaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal manteigaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal toucinhoBaconFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal aguaFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal sucoFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal bebidasAlcoolicasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal gaseificadasFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal infusoesFrequenciaSemanal;
	@Enumerated(EnumType.STRING)
	private FrequenciaSemanal embutidosFrequenciaSemanal;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String bovinaAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String avesAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String peixeAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String viscerasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String leiteDerivadosAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String ovosAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String leguminosasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String cereaisAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String massasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String vegetaisCrusAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String vegetaisCozidosAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String frutasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String docesAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String oleoAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String margarinaAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String manteigaAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String toucinhoBaconAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String aguaAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String sucoAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String bebidasAlcoolicasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String gaseificadasAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String infusoesAnotacao;

	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String embutidosAnotacao;
	
	@Size(max=256, message="(Máximo de caracteres excedido)")
	private String observacoes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servidor getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
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
	
	public boolean isEmbutidosGosta() {
		return embutidosGosta;
	}

	public void setEmbutidosGosta(boolean embutidosGosta) {
		this.embutidosGosta = embutidosGosta;
	}

	public FrequenciaSemanal getAguaFrequenciaSemanal() {
		return aguaFrequenciaSemanal;
	}

	public void setAguaFrequenciaSemanal(FrequenciaSemanal aguaFrequenciaSemanal) {
		this.aguaFrequenciaSemanal = aguaFrequenciaSemanal;
	}

	public FrequenciaSemanal getAvesFrequenciaSemanal() {
		return avesFrequenciaSemanal;
	}

	public void setAvesFrequenciaSemanal(FrequenciaSemanal avesFrequenciaSemanal) {
		this.avesFrequenciaSemanal = avesFrequenciaSemanal;
	}

	public FrequenciaSemanal getBebidasAlcoolicasFrequenciaSemanal() {
		return bebidasAlcoolicasFrequenciaSemanal;
	}

	public void setBebidasAlcoolicasFrequenciaSemanal(FrequenciaSemanal bebidasAlcoolicasFrequenciaSemanal) {
		this.bebidasAlcoolicasFrequenciaSemanal = bebidasAlcoolicasFrequenciaSemanal;
	}

	public FrequenciaSemanal getBovinaFrequenciaSemanal() {
		return bovinaFrequenciaSemanal;
	}

	public void setBovinaFrequenciaSemanal(FrequenciaSemanal bovinaFrequenciaSemanal) {
		this.bovinaFrequenciaSemanal = bovinaFrequenciaSemanal;
	}

	public FrequenciaSemanal getCereaisFrequenciaSemanal() {
		return cereaisFrequenciaSemanal;
	}

	public void setCereaisFrequenciaSemanal(FrequenciaSemanal cereaisFrequenciaSemanal) {
		this.cereaisFrequenciaSemanal = cereaisFrequenciaSemanal;
	}

	public FrequenciaSemanal getDocesFrequenciaSemanal() {
		return docesFrequenciaSemanal;
	}

	public void setDocesFrequenciaSemanal(FrequenciaSemanal docesFrequenciaSemanal) {
		this.docesFrequenciaSemanal = docesFrequenciaSemanal;
	}

	public FrequenciaSemanal getFrutasFrequenciaSemanal() {
		return frutasFrequenciaSemanal;
	}

	public void setFrutasFrequenciaSemanal(FrequenciaSemanal frutasFrequenciaSemanal) {
		this.frutasFrequenciaSemanal = frutasFrequenciaSemanal;
	}

	public FrequenciaSemanal getGaseificadasFrequenciaSemanal() {
		return gaseificadasFrequenciaSemanal;
	}

	public void setGaseificadasFrequenciaSemanal(FrequenciaSemanal gaseificadasFrequenciaSemanal) {
		this.gaseificadasFrequenciaSemanal = gaseificadasFrequenciaSemanal;
	}

	public FrequenciaSemanal getInfusoesFrequenciaSemanal() {
		return infusoesFrequenciaSemanal;
	}

	public void setInfusoesFrequenciaSemanal(FrequenciaSemanal infusoesFrequenciaSemanal) {
		this.infusoesFrequenciaSemanal = infusoesFrequenciaSemanal;
	}

	public FrequenciaSemanal getLeguminosasFrequenciaSemanal() {
		return leguminosasFrequenciaSemanal;
	}

	public void setLeguminosasFrequenciaSemanal(FrequenciaSemanal leguminosasFrequenciaSemanal) {
		this.leguminosasFrequenciaSemanal = leguminosasFrequenciaSemanal;
	}

	public FrequenciaSemanal getLeiteDerivadosFrequenciaSemanal() {
		return leiteDerivadosFrequenciaSemanal;
	}

	public void setLeiteDerivadosFrequenciaSemanal(FrequenciaSemanal leiteDerivadosFrequenciaSemanal) {
		this.leiteDerivadosFrequenciaSemanal = leiteDerivadosFrequenciaSemanal;
	}

	public FrequenciaSemanal getManteigaFrequenciaSemanal() {
		return manteigaFrequenciaSemanal;
	}

	public void setManteigaFrequenciaSemanal(FrequenciaSemanal manteigaFrequenciaSemanal) {
		this.manteigaFrequenciaSemanal = manteigaFrequenciaSemanal;
	}

	public FrequenciaSemanal getMargarinaFrequenciaSemanal() {
		return margarinaFrequenciaSemanal;
	}

	public void setMargarinaFrequenciaSemanal(FrequenciaSemanal margarinaFrequenciaSemanal) {
		this.margarinaFrequenciaSemanal = margarinaFrequenciaSemanal;
	}

	public FrequenciaSemanal getMassasFrequenciaSemanal() {
		return massasFrequenciaSemanal;
	}

	public void setMassasFrequenciaSemanal(FrequenciaSemanal massasFrequenciaSemanal) {
		this.massasFrequenciaSemanal = massasFrequenciaSemanal;
	}

	public FrequenciaSemanal getOleoFrequenciaSemanal() {
		return oleoFrequenciaSemanal;
	}

	public void setOleoFrequenciaSemanal(FrequenciaSemanal oleoFrequenciaSemanal) {
		this.oleoFrequenciaSemanal = oleoFrequenciaSemanal;
	}

	public FrequenciaSemanal getOvosFrequenciaSemanal() {
		return ovosFrequenciaSemanal;
	}

	public void setOvosFrequenciaSemanal(FrequenciaSemanal ovosFrequenciaSemanal) {
		this.ovosFrequenciaSemanal = ovosFrequenciaSemanal;
	}

	public FrequenciaSemanal getPeixeFrequenciaSemanal() {
		return peixeFrequenciaSemanal;
	}

	public void setPeixeFrequenciaSemanal(FrequenciaSemanal peixeFrequenciaSemanal) {
		this.peixeFrequenciaSemanal = peixeFrequenciaSemanal;
	}

	public FrequenciaSemanal getSucoFrequenciaSemanal() {
		return sucoFrequenciaSemanal;
	}

	public void setSucoFrequenciaSemanal(FrequenciaSemanal sucoFrequenciaSemanal) {
		this.sucoFrequenciaSemanal = sucoFrequenciaSemanal;
	}

	public FrequenciaSemanal getToucinhoBaconFrequenciaSemanal() {
		return toucinhoBaconFrequenciaSemanal;
	}

	public void setToucinhoBaconFrequenciaSemanal(FrequenciaSemanal toucinhoBaconFrequenciaSemanal) {
		this.toucinhoBaconFrequenciaSemanal = toucinhoBaconFrequenciaSemanal;
	}

	public FrequenciaSemanal getVegetaisCozidosFrequenciaSemanal() {
		return vegetaisCozidosFrequenciaSemanal;
	}

	public void setVegetaisCozidosFrequenciaSemanal(FrequenciaSemanal vegetaisCozidosFrequenciaSemanal) {
		this.vegetaisCozidosFrequenciaSemanal = vegetaisCozidosFrequenciaSemanal;
	}

	public FrequenciaSemanal getVegetaisCrusFrequenciaSemanal() {
		return vegetaisCrusFrequenciaSemanal;
	}

	public void setVegetaisCrusFrequenciaSemanal(FrequenciaSemanal vegetaisCrusFrequenciaSemanal) {
		this.vegetaisCrusFrequenciaSemanal = vegetaisCrusFrequenciaSemanal;
	}

	public FrequenciaSemanal getViscerasFrequenciaSemanal() {
		return viscerasFrequenciaSemanal;
	}

	public void setViscerasFrequenciaSemanal(FrequenciaSemanal viscerasFrequenciaSemanal) {
		this.viscerasFrequenciaSemanal = viscerasFrequenciaSemanal;
	}
	
	public FrequenciaSemanal getEmbutidosFrequenciaSemanal() {
		return embutidosFrequenciaSemanal;
	}

	public void setEmbutidosFrequenciaSemanal(
			FrequenciaSemanal embutidosFrequenciaSemanal) {
		this.embutidosFrequenciaSemanal = embutidosFrequenciaSemanal;
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

	public String getEmbutidosAnotacao() {
		return embutidosAnotacao;
	}

	public void setEmbutidosAnotacao(String embutidosAnotacao) {
		this.embutidosAnotacao = embutidosAnotacao;
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