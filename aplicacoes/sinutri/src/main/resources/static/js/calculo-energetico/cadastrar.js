$(document).ready(function() {
	$("#inputPesoDesejado").on('keyup change', function(){	
		var valorCampo = $("#inputPesoDesejado").val()*30;
		updateValue("#inputVet", valorCampo);
		
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		updateValue("#inputVetReducao", ((vetAjuste*vet)+vet));
		updateCampos();
	});
	
	$("#inputVetAjuste").on('keyup change', function(){
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		var valorCampo = (vetAjuste*vet)+vet;
		updateValue("#inputVetReducao", valorCampo);
		updateCampos();
	});
	
	
	$("#inputGlicidio").on('change', function(){
		var max = 100 - getInputTotal();
		updateMaxCard1(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputProteina").on('change', function(){
		var max = 100 - getInputTotal();
		updateMaxCard1(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputLipidio").on('change', function(){
		var max = 100 - getInputTotal();
		updateMaxCard1(max);
		updateValue("#inputTotal", getInputTotal());
	});
	
	$(".porcao").on('change', function(){
		var data_id = $(this).data("id-grupo");
		var max = $("input.numero-porcao[data-id-grupo="+data_id+"]").val();
		max = max - getTotalQtdPorcao(data_id);
		updateMaxCard3(data_id, max);

	});
	
	$("#inputGlicidio").on('keyup', function(){
		updateAll("#inputGlicidio", "#inputGramasGlicidio", "#inputCaloriasGlicidio", Number(4));
	});
	
	$("#inputProteina").on('keyup', function(){
		updateAll("#inputProteina", "#inputGramasProteina", "#inputCaloriasProteina", Number(4));
	});
	
	$("#inputLipidio").on('keyup', function(){
		updateAll("#inputLipidio", "#inputGramasLipidio", "#inputCaloriasLipidio", Number(9));
	});
	

	$(".numero-porcao").on('keyup change', function(){
		var data_id = $(this).data("id-grupo");		
		var valor = $(this).val();
		zerarQtdPorcao(data_id);
		updateMaxCard3(data_id, valor);
		calcularGlicidio();
		calcularLipidio();
		calcularProteina();
	});
	
	$(".porcao").on('keyup change', function(){
		var data_id = $(this).data("id-grupo");
		var valor = $(this).val();
		var max = Number($(this).attr("max"));
		
		if(valor>max){
			valor = max;
		}
		$(this).val(valor);
		var somaCampos = getTotalQtdPorcao(data_id);
		var qtd_porcao = $("input.numero-porcao[data-id-grupo="+data_id+"]").val();
		valor = qtd_porcao - somaCampos;
		$("input.porcao-distribuicao[data-id-grupo="+data_id+"]").val(valor);
		
	});
	
	$(".glicidio").on("keyup change", function(){
		calcularGlicidio();
	});

	$(".proteina").on("keyup change", function(){
		calcularProteina();
	});
	
	$(".lipidio").on("keyup change", function(){
		calcularLipidio();
	});
	
});

function calcularGlicidio(){
	$("#inputTotalGlicidio").val(getTotalValor(".glicidio"));
	$("#inputPorcentagemGlicidio").val(getTotalPorcentagem(".glicidio", "#inputGramasGlicidio"));
}

function calcularProteina(){
	$("#inputTotalProteina").val(getTotalValor(".proteina"));
	$("#inputPorcentagemProteina").val(getTotalPorcentagem(".proteina", "#inputGramasProteina"));
}

function calcularLipidio(){
	$("#inputTotalLipidio").val(getTotalValor(".lipidio"));
	$("#inputPorcentagemLipidio").val(getTotalPorcentagem(".lipidio", "#inputGramasLipidio"));
}

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
	
	var valorCalorias = vetReducao*valor/Number(100.0);		
	updateValue("#inputTotal", getInputTotal());	
	updateValue(campoCalorias, valorCalorias);
	updateValue(campoGramas, String(valorCalorias/Number(fator)));
		
}

function updateCampos(){
	updateAll("#inputGlicidio", "#inputGramasGlicidio", "#inputCaloriasGlicidio", Number(4))
	updateAll("#inputProteina", "#inputGramasProteina", "#inputCaloriasProteina", Number(4))
	updateAll("#inputLipidio" , "#inputGramasLipidio" , "#inputCaloriasLipidio", Number(9))
	$("#inputTotalGlicidio").val(getTotalValor(".glicidio"));
	$("#inputPorcentagemGlicidio").val(getTotalPorcentagem(".glicidio", "#inputGramasGlicidio"));
	$("#inputTotalProteina").val(getTotalValor(".proteina"));
	$("#inputPorcentagemProteina").val(getTotalPorcentagem(".proteina", "#inputGramasProteina"));
	$("#inputTotalLipidio").val(getTotalValor(".lipidio"));
	$("#inputPorcentagemLipidio").val(getTotalPorcentagem(".lipidio", "#inputGramasLipidio"));
}

function updateMaxCard1(valor){
	updateMax("#inputLipidio", valor);
	updateMax("#inputProteina", valor);
	updateMax("#inputGlicidio", valor);
}

function updateMax(campo, valor){
	var valorAtual = Number($(campo).val());	
	setAtributo(campo, "max", valorAtual + valor);	
}

function setAtributo(nomeCampo, nomeAtributo, valor){
	$(nomeCampo).attr(nomeAtributo, valor);
}

function getInputTotal(){
	var valorGlicidio = Number($("#inputGlicidio").val());
	var valorProteina = Number($("#inputProteina").val());
	var valorLipidio  = Number($("#inputLipidio").val());
	
	return valorGlicidio + valorLipidio + valorProteina;
}

function updateMaxCard3(data_id, max){
	updateMax("input.porcao-desjejum[data-id-grupo="+data_id+"]", max);
	updateMax("input.porcao-cafe-manha[data-id-grupo="+data_id+"]", max);
	updateMax("input.porcao-almoco[data-id-grupo="+data_id+"]", max);
	updateMax("input.porcao-lanche-tarde[data-id-grupo="+data_id+"]", max);
	updateMax("input.porcao-jantar[data-id-grupo="+data_id+"]", max);
	updateMax("input.porcao-colacao[data-id-grupo="+data_id+"]", max);
}

function zerarQtdPorcao(index){
	$("input.porcao-desjejum[data-id-grupo="+index+"]").val(0);
	$("input.porcao-cafe-manha[data-id-grupo="+index+"]").val(0);
	$("input.porcao-almoco[data-id-grupo="+index+"]").val(0);
	$("input.porcao-lanche-tarde[data-id-grupo="+index+"]").val(0);
	$("input.porcao-jantar[data-id-grupo="+index+"]").val(0);
	$("input.porcao-colacao[data-id-grupo="+index+"]").val(0);
	var max = $("input.numero-porcao[data-id-grupo="+index+"]").val();
	$("input.porcao-distribuicao[data-id-grupo="+index+"]").val(max);
}

function getTotalQtdPorcao(index){
	var porcaoDesjejum    = Number($("input.porcao-desjejum[data-id-grupo="+index+"]").val());
	var porcaoCafeManha   = Number($("input.porcao-cafe-manha[data-id-grupo="+index+"]").val());
	var porcaoAlmoco      = Number($("input.porcao-almoco[data-id-grupo="+index+"]").val());
	var porcaoLancheTarde = Number($("input.porcao-lanche-tarde[data-id-grupo="+index+"]").val());
	var porcaoJantar      = Number($("input.porcao-jantar[data-id-grupo="+index+"]").val());
	var porcaoColacao     = Number($("input.porcao-colacao[data-id-grupo="+index+"]").val());
	
	return porcaoDesjejum + porcaoCafeManha + porcaoAlmoco + porcaoLancheTarde + porcaoJantar + porcaoColacao;
}

function getTotalValor(classe){
	var total = Number(0);
	var porcao;
	var data_id;
	$(classe).each(function(){
		data_id = $(this).data("id-grupo");
		porcao =  Number($("input.numero-porcao[data-id-grupo="+data_id+"]").val());
		total = total + (Number($(this).val()) * porcao);
	});
	return total;
}

function getTotalPorcentagem(classe, campo){
	var total = Number(getTotalValor(classe));
	console.log(campo);
	console.log(total);
	console.log(Number($(campo).val()));
	console.log();
	total = total/Number($(campo).val());
	return total*Number(100.0);
}