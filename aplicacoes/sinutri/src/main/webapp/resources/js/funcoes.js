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
							objetivoConsulta : {
								maxlength: 256
							},
							medicamentoComentario:{
								maxlength: 256
							},
							mastigacaoComentario:{
								maxlength: 256
							},
							alergiaComentario:{
								maxlength: 256
							},
							outrasPatologiasComentario:{
								maxlength: 256
							},
							disfagiaComentario:{
								maxlength: 256
							},
							odinofagiaComentario:{
								maxlength: 256
							},
							piroseComentario:{
								maxlength: 256
							},
							nauseaComentario:{
								maxlength: 256
							},
							vomitoComentario:{
								maxlength: 256
							},
							diarreiaComentario:{
								maxlength: 256
							},
							constipacaoComentario:{
								maxlength: 256
							},
							carneVermelhaComentario:{
								maxlength: 256
							},
							bebidaAlcoolicaComentario:{
								maxlength: 256
							},
							atividadeFisicaComentario:{
								maxlength: 256
							},
							intoleranciaComentario:{
								maxlength: 256
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
							objetivoConsulta : {								
								maxlength: "O objetivo da consulta deve ter menos que 256 carácteres"
							},
							altura : {
								min: "O valor não pode ser negativo"
							},
							peso : {
								min: "O valor não pode ser negativo"								
							},
							pesoDesejado : {
								min: "O valor não pode ser negativo"
							},
							circunferenciaCintura : {
								min: "O valor não pode ser negativo"
							},
							circunferenciaCinturaDesejada : {
								min: "O valor não pode ser negativo"
							},
							atividadeFisicaComentario : {
								required : "Informe qual a(s) ativadade(s) física(s) praticada(s) pelo paciente.",
								maxlength: "A(s) atividade(s) física(s) precisa(m) ocupar menos que 256 carácteres"

							},
							atividadeFisicaFrequenciaSemanal : {
								required : "Informe qual a frequência da(s) atividade(s) física(s) praticada(s) pelo paciente."
							},
							carneVermelhaComentario : {
								required : "Informe o tipo de carne vermelha consumida pelo paciente.",
								maxlength: "O comentários sobre carne vermelha precisam ocupar menos que 256 carácteres"

							},
							carneVermelhaFrequenciaSemanal : {
								required : "Informe a frequência do consumo de carne vermelha pelo paciente."
							},
							bebidaAlcoolicaComentario : {
								required : "Informe a bebida alcoólica comsumida pelo paciente.",
								maxlength: "Os comentários sobre disfagia precisam ocupar menos que 256 carácteres"

							},
							bebidaAlcoolicaFrequenciaSemanal : {
								required : "Informe a frequência do consumo de bebiba alcoólica pelo paciente."
							},
							cigarroComentario : {
								required : "Informe o comentário."
							},
							cigarroFrequenciaSemanal : {
								required : "Informe a frequência do consumo de cigarro pelo paciente."
							},
							medicamentoComentario : {
								required : "Informe o(s) medicamento(s) utilizado(s) pelo paciente.",
								maxlength: "A descrição dos medicamentos precisam ter menos de 256 carácteres"
							},
							mastigacaoComentario : {
								required : "Informe características da mastigação do paciente.",
								maxlength: "As características da mastigação precisam ocupar menos de 256 carácteres"
							},
							disfagiaComentario : {
								required : "Informe comentários sobre a disfagia do paciente.",
								maxlength: "Os comentários sobre disfagia precisam ocupar menos que 256 carácteres"
							},
							odinofagiaComentario : {
								required : "Informe comentários sobre a odinofagia do paciente.",
								maxlength: "Os comentários sobre odinofagia precisam ocupar menos que 256 carácteres"

							},
							piroseComentario : {
								required : "Informe comentários sobre a pirose do paciente.",
								maxlength: "Os comentários sobre pirose precisam ocupar menos que 256 carácteres"

							},
							nauseaComentario : {
								required : "Informe comentários sobre náuseas do paciente.",
								maxlength: "Os comentários sobre náuseas precisam ocupar menos que 256 carácteres"

							},
							vomitoComentario : {
								required : "Informe comentários sobre vômitos do paciente.",
								maxlength: "Os comentários sobre vômitos precisam ocupar menos que 256 carácteres"

							},
							diarreiaComentario : {
								required : "Informe comentários sobre a diarreia do paciente.",
								maxlength: "Os comentários sobre diarreia precisam ocupar menos que 256 carácteres"

							},
							constipacaoComentario : {
								required : "Informe comentários sobre a constipação do paciente.",
								maxlength: "Os comentários sobre constipação precisam ocupar menos que 256 carácteres"

							},
							alergiaComentario : {
								required : "Informe se o paciente possui alguma alergia alimentar.",
								maxlength: "Os comentário sobre alergia alimentar precisam ocupar menos que 256 carácteres"
							},
							intoleranciaComentario : {
								required : "Informe se o paciente possui alguma intolerância alimentar.",
								maxlength: "Os comentário sobre intolerância alimentar precisam ocupar menos que 256 carácteres"
							},
							outrasPatologiasComentario : {
								required : "Informe outras patologias do paciente.",
								maxlength: "A descrição de outras patologias precisam ocupar menos que 256 carácteres"
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
	$('#form-cadastro-paciente-externo').validate(
			{
				rules : {
					nome : {
						required : true
					},
					dataNascimento : {
						required : true
					},
					vinculo : {
						required : true
					},
					telefone : {
						required : true
					},
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
					nome : {
						required : "Informe o nome do paciente."
					},
					dataNascimento : {
						required : "Informe a data de nascimento do paciente."
					},
					vinculo : {
						required : "Informe o vinculo do paciente com a universidade."
					},
					telefone : {
						required : "Informe o telefone do paciente."
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
	
	aplicarMascaras();
});

//Definição das Mascaras
$.mask.definitions['H'] = "[0-2]";
$.mask.definitions['h'] = "[0-9]";
$.mask.definitions['M'] = "[0-5]";
$.mask.definitions['m'] = "[0-9]";

function aplicarMascaras(){
	$(".hora").mask("Hh:Mm",
			{ completed:function(){
				if(this.val()>="24:00"){
					this.val("00:00");
				}
			}
	});
}

	
$(function(){
	$('.datepicker').datepicker({
	    format: 'dd/mm/yyyy',
	});
});

