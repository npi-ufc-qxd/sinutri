$(document).ready(function() {

	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		
		$(".sn-index__paper-layers > div").each(function(index, el) {
			$(this).removeClass("sn-hide-right");
			$(this).removeClass("sn-hide-left");
		});
		
		$("form").animate({opacity: "1.0"}, 1500);

	});

});