package br.ufc.quixada.npi.sisat.model;	

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@NamedQueries({
		@NamedQuery(name = "Pessoa.findPessoaByCpf", query = "select p from Pessoa p where p.cpf = :cpf"),
//		@NamedQuery(name = "Pessoa.findPessoasByNome", query = "SELECT p FROM Pessoa p WHERE UPPER(p.nome) LIKE :nome ORDER BY p.nome"),
//		@NamedQuery(name = "Pessoa.findPessoasByNomeOrCpf", query = "SELECT p FROM Pessoa p WHERE UPPER(p.nome) LIKE :busca or p.cpf = :cpf ORDER BY p.nome"),
		@NamedQuery(name = "Pessoa.findPessoaByLogin", query = "select p from Pessoa p where p.cpf = :login"),
		@NamedQuery(name = "Pessoa.findPareceristas", query = "select p from Pessoa p where p.id <> :id") // '<>'
																											// diferente
})
@Entity
@EntityListeners(PessoaEntityListener.class)
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

	@JsonIgnore
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

	public String getIdade() {
		String idade;
		if (this.dataNascimento != null) {
			Calendar dateOfBirth = new GregorianCalendar();
			dateOfBirth.setTime(this.dataNascimento);

			// Cria um objeto calendar com a data atual
			Calendar today = Calendar.getInstance();

			// Obtém a idade baseado no ano
			int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
			dateOfBirth.add(Calendar.YEAR, age);

			// se a data de hoje é antes da data de Nascimento, então diminui
			// 1(um)
			if (today.before(dateOfBirth)) {
				age--;
			}
			idade = "" + age;
		} else {
			idade = " ";
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



