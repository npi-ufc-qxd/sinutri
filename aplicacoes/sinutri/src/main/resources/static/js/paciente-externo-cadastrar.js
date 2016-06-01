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
	
});