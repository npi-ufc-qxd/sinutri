	$.ajax({
		type: "GET",
		url: '/sisat/nutricao/frequencia-alimentar.json',
	})
	.success(function(result) {
		
		$.each( result, function( key, frequenciaAlimentar ) {
			$('#tblAppendGrid').appendGrid('insertRow', [{
				'refeicao' : frequenciaAlimentar.refeicao,
				'horario': frequenciaAlimentar.horario,
				
			} ,], frequenciaAlimentar.id);

			$.each( frequenciaAlimentar.alimentos, function( key, alimento ) {
				alert(alimento.alimento)
				$('#tblAppendGrid').appendGrid('insertRow', [{
					'SubGridData': [
                     {
                       'alimento': alimento.alimento,
	                   'porcao': alimento.porcao
	                 },
                    ]
				} ,], frequenciaAlimentar.id);
			});
		});
	})
	.error(function(error) {
		$.each( error, function( key, value ) {
			console.log(key +"--"+value);
		});
	});


$(function() {
		// Initialize appendGrid
		$('#tblAppendGrid')
				.appendGrid(
						{
							caption : 'Refeições',
							initRows : 0,
							maxRowsAllowed : 6,
							columns : [ {
								name : 'refeicao',
								display : 'Tipo de refição',
								type : 'select',
								ctrlOptions : 'DESJEJUM:Desjejum;LANCHE_DA_MANHA:Lanche da Manhã;ALMOCO:Almoço;LANCHE_DA_TARDE:Lanche da Tarde;JANTAR:Jantar;CEIA:Ceia'
										
							}, {
								name : 'horario',
								display : 'Hora',
								type : 'text',
								ctrlAttr : {
									maxlength : 10
								},
								ctrlCss : {
									width : '50px',
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
											columns : [ {
												name : 'alimento',
												display : 'Alimento',
												ctrlCss : {
													'width' : '200px'
												}
											}, {
												name : 'porcao',
												display : 'Porção',
												ctrlCss : {
													'width' : '60px',
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
