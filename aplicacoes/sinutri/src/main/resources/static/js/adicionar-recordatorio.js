$(function() 
{	
	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		var dialog = null;
		
		var dynamicList = $(".sn-list-refeicoes").dynamicList({
			cloneableElement: ".sn-cloneable",
			removeButton:     ".sn-refeicao-remover",
			editButton:       ".sn-refeicao-editar",
			onItemEdit:		  function(el, index) {
				if( dialog != null ) {
					var hora = el.find(".sn-refeicao-hora").text();
					var descricao = el.find(".sn-refeicao-descricao").text();
					var itens = el.find(".sn-refeicao-itens").text();
					var observacao = el.find(".sn-refeicao-observacao").text();
					
					$(dialog).find("#sn-refeicao-hora").val(hora);
					$(dialog).find("#sn-refeicao-descricao").val(descricao);
					$(dialog).find("#sn-refeicao-itens").val(itens);
					$(dialog).find("#sn-refeicao-observacao").val(observacao);
					$(dialog).find("#sn-refeicao-item-index").val(index);
					
					dialog.showModal();
				}
				
			}
		
		});
		
		dialog = sn_base.doRegistryDialog({
			title: "Refeição",
			dialog: "#sn-add-refeicao-modal",
			showButton: "#sn-add-refeicao-button",
			buttons: [
		          {
		        	  label: "Adicionar",
		        	  attrs: {id: "btn-add", type: "button"},
		        	  action: function() {
		        		  
		        		  
		        		  
		        		  var index 	 = $(dialog).find("#sn-refeicao-item-index").val();
		        		  var hora 		 = $(dialog).find("#sn-refeicao-hora").val();
						  var descricao  = $(dialog).find("#sn-refeicao-descricao").val();
						  var textdescricao  = $(dialog).find("#sn-refeicao-descricao option:selected").text();
						  var itens      = $(dialog).find("#sn-refeicao-itens").val();
						  var observacao = $(dialog).find("#sn-refeicao-observacao").val();
						  
						  if( !(hora.length > 0 && descricao.length > 0
						  &&  itens.length > 0 && observacao.length > 0) )
							  return;
						  
					      dialog.close();
						  
						  
						  hora2 = hora.split(":");

					      var d = new Date();
					      d.setHours( parseInt(hora2[0]) );
					      d.setMinutes( parseInt(hora2[1]) );
						  
					      var data = {
								  sortValue: d.getTime(),
								  ".sn-refeicao-hora": 			   {text:  hora},
								  ".sn-refeicao-descricao":		   {text:  textdescricao},
								  ".sn-refeicao-itens": 		   {text:  itens},
								  ".sn-refeicao-observacao": 	   {text:  observacao},
								  ".sn-refeicao-input-hora": 	   {value: hora},
								  ".sn-refeicao-input-descricao":  {value: descricao},
								  ".sn-refeicao-input-itens": 	   {value: itens},
								  ".sn-refeicao-input-observacao": {value: observacao}
						  };
						  
						  var el;
						  
						  if(index.length != 0)
							  el = dynamicList.doEditItem(index, data);
						  else 
							  el = dynamicList.doAddItem(data);
						 
						  componentHandler.upgradeElement(el[0]);
						  el.find("*").each( function(index, el) {
							  componentHandler.upgradeElement(el);
						  });
						  $(dialog).find("#sn-refeicao-item-index").val("");
		        	  }
		          }
			]
		});
		
	});
	
	
	$(".sn-editar-refeicao").click(function() {
		var idDialog = $(this).attr("name");
		var dialog = sn_base.doRegistryDialog(idDialog);
		dialog.showModal();
	});
	
	$("#btnAdicionarRefeicaoDialog").click(function() {
		var dialog = sn_base.doRegistryDialog("#adicionarRefeicao");
		dialog.showModal();
	});
	
	$("#bntAdicionarRefeicao").click(function() {
		$("#formAdicionarRecordatorio").validate({
			rules: {
				horaRefeicao: "required", 
				descricaoRefeicao: "required",
				itensRefeicao: "required",
				observacaoRefeicao: "required",
				pass: "required"
			}
		});
		$("#formAdicionarRecordatorio").valid();
	});
	
	$("#btnEditarRefeicao").click(function() {
	});
});