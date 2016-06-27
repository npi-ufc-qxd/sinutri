$( "#excluir" ).click(function(event) {
	   var dialog = sn_base.doRegistryDialog({
           title: "Você realmente deseja excluir esta Avaliação Antropométrica?", 
           dialog: "#modal-exclusao", 
           buttons: [
                   {
                      label: "Excluir",
                      attrs: {href: $(this).attr("href")}, 
                      action: function() {
                          dialog.close();
                      }
                   }, 
                   {
                       label: "Cancelar",
                       action: function() {
                           dialog.close();
                       }
                   }
           ]
   		});    	   

	   dialog.showModal();
	   event.preventDefault();
});       
