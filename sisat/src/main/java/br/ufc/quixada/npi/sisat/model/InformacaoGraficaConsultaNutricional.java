package br.ufc.quixada.npi.sisat.model;

import java.util.Date;

public class InformacaoGraficaConsultaNutricional {

	private String sexo;

	private Date data;

	private Double altura;

	private Double peso;

	private Double pesoDesejado;

	private Double circunferenciaCintura;

	private Double circunferenciaCinturaDesejada;

	private Double IMC;

	private String classificacaoIMC;

	private String classificacaoCC;
	
	public InformacaoGraficaConsultaNutricional(String sexo, Date data, Double peso, Double altura, Double circunferenciaCintura) {
		this.sexo = sexo;
		this.data = data;
		this.peso = peso;
		this.altura = altura;
		this.IMC = calculaIMC();
		this.classificacaoCC = classificaCircunferenciaCintura();
		this.circunferenciaCintura = circunferenciaCintura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPesoDesejado() {
		return pesoDesejado;
	}

	public void setPesoDesejado(Double pesoDesejado) {
		this.pesoDesejado = pesoDesejado;
	}

	public Double getCircunferenciaCintura() {
		return circunferenciaCintura;
	}

	public void setCircunferenciaCintura(Double circunferenciaCintura) {
		this.circunferenciaCintura = circunferenciaCintura;
	}

	public Double getCircunferenciaCinturaDesejada() {
		return circunferenciaCinturaDesejada;
	}

	public void setCircunferenciaCinturaDesejada(Double circunferenciaCinturaDesejada) {
		this.circunferenciaCinturaDesejada = circunferenciaCinturaDesejada;
	}

	public Double getIMC() {
		this.IMC = calculaIMC();
		return IMC;
	}

	private Double calculaIMC() {
		try {
			double imc = this.peso / (this.altura * this.altura);
			return imc;
		} catch (NullPointerException e) {
			return 0.0;
		}

	}

	public String getClassificacaoIMC() {
		classificacaoIMC = classificaIMC();
		return classificacaoIMC;
	}

	private String classificaIMC() {

		if (this.IMC < 25) {
			if (this.IMC < 17) {
				if (this.IMC < 16) {
					// <16 Desnutrição grau III
					return "Desnutrição grau III";
				} else {
					// 16 a 16,9 Desnutrição grau II
					return "Desnutrição grau II";
				}
			} else {
				if (this.IMC < 18.5) {
					// 17 a 18,4 Desnutrição grau I
					return "Desnutrição grau I";
				} else {
					// 18,5 a 24,9 Eutrofia
					return "Eutrofia";
				}
			}
		} else {
			if (this.IMC < 35) {
				if (this.IMC < 30) {
					// 25 a 29,9 Sobrepeso
					return "Sobrepeso";
				} else {
					// 30 a 34,9 Obesidade grau I
					return "Obesidade grau I";
				}
			} else {
				if (this.IMC < 40) {
					// 35 a 39,9 Obesidade grau II
					return "Obesidade grau  II";
				} else {
					// ≥ 40 Obesidade grau III
					return "Obesidade grau III";
				}
			}
		}

	}

	public String getClassificacaoCC() {
		classificacaoCC = this.classificaCircunferenciaCintura();
		return classificacaoCC;
	}

	public void setClassificacaoCC(String classificacaoCC) {
		this.classificacaoCC = classificacaoCC;
	}

	private String classificaCircunferenciaCintura() {

		if (this.getCircunferenciaCintura() == null) {
			return "";
		}

		Double circunferencia = this.getCircunferenciaCintura() / 100;

		if (this.sexo != null) {
			if (this.sexo.equalsIgnoreCase("m")) {
				if (circunferencia < 0.94) {
					return "Normal";
				} else {
					if (circunferencia < 1.02) {
						return "Risco aumentado";
					} else {
						return "Risco muito aumentado";
					}
				}
			} else if (this.sexo.equalsIgnoreCase("f")) {
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
		} else {
			return "É necessario o sexo para definir a classificação de circurferência";
		}
		return "";
	}

	public void setIMC(Double iMC) {
		this.IMC = iMC;
	}

	public void setClassificacaoIMC(String classificacaoIMC) {
		this.classificacaoIMC = classificacaoIMC;
	}

}
