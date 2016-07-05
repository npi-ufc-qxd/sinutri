$(function() {
	$(".bt-excluir-anamnese").click( function(event) {
		$("#modal-exclusao-anamnese").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Anamnese",
			dialog: "#modal-exclusao-anamnese",
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