package br.ufc.quixada.npi.sinutri.model;

import java.io.Serializable;

public class PorcaoAlimentoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long refeicaoPlanoAlimentar;
	private Long alimento;

	public Long getRefeicaoPlanoAlimentar() {
		return refeicaoPlanoAlimentar;
	}

	public void setRefeicaoPlanoAlimentar(Long refeicaoPlanoAlimentar) {
		this.refeicaoPlanoAlimentar = refeicaoPlanoAlimentar;
	}

	public Long getAlimento() {
		return alimento;
	}

	public void setAlimento(Long alimento) {
		this.alimento = alimento;
	}

	@Override
	public int hashCode() {
		return alimento.intValue()+refeicaoPlanoAlimentar.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof PorcaoAlimentoId){
			 PorcaoAlimentoId porcaoAlimentoId = (PorcaoAlimentoId) obj;
	         return alimento.equals(porcaoAlimentoId.getAlimento())  && refeicaoPlanoAlimentar.equals(porcaoAlimentoId.getRefeicaoPlanoAlimentar());
	     }
	 
	     return false;
	}
	
}