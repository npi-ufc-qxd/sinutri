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