$(function()  {	
	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		var dialog = null;
		
		var dynamicList = $(".sn-list-refeicoes").dynamicList({
			cloneableElement: ".sn-cloneable",
			recurssiveIndex: 0, 
			removeButton:     ".sn-refeicao-remover",
			editButton:       ".sn-refeicao-editar",
			cloneButton:	  ".sn-refeicao-duplicar",
			onItemEdit:		  function(el, index) {
				if( dialog != null ) {
					$(dialog).find("#sn-refeicao-item-index").val("");
					
					var hora = el.find(".sn-refeicao-input-hora").val();
					var descricao = el.find(".sn-refeicao-input-descricao").val();
					var observacao = el.find(".sn-refeicao-input-observacao").val();
					
					var filtro = "[value="+descricao+"]";
					
					$(dialog).find("#sn-refeicao-hora").val(hora);
					$(dialog).find("#sn-refeicao-item-index").val(index);
					$(dialog).find("#sn-refeicao-observacao").val(observacao);
					$(dialog).find("#sn-refeicao-descricao").val(observacao);
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
		        	  label: "Salvar",
		        	  attrs: {id: "btn-add", type: "button"},
		        	  action: function() {
		        		  
		        		  var index 	 = $(dialog).find("#sn-refeicao-item-index").val();
		        		  var hora 		 = $(dialog).find("#sn-refeicao-hora").val();
						  var descricao  = $(dialog).find("#sn-refeicao-descricao").val();
						  var observacao = $(dialog).find("#sn-refeicao-observacao").val();
						  
						  if( !(hora.length > 0 && descricao.length > 0 && observacao.length > 0) )
							  return;
						  
					      dialog.close();
						  
						  
						  hora2 = hora.split(":");

					      var d = new Date();
					      d.setHours( parseInt(hora2[0]) );
					      d.setMinutes( parseInt(hora2[1]) );
						  
					      var data = {
								  sortValue: d.getTime(),
								  ".sn-refeicao-hora": 			   {text:  hora},
								  ".sn-refeicao-descricao":		   {text:  descricao},
								  ".sn-refeicao-observacao": 	   {text:  observacao},
								  ".sn-refeicao-input-hora": 	   {value: hora},
								  ".sn-refeicao-input-descricao":  {value: descricao},
								  ".sn-refeicao-input-observacao": {value: observacao},
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
		
		/***********/
		/* Lista de Porção Alimento */
		
		var dynamicListAlimento = $(".sn-list-alimento-porcao").dynamicList({
			cloneableElement: ".sn-cloneable",
			recurssiveIndex: 1,
			removeButton:     ".sn-alimento-remover",
			editButton:       ".sn-alimento-editar",
			cloneButton:	  ".sn-alimento-duplicar",
			onItemEdit:		  function(el, index) {
				if( dialog != null ) {
					$(dialog).find("#sn-alimento-item-index").val("");
					
					var index 	 = $(dialogAlimento).find("#sn-alimento-item-index").val();
	        		var nome 		 = $(dialogAlimento).find("#sn-alimento-nome").val();
					var quantidade  = $(dialogAlimento).find("#sn-alimento-quantidade").val();
					  
					var filtro = "[value="+descricao+"]";
					
					$(dialog).find("#sn-alimento-nome").val(nome);
					$(dialog).find("#sn-alimento-item-index").val(index);
					$(dialog).find("#sn-alimento-quantidade").val(quantidade);
					
					dialog.showModal();
					
				}
				
			}
		
		});
		
		dialogAlimento = sn_base.doRegistryDialog({
			title: "Alimento",
			dialog: "#sn-add-alimento-modal",
			showButton: "#sn-add-alimento-button", 
			buttons: [
		          {
		        	  label: "Salvar",
		        	  attrs: {id: "btn-add", type: "button"},
		        	  action: function() {
		        		  
		        		  var index 	 = $(dialogAlimento).find("#sn-alimento-item-index").val();
		        		  var nome 		 = $(dialogAlimento).find("#sn-alimento-nome").val();
						  var quantidade  = $(dialogAlimento).find("#sn-alimento-quantidade").val();
						  
						  if( !(nome.length > 0 && quantidade.length > 0) )
							  return;
						  
					      dialogAlimento.close();
					      var data = {
								  sortValue: quantidade,
								  ".sn-alimento-nome": 			{text:  nome},
								  ".sn-alimento-quantidade":	{text:  quantidade}
					      };
						  
						  var el;
						  
						  if(index.length != 0)
							  el = dynamicListAlimento.doEditItem(index, data);
						  else 
							  el = dynamicListAlimento.doAddItem(data);
						 
						  componentHandler.upgradeElement(el[0]);
						  el.find("*").each( function(index, el) {
							  componentHandler.upgradeElement(el);
						  });
						  
						  $(dialogAlimento).find("#sn-alimento-item-index").val("");
		        	  }
		          }
			]
		});
		
		
		$("#sn-add-refeicao-button").click(function() {
			
			$(dialog).find("#sn-refeicao-hora").val("");
			$(dialog).find("#sn-refeicao-descricao").val("");
			$(dialog).find("#sn-refeicao-descricao").selectedIndex = 0;
			$(dialog).find("#sn-refeicao-observacao").val("");
			
			$(dialog).find("#sn-refeicao-item-index").val("");
			
			dialog.showModal();
		});
		
		$("#sn-add-alimento-button").click(function() {
			var dialog = $("#sn-add-alimento-modal"); 
			dialog.find("#sn-alimento-nome").val("");
			dialog.find("#sn-alimento-nome").selectedIndex = 0;
			dialog.find("#sn-alimento-fonte").val("");
			dialog.find("#sn-alimento-fonte").selectedIndex = 0;
			dialog.find("#sn-alimento-quantidade").val("");
			
			dialog.find("#sn-alimento-item-index").val("");
			
			dialog.showModal();
		});
		
		/***********/
		
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
		
		$("#sn-alimento-fonte").on("change", function(){
			var fonte = $(this).val();
			var alimento_nome = $("#sn-alimento-nome");
			var url = alimento_nome.attr("data-url") + fonte;
			$.getJSON(url, function(data, status){
				alimento_nome.empty();
				alimento_nome.select2({
					 'data' : data,
					 'dropdownParent': $("#sn-add-alimento-modal")
				});
				
			});
		});
		
	});
	
});