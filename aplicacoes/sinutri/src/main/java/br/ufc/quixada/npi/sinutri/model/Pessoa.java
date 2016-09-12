package br.ufc.quixada.npi.sinutri.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import br.ufc.quixada.npi.sinutri.model.enuns.Sexo;

@Entity
//@EntityListeners(PessoaEntityListener.class)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;	

	@Valid
	@NotEmpty(message = "Especifique um nome.")
	private String nome;

	@Valid
	@NotNull(message = "Data de nascimento deve ser especificada")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private String vinculo;

	private String telefone;

	private String email;

	@Valid
	@NotNull(message = "O sexo deve ser especificado.")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String ocupacaoOuCargo;

	private Boolean externo;

	@ManyToMany
	@JoinTable(name = "papel_pessoa", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getOcupacaoOuCargo() {
		return ocupacaoOuCargo;
	}

	public void setOcupacaoOuCargo(String ocupacaoOuCargo) {
		this.ocupacaoOuCargo = ocupacaoOuCargo;
	}

	public Boolean getExterno() {
		return externo;
	}

	public void setExterno(Boolean externo) {
		this.externo = externo;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public Integer getIdade(){
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

	

