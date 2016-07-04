$(document).ready(function() {
	
	var options = {
			valueNames: ['criadoEm',
			  { attr: 'data-timestamp', name: 'timestamp' }]
			};

	var anamnese = new List('anamneses', options).sort('timestamp', { order: "desc" });
	var avaliacaoAntropometrica = new List('avaliacoesAntropometricas', options).sort('timestamp', { order: "desc" });
	var recordatorio = new List('recordatorios', options).sort('timestamp', { order: "desc" });
	var prescricao = new List('prescricoes', options).sort('timestamp', { order: "desc" });
	var inqueritoAlimentar = new List('inqueritosAlimentares', options).sort('timestamp', { order: "desc" });
	var avaliacaoLaboratorial = new List('avaliacoesLaboratoriais', options).sort('timestamp', { order: "desc" });
	var planoAlimentar = new List('planosAlimentares', options).sort('timestamp', { order: "desc" });
	
});