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
						  //var listAlimentos = $("#sn-add-refeicao-modal #alimentos").children(".sn-cloneable");
						  if(validacaoVazio($(dialog),"alimentos")){
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
					var filtro1 = "[value=" + fonte + "]";
					var value = id;
					buscarAlimentos(fonte, value);
					
					$(dialogAlimento).find("#sn-alimento-item-index").val(index);
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
		        		  var fonte		 = $(dialogAlimento).find("#sn-alimento-fonte").val();
		        		  var quantidade  = $(dialogAlimento).find("#sn-alimento-quantidade").val();
		        		  var valorMedidaCaseira = $(dialogAlimento).find("#input-medidaCaseira").val();
		      			  var valorMedidaPadrao = $(dialogAlimento).find("#input-medidaPadrao").val();
		        		  
		      			  var data = $(dialogAlimento).find("#sn-alimento-nome").select2('data')[0];
		      			  
		      			  var idAlimento = data.id; 
		      			  var nomeAlimento = data.text;
		      			  
		        		  if(validacaoVazio($(dialogAlimento))){
								return;
						  }
						  
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
			
			removerLabelValidacao($(dialog), "alimentos");
			
			dialog.showModal();
		});
		
		$("#sn-add-alimento-button").click(function() {
			var dialog = $("#sn-add-alimento-modal"); 
			dialog.find("#sn-alimento-quantidade").val("");
			$(dialog).find("#sn-alimento-fonte").val("");
			$(dialog).find("#sn-alimento-fonte").selectedIndex = 0;
			$(dialog).find("#input-medidaCaseira").val("");
			$(dialog).find("#input-medidaPadrao").val("");
			
			dialog.find("#sn-alimento-nome").empty();
			dialog.find("#sn-alimento-item-index").val("");
			
			removerLabelValidacao($(dialog));
			
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
		
		$("#sn-alimento-fonte").on("change", function(){
			var fonte = $(this).val();
			buscarAlimentos(fonte);
		});
		
		/***********Unidade de Médida***********/
		
		function atualizarUnidadeDeMedida(){
			var data = $("#sn-alimento-nome").select2('data')[0];
			
			var id = data.id; 
			var text = data.text; 
			var medidaCaseira = data.medidaCaseira; 
			var medidaPadrao = data.medidaPadrao; 
			var valorMedidaCaseira = data.valorMedidaCaseira; 
			var valorMedidaPadrao = data.valorMedidaPadrao;
			
			$("#input-medidaCaseira").val(valorMedidaCaseira + " " + medidaCaseira);
			$("#input-medidaCaseira").data("valorMedidaCaseira", valorMedidaCaseira);
			$("#input-medidaCaseira").data("medidaCaseira", medidaCaseira);
			
			$("#input-medidaPadrao").val(valorMedidaPadrao + " " + medidaPadrao);
			$("#input-medidaPadrao").data("medidaPadrao", medidaPadrao);
			$("#input-medidaPadrao").data("valorMedidaPadrao", valorMedidaPadrao);
			
			atualizarMedidas();
		};
		
		function atualizarMedidas() {
			var value = $("#sn-alimento-quantidade").val();
			if(value && !isNaN(value)) {
			
				var medidaCaseira = $("#input-medidaCaseira").data("medidaCaseira");
				var valorMedidaCaseira = $("#input-medidaCaseira").data("valorMedidaCaseira");
				
				var medidaPadrao = $("#input-medidaPadrao").data("medidaPadrao");
				var valorMedidaPadrao = $("#input-medidaPadrao").data("valorMedidaPadrao");
				
				$("#input-medidaCaseira").val((value * valorMedidaCaseira) + " " + medidaCaseira);
				$("#input-medidaPadrao").val((value * valorMedidaPadrao) + " " + medidaPadrao);
				
			}
		}
		
		function buscarAlimentos(fonte, value){
			var alimento_nome = $("#sn-alimento-nome");
			var url = alimento_nome.attr("data-url") + fonte;
			$.getJSON(url, function(alimentos, status){
				
				var data = alimentos.map(function(a) {
					return {
						id: a[0], 
						text: a[1], 
						medidaCaseira: a[2], 
						medidaPadrao: a[3], 
						valorMedidaCaseira: a[4], 
						valorMedidaPadrao: a[5]
					};
				});
				
				//console.log(JSON.stringify(data));
				
				alimento_nome.empty();
				alimento_nome.select2({
					 'data' : data,
					 'dropdownParent': $("#sn-add-alimento-modal")
				});
				
				if(value != undefined){
					alimento_nome.val(value, value).change();
				}
				
				$('select').on('select2:select', function (e) {
					atualizarUnidadeDeMedida();
				})
				
				atualizarUnidadeDeMedida();
				
			});
			
		};
		
		$("#sn-alimento-quantidade").on("change keyup paste", atualizarMedidas);
		
	});
	
});