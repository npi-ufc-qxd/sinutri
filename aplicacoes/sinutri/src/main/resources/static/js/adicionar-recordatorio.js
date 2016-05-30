$(function() 
{	
	$("#btnAdicionarRefeicaoDialog").click(function() {
		var dialog = sn_base.doRegistryDialog("#adicionarRefeicao");
		dialog.showModal();
	});
	
	$("#bntAdicionarRefeicao").click(function() {
		$("#formAdicionarRecordatorio").validate({
			rules: {
				horaRefeicao: "required", 
				descricaoRefeicao: "required",
				itensRefeicao: "required",
				observacaoRefeicao: "required",
				pass: "required"
			}
		});
		$("#formAdicionarRecordatorio").valid();
	});
	
	$("#btnEditarRefeicao").click(function() {
		$("#formAdicionarRecordatorio").validate({
			rules: {
				horaRefeicaoAtualizada: "required", 
				descricaoRefeicaoAtualizada: "required",
				itensRefeicaoAtualizada: "required",
				observacaoRefeicaoAtualizada: "required",
				pass: "required"
			}
		});
		$("#formAdicionarRecordatorio").valid();
	});
});