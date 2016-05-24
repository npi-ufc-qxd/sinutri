package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.repository.RecordatorioRepository;
import br.ufc.quixada.npi.sinutri.repository.RefeicaoRecordatorioRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;

@Named
public class ConsultaServiceImpl implements ConsultaService {

	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
	@Inject
	private RecordatorioRepository recordatorioRepository;
	
	@Inject
	private RefeicaoRecordatorioRepository refeicaoRecordatorioRepository;
	
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

		
	//Recordatorio	
	@Override
	public void adicionarRecordatorio(Recordatorio recordatorio) {	
		recordatorio.setCriadoEm(new Date());
    	recordatorio.setAtualizadoEm(new Date());
		this.recordatorioRepository.save(recordatorio);
	}
		
	@Override
	public void excluirRecordatorio(Recordatorio recordatorio) {	
			this.recordatorioRepository.delete(recordatorio);
		}
		
	@Override
	public Recordatorio buscarRecordatorio(Long id) {
		return this.recordatorioRepository.findOne(id);		
	}
		
	@Override
	public void editarRecordatorio(Recordatorio recordatorio) {
		recordatorio.setAtualizadoEm(new Date());
		this.recordatorioRepository.save(recordatorio);
	}

	@Override
	public void excluirRefeicaoRecordatorio(RefeicaoRecordatorio refeicaoRecordatorio) {
		this.refeicaoRecordatorioRepository.delete(refeicaoRecordatorio);
	}

	@Override
	public RefeicaoRecordatorio buscarRefeicaoRecordatorio(Long id) {
		return this.refeicaoRecordatorioRepository.findOne(id);
	}
}
