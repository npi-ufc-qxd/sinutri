package br.ufc.quixada.npi.sisat.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;
import br.ufc.quixada.npi.sisat.model.enuns.ClassificacaoExame;
import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;

@Named
public class ConsultaNutricionalValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ConsultaNutricional.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ConsultaNutricional consultaNutricional = (ConsultaNutricional) target;	

		validarExameEClassificacao(errors, consultaNutricional.getCt(), "ct", consultaNutricional.getClassificacaoCt(), "classificacaoCt");

		validarExameEClassificacao(errors, consultaNutricional.getGlicemia(), "glicemia", consultaNutricional.getClassificacaoGlicemia(), "classificacaoGlicemia");
		
		validarExameEClassificacao(errors, consultaNutricional.getHb(), "hb", consultaNutricional.getClassificacaoHb(), "classificacaoHb");
		
		validarExameEClassificacao(errors, consultaNutricional.getHdlc(), "hdlc", consultaNutricional.getClassificacaoHdlc(), "classificacaoHdlc");
		
		validarExameEClassificacao(errors, consultaNutricional.getLdlc(), "ldlc", consultaNutricional.getClassificacaoLdlc(), "classificacaoLdlc");
		
		validarExameEClassificacao(errors, consultaNutricional.getTg(), "tg", consultaNutricional.getClassificacaoTg(), "classificacaoTg");
		
		validarExameEClassificacao(errors, consultaNutricional.getTgo(), "tgo", consultaNutricional.getClassificacaoTgo(), "classificacaoTgo");
		
		validarExameEClassificacao(errors, consultaNutricional.getTgp(), "tgp", consultaNutricional.getClassificacaoTgp(), "classificacaoTgp");

		validarPatologias(consultaNutricional, errors);
		
		if (consultaNutricional.isAtividadeFisica()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "atividadeFisicaComentario", "atividadeFisicaComentario", "Informe a atividade fisica");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "atividadeFisicaFrequenciaSemanal", "atividadeFisicaFrequenciaSemanal", "Informe a frequência semanal da atividade fisica");
		}
		
		if (consultaNutricional.isBebidaAlcoolica()) {
			validarComentario(errors, consultaNutricional.getBebidaAlcoolicaComentario(), "bebidaAlcoolicaComentario", "Informe a atividade a bebida");
			validarFrequenciaSemanal(errors, consultaNutricional.getBebidaAlcoolicaFrequenciaSemanal(), "bebidaAlcoolicaFrequenciaSemanal", "Informe a frequência de consumo de bebida alcoolica");
		}
		
		if (consultaNutricional.isCigarro()) {
			validarComentario(errors, consultaNutricional.getCigarroComentario(), "cigarroComentario", "Adicione algum comentário");
			validarFrequenciaSemanal(errors, consultaNutricional.getCigarroFrequenciaSemanal(), "cigarroFrequenciaSemanal", "Informe a frequência de consumo de cigarro");
		}
		
	}

	private void validarFrequenciaSemanal(Errors errors, Frequencia frequenciaSemanal, String campo, String message) {
		if(frequenciaSemanal == null){
			errors.rejectValue(campo, campo, message);
		}
	}

	private void validarComentario(Errors errors, String comentario, String campo, String message) {
		if(comentario.isEmpty()){
			errors.rejectValue(campo, campo, message);
		}
	}
	
	private void validarPatologias(ConsultaNutricional consultaNutricional, Errors errors) {
		if(consultaNutricional.isAlergia()){
			validarComentario(errors, consultaNutricional.getAlergiaComentario(), "alergiaComentario", "Informe a alergia alimentar");
		}
		
		if (consultaNutricional.isConstipacao()) {
			validarComentario(errors, consultaNutricional.getConstipacaoComentario(), "constipacaoComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isDiarreia()) {
			validarComentario(errors, consultaNutricional.getDiarreiaComentario(), "diarreiaComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isDisfagia()) {
			validarComentario(errors, consultaNutricional.getDisfagiaComentario(), "disfagiaComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isMastigacao()) {
			validarComentario(errors, consultaNutricional.getMastigacaoComentario(), "mastigacaoComentario", "Informe o comentario");
		}

		if (consultaNutricional.isMedicamento()) {
			validarComentario(errors, consultaNutricional.getMedicamentoComentario(), "medicamentoComentario", "Informe o medicamento");
		}
		
		if (consultaNutricional.isNausea()) {
			validarComentario(errors, consultaNutricional.getNauseaComentario(), "nauseaComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isOdinofagia()) {
			validarComentario(errors, consultaNutricional.getOdinofagiaComentario(), "odinofagiaComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isOutrasPatologias()) {
			validarComentario(errors, consultaNutricional.getOutrasPatologiasComentario(), "outrasPatologiasComentario", "Informe as outras patologias");
		}
		
		if (consultaNutricional.isPirose()) {
			validarComentario(errors, consultaNutricional.getPiroseComentario(), "piroseComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isRegurgitacao()) {
			validarComentario(errors, consultaNutricional.getRegurgitacaoComentario(), "regurgitacaoComentario", "Informe o comentario");
		}
		
		if (consultaNutricional.isVomito()) {
			validarComentario(errors, consultaNutricional.getVomitoComentario(), "vomitoComentario", "Informe o comentario");
		}
	}

	private void validarExameEClassificacao(Errors errors, Double exame, String campoExame, ClassificacaoExame classificacao, String campoClassificacao) {
		if (exame != null && classificacao == null) {
			if(exame.doubleValue() < 1){
				errors.rejectValue(campoExame, campoExame, "O valor minino do exame é 1");
			}
			errors.rejectValue(campoClassificacao, campoClassificacao, "Informe a classificação");
		}

		if ( (exame == null || exame.doubleValue() < 1) && classificacao != null) {
			errors.rejectValue(campoExame, campoExame, "O valor minino do exame é 1");
		}
	}
	
	
	
}
