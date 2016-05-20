package br.ufc.quixada.npi.sinutri.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

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

}
