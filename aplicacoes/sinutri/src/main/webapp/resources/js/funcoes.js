$(document).ready(function() {
	$('a.back').click(function(){
		parent.history.back();
		return false;
	});
	
	$(".checkboxInput").change(function() {
		var itemForm = $(this).parent().parent();

		if ($(this).is(":checked")) {
			$(itemForm).find("input[type='text']").attr("disabled", false);
			$(itemForm).find("input[type='text']").attr('required', 'required');
			$(itemForm).find("textarea").attr("disabled", false);
			$(itemForm).find("textarea").attr('required', 'required');

		} else if (!$(this).is(":checked")) {
			$(itemForm).find("input[type='text']").val("");
			$(itemForm).find("input[type='text']").attr("disabled", true);
			$(itemForm).find("input[type='text']").removeAttr('required');
			$(itemForm).find("textarea").attr("disabled", true);
			$(itemForm).find("textarea").removeAttr('required');
			$(itemForm).removeClass('has-error');
			$(itemForm).find('.help-block').remove();
		}
		
	});

	$(".checkboxInputSelect").change(function() {
		var itemForm = $(this).parent().parent().parent();

		if ($(this).is(":checked")) {
			$(itemForm).find("input[type='text']").attr("disabled", false);
			$(itemForm).find("input[type='text']").attr('required', 'required');
			$(itemForm).find("select").attr("disabled", false);
			$(itemForm).find("select").attr('required', 'required');
		} else if (!$(this).is(":checked")) {
			$(itemForm).find("input[type='text']").attr("disabled", true);
			$(itemForm).find("select").attr("disabled",true);
			$(itemForm).find("select").prop('selectedIndex', 0);
			$(itemForm).find('.has-error').removeClass('has-error');
			$(itemForm).find('.help-block').remove();
		}
	});

	$(".checkInquerito").change(function() {
		var itemForm = $(this).parent().parent().parent();

		if ($(this).is(":checked")) {
			$(itemForm).find("input[type='text']").attr("disabled", false);
			$(itemForm).find("input[type='text']").attr('required', 'required');
			
			$(itemForm).find("select").attr("disabled", false);
			$(itemForm).find("select").attr('required', 'required');
			
		} else if (!$(this).is(":checked")) {
			$(itemForm).find("input[type='text']").attr("disabled", true);
			$(itemForm).find("input[type='text']").val("");
			$(itemForm).find("select").attr("disabled",true);
			$(itemForm).find("select").prop('selectedIndex', 0);
			$(itemForm).find('.has-error').removeClass('has-error');
			$(itemForm).find('.help-block').remove();
		}
	});
	
	$('.valid-num').focusout(function() {
		if ($(this).val().indexOf(",") >= 0) {
			$(this).val($(this).val().replace(/\,/g, "."));
		}
		$(this).val($(this).val().replace(/^[0][0-9]*$/, ''));
	});

	$('#confirm-delete').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
	
	$('#confirm-delete-plano-alimentar').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
	
	$('.exame').change( function() {
		var itemForm = $(this).parent().parent().parent();
	
		if ($(this).val() == '') {
			$(itemForm).find('.classificacao').removeAttr('required');
		} else {
			$(itemForm).find('.classificacao').attr('required', 'required');
		}
	});

	$('.classificacao').change(function() {
				var itemForm = $(this).parent().parent().parent();

				if ($(this).val() == '') {
					$(itemForm).find('.exame').removeAttr('required');
				} else {
					$(itemForm).find('.exame').attr('required', 'required');
				}
			});
	
	$.extend(jQuery.validator.messages, {
	    required: "Campo obrigatório",
	});

	$('#login-form').validate({
		rules : {
			j_username : {
				required : true
			},
			j_password : {
				required : true
			}
		},
		highlight : function(element) {
			$(element).closest('.form-control')
					.addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-control')
			.removeClass('has-error');
			$(element).closest('.form-control')
			.removeClass('has-success');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function(error,
				element) {
			error.insertAfter(element.parent()
					.children().last());
			var itemForm = element.parent();
			var id = element.attr("name");
			$(itemForm).find("span").attr("id",
					id);
		},
		messages : {
			j_username : {
				required : "Preencha o CPF do usuário."
			},
			j_password : {
				required : "Preencha a senha do usuário."
			}
		}
	});

	$('#form-consulta')
			.validate(
					{
						rules : {
						},
						highlight : function(element) {
							$(element).closest('.form-item')
									.addClass('has-error');
						},
						unhighlight : function(element) {
							$(element).closest('.form-group')
									.removeClass('has-error');
						},
						errorElement : 'span',
						errorClass : 'help-block',
						errorPlacement : function(error,
								element) {
							error.insertAfter(element.parent()
									.children().last());
							var itemForm = element.parent();
							var id = element.attr("name");
							$(itemForm).find("span").attr("id",
									id);
						},
						messages : {
							atividadeFisicaComentario : {
								required : "Informe qual a(s) ativadade(s) física(s) praticada(s) pelo paciente."
							},
							atividadeFisicaFrequenciaSemanal : {
								required : "Informe qual a frequência da(s) atividade(s) física(s) praticada(s) pelo paciente."
							},
							carneVermelhaComentario : {
								required : "Informe o tipo de carne vermelha consumida pelo paciente."
							},
							carneVermelhaFrequenciaSemanal : {
								required : "Informe a frequência do consumo de carne vermelha pelo paciente."
							},
							bebidaAlcoolicaComentario : {
								required : "Informe a bebida alcoólica comsumida pelo paciente."
							},							
							bebidaAlcoolicaFrequenciaSemanal : {
								required : "Informe a frequência do consumo de bebiba alcoólica pelo paciente."
							},
							cigarroComentario : {
								required : ""
							},
							cigarroFrequenciaSemanal : {
								required : "Informe a frequência do consumo de cigarro pelo paciente."
							},
							medicamentoComentario : {
								required : "Informe o(s) medicamento(s) utilizado(s) pelo paciente."
							},
							mastigacaoComentario : {
								required : "Informe características da mastigação do paciente."
							},
							disfagiaComentario : {
								required : "Informe comentários sobre a disfagia do paciente."
							},
							odinofagiaComentario : {
								required : "Informe comentários sobre a odinofagia do paciente."
							},
							piroseComentario : {
								required : "Informe comentários sobre a pirose do paciente."
							},
							nauseaComentario : {
								required : "Informe comentários sobre náuseas do paciente."
							},
							vomitoComentario : {
								required : "Informe comentários sobre vômitos do paciente."
							},
							diarreiaComentario : {
								required : "Informe comentários sobre a diarreia do paciente."
							},
							constipacaoComentario : {
								required : "Informe comentários sobre a constipação do paciente."
							},
							alergiaComentario : {
								required : "Informe se o paciente possui alguma alergia alimentar."
							},
							outrasPatologiasComentario : {
								required : "Informe outras patologias do paciente."
							},
							glicemia : {
								required : "Informe o nível de glicemia do paciente."
							},
							classificacaoGlicemia : {
								required : "Informe a classificação da glicemia do paciente."
							},
							ct : {
								required : "Informe o nível de CT do paciente."
							},
							classificacaoCt : {
								required : "Informe a classificação do CT do paciente."
							},
							ldlc : {
								required : "Informe o nível de LDL-C do paciente."
							},
							classificacaoLdlc : {
								required : "Informe a classificação do LDL-C do paciente."
							},
							hdlc : {
								required : "Informe o nível de HDL-C do paciente."
							},
							classificacaoHdlc : {
								required : "Informe a classificação de HDL-C do paciente."
							},
							tg : {
								required : "Informe o nível de TG do paciente."
							},
							classificacaoTg : {
								required : "Informe a classificação do TG do paciente."
							},
							hb : {
								required : "Informe o nível de HB do paciente."
							},
							classificacaoHb : {
								required : "Informe a classificação do HB do paciente."
							},
							tgo : {
								required : "Informe o nível de TGO do paciente."
							},
							classificacaoTgo : {
								required : "Informe a classificação de TGO do paciente."
							},
							tgp : {
								required : "Informe o nível de TGP do paciente."
							},
							classificacaoTgp : {
								required : "Informe a classificação do TGP do paciente."
							},
							bovinaQuantidade : {
								required: "Informe a quantidade de carne Bovina."
							}
						}
					});
					
					$('#form-alimento-subst').validate(
						{
							rules : {
								nomeAlimento : {
									required : true
								},
								grupo : {
									required : true
								}
							},
							highlight : function(element) {
								$(element).closest('.form-item')
										.addClass('has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group')
										.removeClass('has-error');
							},
							errorElement : 'span',
							errorClass : 'help-block',
							errorPlacement : function(error,
									element) {
								error.insertAfter(element.parent()
										.children().last());
								var itemForm = element.parent();
								var id = element.attr("name");
								$(itemForm).find("span").attr("id",
										id);
							}, 
							messages : {
								nomeAlimento : {
									required : "O nome do alimento não pode ser vazio."
								},
								grupo : {
									required : "Selecione o grupo alimetício ao qual o alimento pertence."
								}
							}
						});

	$('div.error-validation:has(span)').find('span').css(
			'color', '#a94442');
	$('div.error-validation:has(span)').find('span').parent()
			.parent().parent().addClass(
					'has-error has-feedback');

	// Enviar
	$('.send-document').on('click',
function(e) {
	var line = this;
	var href = $(line).attr('href');

	e.preventDefault();
	bootbox.dialog({
			message : "<textarea id = 'mensagem' name='mensagem' rows='6' cols='72'></textarea>",
			title : "Mensagem para o paciente",
			buttons : {
				danger : {
					label : "Enviar",
					className : "btn btn-warning",
					callback : function() {
						var mensagem = $(
								'#mensagem').val();
						href += mensagem;
						$.ajax({
							type : "GET",
							url : href
						}).success(function(result) {

						});
					}
				},
				main : {
					label : "Cancelar",
					className : "btn-default",
					callback : function() {
					}
				}
			}
		});
	});

	$('.delete-file').click(function() {
		alert($(this).attr('id'));
	});

	$(".anexo").fileinput({
    	uploadUrl: "/file-upload-batch/2",
    	showUpload:false,
    	showRemove: false,
    	language: 'pt-BR',
    	uploadAsync: false,
    	layoutTemplates: {
	        actions: '<div class="file-actions">\n' +
	        '    <div class="file-footer-buttons">\n' +
	        '        {delete}' +
	        '    </div>\n' +
	        '    <div class="clearfix"></div>\n' +
	        '</div>'
    	}
    });
	
});