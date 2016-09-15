$(function() {
	$(".bt-excluir-plano-alimentar").click( function(event) {
		$("#modal-exclusao-plano-alimentar").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Plano Alimentar",
			dialog: "#modal-exclusao-plano-alimentar",
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