package br.ufc.quixada.npi.sinutri.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.Anamnese;
import br.ufc.quixada.npi.sinutri.model.AvaliacaoAntropometrica;
import br.ufc.quixada.npi.sinutri.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Paciente;
import br.ufc.quixada.npi.sinutri.model.PlanoAlimentar;
import br.ufc.quixada.npi.sinutri.model.Prescricao;
import br.ufc.quixada.npi.sinutri.model.Recordatorio;
import br.ufc.quixada.npi.sinutri.model.RefeicaoRecordatorio;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;
import br.ufc.quixada.npi.sinutri.repository.AlimentoRepository;
import br.ufc.quixada.npi.sinutri.repository.AnamneseRepository;
import br.ufc.quixada.npi.sinutri.repository.AvaliacaoAntropometricaRepository;
import br.ufc.quixada.npi.sinutri.repository.InqueritoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.repository.PlanoAlimentarRepository;
import br.ufc.quixada.npi.sinutri.repository.PrescricaoRepository;
import br.ufc.quixada.npi.sinutri.repository.RecordatorioRepository;
import br.ufc.quixada.npi.sinutri.repository.RefeicaoRecordatorioRepository;
import br.ufc.quixada.npi.sinutri.service.ConsultaService;

@Named
public class ConsultaServiceImpl implements ConsultaService {

	@Inject
	private InqueritoAlimentarRepository inqueritoAlimentarRepository;
	
	@Inject
	private PlanoAlimentarRepository planoAlimentarRepository;
	
	@Inject
	private AvaliacaoAntropometricaRepository avaliacaoAntropometricaRepository;
	
	@Inject
	private AlimentoRepository alimentoRepository;
	
	@Inject
	private PrescricaoRepository prescricaoRepository;
	
	@Inject
	private AnamneseRepository anamneseRepository;
	
	@Inject
	private RecordatorioRepository recordatorioRepository;
	
	@Inject
	private RefeicaoRecordatorioRepository refeicaoRecordatorioRepository;
	
	@Override
	public void adicionarPrescricao(Prescricao prescricao){
		prescricaoRepository.save(prescricao);
	}
	
	@Override
	public void excluirPrescricao(Prescricao prescricao){
		prescricaoRepository.delete(prescricao);
	}
	
	@Override
	public void editarPrescricao(Prescricao prescricao){
		prescricaoRepository.save(prescricao);
	}
	
	@Override
	public Prescricao buscarPrescricaoPorId(Long idPrescricao){
		return prescricaoRepository.findOne(idPrescricao);
	}
	
	@Override
	public void adicionarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar, Paciente paciente) {
		inqueritoAlimentar.setPaciente(paciente);
		inqueritoAlimentar.setAtualizadoEm(new Date());
		inqueritoAlimentarRepository.save(inqueritoAlimentar);
	}
	
	@Override
	public void editarInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar) {
		inqueritoAlimentar.setAtualizadoEm(new Date());
		inqueritoAlimentarRepository.save(inqueritoAlimentar);
	}
	
	@Override
	public InqueritoAlimentar buscarInqueritoAlimentarPorId(Long idInqueritoAlimentar) {
		return inqueritoAlimentarRepository.findOne(idInqueritoAlimentar);
	}

	@Override
	public void excluirInqueritoAlimentar(InqueritoAlimentar inqueritoAlimentar) {
		inqueritoAlimentarRepository.delete(inqueritoAlimentar);
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

	@Override
	public void adicionarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}

	@Override
	public void editarAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.save(antropometria);
		
	}
	
	public void excluirAvaliacaoAntropometrica(AvaliacaoAntropometrica antropometria) {
		avaliacaoAntropometricaRepository.delete(antropometria);
	}

	@Override
	public AvaliacaoAntropometrica buscarAvaliacaoAntropometricaPorId(Long id) {
		return avaliacaoAntropometricaRepository.findOne(id);
		
	}

	@Override
	public List<Alimento> buscarAlimentosPorFonte(FonteAlimento fonte) {
		return alimentoRepository.getAlimentosByFonte(fonte);
	}

	@Override
	public void adicionarAnamnese(Anamnese anamnese) {
		anamnese.setAtualizadoEm(new Date());
		anamneseRepository.save(anamnese);
	}

	@Override
	public void editarAnamnese(Anamnese anamnese) {		
		anamneseRepository.save(anamnese);
		
	}

	@Override
	public void excluirAnamnese(Anamnese anamnese) {
		anamneseRepository.delete(anamnese);
	}

	@Override
	public Anamnese buscarAnamnese(Long id) {
		return anamneseRepository.findOne(id);		
	}	
	
}
