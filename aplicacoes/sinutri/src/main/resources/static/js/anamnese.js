//Oculta todos os campos de comentários
$(document).ready(function() {	
	campos = ['AtividadeFisica','DormeBem','BebidaAlcoolica','Medicamento','Mastigacao','Disfagia', 'Odinofagia','Pirose','Nausea','Vomito','Diarreia','Constipacao','Alergia','Intolerancia']
	for (var i = 0; i < campos.length; i++) {
		checkChange(campos[i])
	}
});
//Usa o sufixo do id do inputText para ocultar o inputText e o label
function esconderCampo(nome) {
	nome = '#inputText'+nome
	$(nome).val('')
	campo = $(nome).parent();
	campo.attr('style', 'display:none');	
}
//Usa o sufixo do id do inputText para mostrar o inputText e o label
function mostrarCampo(nome){
	nome = '#inputText'+nome
	campo = $(nome).parent();
	campo.attr('style', 'display:show');	
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