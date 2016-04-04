package br.ufc.quixada.npi.sisat.model.enuns;

public enum ClassificacaoExame {
		
	VAZIO("Vazio"),
	MUITOALTO("Muito Alto"),	
	ALTO("Alto"),
	DESEJAVEL("Desejavel"),
	BAIXO("Baixo"),
	MUITOBAIXO("Muito Baixo");

	private String tipo;
		
	private ClassificacaoExame(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
