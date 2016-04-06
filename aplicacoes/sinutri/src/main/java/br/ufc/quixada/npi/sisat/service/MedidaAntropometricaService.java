package br.ufc.quixada.npi.sisat.service;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.MedidaAntropometrica;

public interface MedidaAntropometricaService extends GenericService<MedidaAntropometrica> {
	public MedidaAntropometrica findMedidaAntropometricaByNome(String nome);
}
