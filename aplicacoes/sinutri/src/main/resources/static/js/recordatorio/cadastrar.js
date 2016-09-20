$(function() 
{	
	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		var dialog = null;
		
		var dynamicList = $(".sn-list-refeicoes").dynamicList({
			cloneableElement: ".sn-cloneable",
			removeButton:     ".sn-refeicao-remover",
			editButton:       ".sn-refeicao-editar",
			cloneButton:	  ".sn-refeicao-duplicar",
			onItemEdit:		  function(el, index) {
				if( dialog != null ) {
					$(dialog).find("#sn-refeicao-item-index").val("");
					
					var hora = el.find(".sn-refeicao-input-hora").val();
					var descricao = el.find(".sn-refeicao-input-descricao").val();
					var itens = el.find(".sn-refeicao-input-itens").val();
					var observacao = el.find(".sn-refeicao-input-observacao").val();
					
					var filtro = "[value="+descricao+"]";
					
					$(dialog).find("#sn-refeicao-hora").val(hora);
					$(dialog).find("#sn-refeicao-itens").val(itens);
					$(dialog).find("#sn-refeicao-item-index").val(index);
					$(dialog).find("#sn-refeicao-observacao").val(observacao);
					$(dialog).find("#sn-refeicao-descricao option").removeAttr("selected");
					$(dialog).find("#sn-refeicao-descricao option"+filtro).prop("selected", true);
					
					dialog.showModal();
					
				}
				
			}
		
		});
		
		dialog = sn_base.doRegistryDialog({
			title: "Refeição",
			dialog: "#sn-add-refeicao-modal",
			buttons: [
		          {
		        	  label: "Salvar",
		        	  attrs: {id: "btn-add", type: "button"},
		        	  action: function() {
		        		  
		        		  var index 	 = $(dialog).find("#sn-refeicao-item-index").val();
		        		  var hora 		 = $(dialog).find("#sn-refeicao-hora").val();
						  var descricao  = $(dialog).find("#sn-refeicao-descricao").val();
						  var textdescricao  = $(dialog).find("#sn-refeicao-descricao option:selected").text();
						  var itens      = $(dialog).find("#sn-refeicao-itens").val();
						  var observacao = $(dialog).find("#sn-refeicao-observacao").val();
						  
						  if(validacaoVazio($(dialog))){
								return;
							}
						  
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
						  
						  if(index.length != 0) {
							  el = dynamicList.doEditItem(index, data);
						  } else {
							  el = dynamicList.doAddItem(data);
						  } 
						  
						  componentHandler.upgradeElement(el[0]);
						  el.find("*").each( function(index, el) {
							  componentHandler.upgradeElement(el);
						  });

						  $(dialog).find("#sn-refeicao-item-index").val("");
		        	  }
		          }
			]
		});
		
		$("#sn-add-refeicao-button").click(function() {
			
			$(dialog).find("#sn-refeicao-hora").val("");
			$(dialog).find("#sn-refeicao-descricao").val("");
			$(dialog).find("#sn-refeicao-descricao").selectedIndex = 0;
			$(dialog).find("#sn-refeicao-itens").val("");
			$(dialog).find("#sn-refeicao-observacao").val("");
			
			$(dialog).find("#sn-refeicao-item-index").val("");
			
			dialog.showModal();
		});
		
		var confirmacao = sn_base.doRegistryDialog({
			title: "Cancelar",
			dialog: "#sn-confirma-cancelar-modal",
			buttons: [
	          {
		          label: "SIM",
		          attrs: {href: $("#btnCancelar").attr("link")}
	          },
	          {
	        	  label: "NÃO",
	        	  action: function() {
	        		  confirmacao.close();
				  }
	          }
			]
		});
		
		$("#btnCancelar").click(function() {
			confirmacao.showModal();
		});
		
		
	});
	
});