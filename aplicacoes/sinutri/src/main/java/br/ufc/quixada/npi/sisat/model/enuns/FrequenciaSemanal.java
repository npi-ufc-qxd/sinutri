package br.ufc.quixada.npi.sisat.model.enuns;

public enum FrequenciaSemanal {
		
	RARAMENTE("Raramente"),
	UMA_VEZ_POR_SEMANA("Uma vez por semana"),	
	POUCAS_VEZES_POR_SEMANA("Poucas vez por semana"),	
	DIARIAMENTE("Diariamente");

	private String descricao;
		
	private FrequenciaSemanal(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
