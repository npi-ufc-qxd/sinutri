$(document).ready(function() {
	calcularVet();
	calcularVetComReducao();
	updateCampos();
	
	$("#inputPesoDesejado").on('keyup change', function(){	
		calcularVet();
		calcularVetComReducao();
		updateCampos();
	});
	
	$("#inputFatorAtividade").on('keyup change', function(){	
		calcularVet();
		calcularVetComReducao();
		updateCampos();
	});
	
	$("#inputVetAjuste").on('keyup change', function(){
		calcularVetComReducao();
		updateCampos();
	});

	$(".porcao").on('change', function(){
		var data_id = $(this).data("id-grupo");
		var max = $("input.numero-porcao[data-id-grupo="+data_id+"]").val();
		max = max - getTotalQtdPorcao(data_id);
		updateMaxCard3(data_id, max);

	});
	
	$("#inputGlicidio").on('keyup change', function(){
		updateAll("#inputGlicidio", "#inputGramasGlicidio", "#inputCaloriasGlicidio", Number(4));
		validarPorcentagem();
		calcularGlicidio();
	});
	
	$("#inputProteina").on('keyup change', function(){
		updateAll("#inputProteina", "#inputGramasProteina", "#inputCaloriasProteina", Number(4));
		validarPorcentagem();
		calcularProteina();
	});
	
	$("#inputLipidio").on('keyup change', function(){
		updateAll("#inputLipidio", "#inputGramasLipidio", "#inputCaloriasLipidio", Number(9));
		validarPorcentagem();
		calcularLipidio();
	});

	$(".numero-porcao").on('keyup change', function(){
		validarNumero(this, "");
		var data_id = $(this).data("id-grupo");		
		var valor = $(this).val();		
		zerarQtdPorcao(data_id);
		updateMaxCard3(data_id, valor);
		calcularGlicidio();
		calcularLipidio();
		calcularProteina();
	});
	
	$(".porcao").on('keyup change', function(){
		validarNumero(this, "");
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

function validarPorcentagem() {
	var max = Number(100) - getInputTotal();
	updateMaxCard1(max);
	updateValue("#inputTotal", getInputTotal());
}

function calcularVet() {
	var peso = Number($("#inputPesoDesejado").val())
	var fator = Number($("#inputFatorAtividade").val());
	updateValue("#inputVet", peso * fator);
}

function calcularVetComReducao() {
	var vet = Number($("#inputVet").val());
	var vetAjuste = Number($("#inputVetAjuste").val()/100);
	updateValue("#inputVetReducao", (vet - (vetAjuste*vet)));
}

function calcularGlicidio(){
	updateValue("#inputTotalGlicidio", getTotalValor(".glicidio"));
	updateValue("#inputPorcentagemGlicidio", getTotalPorcentagem(".glicidio", "#inputGramasGlicidio"));
}

function calcularProteina(){
	updateValue("#inputTotalProteina", getTotalValor(".proteina"));
	updateValue("#inputPorcentagemProteina", getTotalPorcentagem(".proteina", "#inputGramasProteina"));
}

function calcularLipidio(){
	updateValue("#inputTotalLipidio", getTotalValor(".lipidio"));
	updateValue("#inputPorcentagemLipidio", getTotalPorcentagem(".lipidio", "#inputGramasLipidio"));
}

function updateValue(nomeCampo, valor){	
	if(isNaN(valor) || valor==Infinity){
		$(nomeCampo).val("0.00");
	}else{
		$(nomeCampo).val(Number(valor).toFixed(2));
	}
}

function updateAll(campo, campoGramas, campoCalorias, fator){
	var valor = Number($(campo).val());	
	var max = Number($(campo).attr("max"));
	if(!validarNumero(campo, max)) return;
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
	calcularGlicidio();
	calcularLipidio();
	calcularProteina();
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
	
	return Number(valorGlicidio + valorLipidio + valorProteina);
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
	total = total/Number($(campo).val());
	return total*Number(100.0);
}

function validarNumero(campo, valorPadrao){
	$(campo).val($(campo).val());
	var valor = Number($(campo).val());	
	if(valor < 0){
		$(campo).val(valorPadrao);
		return false;
	}
	return true;
}