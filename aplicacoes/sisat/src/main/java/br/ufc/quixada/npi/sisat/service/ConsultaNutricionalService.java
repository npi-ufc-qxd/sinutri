package br.ufc.quixada.npi.sisat.service;

import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;

public interface ConsultaNutricionalService extends GenericService<ConsultaNutricional> {

	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id);

	public abstract ConsultaNutricional getConsultaNutricionalWithFrequenciasById(Long id);

	public abstract String getOrientacoesIndividuaisById(Long id);

	public abstract String getPacientePessoaCpfById(Long id);

	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosAndFrequenciasById(Long id);

	public abstract Map<String, Object> getFrequenciaPatologia() ;

}
