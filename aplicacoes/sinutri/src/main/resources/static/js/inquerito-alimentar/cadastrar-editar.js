$(document).ready(function() {
	$( "#cancelar" ).click(function(event) {
   		var dialog = sn_base.doRegistryDialog({
       		title: "Você realmente deseja descartar as alterações?", 
       		dialog: "#modal-cancelar", 
       		buttons: [
            		   {
                  		label: "SIM",
                  		attrs: {href: $(this).attr("href")}, 
                  		action: function() {
                      	dialog.close();
                  		}
              		 }, 
              	 {
                   	label: "NÃO",
                   	action: function() {
                       dialog.close();
                   	}
				}
       		]
		});    	   

   		dialog.showModal();
   		event.preventDefault();
	});
	
	camposCheckBox = ['AguaGosta', 'AvesGosta', 'BebidasAlcoolicasGosta', 'BovinaGosta', 'CereaisGosta', 'DocesGosta', 'FrutasGosta', 'GaseificadasGosta', 'InfusoesGosta', 'LeguminosasGosta', 'LeiteDerivadosGosta', 'ManteigaGosta', 'MargarinaGosta', 'MassasGosta', 'OleoGosta', 'OvosGosta', 'PeixeGosta', 'SucoGosta', 'ToucinhoBaconGosta', 'VegetaisCozidosGosta', 'VegetaisCrusGosta', 'ViscerasGosta']
	for (var i = 0; i < camposCheckBox.length; i++) {
		checkChange(camposCheckBox[i])
	}
});

//Usa o sufixo do id do inputText para ocultar o inputText e o label
function esconderCampo(nome) {
	nomeInput = '#inputText'+nome
	$(nomeInput).val('')
	$(nomeInput).attr('disabled', 'true');
	divInput = $(nomeInput).parent();
	divInput.attr('style', 'display:none');
	
	nomeSelect = '#select'+nome
	$(nomeSelect).prop('selectedIndex', 0);
	$(nomeSelect).attr('disabled', 'true');
	divSelect = $(nomeSelect).parent();
	divSelect.attr('style', 'display:none');
}
//Usa o sufixo do id do inputText para mostrar o inputText e o label
function mostrarCampo(nome){
	nomeInput = '#inputText'+nome
	$(nomeInput).removeAttr('disabled')
	div = $(nomeInput).parent();
	div.attr('style', 'display:show');
	
	nomeSelect = '#select'+nome
	$(nomeSelect).removeAttr('disabled');
	divSelect = $(nomeSelect).parent();
	divSelect.attr('style', 'display:show');
}


//oculta/mostra o inputText baseado no valor do checkBox
function checkChange(nome) {
	check_nome = "#check"+nome;
	checkbox = $(check_nome);
	if (checkbox.is(":checked")){
		mostrarCampo(nome);
	}else{
		esconderCampo(nome);
	}
}