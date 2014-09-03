package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ConsultaNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat
	private Date data;

	private Double peso;

	private Double altura;

	private Double circunferenciaCintura;

	private int glicemia;
	private String classificacaoGlicemia;

	private int tgl;
	private String classificacaoTgl;
	
	private int hdl;
	private String classificacaoHdl;
	
	private int idl;
	private String classificacaoIdl;
	
	private int ht;
	private String classificacaoHt;
	
	private int hb;
	private String classificacaoHb;
	
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

	private int bebidaAlcoolicaFrequenciaSemanal;

	private String bebidadaAlcoolicaComentario;

	private Boolean atividadeFisica;

	private int atividadeFisicaFrequenciaSemanal;

	private String atividadeFisicaComentario;

	private Boolean diabetes;

	private Boolean hipertensao;

	private Boolean outrasPatologias;

	private String outrasPatologiasComentario;

	private Boolean alergia;

	private String alergiaComentario;

	private String objetivoConsulta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public int getBebidaAlcoolicaFrequenciaSemanal() {
		return bebidaAlcoolicaFrequenciaSemanal;
	}

	public void setBebidaAlcoolicaFrequenciaSemanal(
			int bebidaAlcoolicaFrequenciaSemanal) {
		this.bebidaAlcoolicaFrequenciaSemanal = bebidaAlcoolicaFrequenciaSemanal;
	}

	public String getBebidadaAlcoolicaComentario() {
		return bebidadaAlcoolicaComentario;
	}

	public void setBebidadaAlcoolicaComentario(String bebidadaAlcoolicaComentario) {
		this.bebidadaAlcoolicaComentario = bebidadaAlcoolicaComentario;
	}

	public Boolean getAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(Boolean atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	public int getAtividadeFisicaFrequenciaSemanal() {
		return atividadeFisicaFrequenciaSemanal;
	}

	public void setAtividadeFisicaFrequenciaSemanal(
			int atividadeFisicaFrequenciaSemanal) {
		this.atividadeFisicaFrequenciaSemanal = atividadeFisicaFrequenciaSemanal;
	}

	public String getAtividadeFisicaComentario() {
		return atividadeFisicaComentario;
	}

	public void setAtividadeFisicaComentario(String atividadeFisicaComentario) {
		this.atividadeFisicaComentario = atividadeFisicaComentario;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(Boolean hipertensao) {
		this.hipertensao = hipertensao;
	}

	public Boolean getOutrasPatologias() {
		return outrasPatologias;
	}

	public void setOutrasPatologias(Boolean outrasPatologias) {
		this.outrasPatologias = outrasPatologias;
	}

	public String getOutrasPatologiasComentario() {
		return outrasPatologiasComentario;
	}

	public void setOutrasPatologiasComentario(String outrasPatologiasComentario) {
		this.outrasPatologiasComentario = outrasPatologiasComentario;
	}

	public Boolean getAlergia() {
		return alergia;
	}

	public void setAlergia(Boolean alergia) {
		this.alergia = alergia;
	}

	public String getAlergiaComentario() {
		return alergiaComentario;
	}

	public void setAlergiaComentario(String alergiaComentario) {
		this.alergiaComentario = alergiaComentario;
	}

	public String getObjetivoConsulta() {
		return objetivoConsulta;
	}

	public void setObjetivoConsulta(String objetivoConsulta) {
		this.objetivoConsulta = objetivoConsulta;
	}

	public String getClassificacaoGlicemia() {
		return classificacaoGlicemia;
	}

	public void setClassificacaoGlicemia(String classificacaoGlicemia) {
		this.classificacaoGlicemia = classificacaoGlicemia;
	}

	public String getClassificacaoTgl() {
		return classificacaoTgl;
	}

	public void setClassificacaoTgl(String classificacaoTgl) {
		this.classificacaoTgl = classificacaoTgl;
	}

	public String getClassificacaoHdl() {
		return classificacaoHdl;
	}

	public void setClassificacaoHdl(String classificacaoHdl) {
		this.classificacaoHdl = classificacaoHdl;
	}

	public String getClassificacaoIdl() {
		return classificacaoIdl;
	}

	public void setClassificacaoIdl(String classificacaoIdl) {
		this.classificacaoIdl = classificacaoIdl;
	}

	public String getClassificacaoHt() {
		return classificacaoHt;
	}

	public void setClassificacaoHt(String classificacaoHt) {
		this.classificacaoHt = classificacaoHt;
	}

	public String getClassificacaoHb() {
		return classificacaoHb;
	}

	public void setClassificacaoHb(String classificacaoHb) {
		this.classificacaoHb = classificacaoHb;
	}

	@Override
	public String toString() {
		return "ConsultaNutricional [id=" + id + ", data=" + data + ", peso="
				+ peso + ", altura=" + altura + ", circunferenciaCintura="
				+ circunferenciaCintura + ", glicemia=" + glicemia
				+ ", clasificacaoGlicemia=" + classificacaoGlicemia + ", tgl="
				+ tgl + ", clasificacaoTgl=" + classificacaoTgl + ", hdl=" + hdl
				+ ", clasificacaoHdl=" + classificacaoHdl + ", idl=" + idl
				+ ", clasificacaoIdl=" + classificacaoIdl + ", ht=" + ht
				+ ", clasificacaoHt=" + classificacaoHt + ", hb=" + hb
				+ ", clasificacaoHb=" + classificacaoHb
				+ ", condutaNutricional=" + condutaNutricional
				+ ", medicamento=" + medicamento + ", medicamentoComentario="
				+ medicamentoComentario + ", mastigacao=" + mastigacao
				+ ", mastigacaoComentario=" + mastigacaoComentario
				+ ", disfagia=" + disfagia + ", pirose=" + pirose + ", nausea="
				+ nausea + ", vomito=" + vomito + ", diarreia=" + diarreia
				+ ", constipacao=" + constipacao + ", agua=" + agua
				+ ", carneVermelhaFrequencia=" + carneVermelhaFrequencia
				+ ", bebidaAlcoolica=" + bebidaAlcoolica
				+ ", bebidaAlcoolicaFrequenciaSemanal="
				+ bebidaAlcoolicaFrequenciaSemanal
				+ ", bebidadaAlcoolicaComentario="
				+ bebidadaAlcoolicaComentario + ", atividadeFisica="
				+ atividadeFisica + ", atividadeFisicaFrequenciaSemanal="
				+ atividadeFisicaFrequenciaSemanal
				+ ", atividadeFisicaComentario=" + atividadeFisicaComentario
				+ ", diabetes=" + diabetes + ", hipertensao=" + hipertensao
				+ ", outrasPatologias=" + outrasPatologias
				+ ", outrasPatologiasComentario=" + outrasPatologiasComentario
				+ ", alergia=" + alergia + ", alergiaComentario="
				+ alergiaComentario + ", objetivoConsulta=" + objetivoConsulta
				+ "]";
	}
	
}
