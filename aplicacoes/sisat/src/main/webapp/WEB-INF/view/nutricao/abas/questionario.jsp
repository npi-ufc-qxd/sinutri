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
						name : 'Tipo',
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
						name : 'Hora',
						display : 'Hora',
						type : 'text',
						ctrlAttr : {
							maxlength : 10
						},
						ctrlCss : {
							width : '50px',
							'text-align' : 'right'
						}
					} ],
					initData : [

					//Aqui ficam os valores 

					],
					useSubPanel : true,
					subPanelBuilder : function(cell, uniqueIndex) {
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
								name : 'Alemento',
								display : 'Alemento',
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
							} ]
						});
					},
					subPanelGetter : function(uniqueIndex) {
						// Return the sub grid value inside sub panel for `getAllValue` and `getRowValue` methods
						return $('#tblSubGrid_' + uniqueIndex).appendGrid(
								'getAllValue', true);
					},
					rowDataLoaded : function(caller, record, rowIndex,
							uniqueIndex) {
						// Check SubGridData exist in the record data
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
	<div class="form-group">
		<table id="tblAppendGrid">
		</table>
	</div>
</fieldset>

<script
	src="<c:url value="../../resources/js/questionario-frequencia-alimentar.js" />"></script>

</html>

