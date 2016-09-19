$( "#cancelar" ).click(function(event) {
	var dialog = sn_base.doRegistryDialog({
		title: "Você realmente deseja descartar as alterações?",
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
