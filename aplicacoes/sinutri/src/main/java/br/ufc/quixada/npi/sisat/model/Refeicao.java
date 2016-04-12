package br.ufc.quixada.npi.sisat.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Refeicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "refeicao")
    private List<Distribuicao> grupos;
	
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

	public List<Distribuicao> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Distribuicao> grupos) {
		this.grupos = grupos;
	}
	
	
}
