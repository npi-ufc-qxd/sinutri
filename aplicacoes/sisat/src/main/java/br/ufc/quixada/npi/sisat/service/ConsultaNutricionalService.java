package br.ufc.quixada.npi.sisat.service;

import java.util.List;
import java.util.Map;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.model.enuns.TipoFrequencia;

public interface ConsultaNutricionalService extends GenericService<ConsultaNutricional> {

	public abstract ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id);

	public abstract List<FrequenciaAlimentar> getFrequenciasByIdConsultaByTipo(Long id, TipoFrequencia tipoFrequencia);

	public abstract String getOrientacoesIndividuaisById(Long id);

	public abstract String getPacientePessoaCpfById(Long id);

	public abstract List<FrequenciaAlimentar> getFrequenciasByIdConsulta(Long id);

	public abstract Map<String, Object> getFrequenciaPatologia();
	

}
