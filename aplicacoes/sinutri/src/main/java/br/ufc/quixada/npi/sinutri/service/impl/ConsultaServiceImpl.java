package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.repository.PlanoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;

@Named
public class ConsultaServiceImpl implements ConsultaService {

	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
	@Inject
	private PlanoAlimentarRepository planoAlimentarRepository;
	
	
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
	public void adicionarPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		planoAlimentar.setAtualizadoEm(new Date());
		planoAlimentarRepository.save(planoAlimentar);
	}

	@Override
	public PlanoAlimentar buscarPlanoAlimentarPorId(Long idPlanoAlimentar) {
		return planoAlimentarRepository.findOne(idPlanoAlimentar);
	}

	@Override
	public void editarPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		planoAlimentar.setAtualizadoEm(new Date());
		planoAlimentarRepository.save(planoAlimentar);
		
	}

	@Override
	public void excluirPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		planoAlimentarRepository.delete(planoAlimentar);
		
	}
	
}
