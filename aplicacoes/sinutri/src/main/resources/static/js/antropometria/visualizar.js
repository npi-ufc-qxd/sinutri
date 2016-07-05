$(function() {
	$(".bt-excluir-avaliacao-antropometrica").click( function(event) {
		$("#modal-exclusao-avaliacao-antropometrica").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Avaliação Antropométrica",
			dialog: "#modal-exclusao-avaliacao-antropometrica",
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