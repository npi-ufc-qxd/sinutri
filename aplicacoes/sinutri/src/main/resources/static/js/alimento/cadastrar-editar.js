$( "#cancelar" ).click(function(event) {
	var dialog = sn_base.doRegistryDialog({
		title: "Você realmente deseja descartar as alterações?", 
		dialog: "#modal-cancelar", 
		buttons: [
		          {
		        	  label: "Sim",
		        	  attrs: {href: $(this).attr("href")}, 
		        	  action: function() {
		        		  dialog.close();
		        	  }
		          }, 
		          {
		        	  label: "Não",
		        	  action: function() {
		        		  dialog.close();
		        	  }
		          }
		          ]
	});    	   

	dialog.showModal();
	event.preventDefault();
});
