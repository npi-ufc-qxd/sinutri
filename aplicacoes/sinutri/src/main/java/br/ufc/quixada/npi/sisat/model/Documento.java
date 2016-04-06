package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({
	@NamedQuery(name = "Documento.findDocumentosByIdConsulta", query = "select d from Documento d where d.consultaNutricional.id=:id"),
	@NamedQuery(name = "Documento.findDocumentosEnvio", query ="select d from Documento d where d.consultaNutricional.id=:id and d.enviar = TRUE" ),
	@NamedQuery(name = "Documento.findDocumentosNutricionista", query ="select d from Documento d where d.consultaNutricional.id=:id and d.enviar = FALSE")
})
@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String tipo;

	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] arquivo;

	@ManyToOne
	@JoinColumn(name = "consultaNutricional_id")
	private ConsultaNutricional consultaNutricional;

	@DateTimeFormat
	private Date data;
	
	private boolean enviar;

	public Documento() {
		super();
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public ConsultaNutricional getConsultaNutricional() {
		return consultaNutricional;
	}

	public void setConsultaNutricional(ConsultaNutricional consultaNutricional) {
		this.consultaNutricional = consultaNutricional;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public boolean isEnviar() {
		return enviar;
	}

	public void setEnviar(boolean enviar) {
		this.enviar = enviar;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			Documento other = (Documento) obj;
			if (other != null && other.getId() != null && this.id != null
					&& other.getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", nome=" + nome + ", tipo=" + tipo
				+ ", data=" + data + ", enviar=" + enviar + "]";
	}
	
	
}
