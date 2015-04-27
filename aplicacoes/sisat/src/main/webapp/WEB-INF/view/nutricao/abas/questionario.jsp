<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<script id="jsSource" type="text/javascript">
	$(function() {
		// Initialize appendGrid
		$('#tblAppendGrid').appendGrid(
				{
					caption : 'Tabela de refeições',
					initRows : 0,
					columns : [ {
						name : 'refeicao',
						display : 'Tipo de refição',
						type : 'select',
						ctrlOptions : {
							0 : 'Desjejum',
							1 : 'Lanche da Manhã',
							2 : 'Almoço',
							3 : 'Lanche da Tarde',
							4 : 'Jantar',
							5 : 'Ceia'
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
					nameFormatter : function(idPrefix, name, uniqueIndex) {
						
						return "frequencias["+uniqueIndex+"]."+name;
					},
					initData : [ {
						'refeicao' : 3,
						'horario' : '12:00',
						'SubGridData' : [ {
							Alimento : 'Poster',
							Porcao : 1
						} ]
					}, {
						'refeicao' : 3,
						'horario' : '14:00',
						'SubGridData' : [ {
							Alimento : 'Poster',
							Porcao : 1
						}, {
							Alimento : 'Poster',
							Porcao : 1
						} ]
					},

					],
					useSubPanel : true,
					subPanelBuilder : function(cell, uniqueIndex) {
						$(".hora").mask("99:99");
						// Create a table object and add to sub panel
						var subgrid = $('<table></table>').attr('id',
								'tblSubGrid_' + uniqueIndex).appendTo(cell);
						// Optional. Add a class which is the CSS scope specified when you download jQuery UI
						subgrid.addClass('alternate');
						// Initial the sub grid
						subgrid.appendGrid({
							initRows : 0,
							hideRowNumColumn : true,
							columns : [ {
								name : 'Alimento',
								display : 'Alimento',
								ctrlCss : {
									'width' : '200px'
								}
							}, {
								name : 'Porcao',
								display : 'Porção',
								ctrlCss : {
									'width' : '60px',
									'text-align' : 'right'
								},
								value : 1
							} ],
						nameFormatter : function(idPrefix, name, uniqueIndex) {
							
							return "frequencias["+uniqueIndex+"]."+name;
						},
						});
					},
					subPanelGetter : function(uniqueIndex) {
						// Return the sub grid value inside sub panel for `getAllValue` and `getRowValue` methods
						return $('#tblSubGrid_' + uniqueIndex).appendGrid(
								'getAllValue', true);
					},
					rowDataLoaded : function(caller, record, rowIndex,
							uniqueIndex) {

						if (record.SubGridData) {
							// Fill the sub grid
							$('#tblSubGrid_' + uniqueIndex, caller).appendGrid(
									'load', record.SubGridData);
						}
					}
				});
	});
</script>

<fieldset>
	<h3>Adicione as refeições</h3>
	<!-- 	${consultaNutricional.frequencias} -->
	<div class="form-group">
		<table id="tblAppendGrid">
		</table>
	</div>
</fieldset>
</html>

