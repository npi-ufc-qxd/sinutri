function validacaoVazio(modal, nomeLista){
	result = false;
	if(nomeLista != undefined){
		var list = $(modal).find("#"+nomeLista).children(".sn-cloneable");
		if(list.length <= 0){
			result = true;
			$(modal).find("#validate").attr('style', 'display:show');
		}else{
			$(modal).find("#validate").attr('style', 'display:none');
		}
	}
	
	modal.find(".erro").remove();
	modal.find(".validate").each(function(_,e){
		id = $(e).attr("id");
		if($(e).val().length <= 0){
			result = true;
			$(e).after(
					$.parseHTML(
							"<label for=\""+id+"\" class=\"erro sn-textfield__messages sn-error-text\">Campo Obrigatório</label>"
					)
			);
		}
	});
	return result;
}
