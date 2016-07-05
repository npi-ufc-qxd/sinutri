$( ".bt-excluir-avaliacao-antropometrica" ).click(function(event) {
	   var dialog = sn_base.doRegistryDialog({
           title: "Você realmente deseja excluir esta Avaliação Antropométrica?", 
           dialog: "#modal-exclusao", 
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
