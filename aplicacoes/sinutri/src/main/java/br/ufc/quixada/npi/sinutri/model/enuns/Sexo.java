package br.ufc.quixada.npi.sinutri.model.enuns;

public enum Sexo {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String sexo;
	
	
	
	private Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}

}
