package br.com.ufc.quixada.npi.sisat.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

public class ConsultaNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat
	private Data data;

	private Double peso;

	private Double altura;

	private Double circunferenciaCintura;

	private int glicemia;

	private int tgl;

	private int hdl;

	private int idl;

	private int ht;

	private int hb;

	private String condutaNutricional;
	
	
	private Boolean medicamento;
	
	private String medicamentoComentario;
	
	
	private Boolean mastigacao;
	
	private String mastigacaoComentario;
	
	
	private Boolean disfagia;
	
	private Boolean pirose;
	
	private Boolean nausea;
	
	
	private Boolean vomito;
	
	private Boolean diarreia;
	
	private Boolean constipacao;
	
	
	private String agua;
	
	private String carneVermelhaFrequencia;
	
	
	private Boolean bebidaAlcoolica;
	
	private int bebidaAlcoolicaFrequencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getCircunferenciaCintura() {
		return circunferenciaCintura;
	}

	public void setCircunferenciaCintura(Double circunferenciaCintura) {
		this.circunferenciaCintura = circunferenciaCintura;
	}

	public int getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(int glicemia) {
		this.glicemia = glicemia;
	}

	public int getTgl() {
		return tgl;
	}

	public void setTgl(int tgl) {
		this.tgl = tgl;
	}

	public int getHdl() {
		return hdl;
	}

	public void setHdl(int hdl) {
		this.hdl = hdl;
	}

	public int getIdl() {
		return idl;
	}

	public void setIdl(int idl) {
		this.idl = idl;
	}

	public int getHt() {
		return ht;
	}

	public void setHt(int ht) {
		this.ht = ht;
	}

	public int getHb() {
		return hb;
	}

	public void setHb(int hb) {
		this.hb = hb;
	}

	public String getCondutaNutricional() {
		return condutaNutricional;
	}

	public void setCondutaNutricional(String condutaNutricional) {
		this.condutaNutricional = condutaNutricional;
	}

	public Boolean getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Boolean medicamento) {
		this.medicamento = medicamento;
	}

	public String getMedicamentoComentario() {
		return medicamentoComentario;
	}

	public void setMedicamentoComentario(String medicamentoComentario) {
		this.medicamentoComentario = medicamentoComentario;
	}

	public Boolean getMastigacao() {
		return mastigacao;
	}

	public void setMastigacao(Boolean mastigacao) {
		this.mastigacao = mastigacao;
	}

	public String getMastigacaoComentario() {
		return mastigacaoComentario;
	}

	public void setMastigacaoComentario(String mastigacaoComentario) {
		this.mastigacaoComentario = mastigacaoComentario;
	}

	public Boolean getDisfagia() {
		return disfagia;
	}

	public void setDisfagia(Boolean disfagia) {
		this.disfagia = disfagia;
	}

	public Boolean getPirose() {
		return pirose;
	}

	public void setPirose(Boolean pirose) {
		this.pirose = pirose;
	}

	public Boolean getNausea() {
		return nausea;
	}

	public void setNausea(Boolean nausea) {
		this.nausea = nausea;
	}

	public Boolean getVomito() {
		return vomito;
	}

	public void setVomito(Boolean vomito) {
		this.vomito = vomito;
	}

	public Boolean getDiarreia() {
		return diarreia;
	}

	public void setDiarreia(Boolean diarreia) {
		this.diarreia = diarreia;
	}

	public Boolean getConstipacao() {
		return constipacao;
	}

	public void setConstipacao(Boolean constipacao) {
		this.constipacao = constipacao;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public String getCarneVermelhaFrequencia() {
		return carneVermelhaFrequencia;
	}

	public void setCarneVermelhaFrequencia(String carneVermelhaFrequencia) {
		this.carneVermelhaFrequencia = carneVermelhaFrequencia;
	}

	public Boolean getBebidaAlcoolica() {
		return bebidaAlcoolica;
	}

	public void setBebidaAlcoolica(Boolean bebidaAlcoolica) {
		this.bebidaAlcoolica = bebidaAlcoolica;
	}

	public int getBebidaAlcoolicaFrequencia() {
		return bebidaAlcoolicaFrequencia;
	}

	public void setBebidaAlcoolicaFrequencia(int bebidaAlcoolicaFrequencia) {
		this.bebidaAlcoolicaFrequencia = bebidaAlcoolicaFrequencia;
	}
	

}
