var id = $("#id").val();

$.ajax({
		type: "GET",
		data: {"id": id},
		url: '/sisat/nutricao/frequencia-alimentar.json',
		success: function(result) {
			loadQuestionarios(result);
		},
		error: function(error) {
			
		}
		
});


function loadQuestionarios(result) {
	var i = 0;
	var frequencias = [];

	$.each( result, function( key, frequenciaAlimentar ) {
		var alimentos = [];
		var y = 0;

		$.each( frequenciaAlimentar.alimentos, function( key, alimento ) {
			alimentos[y] = { 
				'id': alimento.id,
				'alimento': alimento.alimento, 
				'porcao': alimento.porcao 
			};
			y++;
		});

		frequencias[i] = {
				'id' : frequenciaAlimentar.id,
            	'refeicao': frequenciaAlimentar.refeicao, 
             	'horario': frequenciaAlimentar.horario,
             	'SubGridData' : alimentos,
   	   };
	   i++;
	});

	$('#questionarioFrequenciaAlimentar').appendGrid('load', frequencias);
}


$(function() {
	
	$('#questionarioFrequenciaAlimentar')
			.appendGrid(
					{
						caption : 'Refeições',
						initRows : 0,
						maxRowsAllowed : 6,
						columns : [{
							name : 'id',
							type : 'hidden',
						}, 
						  
						{
							name : 'refeicao',
							display : 'Tipo de refição',
							type : 'select',
							ctrlOptions : 'DESJEJUM:Desjejum;LANCHE_DA_MANHA:Lanche da Manhã;ALMOCO:Almoço;LANCHE_DA_TARDE:Lanche da Tarde;JANTAR:Jantar;CEIA:Ceia'
									
						}, {
							name : 'horario',
							display : 'Hora',
							type : 'text',
							ctrlAttr : {
								maxlength : 15
							},
							ctrlCss : {
								width : '70px',
								'text-align' : 'right'
							},
							ctrlClass : 'hora'
						} ],
					
						
						i18n : {
							rowEmpty : "Nenhum alimentação foi adicionada!"
						},
						nameFormatter : function(idPrefix, name, uniqueIndex) {
							return "frequencias[" + (uniqueIndex - 1)+ "]." + name;
						},
						useSubPanel : true,
						subPanelBuilder : function(cell, uniqueIndex) {
							var idPanel = uniqueIndex-1;

							$(".hora").mask("99:99:99");
			
							var subgrid = $('<table></table>').attr('id',
									'tblSubGrid_' + uniqueIndex).appendTo(cell);
	
							subgrid.addClass('alternate');
					
							subgrid.appendGrid({
										initRows : 0,
										hideRowNumColumn : true,
										columns : [{
											name : 'id',
											type : 'hidden',
										},          
										{
											name : 'alimento',
											display : 'Alimento',
											ctrlCss : {
												'width' : '200px'
											}
										}, {
											name : 'porcao',
											display : 'Porção',
											ctrlCss : {
												'width' : '100px',
												'text-align' : 'right'
											},

										} ],
										i18n : {
											rowEmpty : "Nenhum alimento foi adicionado!"
										},
										nameFormatter : function(idPrefix, name, uniqueIndex) {
											return "frequencias["+ (idPanel)+ "].alimentos["+ (uniqueIndex - 1)+ "]." + name;
										},
									});
						},
						subPanelGetter : function(uniqueIndex) {
							// Return the sub grid value inside sub panel for `getAllValue` and `getRowValue` methods
							return $('#tblSubGrid_' + uniqueIndex).appendGrid('getAllValue', true);
						},
						rowDataLoaded : function(caller, record, rowIndex, uniqueIndex) {
							// Check SubGridData exist in the record data
							if (record.SubGridData) {
								// Fill the sub grid
								$('#tblSubGrid_' + uniqueIndex, caller).appendGrid('load',record.SubGridData);
							}
						}
					});

});


