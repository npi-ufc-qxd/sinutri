$(document).ready(function() {

	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
				
		$(".sn-hide-right").each(function(index, el) {
			$(this).removeClass("sn-hide-right");
			$(this).addClass("sn-hide-right-flag");
		});

		$(".sn-hide-left").each(function(index, el) {
			$(this).removeClass("sn-hide-left");
			$(this).addClass("sn-hide-left-flag");
		});
		
		$("form").animate({opacity: "1.0"}, 1500);

	});

});