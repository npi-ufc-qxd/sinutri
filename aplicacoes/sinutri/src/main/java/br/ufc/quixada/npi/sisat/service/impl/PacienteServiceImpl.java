package br.ufc.quixada.npi.sisat.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.model.Prescricao;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PacienteServiceImpl extends GenericServiceImpl<Paciente> implements PacienteService {

	@Inject
	GenericRepository<ConsultaNutricional> consultaRepository;
	
	@Inject
	GenericRepository<Prescricao> prescricaoRepository;

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
	public void adicionarPrescricao(Prescricao prescricao) {
		prescricaoRepository.save(prescricao);
	}

	@Override
	public void excluirPrescricao(Prescricao prescricao) {
		prescricaoRepository.delete(prescricao);
	}

	@Override
	public void editarPrescricao(Prescricao prescricao) {
		prescricaoRepository.update(prescricao);
	}

	@Override
	public Prescricao buscarPrescricao(Long id) {
		prescricaoRepository.find(Prescricao.class, id);
		return null;
	}
		
}
