package br.ufc.quixada.npi.sisat.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.FrequenciaAlimentar;
import br.ufc.quixada.npi.sisat.service.ConsultaNutricionalService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class ConsultaNutricionalServiceImpl extends GenericServiceImpl<ConsultaNutricional>
		implements ConsultaNutricionalService {
	
	
	@Inject 
	GenericRepository<ConsultaNutricional> r;

	@Override
	public ConsultaNutricional getConsultaNutricionalWithDocumentosById(Long id) {
		return (ConsultaNutricional) findFirst("ConsultaNutricional.findConsultaNutricionalWithDocumentosById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public ConsultaNutricional getConsultaNutricionalWithFrequenciasById(Long id) {
		return (ConsultaNutricional) findFirst("ConsultaNutricional.findConsultaNutricionalWithFrequenciasById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public String getOrientacoesIndividuaisById(Long id) {
		return (String) findFirst("ConsultaNutricional.findOrientacoesIndividuaisById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public String getPacientePessoaCpfById(Long id) {
		return (String) findFirst("ConsultaNutricional.findPacientePessoaCpfById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public Map<String, Object> getFrequenciaPatologia() {

		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put("Mastigação", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaMastigacao", new HashMap<String, Object>()));
		maps.put("disfagia", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaDisfagia", null));
		maps.put("odinofagia", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaOdinofagia", null));
		maps.put("pirose", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaPirose", null));
		maps.put("nausea", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaNausea", null));
		maps.put("vômitos",findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaVomito", null));
		maps.put("diarreia", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaDiarreia", null));
		maps.put("constipação", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaConstipacao", null));
		maps.put("diabetes", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaDiabetes", null));
		maps.put("hipertensao", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaHipertensao", null));
		maps.put("alergia", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaAlergia", null));
		maps.put("outrasPatologias", findFirst(QueryType.NAMED, "ConsultaNutricional.countFrequenciaOutrasPatologias", null));

		return maps;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrequenciaAlimentar> getFrequenciasByIdConsulta(Long id) {
 		return find("ConsultaNutricional.findFrequenciasByIdConsulta", new SimpleMap<String, Object>("id", id));
	}
}