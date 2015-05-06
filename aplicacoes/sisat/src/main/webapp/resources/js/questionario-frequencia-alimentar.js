$(function() {
		// Initialize appendGrid
		$('#tblAppendGrid')
				.appendGrid(
						{
							caption : 'Refeições',
							initRows : 1,
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
							initData : [
							            

							            $.ajax({
							            	type: "GET",
							            	url: '/sisat/nutricao/frequencia-alimentar.json',
							            })
							            .success(function(result) {
							            	$.each( result, function( key, value ) {
							            		console.log(key +" : " + value.id);
							            		console.log(key +" : " + value.refiecao);
							            		console.log(key +" : " + value.h);
							            	});

							            })
							            .error(function(error) {
							            	$.each( error, function( key, value ) {
							            		console.log(key +"--"+value);
							            	});
							            }),

							            
			            	
								{
									'refeicao' : 'LANCHE_DA_MANHA',
									'horario': '12:00:00',
									'SubGridData':[
													
													{ alimento: 'Arroz', porcao: '200g' },
													
									               ]
								},
								
								
							],
							useSubPanel : true,
							subPanelBuilder : function(cell, uniqueIndex) {
								var idPanel = uniqueIndex-1;

								$(".hora").mask("99:99:99");
								// Create a table object and add to sub panel
								var subgrid = $('<table></table>').attr('id',
										'tblSubGrid_' + uniqueIndex).appendTo(cell);
								// Optional. Add a class which is the CSS scope specified when you download jQuery UI
								subgrid.addClass('alternate');
								// Initial the sub grid
								subgrid
								
								
										.appendGrid({
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

//
//$.ajax({
//	type: "GET",
//	url: '/sisat/nutricao/frequencia-alimentar.json',
//})
//.success(function(result) {
//	$.each( result, function( key, value ) {
//	    $('#tblAppendGrid').appendGrid('insertRow', [
//	       {
//	       	 'refeicao' : value.refiecao,
//	       	 'horario': value.horario,
//	       	} 
//
//
//	       		,], value.id);
//	});
//})
//.error(function(error) {
//	$.each( error, function( key, value ) {
//		console.log(key +"--"+value);
//	});
//})							],
//
//
//
//
