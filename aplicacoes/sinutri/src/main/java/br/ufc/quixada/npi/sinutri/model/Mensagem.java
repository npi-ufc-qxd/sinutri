package br.ufc.quixada.npi.sinutri.model;

public class Mensagem {
	
	public enum Tipo { 
		SUCESSO, 
		ERRO
	};
	
	public enum Prioridade { 
		BAIXA, 
		MEDIA, 
		ALTA
	};
	
	private String texto;
	private Tipo tipo;
	private Prioridade prioridade;
	
	public Mensagem(String mensagem, Tipo tipo, Prioridade prioridade) {
		this.texto = mensagem;
		this.tipo = tipo;
		this.prioridade = prioridade;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String mensagem) {
		this.texto = mensagem;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
}
