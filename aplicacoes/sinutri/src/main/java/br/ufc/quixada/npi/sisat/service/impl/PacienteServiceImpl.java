package br.ufc.quixada.npi.sisat.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sisat.model.Paciente;
import br.ufc.quixada.npi.sisat.service.PacienteService;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class PacienteServiceImpl extends GenericServiceImpl<Paciente> implements PacienteService {

	@Inject
	GenericRepository<ConsultaNutricional> consultaRepository;

	@Inject
	GenericRepository<InqueritoAlimentar> inqueritoAlimentarRepository;
	
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
	
	public boolean adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Long id){
		Paciente paciente = this.find(Paciente.class, id);
		if(paciente != null){
			inqueritoAlimentar.setAtualizadoEm(inqueritoAlimentar.getCriadoEm());
			inqueritoAlimentar.setPaciente(paciente);
			inqueritoAlimentarRepository.save(inqueritoAlimentar);
			return true;
		}else
			return false;
	}

	@Override
	public InqueritoAlimentar getInqueritoAlimentarById(Long idInquerito) {
		InqueritoAlimentar inquerito = (InqueritoAlimentar) findFirst("InqueritoAlimentar.findInqueritoAlimentarById", new SimpleMap<String, Object>("id", idInquerito));
		return inquerito;
	}

	@Override
	public boolean editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Long idPaciente) {
		Paciente paciente = this.find(Paciente.class, idPaciente);
		if(inqueritoAlimentar != null || paciente != null){
			inqueritoAlimentar.setPaciente(paciente);
			inqueritoAlimentar.setAtualizadoEm(new Date());
			inqueritoAlimentarRepository.update(inqueritoAlimentar);
			return true;
		}else
			return false;
	}

	@Override
	public void excluirInqueritoAlimentar(Long idInquerito) {
		InqueritoAlimentar inquerito = getInqueritoAlimentarById(idInquerito);
 		if(inquerito != null){
 			inqueritoAlimentarRepository.delete(inquerito);
 		}
	}
}
