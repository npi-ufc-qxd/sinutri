package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoLaboratorialRepository;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoAntropometricaRepository;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;

@Named
public class ConsultaServiceImpl implements ConsultaService {
	
	@Inject
	private AvaliacaoLaboratorialRepository avaliacaoLaboratorialRepository;
	
	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
	@Inject
	private AvaliacaoAntropometricaRepository avaliacaoAntropometricaRepository;

	@Override
	public void adicionarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial, Paciente paciente) {
		
		avaliacaoLaboratorial.setPaciente(paciente);
		avaliacaoLaboratorial.setAtualizado(new Date());
		
		avaliacaoLaboratorialRepository.save(avaliacaoLaboratorial);
	}
	
	@Override
	public void editarAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial) {
		
		avaliacaoLaboratorial.setAtualizado(new Date());
		avaliacaoLaboratorialRepository.save(avaliacaoLaboratorial);
	}
	
	@Override
	public AvaliacaoLaboratorial buscarAvaliacaoLaboratorialPorId(Long idAvaliacaoLaboratorial) {
		
		return avaliacaoLaboratorialRepository.findOne(idAvaliacaoLaboratorial);
	}

	@Override
	public void excluirAvaliacaoLaboratorial(AvaliacaoLaboratorial avaliacaoLaboratorial) {
		
		avaliacaoLaboratorialRepository.delete(avaliacaoLaboratorial);
	}
	
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
	public void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}

	@Override
	public void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}

	@Override
	public void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.delete(antropometria);
	}

	@Override
	public AvaliacaoAntropometrica buscarAvaliacaoAntropometricaPorId(Long id) {
		return avaliacaoAntropometricaRepository.findOne(id);
		
	}
}
