$(document)
		.ready(
				function() {

					$("input[type='checkbox']").change(
							function() {
								var itemForm = $(this).parent().parent()
										.parent();

								if ($(this).is(":checked")) {
									$(itemForm).find("input[type='text']")
											.attr("disabled", false);
									$(itemForm).find("select").attr("disabled",
											false);
									$(itemForm).find("textarea").attr(
											"disabled", false);
								}

								else if ($(this).not(":checked")) {
									var valueEmpty = "";
									$(itemForm).find("input[type='text']")
											.attr('value', valueEmpty);
									$(itemForm).find("input[type='text']")
											.attr("disabled", true);
									$(itemForm).find("textarea").attr(
											"disabled", true);
									$(itemForm).find("select").attr("disabled",
											true);
								}
							});

					$('#consultaNutricional')
							.validate(
									{
										rules : {
											agua : {
												required : true,
												digits : true
											},
											objetivoConsulta : {
												required : true,
											},
											altura : {
												requered : true,
												number : true
											},
											peso : {
												requered : true,
												number : true
											},
											circunferenciaCintura : {
												required : true
											},
											circunferenciaCinturaDesejada : {
												required : true
											},
											medicamentoComentario : {
												required : $(
														'#checkMedicamento')
														.val(),
												required : true
											},
											mastigacaoComentario : {
												required : $('#checkMastigacao')
														.val(),
												required : true
											},
											alergiaComentario : {
												required : $('#checkAlergia')
														.val(),
												required : true
											},
											atividadeFisicaComentario : {
												required : $(
														'#checkAtividadeFisica')
														.val(),
												required : true
											},
											atividadeFisicaFrequenciaSemanal : {
												required : $(
														'#checkAtividadeFisica')
														.val(),
												required : true
											},
											carneVermelhaComentario : {
												required : $(
														'#checkCarneVermelha')
														.val(),
												required : true
											},
											carneVermelhaFrequenciaSemanal : {
												required : $(
														'#checkCarneVermelha')
														.val(),
												required : true
											},
											bebidaAlcoolicaComentario : {
												required : $(
														'#checkBebidaAlcoolica')
														.val(),
												required : true
											},
											bebidaAlcoolicaFrequenciaSemanal : {
												required : $(
														'#checkBebidaAlcoolica')
														.val(),
												required : true
											},
											outrasPatologiasComentario : {
												required : $('#checkPatologia')
														.val(),
												required : true
											},

											glicemia : {
												digits : true
											},
											ldl : {
												digits : true
											},
											tg : {
												digits : true
											},
											tgo : {
												digits : true
											},
											ct : {
												digits : true
											},
											hdl : {
												digits : true
											},
											hb : {
												digits : true
											},
											tgp : {
												digits : true
											},

											classificacaoGlicemia : {
												required : true
											},
											classificacaoLdl : {
												required : true
											},
											classificacaoTg : {
												required : true
											},
											classificacaoTgo : {
												required : true
											},
											classificacaoCt : {
												required : true
											},
											classificacaoHdl : {
												required : true
											},
											classificacaoHb : {
												required : true
											},
											classificacaoTgp : {
												required : true
											}

										},
										highlight : function(element) {
											$(element).closest('.form-item')
													.addClass('has-error');
										},
										unhighlight : function(element) {
											$(element).closest('.form-item')
													.removeClass('has-error');
										},
										errorElement : 'span',
										errorClass : 'help-block',
										errorPlacement : function(error,
												element) {
											error.insertAfter(element.parent()
													.children().last());
										},
										messages : {
											peso : {
												required : "Informe o peso do paciente."
											},
											circunferenciaCintura : {
												required : "Informe o comprimento da cintura do Paciente."
											},
											agua : {
												required : "Informe o consumo de água do paciente"
											},
											altura : {
												required : "Somente valores numericos.",
											},
											cc : {
												required : "Somente valores numericos.",
											},
											objetivoConsulta : {
												required : "Preencha o campo de objetivo da consulta para o paciente.",
											},
											medicamentoComentario : {
												required : "Preencha o campo de medicamentos da consulta.",
											},
											mastigacaoComentario : {
												required : "Preencha o campo de mastigação da consulta.",
											},
											alergiaComentario : {
												required : "Preencha o campo de Alergia Alimentar da consulta.",
											},
											atividadeFisicaComentario : {
												required : "Preencha o campo de Atividade Fisica da consulta.",
											},
											atividadeFisicaFrequenciaSemanal : {
												required : "Preencha a frequência semanal"
											},
											carneVermelhaComentario : {
												required : "Preencha o campo de Carne Vermelha da consulta.",
											},
											carneVermelhaFrequenciaSemanal : {
												required : "Preencha a frequência semanal."
											},
											bebidaAlcoolicaComentario : {
												required : "Preencha o campo de Bebida Alcoólica da consulta.",
											},
											bebidaAlcoolicaFrequenciaSemanal : {
												required : "Informe a frequência semanal."
											},
											outrasPatologiasComentario : {
												required : "Preencha o campo de Patologia da consulta.",
											},
											classificacaoGlicemia : {
												required : "Informe a classificação da Glicemia."
											},
											classificacaoLdl : {
												required : "Informe a classificação da LDL."
											},
											classificacaoTg : {
												required : "Informe a classificação da TG."
											},
											classificacaoTgo : {
												required : "Informe a classificação da TGO."
											},
											classificacaoCt : {
												required : "Informe a classificação da CT."
											},
											classificacaoHdl : {
												required : "Informe a classificação da HDL-C."
											},
											classificacaoHb : {
												required : "Informe a classificação da HB."
											},
											classificacaoTgp : {
												required : "Informe a classificação da TGP."
											}
										}
									});

					$('div.error-validation:has(span)').find('span').css(
							'color', '#a94442');
					$('div.error-validation:has(span)').find('span').parent()
							.parent().parent().addClass(
									'has-error has-feedback');

					$('#confirm-delete').on(
							'show.bs.modal',
							function(e) {
								$(this).find('.btn-danger').attr('href',
										$(e.relatedTarget).data('href'));
							});

					$('#confirm-submit').on(
							'show.bs.modal',
							function(e) {
								$(this).find('.btn-primary').attr('href',
										$(e.relatedTarget).data('href'));
							});

					$('.delete-document')
							.on(
									'click',
									function(e) {
										var line = this;
										var href = $(this).attr('href');
										e.preventDefault();
										bootbox
												.dialog({
													message : "Tem certeza de que deseja excluir esse documento?",
													title : "Excluir",
													buttons : {
														danger : {
															label : "Excluir",
															className : "btn-danger",
															callback : function() {
																$
																		.ajax(
																				{
																					type : "GET",
																					url : href
																				})
																		.success(
																				function(
																						result) {
																					var tr = $(
																							line)
																							.parent()
																							.parent()
																							.remove();
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

					// Enviar
					$('.send-document')
							.on(
									'click',
									function(e) {
										var line = this;
										var href = $(line).attr('href');

										e.preventDefault();
										bootbox
												.dialog({
													message : "<textarea id = 'mensagem' name='mensagem' rows='6' cols='72'></textarea>",
													title : "Mensagem para o paciente",
													buttons : {
														danger : {
															label : "Enviar",
															className : "btn btn-warning",
															callback : function() {
																var mensagem = $(
																		'#mensagem')
																		.val();
																href += mensagem;
																$
																		.ajax(
																				{
																					type : "GET",
																					url : href
																				})
																		.success(
																				function(
																						result) {

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

					$('input[type=file]').bootstrapFileInput();

					$('.delete-file').click(function() {
						alert($(this).attr('id'));
					});
				});

function commaToDot(string) {
	if (string.value.indexOf(",") >= 0) {
		string.value = string.value.replace(/\,/g,".");
	}
}
