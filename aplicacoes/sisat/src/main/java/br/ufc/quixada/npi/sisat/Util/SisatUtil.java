package br.ufc.quixada.npi.sisat.Util;

import br.ufc.quixada.npi.sisat.model.ConsultaNutricional;

public class SisatUtil {
	
	public static double calculaIMC(ConsultaNutricional consulta){
		
		try{
			double peso = consulta.getPeso();
			double altura = consulta.getPaciente().getAltura();
			double imc = peso / (altura * altura);
			return imc;
		}catch(NullPointerException e){
			return 0.0;
		}
		
	}
	
	public static String classificaIMC(double imc){
		
		if (imc < 25) {
			if (imc < 17) {
				if (imc < 16) {
					// <16 Desnutrição grau III
					return "Desnutrição grau III";
				} else {
					// 16 a 16,9 Desnutrição grau II
					return "Desnutrição grau II";
				}
			} else {
				if (imc < 18.5) {
					// 17 a 18,4 Desnutrição grau I
					return "Desnutrição grau I";
				} else {
					// 18,5 a 24,9 Eutrofia
					return "Eutrofia";
				}
			}
		} else {
			if (imc < 35) {
				if (imc < 30) {
					// 25 a 29,9 Sobrepeso
					return "Sobrepeso";
				} else {
					// 30 a 34,9 Obesidade grau I
					return "Obesidade grau I";
				}
			} else {
				if (imc < 40) {
					// 35 a 39,9 Obesidade grau II
					return "Obesidade grau  II";
				} else {
					// ≥ 40 Obesidade grau III
					return "Obesidade grau III";
				}
			}
		}
		
		
	}
	
	public static String classificaCircunferenciaCintura(ConsultaNutricional consulta){
		
		if (consulta.getCircunferenciaCintura() == null) {
			return "";
		}
		
		Double circunferencia = consulta.getCircunferenciaCintura();
		String sexo = consulta.getPaciente().getPessoa().getSexo();
		
		if(sexo != null) {
			if (sexo.equalsIgnoreCase("m")) {
				if (circunferencia < 0.94) {
					return "Normal";
				} else {
					if (circunferencia < 1.02) {
						return "Risco aumentado";
					} else {
						return "Risco muito aumentado";
					}
				}
			} else if (sexo.equalsIgnoreCase("f")) {
				if (circunferencia < 0.80) {
					return "Normal";
				} else {
					if (circunferencia < 0.88) {
						return "Risco aumentado";
					} else {
						return "Risco muito aumentado";
					}
				}
			}
		}else {
			return "Erro - Sexo da paciente não está indefinido";
		}
		return "";
	}

}
