function validacaoVazio(modal, nomeLista){
	result = false;
	if(nomeLista != undefined){
		var list = $(modal).find("#"+nomeLista).children(".sn-cloneable");
		if(list.length <= 0){
			result = true;
			alert("entrou");
			$(modal).find("#validate").attr('style', 'display:none');
		}else{
			$(modal).find("#validate").attr('style', 'display:show');
		}
	}
	
	modal.find(".sn-error-text").remove();
	modal.find(".validate").each(function(_,e){
		id = $(e).attr("id");
		console.log(e);
		if($(e).val().length <= 0){
			result = true;
			$(e).after(
					$.parseHTML(
							"<label for=\""+id+"\" class=\"sn-textfield__messages sn-error-text\">Campo Obrigatório</label>"
					)
			);
		}
	});
	return result;
}
