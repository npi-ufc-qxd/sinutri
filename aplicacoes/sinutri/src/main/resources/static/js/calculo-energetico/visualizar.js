$(function() {
	$(".bt-excluir-prescricao").click( function(event) {
		$("#modal-exclusao-calculo-energetico").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Cálculo Energético",
			dialog: "#modal-exclusao-calculo-energetico",
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