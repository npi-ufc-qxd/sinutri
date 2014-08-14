package br.com.ufc.quixada.npi.sisat.enumerator;

public enum StatusProjeto {
	
	NOVO("NOVO"), SUBMETIDO("SUBMETIDO"), AGUARDANDO_PARECER("AGUARDANDO PARECER"), 
	AGUARDANDO_AVALIACAO("AGUARDANDO AVALIAÇÃO"), ACEITO("ACEITO"), NAO_ACEITO("NÃO ACEITO");
	
	private String descricao;
	
	private StatusProjeto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
