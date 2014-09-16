package br.com.ufc.quixada.npi.sisat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.ufc.quixada.npi.sisat.enumerator.Classificacao;

@Entity
public class ConsultaNutricional {

<<<<<<< HEAD
<<<<<<< HEAD
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
=======
=======
>>>>>>> 529617fb93702199d51fe6a94f6f6b4e85592e64
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

<<<<<<< HEAD
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
=======
>>>>>>> 529617fb93702199d51fe6a94f6f6b4e85592e64
	@DateTimeFormat
	private Date data;

	private Double peso;

	private Double altura;

	private Double circunferenciaCintura;

	private Integer glicemia;
	private String classificacaoGlicemia;

	private Integer ct;
	private String classificacaoCt;
	
	private Integer hdl;
	private String classificacaoHdl;
	
	private Integer ldl;
	private String classificacaoLdl;
	
	private Integer tg;
	private String classificacaoTg;
	
	private Integer hb;
	private String classificacaoHb;
	
	private Integer tgo;
	private String classificacaoTgo;
	
	private Integer tgp;
	private String classificacaoTgp;
	
	private String condutaNutricional;

	private Boolean medicamento=false;

	private String medicamentoComentario;

	private Boolean mastigacao=false;

	private String mastigacaoComentario;

	private Boolean disfagia=false;

	private Boolean pirose=false;

	private Boolean nausea=false;

	private Boolean vomito=false;

	private Boolean diarreia=false;

	private Boolean constipacao=false;

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

	private Boolean outrasPatologias=false;

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

	public Integer getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(Integer glicemia) {
		this.glicemia = glicemia;
	}

	public String getClassificacaoGlicemia() {
		return classificacaoGlicemia;
	}

	public void setClassificacaoGlicemia(String classificacaoGlicemia) {
		this.classificacaoGlicemia = classificacaoGlicemia;
	}

	public Integer getCt() {
		return ct;
	}

	public void setCt(Integer ct) {
		this.ct = ct;
	}

	public String getClassificacaoCt() {
		return classificacaoCt;
	}

	public void setClassificacaoCt(String classificacaoCt) {
		this.classificacaoCt = classificacaoCt;
	}

	public Integer getHdl() {
		return hdl;
	}

	public void setHdl(Integer hdl) {
		this.hdl = hdl;
	}

	public String getClassificacaoHdl() {
		return classificacaoHdl;
	}

	public void setClassificacaoHdl(String classificacaoHdl) {
		this.classificacaoHdl = classificacaoHdl;
	}

	public Integer getLdl() {
		return ldl;
	}

	public void setLdl(Integer ldl) {
		this.ldl = ldl;
	}

	public String getClassificacaoLdl() {
		return classificacaoLdl;
	}

	public void setClassificacaoLdl(String classificacaoLdl) {
		this.classificacaoLdl = classificacaoLdl;
	}

	public Integer getTg() {
		return tg;
	}

	public void setTg(Integer tg) {
		this.tg = tg;
	}

	public String getClassificacaoTg() {
		return classificacaoTg;
	}

	public void setClassificacaoTg(String classificacaoTg) {
		this.classificacaoTg = classificacaoTg;
	}

	public Integer getHb() {
		return hb;
	}

	public void setHb(Integer hb) {
		this.hb = hb;
	}

	public String getClassificacaoHb() {
		return classificacaoHb;
	}

	public void setClassificacaoHb(String classificacaoHb) {
		this.classificacaoHb = classificacaoHb;
	}

	public Integer getTgo() {
		return tgo;
	}

	public void setTgo(Integer tgo) {
		this.tgo = tgo;
	}

	public String getClassificacaoTgo() {
		return classificacaoTgo;
	}

	public void setClassificacaoTgo(String classificacaoTgo) {
		this.classificacaoTgo = classificacaoTgo;
	}

	public Integer getTgp() {
		return tgp;
	}

	public void setTgp(Integer tgp) {
		this.tgp = tgp;
	}

	public String getClassificacaoTgp() {
		return classificacaoTgp;
	}

	public void setClassificacaoTgp(String classificacaoTgp) {
		this.classificacaoTgp = classificacaoTgp;
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

<<<<<<< HEAD
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

<<<<<<< HEAD
	

=======
=======
>>>>>>> 529617fb93702199d51fe6a94f6f6b4e85592e64
	@Override
	public String toString() {
		return "ConsultaNutricional [id=" + id + ", data=" + data + ", peso="
				+ peso + ", altura=" + altura + ", circunferenciaCintura="
				+ circunferenciaCintura + ", glicemia=" + glicemia
				+ ", classificacaoGlicemia=" + classificacaoGlicemia + ", ct="
				+ ct + ", classificacaoCt=" + classificacaoCt + ", hdl="
				+ hdl + ", classificacaoHdl=" + classificacaoHdl + ", ldl="
				+ ldl + ", classificacaoLdl=" + classificacaoLdl + ", tg=" + tg
				+ ", classificacaoTg=" + classificacaoTg + ", hb=" + hb
				+ ", classificacaoHb=" + classificacaoHb + ", tgo=" + tgo
				+ ", classificacaoTgo=" + classificacaoTgo + ", tgp=" + tgp
				+ ", classificacaoTgp=" + classificacaoTgp
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
	
<<<<<<< HEAD
>>>>>>> 1c0b2553b96857632ac90cd1c1280abf0ac3173c
}
=======
	

}
>>>>>>> 529617fb93702199d51fe6a94f6f6b4e85592e64
