$(document).ready(function() {
	$("#inputPesoDesejado").on('keyup', function(){	
		var valorCampo = $("#inputPesoDesejado").val()*30;
		updateValue("#inputVet", valorCampo);
		
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		updateValue("#inputVetReducao", ((vetAjuste*vet)+vet));
	});
	
	$("#inputVetAjuste").on('keyup', function(){
		var vet = Number($("#inputVet").val());
		var vetAjuste = Number($("#inputVetAjuste").val());
		var valorCampo = (vetAjuste*vet)+vet;
		updateValue("#inputVetReducao", valorCampo);
	});
	
	$("#inputGlicidio").on('keyup', function(){
		var ultimoDigito = $("#inputGlicidio").val().slice(0,-1);
		console.log(ultimoDigito);
		
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputProteina").on('keyup', function(){
		updateValue("#inputTotal", getInputTotal());
	});
	
	$("#inputLipidio").on('keyup', function(){		
		updateValue("#inputTotal", getInputTotal());
	});
	
});

function updateValue(nomeCampo, valor){
	$(nomeCampo).val(valor);
}

function getInputTotal(){
	var valorGlicidio = Number($("#inputGlicidio").val());
	var valorProteina = Number($("#inputProteina").val());
	var valorLipidio = Number($("#inputLipidio").val());
	return valorGlicidio+valorLipidio+valorProteina;
}