package br.ufc.quixada.npi.sisat.model;

import java.io.Serializable;

public class DistribuicaoId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int grupo;
    private int refeicao;
	
    public int getGrupo() {
    	
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public int getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(int refeicao) {
		this.refeicao = refeicao;
	}
    
	@Override
	public int hashCode() {
		return grupo + refeicao;
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof DistribuicaoId){
            DistribuicaoId distribuicaoId = (DistribuicaoId) obj;
            return distribuicaoId.grupo == grupo && distribuicaoId.refeicao == refeicao;
        }
 
        return false;
    }
    
	
}
