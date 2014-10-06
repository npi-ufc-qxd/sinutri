package br.com.ufc.quixada.npi.sisat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6651490753121518188L;

	@Id
    private Long id;
	
	@MapsId
	@OneToOne(mappedBy = "paciente")
	@JoinColumn(name = "id")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="paciente")
 	private List<ConsultaNutricional> consultas;
	/*
	@OneToMany(mappedBy="paciente")
	private List<Agendamento> agendamentos;
	 */
	private double altura;
	
	
	//gets and sets
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public List<ConsultaNutricional> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<ConsultaNutricional> consultas) {
		this.consultas = consultas;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", pessoa=" + pessoaToString() + ", consultas="
				+ consultas + ", altura=" + altura + "]";
	}

	private String pessoaToString() {
		return "Pessoa [id=" + id + ", login=" + pessoa.getLogin()
				+ ", password=" + pessoa.getPassword() + ", papeis="
				+ pessoa.getPapeis() + ", servidores=" + pessoa.getServidores()
				+ ", cpf=" + pessoa.getCpf() + ", nome=" + pessoa.getNome()
				+ ", email=" + pessoa.getEmail() + ", sexo=" + pessoa.getSexo()
				+ ", dataNascimento=" + pessoa.getDataNascimento()
				+ ", telefone=" + pessoa.getTelefone() + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
