$(document).ready(function() {
	$("#inputPesoDesejado").on('keyup', function(){			
		$("#inputVet").val($("#inputPesoDesejado").val()*30);
	});
	
	$("#inputVetAjuste").on('keyup', function(){
		var vet = $("#inputVet").val();
		var vetAjuste = $("#inputVetAjuste").val();
		console.log("");
		console.log(vet);
		console.log(vetAjuste);
		$("#inputVetReducao").val((vetAjuste*vet));
	});
	
});