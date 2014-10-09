package br.ufc.quixada.npi.sisat.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sisat.enumeration.Classificacao;

@Entity
public class ConsultaNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "consultaNutricional", cascade = CascadeType.ALL)
	private List<FrequenciaAlimentar> frequencias;	
	
	private Double peso;

	private Double circunferenciaCintura;

	private Integer glicemia;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoGlicemia;

	private Integer ct;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoCt;
	
	private Integer hdl;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoHdl;
	
	private Integer ldl;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoLdl;
	
	private Integer tg;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoTg;
	
	private Integer hb;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoHb;
	
	private Integer tgo;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoTgo;
	
	private Integer tgp;
	@Enumerated(EnumType.STRING)
	private Classificacao classificacaoTgp;
	
	private String condutaNutricional;
	
	private boolean medicamento;
	
	private String medicamentoComentario;

	private boolean mastigacao;
	
	private String mastigacaoComentario;

	private boolean disfagia;

	private boolean pirose;

	private boolean nausea;

	private boolean vomito;

	private boolean diarreia;

	private boolean constipacao;

	private String agua;

	private boolean carneVermelha;
	
	private int carneVermelhaFrequenciaSemanal;
	
	private String carneVermelhaComentario;

	private boolean bebidaAlcoolica;
	
	private int bebidaAlcoolicaFrequenciaSemanal;
	
	private String bebidaAlcoolicaComentario;

	private boolean atividadeFisica;
	
	private int atividadeFisicaFrequenciaSemanal;
	
	private String atividadeFisicaComentario;

	private Boolean diabetes;

	private Boolean hipertensao;

	private boolean outrasPatologias;

	private String outrasPatologiasComentario;

	private boolean alergia;
	private String alergiaComentario;

	private String objetivoConsulta;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public List<FrequenciaAlimentar> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<FrequenciaAlimentar> frequencias) {
		this.frequencias = frequencias;
	}
	


	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
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

	public Classificacao getClassificacaoGlicemia() {
		return classificacaoGlicemia;
	}

	public void setClassificacaoGlicemia(Classificacao classificacaoGlicemia) {
		this.classificacaoGlicemia = classificacaoGlicemia;
	}

	public Integer getCt() {
		return ct;
	}

	public void setCt(Integer ct) {
		this.ct = ct;
	}

	public Classificacao getClassificacaoCt() {
		return classificacaoCt;
	}

	public void setClassificacaoCt(Classificacao classificacaoCt) {

		this.classificacaoCt = classificacaoCt;
	}

	public Integer getHdl() {
		return hdl;
	}

	public void setHdl(Integer hdl) {
		this.hdl = hdl;
	}

	public Classificacao getClassificacaoHdl() {
		return classificacaoHdl;
	}

	public void setClassificacaoHdl(Classificacao classificacaoHdl) {
		this.classificacaoHdl = classificacaoHdl;
	}

	public Integer getLdl() {
		return ldl;
		
	}

	public void setLdl(Integer ldl) {
		this.ldl = ldl;
	}

	public Classificacao getClassificacaoLdl() {
		return classificacaoLdl;
	}

	public void setClassificacaoLdl(Classificacao classificacaoLdl) {
		this.classificacaoLdl = classificacaoLdl;
	}
	
	public Integer getTg() {
		return tg;
	}

	public void setTg(Integer tg) {
		this.tg = tg;
	}

	public Classificacao getClassificacaoTg() {
		return classificacaoTg;
	}

	public void setClassificacaoTg(Classificacao classificacaoTg) {
		this.classificacaoTg = classificacaoTg;
	}

	public Integer getHb() {
		return hb;
	}

	public void setHb(Integer hb) {
		this.hb = hb;
	}

	public Classificacao getClassificacaoHb() {
		return classificacaoHb;
	}

	public void setClassificacaoHb(Classificacao classificacaoHb) {
		this.classificacaoHb = classificacaoHb;
	}

	public Integer getTgo() {
		return tgo;
	}

	public void setTgo(Integer tgo) {
		this.tgo = tgo;
	}

	public Classificacao getClassificacaoTgo() {
		return classificacaoTgo;
	}

	public void setClassificacaoTgo(Classificacao classificacaoTgo) {
		this.classificacaoTgo = classificacaoTgo;
	}

	public Integer getTgp() {
		return tgp;
	}

	public void setTgp(Integer tgp) {
		this.tgp = tgp;
	}

	public Classificacao getClassificacaoTgp() {
		return classificacaoTgp;
	}

	public void setClassificacaoTgp(Classificacao classificacaoTgp) {
		this.classificacaoTgp = classificacaoTgp;
	}

	public String getCondutaNutricional() {
		return condutaNutricional;
	}

	public void setCondutaNutricional(String condutaNutricional) {
		this.condutaNutricional = condutaNutricional;
	}

	public boolean isMedicamento() {
		return medicamento;
	}

	public void setMedicamento(boolean medicamento) {
		this.medicamento = medicamento;
	}

	public String getMedicamentoComentario() {
		return medicamentoComentario;
	}

	public void setMedicamentoComentario(String medicamentoComentario) {
		this.medicamentoComentario = medicamentoComentario;
	}

	public boolean isMastigacao() {
		return mastigacao;
	}

	public void setMastigacao(boolean mastigacao) {
		this.mastigacao = mastigacao;
	}

	public String getMastigacaoComentario() {
		return mastigacaoComentario;
	}

	public void setMastigacaoComentario(String mastigacaoComentario) {
		this.mastigacaoComentario = mastigacaoComentario;
	}

	public boolean isDisfagia() {
		return disfagia;
	}

	public void setDisfagia(boolean disfagia) {
		this.disfagia = disfagia;
	}

	public boolean isPirose() {
		return pirose;
	}

	public void setPirose(boolean pirose) {
		this.pirose = pirose;
	}

	public boolean isNausea() {
		return nausea;
	}

	public void setNausea(boolean nausea) {
		this.nausea = nausea;
	}

	public boolean isVomito() {
		return vomito;
	}

	public void setVomito(boolean vomito) {
		this.vomito = vomito;
	}

	public boolean isDiarreia() {
		return diarreia;
	}

	public void setDiarreia(boolean diarreia) {
		this.diarreia = diarreia;
	}

	public boolean isConstipacao() {
		return constipacao;
	}

	public void setConstipacao(boolean constipacao) {
		this.constipacao = constipacao;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public boolean isCarneVermelha() {
		return carneVermelha;
	}

	public void setCarneVermelha(boolean carneVermelha) {
		this.carneVermelha = carneVermelha;
	}

	public int getCarneVermelhaFrequenciaSemanal() {
		return carneVermelhaFrequenciaSemanal;
	}

	public void setCarneVermelhaFrequenciaSemanal(int carneVermelhaFrequenciaSemanal) {
		this.carneVermelhaFrequenciaSemanal = carneVermelhaFrequenciaSemanal;
	}

	public String getCarneVermelhaComentario() {
		return carneVermelhaComentario;
	}

	public void setCarneVermelhaComentario(String carneVermelhaComentario) {
		this.carneVermelhaComentario = carneVermelhaComentario;
	}
	
	public boolean getBebidaAlcoolica() {
		return bebidaAlcoolica;
	}

	public void setBebidaAlcoolica(boolean bebidaAlcoolica) {
		this.bebidaAlcoolica = bebidaAlcoolica;
	}

	public int getBebidaAlcoolicaFrequenciaSemanal() {
		return bebidaAlcoolicaFrequenciaSemanal;
	}

	public void setBebidaAlcoolicaFrequenciaSemanal(
			int bebidaAlcoolicaFrequenciaSemanal) {
		this.bebidaAlcoolicaFrequenciaSemanal = bebidaAlcoolicaFrequenciaSemanal;
	}

	public String getBebidaAlcoolicaComentario() {
		return bebidaAlcoolicaComentario;
	}

	public void setBebidaAlcoolicaComentario(String bebidaAlcoolicaComentario) {
		this.bebidaAlcoolicaComentario = bebidaAlcoolicaComentario;
	}

	public boolean getAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(boolean atividadeFisica) {
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

	public boolean isOutrasPatologias() {
		return outrasPatologias;
	}

	public void setOutrasPatologias(boolean outrasPatologias) {
		this.outrasPatologias = outrasPatologias;
	}

	public String getOutrasPatologiasComentario() {
		return outrasPatologiasComentario;
	}

	public void setOutrasPatologiasComentario(String outrasPatologiasComentario) {
		this.outrasPatologiasComentario = outrasPatologiasComentario;
	}

	public boolean isAlergia() {
		return alergia;
	}

	public void setAlergia(boolean alergia) {
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "ConsultaNutricional [id=" + id + ", frequencias=" + frequencias
				+ ", peso=" + peso + ", circunferenciaCintura="
				+ circunferenciaCintura + ", glicemia=" + glicemia
				+ ", classificacaoGlicemia=" + classificacaoGlicemia + ", ct="
				+ ct + ", classificacaoCt=" + classificacaoCt + ", hdl=" + hdl
				+ ", classificacaoHdl=" + classificacaoHdl + ", ldl=" + ldl
				+ ", classificacaoLdl=" + classificacaoLdl + ", tg=" + tg
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
				+ ", carneVermelha=" + carneVermelha
				+ ", carneVermelhaFrequenciaSemanal="
				+ carneVermelhaFrequenciaSemanal + ", carneVermelhaComentario="
				+ carneVermelhaComentario + ", bebidaAlcoolica="
				+ bebidaAlcoolica + ", bebidaAlcoolicaFrequenciaSemanal="
				+ bebidaAlcoolicaFrequenciaSemanal
				+ ", bebidaAlcoolicaComentario=" + bebidaAlcoolicaComentario
				+ ", atividadeFisica=" + atividadeFisica
				+ ", atividadeFisicaFrequenciaSemanal="
				+ atividadeFisicaFrequenciaSemanal
				+ ", atividadeFisicaComentario=" + atividadeFisicaComentario
				+ ", diabetes=" + diabetes + ", hipertensao=" + hipertensao
				+ ", outrasPatologias=" + outrasPatologias
				+ ", outrasPatologiasComentario=" + outrasPatologiasComentario
				+ ", alergia=" + alergia + ", alergiaComentario="
				+ alergiaComentario + ", objetivoConsulta=" + objetivoConsulta
				+ ", paciente=" + paciente + "]";
	}

	
}
