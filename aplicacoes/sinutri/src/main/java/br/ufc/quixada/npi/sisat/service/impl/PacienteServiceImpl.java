package br.ufc.quixada.npi.sisat.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.Anamnese;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PacienteServiceImpl extends GenericServiceImpl<Paciente> implements PacienteService {

	@Inject
	GenericRepository<ConsultaNutricional> consultaRepository;
	
	@Inject
	GenericRepository<Anamnese> anamneseRepository;
	
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

	@Override
	public void adicionarAnamnese(Anamnese anamnese) {
		anamneseRepository.save(anamnese);		
	}

	@Override
	public void editarAnamnese(Anamnese anamnese) {
		anamneseRepository.update(anamnese);
		
	}

	@Override
	public void excluirAnamnese(Anamnese anamnese) {
		anamneseRepository.delete(anamnese);
		
	}

	@Override
	public Anamnese buscarAnamnese(Long id) {		
		return anamneseRepository.find(Anamnese.class, id);
	}
	
	
		
}
