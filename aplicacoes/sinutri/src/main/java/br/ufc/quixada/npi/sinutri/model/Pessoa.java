package br.ufc.quixada.npi.sinutri.model;


import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
//@EntityListeners(PessoaEntityListener.class)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id", "cpf" }))
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(name = "papel_pessoa", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;

	@Column(unique = true)
	private String cpf;

	@Transient
	private String nome;

	@Transient
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Paciente paciente;

	@OneToMany(mappedBy = "pessoa")
	private List<Servidor> servidores;

	@Column(columnDefinition = "char(1)")
	private String sexo;

	@Transient
	private Date dataNascimento;

	@Transient
	private String telefone;

	public Pessoa(){}

	public Pessoa(String cpf){
		setCpf(cpf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public boolean isNutricao() {
		for (Papel p : this.papeis) {
			if (p.getNome().equals("ROLE_NUTRICAO")) {
				return true;
			}
		}
		return false;
	}

}

	

