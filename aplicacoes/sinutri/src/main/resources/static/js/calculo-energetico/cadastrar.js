$(document).ready(function() {
	$("#inputPesoDesejado").on('keyup', function(){	
		var valorCampo = $("#inputPesoDesejado").val()*30;
		updateValue("#inputVet", valorCampo);
		
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		updateValue("#inputVetReducao", ((vetAjuste*vet)+vet));
		updateAll("#inputGlicidio", "#inputGramasGlicidio", "#inputCaloriasGlicidio", Number(4))
		updateAll("#inputProteina", "#inputGramasProteina", "#inputCaloriasProteina", Number(4))
		updateAll("#inputLipidio" , "#inputGramasLipidio" , "#inputCaloriasLipidio", Number(9))
	});
	
	$("#inputVetAjuste").on('keyup', function(){
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		var valorCampo = (vetAjuste*vet)+vet;
		updateValue("#inputVetReducao", valorCampo);
	});
	
	
	$("#inputGlicidio").on('change', function(){
		var max = 100 - getInputTotal();
		updateMax(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputProteina").on('change', function(){
		var max = 100 - getInputTotal();
		updateMax(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputLipidio").on('change', function(){
		var max = 100 - getInputTotal();
		updateMax(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputGlicidio").on('keyup', function(){
		updateAll("#inputGlicidio", "#inputGramasGlicidio", "#inputCaloriasGlicidio", Number(4))
		
//		var valor = Number($("#inputGlicidio").val());
//		var max = Number($("#inputGlicidio").attr("max"));
//		var vetReducao = Number($("#inputVetReducao").val());		
//		
//		if(valor > max ){			
//			$("#inputGlicidio").val(max);
//			valor = max;
//		}
//		
//		var valorCalorias = vetReducao*valor/100;
//		updateValue("#inputTotal", getInputTotal());
//		updateValue("#inputCaloriasGlicidio", valorCalorias);
//		updateValue("#inputGramasGlicidio", valorCalorias/4);
		
	});
	
	$("#inputProteina").on('keyup', function(){
		updateAll("#inputProteina", "#inputGramasProteina", "#inputCaloriasProteina", Number(4))
//		var valor = Number($("#inputProteina").val());
//		var max = Number($("#inputProteina").attr("max"));
//		var vetReducao = Number($("#inputVetReducao").val());
//		
//		if(valor > max ){			
//			$("#inputProteina").val(max);
//			valor = max;
//		}
//		
//		var valorCalorias = vetReducao*valor/100;		
//		updateValue("#inputTotal", getInputTotal());
//		updateValue("#inputCaloriasProteina", valorCalorias);
//		updateValue("#inputGramasProteina", valorCalorias/4);
		
	});
	
	$("#inputLipidio").on('keyup', function(){
		updateAll("#inputLipidio", "#inputGramasLipidio", "#inputCaloriasLipidio", Number(9));
//		var valor = Number($("#inputLipidio").val());
//		var max = Number($("#inputLipidio").attr("max"));
//		var vetReducao = Number($("#inputVetReducao").val());
//				
//		if(valor > max ){			
//			$("#inputLipidio").val(max);
//			valor = 1max;
//		}
//		
//		var valorCalorias = vetReducao*valor/100;		
//		updateValue("#inputTotal", getInputTotal());	
//		updateValue("#inputCaloriasLipidio", valorCalorias);
//		updateValue("#inputGramasLipidio", valorCalorias/9);
	});
	
	$(".numero-porcao").on('keyup', function(){
		var data_id = $(this).data("id-grupo");
		console.log(data_id);
	})
	
});

function updateValue(nomeCampo, valor){
	$(nomeCampo).val(valor);
}

function updateAll(campo, campoGramas, campoCalorias, fator){
	var valor = Number($(campo).val());
	var max = Number($(campo).attr("max"));
	var vetReducao = Number($("#inputVetReducao").val());
			
	if(valor > max ){			
		$(campo).val(max);
		valor = max;
	}
	
	var valorCalorias = vetReducao*valor/100;		
	updateValue("#inputTotal", getInputTotal());	
	updateValue(campoCalorias, String(valorCalorias) + " cal");
	updateValue(campoGramas, String(valorCalorias/fator) + " g");
		
}

function updateMax(valor){
	var valorAtual = Number($("#inputLipidio").val());	
	setAtributo("#inputLipidio", "max", valorAtual + valor);
	
	var valorAtual = Number($("#inputProteina").val());
	setAtributo("#inputProteina", "max", valorAtual + valor);
	
	var valorAtual = Number($("#inputGlicidio").val());
	setAtributo("#inputGlicidio", "max", valorAtual + valor);
}

function setAtributo(nomeCampo, nomeAtributo, valor){
	$(nomeCampo).attr(nomeAtributo, valor);
}

function getInputTotal(){
	var valorGlicidio = Number($("#inputGlicidio").val());
	var valorProteina = Number($("#inputProteina").val());
	var valorLipidio = Number($("#inputLipidio").val());
	return valorGlicidio+valorLipidio+valorProteina;
}