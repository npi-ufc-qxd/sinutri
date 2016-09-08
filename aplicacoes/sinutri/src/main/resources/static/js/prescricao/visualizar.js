$(function() {
	$(".bt-excluir-prescricao").click( function(event) {
		$("#modal-exclusao-prescricao").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Prescrição",
			dialog: "#modal-exclusao-prescricao",
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