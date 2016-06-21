//Usa o sufixo do id do inputText para ocultar o inputText e o label
function esconderCampo(nome) {
	nome = "#inputText"+nome;
	$(nome).val("");
	$(nome).attr("disabled", "true");
	campo = $(nome).parent();
	campo.attr("style", "display:none");	
}
//Usa o sufixo do id do inputText para mostrar o inputText e o label
function mostrarCampo(nome){
	var nome = "#inputText"+nome;
	$(nome).removeAttr("disabled");
	var campo = $(nome).parent();
	campo.attr("style", "display:show");	
}

function desabilitarCampo(nome) {
	var nome = "#inputText"+nome;
	var campo = $(nome);
	campo.val("");
	campo.attr("disabled", "true");	
}

function habilitarCampo(nome){
	var nome = "#inputText"+nome;
	var campo = $(nome);
	campo.removeAttr("disabled");	
}

function existeComentario(){
	return "Não há comentário!";
}

//oculta/mostra o inputText baseado no valor do checkBox
function checkChange(nome) {
	var check_nome = "#check"+nome;
	var checkbox = $(check_nome);
	if (checkbox.is(":checked")){
		mostrarCampo(nome);
	}else{
		esconderCampo(nome);
	}
}

function selectChange(nome){
	var select = $("#select"+nome);
	if(select.val() === "")
		desabilitarCampo(nome);
	else
		habilitarCampo(nome);
}
//Oculta todos os campos de comentários
$(document).ready(function() {	
	var camposCheckBox = ["AtividadeFisica","DormeBem","BebidaAlcoolica","Medicamento","Mastigacao","Disfagia", "Odinofagia","Pirose","Nausea","Vomito","Diarreia","Constipacao","Alergia","Intolerancia"];
	for (var i = 0; i < camposCheckBox.length; i++) {
		checkChange(camposCheckBox[i]);
	}
	var camposSelect = ["Apetite","SistemaUrinario","SistemaGastrointestinal"];
	for (var i = 0; i < camposSelect.length; i++) {
		selectChange(camposSelect[i]);
	}
	
	$( "#bt-cancelar" ).click(function(event) {
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
});
