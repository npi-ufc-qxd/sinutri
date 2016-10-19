$(function() {
	$(".bt-excluir-alimento").click( function(event) {
		$("#modal-exclusao-alimento").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Alimento",
			dialog: "#modal-exclusao-alimento",
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