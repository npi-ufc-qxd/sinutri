package br.ufc.quixada.npi.sisat.model;

import java.io.Serializable;

public class DistribuicaoAlimentarId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long grupo;
    
	private Long calculoGastosEnergeticos;

	public Long getGrupo() {
		return grupo;
	}

	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}

	public Long getCalculoGastosEnergeticos() {
		return calculoGastosEnergeticos;
	}

	public void setCalculoGastosEnergeticos(Long calculoGastosEnergeticos) {
		this.calculoGastosEnergeticos = calculoGastosEnergeticos;
	}

	@Override
    public int hashCode() {
        return (int) (grupo + calculoGastosEnergeticos);
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DistribuicaoAlimentarId){
            DistribuicaoAlimentarId distribuicaoAlimentarId = (DistribuicaoAlimentarId) obj;
            return distribuicaoAlimentarId.grupo == grupo && distribuicaoAlimentarId.calculoGastosEnergeticos == calculoGastosEnergeticos;
        }
 
        return false;
    }
	
}
