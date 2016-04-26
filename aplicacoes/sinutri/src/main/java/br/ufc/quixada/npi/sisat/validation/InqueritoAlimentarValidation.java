package br.ufc.quixada.npi.sisat.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.ufc.quixada.npi.sisat.model.InqueritoAlimentar;
import br.ufc.quixada.npi.sisat.model.enuns.Frequencia;

public class InqueritoAlimentarValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return InqueritoAlimentar.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InqueritoAlimentar inqueritoAlimentar = (InqueritoAlimentar) target;
		
		if(inqueritoAlimentar.isAguaGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getAguaAnotacao(), "aguaAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getAguaFrequenciaSemanal(), "aguaFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isAvesGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getAvesAnotacao(), "avesAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getAvesFrequenciaSemanal(), "avesFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isBebidasAlcoolicasGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getBebidasAlcoolicasAnotacao(), "bebidaAlcoolicasAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getBebidasAlcoolicasFrequenciaSemanal(), "bebidaAlcoolicasFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isBovinaGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getBovinaAnotacao(), "bovinaAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getBovinaFrequenciaSemanal(), "bovinaFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isCereaisGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getCereaisAnotacao(), "cereaisAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getCereaisFrequenciaSemanal(), "cereaisFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isDocesGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getDocesAnotacao(), "docesAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getDocesFrequenciaSemanal(), "docesFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isFrutasGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getFrutasAnotacao(), "frutasAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getFrutasFrequenciaSemanal(), "frutasFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isGaseificadasGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getGaseificadasAnotacao(), "gaseificadasAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getGaseificadasFrequenciaSemanal(), "gaseificadasFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isInfusoesGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getInfusoesAnotacao(), "infusoesAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getInfusoesFrequenciaSemanal(), "infusoesFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isLeguminosasGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getLeguminosasAnotacao(), "leguminosasAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getLeguminosasFrequenciaSemanal(), "leguminosasFrequenciaSemanal", "Campo obrigatório");
		}
		
		if(inqueritoAlimentar.isLeiteDerivadosGosta()){
			validarAnotacao(errors, inqueritoAlimentar.getLeiteDerivadosAnotacao(), "leiteDerivadosAnotacao", "Campo obrigatório");
			validarFrequencia(errors, inqueritoAlimentar.getLeiteDerivadosFrequenciaSemanal(), "leiteDerivadosFrequenciaSemanal", "Campo obrigatório");
		}
	}
	
	public void validarAnotacao(Errors errors, String anotacao, String campo, String mensagem){
		if(anotacao.isEmpty()){
			errors.rejectValue(campo, campo, mensagem);
		}
	}
	
	public void validarFrequencia(Errors errors, Frequencia frequencia, String campo, String mensagem){
		if(frequencia == null){
			errors.rejectValue(campo, campo, mensagem);
		}
	}
	
	

}
