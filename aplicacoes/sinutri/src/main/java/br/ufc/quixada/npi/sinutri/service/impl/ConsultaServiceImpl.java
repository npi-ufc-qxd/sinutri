package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoAntropometricaRepository;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;
import br.ufc.quixada.npi.sinutri.service.HashMap;
import br.ufc.quixada.npi.sinutri.service.Map;

@Named
public class ConsultaServiceImpl implements ConsultaService {

	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
	@Inject
	private AvaliacaoAntropometricaRepository avaliacaoAntropometricaRepository;
	
	
	@Override
	public void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente) {
		inqueritoAlimentar.setPaciente(paciente);
		inqueritoAlimentar.setAtualizadoEm(new Date());
		inqueritoAlimentarRepository.save(inqueritoAlimentar);
	}

	@Override
	public void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar) {
		inqueritoAlimentarRepository.delete(inqueritoAlimentar);
	}

	@Override
	public InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar) {
		return inqueritoAlimentarRepository.findOne(idInqueritoAlimentar);
	}

	@Override
	public void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar) {
		inqueritoAlimentar.setAtualizadoEm(new Date());
		inqueritoAlimentarRepository.save(inqueritoAlimentar);
	}

	@Override
	public void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente) {
		antropometria.setPaciente(paciente);
		antropometria.setAtualizadoEm(new Date());
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}

	@Override
	public void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente) {
		antropometria.setAtualizadoEm(new Date());
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}

	@Override
	public void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria, Paciente paciente) {
		avaliacaoAntropometricaRepository.delete(antropometria);
	}

	@Override
	public AvaliacaoAntropometrica buscarAvaliacaoAntropometricaById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		AvaliacaoAntropometrica avaliacaoAntropometrica = (AvaliacaoAntropometrica) 
				findFirst(QueryType.JPQL, "from AvaliacaoAntropometrica where id = :id", params);
		return avaliacaoAntropometrica;

		return null;
	}
}
