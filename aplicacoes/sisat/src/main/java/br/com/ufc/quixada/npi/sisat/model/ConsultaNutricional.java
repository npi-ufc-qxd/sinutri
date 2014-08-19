package br.com.ufc.quixada.npi.sisat.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

public class ConsultaNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat
	private Data data;

	private Double peso;

	private Double altura;

	private Double circunferenciaCintura;

	private int glicemia;

	private int tgl;

	private int hdl;

	private int idl;

	private int ht;

	private int hb;

	private String condutaNutricional;
	
	
	private Boolean medicamento;
	
	private String medicamentoComentario;
	
	
	private Boolean mastigacao;
	
	private String mastigacaoComentario;
	
	
	private Boolean disfagia;
	
	private Boolean pirose;
	
	private Boolean nausea;
	
	
	private Boolean vomito;
	
	private Boolean diarreia;
	
	private Boolean constipacao;
	
	
	private String agua;
	
	private String carneVermelhaFrequencia;
	
	
	private Boolean bebidaAlcoolica;
	
	private int bebidaAlcoolicaFrequencia;
	
	
	
	
	
}
