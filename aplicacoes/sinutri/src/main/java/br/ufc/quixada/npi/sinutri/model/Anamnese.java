package br.ufc.quixada.npi.sinutri.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sinutri.model.enuns.Apetite;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaGastrointestinal;
import br.ufc.quixada.npi.sinutri.model.enuns.SistemaUrinario;


@Entity
public class Anamnese {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date criadoEm;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date atualizadoEm;
		
	@ManyToOne
	private Paciente paciente;
	
	@OneToOne
	private Servidor nutricionista;
	
	@Size(max=256, message="O objetivo da consulta deve ter menos que 256 caracteres")
	private String objetivoConsulta;
	
	@Min(value = 0,message = "Deve ser um numero positivo")
	private Double agua;
	
	private boolean atividadeFisica;
	@Size(max=256, message="Os comentários sobre atividade física precisam ocupar menos que 256 caracteres")
	private String atividadeFisicaComentario;
	
	private boolean dormeBem;
	@Size(max=256, message="Os comentários sobre o sono precisam ocupar menos que 256 caracteres")
	private String dormeBemComentario;
	
	private boolean medicamento;
	@Size(max=256, message="A descrição dos medicamentos precisam ter menos de 256 caracteres")
	private String medicamentoComentario;
	
	private boolean mastigacao;
	@Size(max=256, message="As características da mastigação precisam ocupar menos de 256 caracteres")
	private String mastigacaoComentario;
	
	private boolean disfagia;
	@Size(max=256, message="Os comentários sobre disfagia precisam ocupar menos que 256 caracteres")
	private String disfagiaComentario;
	
	private boolean pirose;
	@Size(max=256, message="Os comentários sobre pirose precisam ocupar menos que 256 caracteres")
	private String piroseComentario;
	
	private boolean nausea;
	@Size(max=256, message="Os comentários sobre náuseas precisam ocupar menos que 256 caracteres")
	private String nauseaComentario;
	
	private boolean vomito;
	@Size(max=256, message="Os comentários sobre vomito precisam ocupar menos que 256 caracteres")
	private String vomitoComentario;
	
	private boolean diarreia;
	@Size(max=256, message="Os comentários sobre diarreia precisam ocupar menos que 256 caracteres")
	private String diarreiaComentario;

	private boolean constipacao;
	@Size(max=256, message="Os comentários sobre constipação precisam ocupar menos que 256 caracteres")
	private String constipacaoComentario;
	
	private boolean odinofagia;
	@Size(max=256, message="Os comentários sobre odinofagia precisam ocupar menos que 256 caracteres")
	private String odinofagiaComentario;
	
	private boolean bebidaAlcoolica;
	@Size(max=256, message="Os comentários sobre bebida alcóolica precisam ocupar menos que 256 caracteres")
	private String bebidaAlcoolicaComentario;
		
	@Size(max=256, message="Os comentários patologias precisam ocupar menos que 256 caracteres")
	private String patologiasComentario;
	
	private boolean alergia;
	@Size(max=256, message="Os comentários sobre alergia alimentar precisam ocupar menos que 256 caracteres")
	private String alergiaComentario;
	
	private boolean intolerancia;
	@Size(max=256, message="Os comentários sobre intolerância alimentar precisam ocupar menos que 256 caracteres")
	private String intoleranciaComentario;
	
	@Enumerated(EnumType.STRING)
	private SistemaUrinario sistemaUrinario;
	@Size(max=256, message="Os comentários sobre o sistema urinário precisam ocupar menos que 256 caracteres")
	private String sistemaUrinarioComentario;
	
	@Enumerated(EnumType.STRING)
	private SistemaGastrointestinal sistemaGastrointestinal;
	
	@Enumerated(EnumType.STRING)
	private Apetite apetite;
	@Size(max=256, message="Os comentários sobre o apetite precisam ocupar menos que 256 caracteres")
	private String apetiteComentario;
	
	private String suplementosAlimentares;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Servidor getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Servidor nutricionista) {
		this.nutricionista = nutricionista;
	}

	public String getObjetivoConsulta() {
		return objetivoConsulta;
	}

	public void setObjetivoConsulta(String objetivoConsulta) {
		this.objetivoConsulta = objetivoConsulta;
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

	public boolean isDormeBem() {
		return dormeBem;
	}

	public void setDormeBem(boolean dormeBem) {
		this.dormeBem = dormeBem;
	}

	public String getDormeBemComentario() {
		return dormeBemComentario;
	}

	public void setDormeBemComentario(String dormeBemComentario) {
		this.dormeBemComentario = dormeBemComentario;
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

	public boolean isBebidaAlcoolica() {
		return bebidaAlcoolica;
	}

	public void setBebidaAlcoolica(boolean bebidaAlcoolica) {
		this.bebidaAlcoolica = bebidaAlcoolica;
	}

	public String getBebidaAlcoolicaComentario() {
		return bebidaAlcoolicaComentario;
	}

	public void setBebidaAlcoolicaComentario(String bebidaAlcoolicaComentario) {
		this.bebidaAlcoolicaComentario = bebidaAlcoolicaComentario;
	}

	public String getPatologiasComentario() {
		return patologiasComentario;
	}

	public void setPatologiasComentario(String outrasPatologiasComentario) {
		this.patologiasComentario = outrasPatologiasComentario;
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

	public boolean isIntolerancia() {
		return intolerancia;
	}

	public void setIntolerancia(boolean intolerancia) {
		this.intolerancia = intolerancia;
	}

	public String getIntoleranciaComentario() {
		return intoleranciaComentario;
	}

	public void setIntoleranciaComentario(String intoleranciaComentario) {
		this.intoleranciaComentario = intoleranciaComentario;
	}

	public SistemaUrinario getSistemaUrinario() {
		return sistemaUrinario;
	}

	public void setSistemaUrinario(SistemaUrinario sistemaUrinario) {
		this.sistemaUrinario = sistemaUrinario;
	}

	public String getSistemaUrinarioComentario() {
		return sistemaUrinarioComentario;
	}

	public void setSistemaUrinarioComentario(String sistemaUrinarioComentario) {
		this.sistemaUrinarioComentario = sistemaUrinarioComentario;
	}	

	public SistemaGastrointestinal getSistemaGastrointestinal() {
		return sistemaGastrointestinal;
	}

	public void setSistemaGastrointestinal(SistemaGastrointestinal sistemaGastrointestinal) {
		this.sistemaGastrointestinal = sistemaGastrointestinal;
	}

	public Apetite getApetite() {
		return apetite;
	}

	public void setApetite(Apetite apetite) {
		this.apetite = apetite;
	}

	public String getApetiteComentario() {
		return apetiteComentario;
	}

	public void setApetiteComentario(String apetiteComentario) {
		this.apetiteComentario = apetiteComentario;
	}

	public String getSuplementosAlimentares() {
		return suplementosAlimentares;
	}

	public void setSuplementosAlimentares(String suplementosAlimentares) {
		this.suplementosAlimentares = suplementosAlimentares;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}