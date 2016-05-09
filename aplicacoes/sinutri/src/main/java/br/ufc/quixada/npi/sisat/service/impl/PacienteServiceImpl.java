package br.ufc.quixada.npi.sisat.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.Papel;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PacienteServiceImpl extends GenericServiceImpl<Paciente> implements PacienteService {
	
	@Inject
	GenericRepository<AvaliacaoAntropometrica> antropometriaRepository;
	
	@Inject
	GenericRepository<ConsultaNutricional> consultaRepository;

	@Override
	public Map<Long, Object> getConsultasByPaciente(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		
		List<ConsultaNutricional> consultas = consultaRepository.find(ConsultaNutricional.class);

		Map<Long, Object> map = new HashMap<Long, Object>();

		for(ConsultaNutricional consulta : consultas) {
			
			Map<String, Object> p = new HashMap<String, Object>();
			
			p.put("peso", consulta.getPeso());
			p.put("data", consulta.getData());
			map.put(consulta.getId(), p);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaNutricional> getHistoricoPeso(String cpf) {
		List<ConsultaNutricional> consultas = find(QueryType.NAMED, "ConsultaNutricional.historicoPaciente", new SimpleMap<String, Object>("cpf", cpf));

		return consultas;
	}
	@Override
	public void excluir(ConsultaNutricional consulta){
		this.excluir(consulta);
	}
	
	//Implementação dos Métodos da Avaliação Antropométrica
	public void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria){
		antropometriaRepository.save(antropometria);
	}
	
	public void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		antropometriaRepository.update(antropometria);
		
	}
	
	public AvaliacaoAntropometrica buscarAvaliacaoAntropometricaById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		AvaliacaoAntropometrica avaliacaoAntropometrica = (AvaliacaoAntropometrica) 
				findFirst(QueryType.JPQL, "from AvaliacaoAntropometrica where id = :id", params);
		return avaliacaoAntropometrica;
	}

	@Override
	public void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		antropometriaRepository.delete(antropometria);
		
	}
}
