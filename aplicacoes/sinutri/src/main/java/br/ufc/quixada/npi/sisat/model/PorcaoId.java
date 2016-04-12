package br.ufc.quixada.npi.sisat.model;

import java.io.Serializable;

public class PorcaoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int grupo;
	private int calculoDieta;
	
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public int getCalculosDietas() {
		return calculoDieta;
	}
	public void setCalculosDietas(int calculosDietas) {
		this.calculoDieta = calculosDietas;
	}

	@Override
	public int hashCode() {
		return grupo + calculoDieta;
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof PorcaoId){
            PorcaoId porcaoId = (PorcaoId) obj;
            return porcaoId.grupo == grupo && porcaoId.calculoDieta == calculoDieta;
        }
 
        return false;
    }
    
	

}
