package br.ufc.quixada.npi.sinutri.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6651490753121518188L;

	@Id
	private Long id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "id")
	private Pessoa pessoa;

	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private String vinculo;

	private String telefone;

	private String email;

	private Boolean externo;
	
	@OneToMany(mappedBy="paciente")
	private List<Prescricao> listPrescricao;

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

	public List<Prescricao> getListPrescricao() {
		return listPrescricao;
	}

	public void setListPrescricao(List<Prescricao> listPrescricao) {
		this.listPrescricao = listPrescricao;
	}

	
	
}
