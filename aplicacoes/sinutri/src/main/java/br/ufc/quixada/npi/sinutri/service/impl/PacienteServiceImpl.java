package br.ufc.quixada.npi.sinutri.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Pessoa;
import br.ufc.quixada.npi.sinutri.repository.PacienteRepository;
import br.ufc.quixada.npi.sinutri.service.PacienteService;

@Named
public class PacienteServiceImpl implements PacienteService{

	@Inject
	private PacienteRepository pacienteRepository;
	
	@Override
	public Paciente buscarPacientePorId(Long idPaciente) {
		return pacienteRepository.findOne(idPaciente);
	}

	@Override
	public void adicionarPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);	
	}

	@Override
	public void editarPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);
		
	}

	@Override
	public void excluirPaciente(Paciente paciente) {
		pacienteRepository.delete(paciente);
		
	}
	
}
