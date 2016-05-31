$(function() 
{	
	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		var dialog = null;
		
		var dynamicList = $(".sn-list-refeicoes").dynamicList({
			cloneableElement: ".sn-cloneable",
			removeButton:     ".sn-refeicao-remover",
			editButton:       ".sn-refeicao-editar",
			orderBy: 	   	  ".sn-refeicao-hora",
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
				
			},
			compare: function(hora1, hora2) {
				hora1 = hora1.split(":");
			    hora2 = hora2.split(":");

			    var d = new Date();
			    var data1 = new Date(d.getFullYear(), d.getMonth(), d.getDate(), hora1[0], hora1[1]);
			    var data2 = new Date(d.getFullYear(), d.getMonth(), d.getDate(), hora2[0], hora2[1]);

			    return data1 > data2;
			}
		
		});
		
		dialog = sn_base.doRegistryDialog({
			title: "Adicionar Refeição",
			dialog: "#sn-add-refeicao-modal",
			showButton: "#sn-add-refeicao-button",
			buttons: [
		          {
		        	  label: "Adicionar",
		        	  attrs: {id: "btn-add", type: "button"},
		        	  action: function() {
		        		  dialog.close();
		        		  
		        		  var index 	 = $(dialog).find("#sn-refeicao-item-index").val();
		        		  var hora 		 = $(dialog).find("#sn-refeicao-hora").val();
						  var descricao  = $(dialog).find("#sn-refeicao-descricao").val();
						  var itens      = $(dialog).find("#sn-refeicao-itens").val();
						  var observacao = $(dialog).find("#sn-refeicao-observacao").val();
						  
						  var data = {
								  ".sn-refeicao-hora": 		 {text: hora},
								  ".sn-refeicao-descricao":  {text: descricao},
								  ".sn-refeicao-itens": 	 {text: itens},
								  ".sn-refeicao-observacao": {text: observacao}
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
		$("#formAdicionarRecordatorio").validate({
			rules: {
				horaRefeicaoAtualizada: "required", 
				descricaoRefeicaoAtualizada: "required",
				itensRefeicaoAtualizada: "required",
				observacaoRefeicaoAtualizada: "required",
				pass: "required"
			}
		});
		$("#formAdicionarRecordatorio").valid();
	});
});