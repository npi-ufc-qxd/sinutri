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
					
					var filtro = "[value=" + descricao + "]";
					
					$(dialog).find("#sn-refeicao-hora").val(hora);
					$(dialog).find("#sn-refeicao-item-index").val(index);
					$(dialog).find("#sn-refeicao-observacao").val(observacao);
					$(dialog).find("#sn-refeicao-descricao option").removeAttr("selected");
					$(dialog).find("#sn-refeicao-descricao option"+filtro).prop("selected", true);
					
					dynamicListAlimento.doClearItems();
					
					el.find("#sn-alimentos-sub-items").children().each(function(_, e_) {
						e = $(e_);
						nome = e.find("#sub-item-nome").text();
						fonte = e.find("#sub-item-fonte").text();
						id = e.find("#sub-item-id").val();
						namePath = e.find("#sub-item-id").attr("name");
						quantidade = e.find("#sub-item-quantidade").val();
						quantidadePath = e.find("#sub-item-quantidade").attr("name");
						
						dynamicListAlimento.doAddItem({
							".sn-alimento-input-nome": {value: id, name: namePath}, 
							".sn-alimento-input-quantidade": {value: quantidade, name: quantidadePath}, 
							".sn-alimento-nome": {text: nome},
							".sn-alimento-input-fonte": {text: fonte},
							".sn-alimento-quantidade": {text: quantidade} 
						});
						
					});
					
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
						  var textdescricao  = $(dialog).find("#sn-refeicao-descricao option:selected").text();
						  var observacao = $(dialog).find("#sn-refeicao-observacao").val();
						  var tamListAlimentos = $("#sn-add-refeicao-modal #alimentos").children(".sn-cloneable").length
						  
						  if( !(hora.length > 0 && descricao.length > 0 && observacao.length > 0 && tamListAlimentos > 0) )
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
						  
						  /*** ALIMENTOS ***/
						  
						  el.find("#sn-alimentos-sub-items").remove();
						  el.append(
							  $.parseHTML(
								  "<div id=\"sn-alimentos-sub-items\"></div>"
							  )
						  );
						  
						  $("#sn-add-refeicao-modal #alimentos").children(".sn-cloneable").each(function(_, e) {
							  var nome = $(e).find(".sn-alimento-nome").text();
							  var fonte = $(e).find(".sn-alimento-input-fonte").text();
							  var id = $(e).find(".sn-alimento-input-nome").val();
							  var nomePath = $(e).find(".sn-alimento-input-nome").attr("name");
							  var quantidade = $(e).find(".sn-alimento-input-quantidade").val();
							  var quantidadePath = $(e).find(".sn-alimento-input-quantidade").attr("name");
							  el.find("#sn-alimentos-sub-items").append(
								  $.parseHTML(
									  "<div>" + 
									  	  "<span class=\"hidden\" id=\"sub-item-fonte\">" + fonte + "</span>"+
									  	  "<span class=\"hidden\" id=\"sub-item-nome\">" + nome + "</span>"+								  
										  "<input type=\"hidden\" id=\"sub-item-id\" name=\"" + nomePath + "\" value=\"" + id + "\" />" + 
										  "<input type=\"hidden\" id=\"sub-item-quantidade\" name=\"" + quantidadePath + "\" value=\"" + quantidade + "\" />" + 
									  "</div>"
								  )  
							  );							  
							  
						  });
						  
						  dynamicList.doSortItems();
						  
						  /*** ... ***/
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
				if( dialogAlimento != null ) {
					
					$(dialogAlimento).find("#sn-alimento-item-index").val("");
					
					var nome =  el.find(".sn-alimento-nome").text();
					var id	=  el.find(".sn-alimento-input-nome").val();
					var quantidade  =  el.find(".sn-alimento-input-quantidade").val();
					var fonte		=  el.find(".sn-alimento-input-fonte").text();
					
					buscarAlimentos(fonte);
					
					var filtro1 = "[value=" + fonte + "]";
					var filtro2 = "[value=" + id+","+nome + "]";
					
					$(dialogAlimento).find("#sn-alimento-item-index").val(index);
					$(dialogAlimento).find("#sn-alimento-nome").val(nome);
					$(dialogAlimento).find("#sn-alimento-quantidade").val(quantidade);
					$(dialogAlimento).find("#sn-alimento-fonte option").removeAttr("selected");
					$(dialogAlimento).find("#sn-alimento-fonte option"+filtro1).prop("selected", true);
					
					dialogAlimento.showModal();
					
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
		        		  var fonte		 = $(dialogAlimento).find("#sn-alimento-fonte").val();
		        		  var quantidade  = $(dialogAlimento).find("#sn-alimento-quantidade").val();
		        		  
		        		  /* Extraindo id do name */
		        		  regId = /^(\d+)/;
		        		  regNome = /([a-zA-Z]+.+)/;
		        		  
		        		  var idAlimento = nome.match(regId)[1];						  
						  var nomeAlimento = nome.match(regNome)[1];
						  
						  if( !(nome.length > 0 && quantidade.length > 0) )
							  return;
						  
					      dialogAlimento.close();
					      var data = {
								  sortValue: quantidade,
								  ".sn-alimento-nome": 			{text:  nomeAlimento},
								  ".sn-alimento-quantidade":	{text:  quantidade},
								  ".sn-alimento-input-fonte":	{text: fonte},
								  ".sn-alimento-input-nome":	{value: idAlimento},
								  ".sn-alimento-input-quantidade":	{value: quantidade}
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
			
			dynamicListAlimento.doClearItems();
			
			dialog.showModal();
		});
		
		$("#sn-add-alimento-button").click(function() {
			var dialog = $("#sn-add-alimento-modal"); 
			dialog.find("#sn-alimento-quantidade").val("");
			$(dialog).find("#sn-alimento-fonte").val("");
			$(dialog).find("#sn-alimento-fonte").selectedIndex = 0;
			
			dialog.find("#sn-alimento-nome").empty();
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
			buscarAlimentos(fonte);
		});
		
		function buscarAlimentos(fonte){
			var alimento_nome = $("#sn-alimento-nome");
			var url = alimento_nome.attr("data-url") + fonte;
			$.getJSON(url, function(data, status){
				alimento_nome.empty();
				alimento_nome.select2({
					 'data' : data,
					 'dropdownParent': $("#sn-add-alimento-modal")
				});
				
			});
		};
		
	});
	
});