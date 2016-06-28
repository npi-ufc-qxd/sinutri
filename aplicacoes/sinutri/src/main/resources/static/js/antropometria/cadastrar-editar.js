$( "#cancelar" ).click(function(event) {
   if(Cookies.get("formulario-alterado")){
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
   }
});

Cookies.remove("formulario-alterado");   


$("#form-antropometria :input").each(function(index){
   $(this).change(function(){
	   Cookies.set("formulario-alterado", true);   
   });
});