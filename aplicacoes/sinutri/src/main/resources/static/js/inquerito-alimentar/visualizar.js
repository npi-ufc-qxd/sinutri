$(function() {
	$(".bt-excluir-inqueritoAlimentar").click( function(event) {
		$("#modal-exclusao-inquerito-alimentar").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Inquérito Alimentar",
			dialog: "#modal-exclusao-inquerito-alimentar",
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