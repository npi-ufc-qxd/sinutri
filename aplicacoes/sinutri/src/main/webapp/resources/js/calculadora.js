/*
 * 
 * MÉTODOS UTILIZADOS EM CÁLCULOS ENVOLVENDO MEDIDAS CORPORAIS
 * 
 */

var calculadora = (function(){
	
	return {
		
		calcIMC : function(altura, peso) {
			
			return peso/(altura * altura);
			
		}
		
	};
	
})();