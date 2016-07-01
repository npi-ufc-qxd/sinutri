$(document).ready(function() {
	
	var verifyCheck = function(check, divs, animate) {
		
		if($(check).is(':checked')) {
			
			if(animate) divs.fadeIn();
			else divs.show();
				
		} else {
			
			if(animate) divs.fadeOut();
			else divs.hide();
			
		}
	
		check.change(function() {
			verifyCheck($(check), divs, animate);
		})
		
	}
	
	verifyCheck($("#externo"), $(".hide-by-externo"));
	
	$('#cpf').mask('000.000.000-00', {reverse: true});
	
	$('#telefone').mask('(00) 0 0000-0000');
	
	$("#cancelar").click(function(event) {
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
	
	$( "#excluir" ).click(function(event) {
		var dialog = sn_base.doRegistryDialog({
			title: "Você realmente deseja excluir este Paciente? ", 
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
});