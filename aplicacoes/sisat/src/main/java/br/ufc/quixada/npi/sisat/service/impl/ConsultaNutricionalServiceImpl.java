package br.ufc.quixada.npi.sisat.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
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
	@Transactional(readOnly = true)
	public ConsultaNutricional getConsultaNutricionalWithDocumentosAndFrequenciasById(Long id) {
		return (ConsultaNutricional) findFirst(
				"ConsultaNutricional.findConsultaNutricionalWithDocumentosAndFrequenciasById",
				new SimpleMap<String, Object>("id", id));
	}

	@Override
	public void teste() {
		
		System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww 1 " + new Date());
		List<ConsultaNutricional> c =  (List<ConsultaNutricional>) r.find(QueryType.JPQL, "SELECT "
				+ "(CASE c.mastigacao WHEN TRUE THEN TRUE END),"
				+ "(CASE c.disfagia WHEN TRUE THEN TRUE END),"
				+ "(CASE c.odinofagia WHEN TRUE THEN TRUE END),"
				+ "(CASE c.pirose WHEN TRUE THEN TRUE END),"
				+ "(CASE c.nausea WHEN TRUE THEN TRUE END),"
				+ "(CASE c.vomito WHEN TRUE THEN TRUE END),"
				+ "(CASE c.diarreia WHEN TRUE THEN TRUE END),"
				+ "(CASE c.constipacao WHEN TRUE THEN TRUE END),"
				+ "(CASE c.diabetes WHEN TRUE THEN TRUE END),"
				+ "(CASE c.hipertensao WHEN TRUE THEN TRUE END),"
				+ "(CASE c.alergia WHEN TRUE THEN TRUE END),"
				+ "(CASE c.outrasPatologias WHEN TRUE THEN TRUE END) "
				+ "FROM ConsultaNutricional c", null);
		
		
		

		System.out.println("wwwwwwwwwwwwwwwwwwwww 1 final" + new Date());

		System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww 2 inicio" + new Date());
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("mastigacao", r.find(QueryType.JPQL, "SELECT COUNT(c.mastigacao) FROM ConsultaNutricional c WHERE c.mastigacao = TRUE", null).size());
		maps.put("disfagia", r.find(QueryType.JPQL, "SELECT COUNT(c.disfagia) FROM ConsultaNutricional c WHERE c.disfagia = TRUE", null).size());
		maps.put("odinofagia", r.find(QueryType.JPQL, "SELECT COUNT(c.odinofagia) FROM ConsultaNutricional c WHERE c.odinofagia = TRUE", null).size());
		maps.put("pirose", r.find(QueryType.JPQL, "SELECT COUNT(c.pirose) FROM ConsultaNutricional c WHERE c.pirose = TRUE", null).size());
		maps.put("nausea", r.find(QueryType.JPQL, "SELECT COUNT(c.nausea) FROM ConsultaNutricional c WHERE c.nausea = TRUE", null).size());
		maps.put("vômitos", r.find(QueryType.JPQL, "SELECT COUNT(c.vomito) FROM ConsultaNutricional c WHERE c.vomito = TRUE", null).size());
		maps.put("diarreia", r.find(QueryType.JPQL, "SELECT COUNT(c.diarreia) FROM ConsultaNutricional c WHERE c.diarreia = TRUE", null).size());
		maps.put("constipação", r.find(QueryType.JPQL, "SELECT COUNT(c.constipacao) FROM ConsultaNutricional c WHERE c.constipacao = TRUE", null).size());
		maps.put("diabetes", r.find(QueryType.JPQL, "SELECT COUNT(c.diabetes) FROM ConsultaNutricional c WHERE c.diabetes = TRUE", null).size());
		maps.put("hipertensão", r.find(QueryType.JPQL, "SELECT COUNT(c.hipertensao) FROM ConsultaNutricional c WHERE c.hipertensao = TRUE", null).size());
		maps.put("alergia", r.find(QueryType.JPQL, "SELECT COUNT(c.alergia) FROM ConsultaNutricional c WHERE c.alergia = TRUE", null).size());
		maps.put("outrasPatologias", r.find(QueryType.JPQL, "SELECT COUNT(c.outrasPatologias) FROM ConsultaNutricional c WHERE c.outrasPatologias = TRUE", null).size());		

		System.out.println("wwwwwwwwwwwwwwwwwwwwww 2 final" + new Date());

}
}