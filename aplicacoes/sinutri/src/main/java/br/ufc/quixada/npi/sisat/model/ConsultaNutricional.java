package br.ufc.quixada.npi.sisat.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sisat.model.enuns.ClassificacaoExame;
import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sisat.model.enuns.SistemaUrinario;

@NamedQueries({
	@NamedQuery(name = "ConsultaNutricional.findFrequenciasByIdconsultaByTipo", query = "select f from FrequenciaAlimentar f where f.consultaNutricional.id=:id and f.tipofrequencia=:tipo"),
	@NamedQuery(name = "ConsultaNutricional.findFrequenciaAlimentarByIdConsulta", query = "select f from FrequenciaAlimentar f where f.consultaNutricional.id=:id"),
	@NamedQuery(name = "ConsultaNutricional.findConsultaNutricionalWithDocumentosById", query = "select c from ConsultaNutricional c left join fetch c.documentos where c.id=:id"),
	@NamedQuery(name = "ConsultaNutricional.findFrequenciasByIdConsulta", query = "select DISTINCT f from FrequenciaAlimentar f left join fetch f.alimentos where f.consultaNutricional.id = :id"),
	@NamedQuery(name = "ConsultaNutricional.findPacientePessoaCpfById", query = "select c.paciente.pessoa.cpf from ConsultaNutricional c where c.id=:id"), 
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaMastigacao", query = "select count(c.mastigacao) from ConsultaNutricional c where c.mastigacao = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.findCountFrequenciaMastigacao", query = "select count(c.mastigacao) from ConsultaNutricional c where c.mastigacao = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaDisfagia", query = "select count(c.disfagia) from ConsultaNutricional c where c.disfagia = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaOdinofagia", query = "select count(c.odinofagia) from ConsultaNutricional c WHERE c.odinofagia = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaPirose", query = "select count(c.pirose) from ConsultaNutricional c where c.pirose = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaNausea", query = "select count(c.nausea) from ConsultaNutricional c where c.nausea = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaVomito", query = "select count(c.vomito) from ConsultaNutricional c where c.vomito = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaDiarreia", query = "select count(c.diarreia) from ConsultaNutricional c where c.diarreia = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaConstipacao", query = "select count(c.constipacao) from ConsultaNutricional c where c.constipacao = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaDiabetes", query = "select count(c.diabetes) from ConsultaNutricional c where c.diabetes = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaHipertensao", query = "select count(c.hipertensao) from ConsultaNutricional c where c.hipertensao = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaAlergia", query = "select count(c.alergia) from ConsultaNutricional c where c.alergia = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.countFrequenciaOutrasPatologias", query = "select count(c.outrasPatologias) from ConsultaNutricional c where c.outrasPatologias = TRUE"),
	@NamedQuery(name = "ConsultaNutricional.historicoPaciente", query = "select new br.ufc.quixada.npi.sisat.model.InformacaoGraficaConsultaNutricional(c.paciente.pessoa.sexo, c.data, c.peso, c.altura, c.circunferenciaCintura) from ConsultaNutricional c where c.paciente.pessoa.cpf = :cpf ")
})

@Entity
public class ConsultaNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "consultaNutricional", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<FrequenciaAlimentar> frequencias;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@OneToOne(mappedBy = "consultaNutricional", cascade = CascadeType.ALL)
	private InqueritoAlimentar inqueritoAlimentar;

	@OneToMany(mappedBy = "consultaNutricional", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Documento> documentos;

	@DateTimeFormat
	private Date data;

	@NotEmpty(message = "Informe o objetivo da consulta")
	private String objetivoConsulta;

	@NotNull(message = "Informe a altura")
	@Min(value = 1)
	private Double altura;

	@NotNull(message = "Informe o peso")
	@Min(value = 1)
	private Double peso;

	@NotNull(message = "Informe o peso desejado")
	@Min(value = 1)
	private Double pesoDesejado;

	@Min(value = 1)
	private Double circunferenciaCintura;

	@Min(value = 1)
	private Double circunferenciaCinturaDesejada;

	@NotNull(message = "Informe a quantidade de copos de água consumida")
	@Min(value = 1)
	private Double agua;

	private boolean atividadeFisica;
	private String atividadeFisicaComentario;
	@Enumerated(EnumType.STRING)
	private Frequencia atividadeFisicaFrequenciaSemanal;

	private boolean carneVermelha;
	private String carneVermelhaComentario;
	@Enumerated(EnumType.STRING)
	private Frequencia carneVermelhaFrequenciaSemanal;

	private boolean bebidaAlcoolica;
	private String bebidaAlcoolicaComentario;
	@Enumerated(EnumType.STRING)
	private Frequencia bebidaAlcoolicaFrequenciaSemanal;

	@Enumerated(EnumType.STRING)
	private SistemaGastrointestinal sistemaGastrointestinal;

	@Enumerated(EnumType.STRING)
	private SistemaUrinario sistemaUrinario;

	private boolean medicamento;
	private String medicamentoComentario;

	private boolean mastigacao;
	private String mastigacaoComentario;

	private boolean disfagia;
	private String disfagiaComentario;

	private boolean pirose;
	private String piroseComentario;

	private boolean nausea;
	private String nauseaComentario;

	private boolean vomito;
	private String vomitoComentario;

	private boolean diarreia;
	private String diarreiaComentario;

	private boolean constipacao;
	private String constipacaoComentario;

	private boolean odinofagia;
	private String odinofagiaComentario;

	private boolean regurgitacao;
	private String regurgitacaoComentario;

	private boolean diabetes;
	private boolean hipertensao;

	private boolean alergia;
	private String alergiaComentario;

	private boolean outrasPatologias;
	private String outrasPatologiasComentario;

	private Double glicemia;
	private ClassificacaoExame classificacaoGlicemia;

	private Double ct;
	private ClassificacaoExame classificacaoCt;

	private Double hdlc;
	private ClassificacaoExame classificacaoHdlc;

	private Double ldlc;
	private ClassificacaoExame classificacaoLdlc;

	private Double tg;
	private ClassificacaoExame classificacaoTg;

	private Double hb;
	private ClassificacaoExame classificacaoHb;

	private Double tgo;
	private ClassificacaoExame classificacaoTgo;

	private Double tgp;
	private ClassificacaoExame classificacaoTgp;

	@Transient
	private Double IMC;

	@Transient
	private String classificacaoIMC;

	@Transient
	private String classificacaoCC;

	private String informacoesComplementaresExames;

	private String observacooesDaConsulta;

	public ConsultaNutricional() {
		this.IMC = 0.0;
	}

	public ConsultaNutricional(Paciente paciente) {
		setPaciente(paciente);
	}

	public ConsultaNutricional(Paciente paciente, Date data, Double peso, Double altura, Double circunferenciaCintura) {
		this.paciente = paciente;
		this.data = data;
		this.peso = peso;
		this.altura = altura;
		this.IMC = calculaIMC();
		this.classificacaoCC = classificaCircunferenciaCintura();
		this.circunferenciaCintura = circunferenciaCintura;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObjetivoConsulta() {
		return objetivoConsulta;
	}

	public void setObjetivoConsulta(String objetivoConsulta) {
		this.objetivoConsulta = objetivoConsulta;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPesoDesejado() {
		return pesoDesejado;
	}

	public void setPesoDesejado(Double pesoDesejado) {
		this.pesoDesejado = pesoDesejado;
	}

	public Double getCircunferenciaCintura() {
		return circunferenciaCintura;
	}

	public void setCircunferenciaCintura(Double circunferenciaCintura) {
		this.circunferenciaCintura = circunferenciaCintura;
	}

	public Double getCircunferenciaCinturaDesejada() {
		return circunferenciaCinturaDesejada;
	}

	public void setCircunferenciaCinturaDesejada(Double circunferenciaCinturaDesejada) {
		this.circunferenciaCinturaDesejada = circunferenciaCinturaDesejada;
	}

	public Double getAgua() {
		return agua;
	}

	public void setAgua(Double agua) {
		this.agua = agua;
	}

	public boolean isAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(boolean atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	public String getAtividadeFisicaComentario() {
		return atividadeFisicaComentario;
	}

	public void setAtividadeFisicaComentario(String atividadeFisicaComentario) {
		this.atividadeFisicaComentario = atividadeFisicaComentario;
	}

	public Frequencia getAtividadeFisicaFrequenciaSemanal() {
		return atividadeFisicaFrequenciaSemanal;
	}

	public void setAtividadeFisicaFrequenciaSemanal(Frequencia atividadeFisicaFrequenciaSemanal) {
		this.atividadeFisicaFrequenciaSemanal = atividadeFisicaFrequenciaSemanal;
	}

	public boolean isCarneVermelha() {
		return carneVermelha;
	}

	public void setCarneVermelha(boolean carneVermelha) {
		this.carneVermelha = carneVermelha;
	}

	public String getCarneVermelhaComentario() {
		return carneVermelhaComentario;
	}

	public void setCarneVermelhaComentario(String carneVermelhaComentario) {
		this.carneVermelhaComentario = carneVermelhaComentario;
	}

	public Frequencia getCarneVermelhaFrequenciaSemanal() {
		return carneVermelhaFrequenciaSemanal;
	}

	public void setCarneVermelhaFrequenciaSemanal(Frequencia carneVermelhaFrequenciaSemanal) {
		this.carneVermelhaFrequenciaSemanal = carneVermelhaFrequenciaSemanal;
	}

	public boolean isBebidaAlcoolica() {
		return bebidaAlcoolica;
	}

	public void setBebidaAlcoolica(boolean bebidaAlcoolica) {
		this.bebidaAlcoolica = bebidaAlcoolica;
	}

	public void setInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar) {
		this.inqueritoAlimentar = inqueritoAlimentar;
	}

	public InqueritoAlimentar getInqueritoAlimentar() {
		return inqueritoAlimentar;
	}

	public String getBebidaAlcoolicaComentario() {
		return bebidaAlcoolicaComentario;
	}

	public void setBebidaAlcoolicaComentario(String bebidaAlcoolicaComentario) {
		this.bebidaAlcoolicaComentario = bebidaAlcoolicaComentario;
	}

	public Frequencia getBebidaAlcoolicaFrequenciaSemanal() {
		return bebidaAlcoolicaFrequenciaSemanal;
	}

	public void setBebidaAlcoolicaFrequenciaSemanal(Frequencia bebidaAlcoolicaFrequenciaSemanal) {
		this.bebidaAlcoolicaFrequenciaSemanal = bebidaAlcoolicaFrequenciaSemanal;
	}

	public SistemaGastrointestinal getSistemaGastrointestinal() {
		return sistemaGastrointestinal;
	}

	public void setSistemaGastrointestinal(SistemaGastrointestinal sistemaGastrointestinal) {
		this.sistemaGastrointestinal = sistemaGastrointestinal;
	}

	public SistemaUrinario getSistemaUrinario() {
		return sistemaUrinario;
	}

	public void setSistemaUrinario(SistemaUrinario sistemaUrinario) {
		this.sistemaUrinario = sistemaUrinario;
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

	public String getDisfagiaComentario() {
		return disfagiaComentario;
	}

	public void setDisfagiaComentario(String disfagiaComentario) {
		this.disfagiaComentario = disfagiaComentario;
	}

	public boolean isPirose() {
		return pirose;
	}

	public void setPirose(boolean pirose) {
		this.pirose = pirose;
	}

	public String getPiroseComentario() {
		return piroseComentario;
	}

	public void setPiroseComentario(String piroseComentario) {
		this.piroseComentario = piroseComentario;
	}

	public boolean isNausea() {
		return nausea;
	}

	public void setNausea(boolean nausea) {
		this.nausea = nausea;
	}

	public String getNauseaComentario() {
		return nauseaComentario;
	}

	public void setNauseaComentario(String nauseaComentario) {
		this.nauseaComentario = nauseaComentario;
	}

	public boolean isVomito() {
		return vomito;
	}

	public void setVomito(boolean vomito) {
		this.vomito = vomito;
	}

	public String getVomitoComentario() {
		return vomitoComentario;
	}

	public void setVomitoComentario(String vomitoComentario) {
		this.vomitoComentario = vomitoComentario;
	}

	public boolean isDiarreia() {
		return diarreia;
	}

	public void setDiarreia(boolean diarreia) {
		this.diarreia = diarreia;
	}

	public String getDiarreiaComentario() {
		return diarreiaComentario;
	}

	public void setDiarreiaComentario(String diarreiaComentario) {
		this.diarreiaComentario = diarreiaComentario;
	}

	public boolean isConstipacao() {
		return constipacao;
	}

	public void setConstipacao(boolean constipacao) {
		this.constipacao = constipacao;
	}

	public String getConstipacaoComentario() {
		return constipacaoComentario;
	}

	public void setConstipacaoComentario(String constipacaoComentario) {
		this.constipacaoComentario = constipacaoComentario;
	}

	public boolean isOdinofagia() {
		return odinofagia;
	}

	public void setOdinofagia(boolean odinofagia) {
		this.odinofagia = odinofagia;
	}

	public String getOdinofagiaComentario() {
		return odinofagiaComentario;
	}

	public void setOdinofagiaComentario(String odinofagiaComentario) {
		this.odinofagiaComentario = odinofagiaComentario;
	}

	public boolean isRegurgitacao() {
		return regurgitacao;
	}

	public void setRegurgitacao(boolean regurgitacao) {
		this.regurgitacao = regurgitacao;
	}

	public String getRegurgitacaoComentario() {
		return regurgitacaoComentario;
	}

	public void setRegurgitacaoComentario(String regurgitacaoComentario) {
		this.regurgitacaoComentario = regurgitacaoComentario;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(boolean hipertensao) {
		this.hipertensao = hipertensao;
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

	public Double getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(Double glicemia) {
		this.glicemia = glicemia;
	}

	public ClassificacaoExame getClassificacaoGlicemia() {
		return classificacaoGlicemia;
	}

	public void setClassificacaoGlicemia(ClassificacaoExame classificacaoGlicemia) {
		this.classificacaoGlicemia = classificacaoGlicemia;
	}

	public Double getCt() {
		return ct;
	}

	public void setCt(Double ct) {
		this.ct = ct;
	}

	public ClassificacaoExame getClassificacaoCt() {
		return classificacaoCt;
	}

	public void setClassificacaoCt(ClassificacaoExame classificacaoCt) {
		this.classificacaoCt = classificacaoCt;
	}

	public Double getHdlc() {
		return hdlc;
	}

	public void setHdlc(Double hdlc) {
		this.hdlc = hdlc;
	}

	public ClassificacaoExame getClassificacaoHdlc() {
		return classificacaoHdlc;
	}

	public void setClassificacaoHdlc(ClassificacaoExame classificacaoHdlc) {
		this.classificacaoHdlc = classificacaoHdlc;
	}

	public Double getLdlc() {
		return ldlc;
	}

	public void setLdlc(Double ldlc) {
		this.ldlc = ldlc;
	}

	public ClassificacaoExame getClassificacaoLdlc() {
		return classificacaoLdlc;
	}

	public void setClassificacaoLdlc(ClassificacaoExame classificacaoLdlc) {
		this.classificacaoLdlc = classificacaoLdlc;
	}

	public Double getTg() {
		return tg;
	}

	public void setTg(Double tg) {
		this.tg = tg;
	}

	public ClassificacaoExame getClassificacaoTg() {
		return classificacaoTg;
	}

	public void setClassificacaoTg(ClassificacaoExame classificacaoTg) {
		this.classificacaoTg = classificacaoTg;
	}

	public Double getHb() {
		return hb;
	}

	public void setHb(Double hb) {
		this.hb = hb;
	}

	public ClassificacaoExame getClassificacaoHb() {
		return classificacaoHb;
	}

	public void setClassificacaoHb(ClassificacaoExame classificacaoHb) {
		this.classificacaoHb = classificacaoHb;
	}

	public Double getTgo() {
		return tgo;
	}

	public void setTgo(Double tgo) {
		this.tgo = tgo;
	}

	public ClassificacaoExame getClassificacaoTgo() {
		return classificacaoTgo;
	}

	public void setClassificacaoTgo(ClassificacaoExame classificacaoTgo) {
		this.classificacaoTgo = classificacaoTgo;
	}

	public Double getTgp() {
		return tgp;
	}

	public void setTgp(Double tgp) {
		this.tgp = tgp;
	}

	public ClassificacaoExame getClassificacaoTgp() {
		return classificacaoTgp;
	}

	public void setClassificacaoTgp(ClassificacaoExame classificacaoTgp) {
		this.classificacaoTgp = classificacaoTgp;
	}

	public String getInformacoesComplementaresExames() {
		return informacoesComplementaresExames;
	}

	public void setInformacoesComplementaresExames(String informacoesComplementaresExames) {
		this.informacoesComplementaresExames = informacoesComplementaresExames;
	}

	public String getObservacooesDaConsulta() {
		return observacooesDaConsulta;
	}

	public void setObservacooesDaConsulta(String observacooesDaConsulta) {
		this.observacooesDaConsulta = observacooesDaConsulta;
	}

	public Double getIMC() {
		this.IMC = calculaIMC();
		return IMC;
	}

	private Double calculaIMC() {
		try {
			double imc = this.peso / (this.altura * this.altura);
			return imc;
		} catch (NullPointerException e) {
			return 0.0;
		}

	}

	public String getClassificacaoIMC() {
		classificacaoIMC = classificaIMC();
		return classificacaoIMC;
	}

	private String classificaIMC() {

		if (this.IMC < 25) {
			if (this.IMC < 17) {
				if (this.IMC < 16) {
					// <16 Desnutrição grau III
					return "Desnutrição grau III";
				} else {
					// 16 a 16,9 Desnutrição grau II
					return "Desnutrição grau II";
				}
			} else {
				if (this.IMC < 18.5) {
					// 17 a 18,4 Desnutrição grau I
					return "Desnutrição grau I";
				} else {
					// 18,5 a 24,9 Eutrofia
					return "Eutrofia";
				}
			}
		} else {
			if (this.IMC < 35) {
				if (this.IMC < 30) {
					// 25 a 29,9 Sobrepeso
					return "Sobrepeso";
				} else {
					// 30 a 34,9 Obesidade grau I
					return "Obesidade grau I";
				}
			} else {
				if (this.IMC < 40) {
					// 35 a 39,9 Obesidade grau II
					return "Obesidade grau  II";
				} else {
					// ≥ 40 Obesidade grau III
					return "Obesidade grau III";
				}
			}
		}

	}

	public String getClassificacaoCC() {
		classificacaoCC = this.classificaCircunferenciaCintura();
		return classificacaoCC;
	}

	public void setClassificacaoCC(String classificacaoCC) {
		this.classificacaoCC = classificacaoCC;
	}

	private String classificaCircunferenciaCintura() {

		if (this.getCircunferenciaCintura() == null) {
			return "";
		}

		Double circunferencia = this.getCircunferenciaCintura() / 100;

		if (this.getPaciente().getPessoa().getSexo() != null) {
			String sexo = this.getPaciente().getPessoa().getSexo();
			if (sexo.equalsIgnoreCase("m")) {
				if (circunferencia < 0.94) {
					return "Normal";
				} else {
					if (circunferencia < 1.02) {
						return "Risco aumentado";
					} else {
						return "Risco muito aumentado";
					}
				}
			} else if (sexo.equalsIgnoreCase("f")) {
				if (circunferencia < 0.80) {
					return "Normal";
				} else {
					if (circunferencia < 0.88) {
						return "Risco aumentado";
					} else {
						return "Risco muito aumentado";
					}
				}
			}
		} else {
			return "É necessario o sexo para definir a classificação de circurferência";
		}
		return "";
	}

	public void setIMC(Double iMC) {
		this.IMC = iMC;
	}

	public void setClassificacaoIMC(String classificacaoIMC) {
		this.classificacaoIMC = classificacaoIMC;
	}

}
