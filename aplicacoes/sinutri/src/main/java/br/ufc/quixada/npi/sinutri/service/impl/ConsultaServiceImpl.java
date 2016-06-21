package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.AvaliacaoLaboratorial;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoLaboratorialRepository;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;

@Named
public class ConsultaServiceImpl implements ConsultaService {
	
	@Inject
	private AvaliacaoLaboratorialRepository avaliacaoLaboratorialRepository;
	
	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
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
}
