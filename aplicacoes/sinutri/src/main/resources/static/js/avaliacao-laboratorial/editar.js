$(document).ready(function() {

	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {

		var dialog = null;

		var dynamicList = $(".sn-list-exames").dynamicList({
			cloneableElement: ".sn-cloneable", 
			removeButton: ".sn-exame-remove", 
			editButton: ".sn-exame-edit", 
			onItemEdit: function(el, index) {

				if(dialog != null) {
					var type = el.find(".sn-exame-input-nome").val();
					var val = el.find(".sn-exame-value").text();
					var filter = "[value=" + type + "]";
										
					$(dialog).find("#sn-exame-type").removeAttr("selected");
					$(dialog).find("#sn-exame-type option"+filter).prop("selected", true);
					$(dialog).find("#sn-exame-value").val(val);
					$(dialog).find("#sn-exame-item-index").val(index);
					
					dialog.showModal();
				}
				
			}
		});

		dialog = sn_base.doRegistryDialog({
			title: "Adicionar Exame", 
			dialog: "#sn-add-exame-modal", 
			showButton: "#sn-add-exame-button", 
			buttons: [
				{
					label: "OK",
					attrs: {id: "btn-ok", type: "submit"}, 
					action: function() {
				
						var index = $(dialog).find("#sn-exame-item-index").val();
						var type = $(dialog).find("#sn-exame-type").val();
						var val = $(dialog).find("#sn-exame-value").val();
						var text  = $(dialog).find("#sn-exame-type option:selected").text();
						var textUnidade = $(dialog).find("#input-medida").val();
						
						if(validacaoVazio($(dialog))){
							return;
						}
						
						dialog.close();
						
						var data = {  
							".sn-exame-type": {text: text},
							".sn-exame-value": {text: val},
							".sn-exame-input-nome": {value: type},
							".sn-exame-input-resultado": {value: val},
							".sn-exame-unidade-value": {text: textUnidade}
						};
						
						var el;

						if(index != "") {
							el = dynamicList.doEditItem(index, data);

						}
						else {
							el = dynamicList.doAddItem(data);

							
						}

						$(dialog).find("#sn-exame-item-index").val("");

						componentHandler.upgradeDom();		
						
						 var dataUnidadadeMedida = $(this).find(':selected').data("unidadademedida");
							$("#exame-unidade-value").text(dataUnidadadeMedida);

					}
				}
			]

		});
		
		$("#sn-exame-type").change(function() {
			 var value = this.value;
			 var dataUnidadadeMedida = $(this).find(':selected').data("unidadademedida");
			 $("#input-medida").val(dataUnidadadeMedida);
			 
		});
		
		$("#sn-add-exame-button").click(function() {
			$(dialog).find("#sn-exame-type").val("");
			$(dialog).find("#sn-exame-type").selectedIndex = 0;
			$(dialog).find("#sn-exame-value").val("");
			
			$(dialog).find("#sn-exame-item-index").val("");
			
			removerLabelValidacao($(dialog));
			
			dialog.showModal();
		});
		
		$("#bt-cancelar").click( function(event) {
			$("#modal-cancelar").removeClass("sn-display-none");
			var dialog = sn_base.doRegistryDialog({
				title: "Cancelar",
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
				
});