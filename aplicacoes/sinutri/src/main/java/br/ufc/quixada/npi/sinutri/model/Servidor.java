package br.ufc.quixada.npi.sinutri.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String siap;

	@ManyToOne
	private Pessoa pessoa;

	public Servidor() {
		super();
	}

	public Servidor(String siap, Pessoa pessoa) {
		super();
		this.siap = siap;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiap() {
		return siap;
	}

	public void setSiap(String siap) {
		this.siap = siap;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
}
