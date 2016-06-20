$(function() {
	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Recordatório",
			dialog: "#sn-confirma-excluir-modal",
			buttons: [
		          {
		        	  label: "SIM",
		        	  attrs: {href: $("#sn-excluir-recordatorio").attr("link")},
		          },
		          {
		        	  label: "NÃO",
		        	  action: function() {
		        		  dialog.close();
		        	  }
		          }
			]
		});
		
		$("#sn-excluir-recordatorio").click( function() {
			dialog.showModal();
		});
		
	});
});