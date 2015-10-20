package br.ufc.quixada.npi.sisat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class InqueritoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "inqueritoAlimentar")
	@JoinColumn(name = "consultaNutricional_id")
	@JsonIgnore
	private ConsultaNutricional consultaNutricional;
	
	private boolean bovinaGosta;
	private int bovinaFrequenciaSemanal;
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
	
	private int avesFrequenciaSemanal;
	private int peixeFrequenciaSemanal;
	private int viscerasFrequenciaSemanal;
	private int leiteDerivadosFrequenciaSemanal;
	private int ovosFrequenciaSemanal;
	private int leguminosasFrequenciaSemanal;
	private int cereaisFrequenciaSemanal;
	private int massasFrequenciaSemanal;
	private int vegetaisCrusFrequenciaSemanal;
	private int vegetaisCozidosFrequenciaSemanal;
	private int frutasFrequenciaSemanal;
	private int docesFrequenciaSemanal;
	private int oleoFrequenciaSemanal;
	private int margarinaFrequenciaSemanal;
	private int manteigaFrequenciaSemanal;
	private int toucinhoBaconFrequenciaSemanal;
	private int aguaFrequenciaSemanal;
	private int sucoFrequenciaSemanal;
	private int bebidasAlcoolicasFrequenciaSemanal;
	private int gaseificadasFrequenciaSemanal;
	private int infusoesFrequenciaSemanal;
	
	private double avesQuantidade;
	private double peixeQuantidade;
	private double viscerasQuantidade;
	private double leiteDerivadosQuantidade;
	private double ovosQuantidade;
	private double leguminosasQuantidade;
	private double cereaisQuantidade;
	private double massasQuantidade;
	private double vegetaisCrusQuantidade;
	private double vegetaisCozidosQuantidade;
	private double frutasQuantidade;
	private double docesQuantidade;
	private double oleoQuantidade;
	private double margarinaQuantidade;
	private double manteigaQuantidade;
	private double toucinhoBaconQuantidade;
	private double aguaQuantidade;
	private double sucoQuantidade;
	private double bebidasAlcoolicasQuantidade;
	private double gaseificadasQuantidade;
	private double infusoesQuantidade;
	
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
	public int getBovinaFrequenciaSemanal() {
		return bovinaFrequenciaSemanal;
	}
	public void setBovinaFrequenciaSemanal(int bovinaFrequenciaSemanal) {
		this.bovinaFrequenciaSemanal = bovinaFrequenciaSemanal;
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
	public int getAvesFrequenciaSemanal() {
		return avesFrequenciaSemanal;
	}
	public void setAvesFrequenciaSemanal(int avesFrequenciaSemanal) {
		this.avesFrequenciaSemanal = avesFrequenciaSemanal;
	}
	public int getPeixeFrequenciaSemanal() {
		return peixeFrequenciaSemanal;
	}
	public void setPeixeFrequenciaSemanal(int peixeFrequenciaSemanal) {
		this.peixeFrequenciaSemanal = peixeFrequenciaSemanal;
	}
	public int getViscerasFrequenciaSemanal() {
		return viscerasFrequenciaSemanal;
	}
	public void setViscerasFrequenciaSemanal(int viscerasFrequenciaSemanal) {
		this.viscerasFrequenciaSemanal = viscerasFrequenciaSemanal;
	}
	public int getLeiteDerivadosFrequenciaSemanal() {
		return leiteDerivadosFrequenciaSemanal;
	}
	public void setLeiteDerivadosFrequenciaSemanal(int leiteDerivadosFrequenciaSemanal) {
		this.leiteDerivadosFrequenciaSemanal = leiteDerivadosFrequenciaSemanal;
	}
	public int getOvosFrequenciaSemanal() {
		return ovosFrequenciaSemanal;
	}
	public void setOvosFrequenciaSemanal(int ovosFrequenciaSemanal) {
		this.ovosFrequenciaSemanal = ovosFrequenciaSemanal;
	}
	public int getLeguminosasFrequenciaSemanal() {
		return leguminosasFrequenciaSemanal;
	}
	public void setLeguminosasFrequenciaSemanal(int leguminosasFrequenciaSemanal) {
		this.leguminosasFrequenciaSemanal = leguminosasFrequenciaSemanal;
	}
	public int getCereaisFrequenciaSemanal() {
		return cereaisFrequenciaSemanal;
	}
	public void setCereaisFrequenciaSemanal(int cereaisFrequenciaSemanal) {
		this.cereaisFrequenciaSemanal = cereaisFrequenciaSemanal;
	}
	public int getMassasFrequenciaSemanal() {
		return massasFrequenciaSemanal;
	}
	public void setMassasFrequenciaSemanal(int massasFrequenciaSemanal) {
		this.massasFrequenciaSemanal = massasFrequenciaSemanal;
	}
	public int getVegetaisCrusFrequenciaSemanal() {
		return vegetaisCrusFrequenciaSemanal;
	}
	public void setVegetaisCrusFrequenciaSemanal(int vegetaisCrusFrequenciaSemanal) {
		this.vegetaisCrusFrequenciaSemanal = vegetaisCrusFrequenciaSemanal;
	}
	public int getVegetaisCozidosFrequenciaSemanal() {
		return vegetaisCozidosFrequenciaSemanal;
	}
	public void setVegetaisCozidosFrequenciaSemanal(int vegetaisCozidosFrequenciaSemanal) {
		this.vegetaisCozidosFrequenciaSemanal = vegetaisCozidosFrequenciaSemanal;
	}
	public int getFrutasFrequenciaSemanal() {
		return frutasFrequenciaSemanal;
	}
	public void setFrutasFrequenciaSemanal(int frutasFrequenciaSemanal) {
		this.frutasFrequenciaSemanal = frutasFrequenciaSemanal;
	}
	public int getDocesFrequenciaSemanal() {
		return docesFrequenciaSemanal;
	}
	public void setDocesFrequenciaSemanal(int docesFrequenciaSemanal) {
		this.docesFrequenciaSemanal = docesFrequenciaSemanal;
	}
	public int getOleoFrequenciaSemanal() {
		return oleoFrequenciaSemanal;
	}
	public void setOleoFrequenciaSemanal(int oleoFrequenciaSemanal) {
		this.oleoFrequenciaSemanal = oleoFrequenciaSemanal;
	}
	public int getMargarinaFrequenciaSemanal() {
		return margarinaFrequenciaSemanal;
	}
	public void setMargarinaFrequenciaSemanal(int margarinaFrequenciaSemanal) {
		this.margarinaFrequenciaSemanal = margarinaFrequenciaSemanal;
	}
	public int getManteigaFrequenciaSemanal() {
		return manteigaFrequenciaSemanal;
	}
	public void setManteigaFrequenciaSemanal(int manteigaFrequenciaSemanal) {
		this.manteigaFrequenciaSemanal = manteigaFrequenciaSemanal;
	}
	public int getToucinhoBaconFrequenciaSemanal() {
		return toucinhoBaconFrequenciaSemanal;
	}
	public void setToucinhoBaconFrequenciaSemanal(int toucinhoBaconFrequenciaSemanal) {
		this.toucinhoBaconFrequenciaSemanal = toucinhoBaconFrequenciaSemanal;
	}
	public int getAguaFrequenciaSemanal() {
		return aguaFrequenciaSemanal;
	}
	public void setAguaFrequenciaSemanal(int aguaFrequenciaSemanal) {
		this.aguaFrequenciaSemanal = aguaFrequenciaSemanal;
	}
	public int getSucoFrequenciaSemanal() {
		return sucoFrequenciaSemanal;
	}
	public void setSucoFrequenciaSemanal(int sucoFrequenciaSemanal) {
		this.sucoFrequenciaSemanal = sucoFrequenciaSemanal;
	}
	public int getBebidasAlcoolicasFrequenciaSemanal() {
		return bebidasAlcoolicasFrequenciaSemanal;
	}
	public void setBebidasAlcoolicasFrequenciaSemanal(int bebidasAlcoolicasFrequenciaSemanal) {
		this.bebidasAlcoolicasFrequenciaSemanal = bebidasAlcoolicasFrequenciaSemanal;
	}
	public int getGaseificadasFrequenciaSemanal() {
		return gaseificadasFrequenciaSemanal;
	}
	public void setGaseificadasFrequenciaSemanal(int gaseificadasFrequenciaSemanal) {
		this.gaseificadasFrequenciaSemanal = gaseificadasFrequenciaSemanal;
	}
	public int getInfusoesFrequenciaSemanal() {
		return infusoesFrequenciaSemanal;
	}
	public void setInfusoesFrequenciaSemanal(int infusoesFrequenciaSemanal) {
		this.infusoesFrequenciaSemanal = infusoesFrequenciaSemanal;
	}
	public double getAvesQuantidade() {
		return avesQuantidade;
	}
	public void setAvesQuantidade(double avesQuantidade) {
		this.avesQuantidade = avesQuantidade;
	}
	public double getPeixeQuantidade() {
		return peixeQuantidade;
	}
	public void setPeixeQuantidade(double peixeQuantidade) {
		this.peixeQuantidade = peixeQuantidade;
	}
	public double getViscerasQuantidade() {
		return viscerasQuantidade;
	}
	public void setViscerasQuantidade(double viscerasQuantidade) {
		this.viscerasQuantidade = viscerasQuantidade;
	}
	public double getLeiteDerivadosQuantidade() {
		return leiteDerivadosQuantidade;
	}
	public void setLeiteDerivadosQuantidade(double leiteDerivadosQuantidade) {
		this.leiteDerivadosQuantidade = leiteDerivadosQuantidade;
	}
	public double getOvosQuantidade() {
		return ovosQuantidade;
	}
	public void setOvosQuantidade(double ovosQuantidade) {
		this.ovosQuantidade = ovosQuantidade;
	}
	public double getLeguminosasQuantidade() {
		return leguminosasQuantidade;
	}
	public void setLeguminosasQuantidade(double leguminosasQuantidade) {
		this.leguminosasQuantidade = leguminosasQuantidade;
	}
	public double getCereaisQuantidade() {
		return cereaisQuantidade;
	}
	public void setCereaisQuantidade(double cereaisQuantidade) {
		this.cereaisQuantidade = cereaisQuantidade;
	}
	public double getMassasQuantidade() {
		return massasQuantidade;
	}
	public void setMassasQuantidade(double massasQuantidade) {
		this.massasQuantidade = massasQuantidade;
	}
	public double getVegetaisCrusQuantidade() {
		return vegetaisCrusQuantidade;
	}
	public void setVegetaisCrusQuantidade(double vegetaisCrusQuantidade) {
		this.vegetaisCrusQuantidade = vegetaisCrusQuantidade;
	}
	public double getVegetaisCozidosQuantidade() {
		return vegetaisCozidosQuantidade;
	}
	public void setVegetaisCozidosQuantidade(double vegetaisCozidosQuantidade) {
		this.vegetaisCozidosQuantidade = vegetaisCozidosQuantidade;
	}
	public double getFrutasQuantidade() {
		return frutasQuantidade;
	}
	public void setFrutasQuantidade(double frutasQuantidade) {
		this.frutasQuantidade = frutasQuantidade;
	}
	public double getDocesQuantidade() {
		return docesQuantidade;
	}
	public void setDocesQuantidade(double docesQuantidade) {
		this.docesQuantidade = docesQuantidade;
	}
	public double getOleoQuantidade() {
		return oleoQuantidade;
	}
	public void setOleoQuantidade(double oleoQuantidade) {
		this.oleoQuantidade = oleoQuantidade;
	}
	public double getMargarinaQuantidade() {
		return margarinaQuantidade;
	}
	public void setMargarinaQuantidade(double margarinaQuantidade) {
		this.margarinaQuantidade = margarinaQuantidade;
	}
	public double getManteigaQuantidade() {
		return manteigaQuantidade;
	}
	public void setManteigaQuantidade(double manteigaQuantidade) {
		this.manteigaQuantidade = manteigaQuantidade;
	}
	public double getToucinhoBaconQuantidade() {
		return toucinhoBaconQuantidade;
	}
	public void setToucinhoBaconQuantidade(double toucinhoBaconQuantidade) {
		this.toucinhoBaconQuantidade = toucinhoBaconQuantidade;
	}
	public double getAguaQuantidade() {
		return aguaQuantidade;
	}
	public void setAguaQuantidade(double aguaQuantidade) {
		this.aguaQuantidade = aguaQuantidade;
	}
	public double getSucoQuantidade() {
		return sucoQuantidade;
	}
	public void setSucoQuantidade(double sucoQuantidade) {
		this.sucoQuantidade = sucoQuantidade;
	}
	public double getBebidasAlcoolicasQuantidade() {
		return bebidasAlcoolicasQuantidade;
	}
	public void setBebidasAlcoolicasQuantidade(double bebidasAlcoolicasQuantidade) {
		this.bebidasAlcoolicasQuantidade = bebidasAlcoolicasQuantidade;
	}
	public double getGaseificadasQuantidade() {
		return gaseificadasQuantidade;
	}
	public void setGaseificadasQuantidade(double gaseificadasQuantidade) {
		this.gaseificadasQuantidade = gaseificadasQuantidade;
	}
	public double getInfusoesQuantidade() {
		return infusoesQuantidade;
	}
	public void setInfusoesQuantidade(double infusoesQuantidade) {
		this.infusoesQuantidade = infusoesQuantidade;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
}
