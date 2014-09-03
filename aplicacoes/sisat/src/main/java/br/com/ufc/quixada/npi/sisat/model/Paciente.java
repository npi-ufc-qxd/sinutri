package br.com.ufc.quixada.npi.sisat.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Paciente implements Serializable {
	
	
	@Id
	@OneToOne
    @JoinColumn(name="id", nullable=false)
    private Pessoa pessoa;
	
	private double altura;

	
	/*
	 //
	@OneToMany(mappedBy="paciente")
	private List<ConsultaNutricional> consultas;
	
	@OneToMany(mappedBy="paciente")
	private List<Agendamento> agendamentos;
	 */	
	
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
}