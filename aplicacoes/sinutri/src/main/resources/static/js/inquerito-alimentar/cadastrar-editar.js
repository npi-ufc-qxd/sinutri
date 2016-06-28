$(document).ready(function() {
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
	
	$(".mdl-checkbox__input").each(function(){
		divCheckBox = $(this).parent();
		divSelect = divCheckBox.next();
		select = divSelect.find("select")
		divInput = divSelect.next();
		input = divInput.find("input");
		if ($(this).is(":checked")) {
			input.removeAttr('disabled')
			divInput.attr('style', 'display:show');
			select.removeAttr('disabled');
			divSelect.attr('style', 'display:show');
		} else if (!$(this).is(":checked")) {
			select.prop('selectedIndex', 0);
			select.attr('disabled', 'true');
			divSelect.attr('style', 'display:none');
			input.val('')
			input.attr('disabled', 'true');
			divInput.attr('style', 'display:none');
		}
		
	});
	
	$(".mdl-checkbox__input").change(function(){
		divCheckBox = $(this).parent();
		divSelect = divCheckBox.next();
		select = divSelect.find("select")
		divInput = divSelect.next();
		input = divInput.find("input");
		if ($(this).is(":checked")) {
			input.removeAttr('disabled')
			divInput.attr('style', 'display:show');
			select.removeAttr('disabled');
			divSelect.attr('style', 'display:show');
		} else if (!$(this).is(":checked")) {
			select.prop('selectedIndex', 0);
			select.attr('disabled', 'true');
			divSelect.attr('style', 'display:none');
			input.val('')
			input.attr('disabled', 'true');
			divInput.attr('style', 'display:none');
		}
	});
	
});