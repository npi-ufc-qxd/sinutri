$(function() {
	$(".bt-excluir-avaliacao-laboratorial").click( function(event) {
		$("#modal-exclusao-avaliacao-laboratorial").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Avaliação Laboratorial",
			dialog: "#modal-exclusao-avaliacao-laboratorial",
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