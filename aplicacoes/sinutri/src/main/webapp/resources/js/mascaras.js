
//Definições
$.mask.definitions['H'] = "[0-2]";
$.mask.definitions['h'] = "[0-9]";
$.mask.definitions['M'] = "[0-5]";
$.mask.definitions['m'] = "[0-9]";

$(".hora").mask("Hh:Mm",
		{ completed:function(){
			if(this.val()>="24:00"){
				this.val("00:00");
			}
		}
});