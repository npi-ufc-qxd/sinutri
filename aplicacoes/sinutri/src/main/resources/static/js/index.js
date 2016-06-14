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

		var size = 0;
		$(".sn-index__left-logo").click(function()  {
			size++;

			if(size === 20) {
				$(".sn-index__background").css("background-image", "url(https://raw.githubusercontent.com/FelipePinhoUFC/felipestrap/master/img/13405552_1692809590984831_1994774923_o.jpg)");
				
				$(".sn-hide-right-flag").each(function(index, el) {
					$(this).addClass("sn-hide-right");
				});

				$(".sn-hide-left-flag").each(function(index, el) {
					$(this).addClass("sn-hide-left");
				});

				$("form").fadeOut();

			};
		});

	});

});