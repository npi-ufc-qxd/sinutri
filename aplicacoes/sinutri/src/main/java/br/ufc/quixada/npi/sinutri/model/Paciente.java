package br.ufc.quixada.npi.sinutri.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.npi.sinutri.model.enuns.Sexo;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6651490753121518188L;

	@Id
	private Long id;

	@MapsId
	@OneToOne(mappedBy = "paciente")
	@JoinColumn(name = "id")
	private Pessoa pessoa;

	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private String vinculo;

	private String telefone;

	private String email;

	private Boolean externo;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	private String ocupacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getExterno() {
		return externo;
	}

	public void setExterno(Boolean externo) {
		this.externo = externo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	
	public Integer getIdade() {
		Integer idade = obterIdade();
		return idade;
	}
	
	private Integer obterIdade(){
		Integer idade = null;
		
		if(this.dataNascimento != null){
			Instant instanteDataNascimento = this.dataNascimento.toInstant();
			ZonedDateTime zonaDataNascimento = instanteDataNascimento.atZone(ZoneId.systemDefault());
		
			LocalDate dataDeNascimento = zonaDataNascimento.toLocalDate();
			LocalDate dataDeHoje = LocalDate.now();
		
			Period periodoEntreDatas = Period.between(dataDeNascimento, dataDeHoje);
			idade = periodoEntreDatas.getYears();
		}
		
		return idade;
	}

}
