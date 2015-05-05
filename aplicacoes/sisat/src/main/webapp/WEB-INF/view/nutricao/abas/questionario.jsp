<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<script id="jsSource" type="text/javascript">
	$(function() {
		// Initialize appendGrid
		$('#tblAppendGrid')
				.appendGrid(
						{
							caption : 'Refeições',
							initRows : 1,
							maxRowsAllowed: 6,
							columns : [ {
								name : 'refeicao',

								display : 'Tipo de refição',
								type : 'select',
								ctrlOptions : {

									DESJEJUM : 'Desjejum',
									LANCHE_DA_MANHA : 'Lanche da Manhã',
									ALMOCO : 'Almoço',
									LANCHE_DA_TARDE : 'Lanche da Tarde',
									JANTAR : 'Jantar',
									CEIA : 'Ceia'

								}
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
							nameFormatter : function(idPrefix, name,
									uniqueIndex) {
								return "frequencias[" + (uniqueIndex - 1)
										+ "]." + name;
							},
							initData : [
							            
							           
							],
							useSubPanel : true,
							subPanelBuilder : function(cell, uniqueIndex) {
								//var idPanel = --uniqueIndex;
								
								$(".hora").mask("99:99:99");
								// Create a table object and add to sub panel
								var subgrid = $('<table></table>').attr('id',
										'' + uniqueIndex).appendTo(
										cell);
								// Optional. Add a class which is the CSS scope specified when you download jQuery UI
								subgrid.addClass('alternate');
								// Initial the sub grid
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
									i18n: {
										rowEmpty : "Nenhum alimento foi adicionado!"
							    },
								nameFormatter : function(idPrefix, name, uniqueIndex) {
									return "frequencias["+(idPrefix-1)+"].alimentos["+(uniqueIndex-1)+"]."+name;
								},
								});
							},
							subPanelGetter : function(uniqueIndex) {
								// Return the sub grid value inside sub panel for `getAllValue` and `getRowValue` methods
								return $('#tblSubGrid_' + uniqueIndex)
										.appendGrid('getAllValue', true);
							},
							rowDataLoaded : function(caller, record, rowIndex,
									uniqueIndex) {
								// Check SubGridData exist in the record data
								if (record.SubGridData) {
									// Fill the sub grid
									$('#tblSubGrid_' + uniqueIndex, caller)
											.appendGrid('load',
													record.SubGridData);
								}
							}
						});

	
	});
</script>

<fieldset>
	<h3>Adicione as refeições</h3>
	${consultaNutricional.frequencias}
	<div class="form-group">
		<table id="tblAppendGrid">
		</table>
	</div>
</fieldset>
</html>

