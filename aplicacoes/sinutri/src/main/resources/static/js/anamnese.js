$(document).ready(function() {
	$(".checkboxInput").click(function() {
		console.log("click")
		var itemForm = $(this).parent().parent();
		if((itemForm).find("input[type='checkbox']").is(":checked"))
			$(itemForm).find("input[type='text']").attr("type", "hidden");
		else
			$(itemForm).find("input[type='hidden']").attr("type", "text");
	});
});