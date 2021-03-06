$(function() {
	$(".bt-excluir-recordatorio").click( function(event) {
		$("#modal-exclusao-recordatorio").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Recordatório",
			dialog: "#modal-exclusao-recordatorio",
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