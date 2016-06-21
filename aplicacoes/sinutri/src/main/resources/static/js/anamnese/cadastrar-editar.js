//Oculta todos os campos de comentários
$(document).ready(function() {	
	camposCheckBox = ['AtividadeFisica','DormeBem','BebidaAlcoolica','Medicamento','Mastigacao','Disfagia', 'Odinofagia','Pirose','Nausea','Vomito','Diarreia','Constipacao','Alergia','Intolerancia']
	for (var i = 0; i < camposCheckBox.length; i++) {
		checkChange(camposCheckBox[i])
	}
	camposSelect = ['Apetite','SistemaUrinario','SistemaGastrointestinal']
	for (var i = 0; i < camposSelect.length; i++) {
		selectChange(camposSelect[i])
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
//Usa o sufixo do id do inputText para ocultar o inputText e o label
function esconderCampo(nome) {
	nome = '#inputText'+nome
	$(nome).val('')
	$(nome).attr('disabled', 'true');
	campo = $(nome).parent();
	campo.attr('style', 'display:none');	
}
//Usa o sufixo do id do inputText para mostrar o inputText e o label
function mostrarCampo(nome){
	nome = '#inputText'+nome
	$(nome).removeAttr('disabled')
	campo = $(nome).parent();
	campo.attr('style', 'display:show');	
}

function desabilitarCampo(nome) {
	nome = '#inputText'+nome
	campo = $(nome);
	campo.val('')
	campo.attr('disabled', 'true');	
}

function habilitarCampo(nome){
	nome = '#inputText'+nome
	campo = $(nome);
	campo.removeAttr('disabled');	
}

function existeComentario(){
	console.log(">><<\n\n")
	return 'Não há comentário!';
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

function selectChange(nome){
	select = $("#select"+nome)
	if(select.val() === "")
		desabilitarCampo(nome)
	else
		habilitarCampo(nome)
}