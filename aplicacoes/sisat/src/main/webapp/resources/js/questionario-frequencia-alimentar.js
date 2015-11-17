
function loadRecordatorio() {
	var id = $("#id").val();

	if(id > 0){
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
	}
}

function loadQuestionarios(result) {
	var i = 0;
	var frequencias = [];

		
	$.each( result, function( key, frequenciaAlimentar ) {
		var alimentos = [];
		var y = 0;
		frequenciaAlimentar.horario = frequenciaAlimentar.horario.slice(0,5);

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
             	'tipo': frequenciaAlimentar.tipo,
             	'SubGridData' : alimentos,
   	   };
	   i++;
	});

	$('#questionarioFrequenciaAlimentar').appendGrid('load', frequencias);
}


$(function() {
	$('#questionarioFrequenciaAlimentar').appendGrid({
		initRows : 0,
		maxRowsAllowed : 6,
		columns : [
		           
		{
			name : 'id',
			type : 'hidden',
		}, 
		{
			name : 'tipo',
			type : 'hidden',
		},
		{
			name : 'refeicao',
			display : 'Tipo de refição',
			type : 'select',
			ctrlOptions : 'DESJEJUM:Desjejum;COLACAO:Colação;ALMOCO:Almoço;LANCHE:Lanche;JANTAR:Jantar;CEIA:Ceia',
			ctrlClass: 'form-control',
			ctrlAttr: {
				required : 'required',
			}
		}, {
			name : 'horario',
			display : 'Hora',
			type : 'text',
			ctrlAttr : {
				maxlength : 5,
				required : 'required'
			},
			ctrlClass : 'form-control hora'
		} ],
		hideButtons: {
            moveUp: true,
            moveDown : true,
            insert: true,
            removeLast: true,
        },	
        customGridButtons: {
            append: function() {
            	return $('<a id="add-refeicao" href="#" class="btn btn-primary add-refeicao"><span class="glyphicon glyphicon-plus"></span> Refeição</a>')
            	.on('click', function (evt) {
            	});
			},
            remove: function() {
            	return $('<a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>')
            	.on('click', function (evt) {
            		deleteFrequencia($(this).parent().find('input').val());
            	})
            }
		},
		i18n : {
			rowEmpty : "Nenhum alimentação foi adicionada!"
		},
		nameFormatter : function(idPrefix, name, uniqueIndex) {
			return "frequencias[" + (uniqueIndex - 1)+ "]." + name;
		},
		useSubPanel : true,
		subPanelBuilder : function(cell, uniqueIndex) {
			var idPanel = uniqueIndex-1;

			$(".hora").mask("99:99");

			var subgrid = $('<table></table>').attr('id', 'tblSubGrid_' + uniqueIndex).attr('class', 'tblSubGrid table table-striped').appendTo(cell);

			subgrid.appendGrid({
				initRows : 1,
				hideRowNumColumn : true,
				columns : [{
					name : 'id',
					type : 'hidden',
				},          
				{
					name : 'alimento',
					display : '',
					ctrlClass: 'form-control',
					ctrlAttr: {
						required : 'required',
						placeholder : 'Alimento',
					}

				}, {
					name : 'porcao',
					display : '',
					ctrlClass: 'form-control',
					ctrlAttr: {
						required : 'required',
						placeholder : 'Porção',
					}
				} ],
				hideButtons: {
		            moveUp: true,
		            moveDown : true,
		            insert: true,
		            removeLast: true
		        },											
				i18n : {
					rowEmpty : "Nenhum alimento foi adicionado!"
				},
				nameFormatter : function(idPrefix, name, uniqueIndex) {
					if(name == 'id'){
						$('#questionarioFrequenciaAlimentar').find('table').find('.last:first a:first').remove();
					}

					return "frequencias["+ (idPanel)+ "].alimentos["+ (uniqueIndex - 1)+ "]." + name;
				},
		        customGridButtons: {
		            append: function() {
		            	return $('<a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Alimento</a>');
					},
		            remove: function() {
		            	return $('<a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>')
			            	.on('click', function (evt) {
			            		deleteAlimento($(this).parent().find('input').val());
			            	});
					},
		        },
			});
		},
		subPanelGetter : function(uniqueIndex) {
			return $('#tblSubGrid_' + uniqueIndex).appendGrid('getAllValue', true);
		},
		rowDataLoaded : function(caller, record, rowIndex, uniqueIndex) {
			if (record.SubGridData) {
				$('#tblSubGrid_' + uniqueIndex, caller).appendGrid('load',record.SubGridData);
			}
		}
	});
	
});

function deleteFrequencia(idFrequencia) {
	if(idFrequencia > 0 ){
		$.ajax({
			type: "GET",
			url: '/sisat/paciente/consulta/refeicao/' + idFrequencia + '/excluir.json',
			success: function(result) {
			},
			error: function(error) {
			}
		});
	}
}

function deleteAlimento(idAlimento) {
	if(idAlimento > 0 ){
		$.ajax({
			type: "GET",
			url: '/sisat/paciente/consulta/alimento/' + idAlimento + '/excluir.json',
			success: function(result) {
			},
			error: function(error) {
			}
		});
	}
}


function loadRecordatorio() {
	var id = $("#id").val();

	if(id > 0){
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
	}
}
