package br.ufc.quixada.npi.sisat.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PacienteExterno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	@NotNull
	private String vinculo;
	@NotNull
	private String telefone;

	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
