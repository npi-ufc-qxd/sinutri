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
									$(itemForm).find("input[type='text']")
											.attr('required', 'required');
									$(itemForm).find("select").attr("disabled",
											false);
									$(itemForm).find("select").attr('required',
											'required');
									$(itemForm).find("textarea").attr(
											"disabled", false);
									$(itemForm).find("textarea").attr(
											'required', 'required');
								} else if (!$(this).is(":checked")) {
									$(itemForm).find("input[type='text']").val(
											"");
									$(itemForm).find("input[type='text']")
											.attr("disabled", true);
									$(itemForm).find("input[type='text']")
											.removeAttr('required');
									$(itemForm).find("select").attr("disabled",
											true);
									$(itemForm).find("select").prop(
											'selectedIndex', 0);
									$(itemForm).find("select").removeAttr(
											'required');
									$(itemForm).find("textarea").attr(
											"disabled", true);
									$(itemForm).find("textarea").removeAttr(
											'required');
									$(itemForm).find('.has-error').removeClass(
											'has-error');
									$(itemForm).find('.help-block').remove();
								}
							});

					$('#fileupload').MultiFile({
						accept : 'pdf|docx|png|jpg|odt',
						list : '#files',
						STRING : {
							remove : 	'<button class="btn btn-danger delete" type="button">' + 
										'<i class="glyphicon glyphicon-trash"></i>'+ 
										'<span>Remover<span>'+
										'</button>',
							selected : 'Selecionado: $file',
							denied : 'Arquivo de tipo inválido: .$ext',
							duplicate : 'Arquivo já selecionado: \n$file'
						}
					});
					
					$('.exame').change(
							function() {
								var itemForm = $(this).parent().parent()
										.parent();

								if ($(this).val() == '') {
									$(itemForm).find('.classificacao')
											.removeAttr('required');
								} else {
									$(itemForm).find('.classificacao').attr(
											'required', 'required');
								}

							});

					$('.classificacao').change(
							function() {
								var itemForm = $(this).parent().parent()
										.parent();

								if ($(this).val() == '') {
									$(itemForm).find('.exame').removeAttr(
											'required');
								} else {
									$(itemForm).find('.exame').attr('required',
											'required');
								}
							});

					$('#form-consulta')
							.validate(
									{
										rules : {
											objetivoConsulta : {
												required : true
											},
											altura : {
												required : true
											},
											peso : {
												required : true
											},
											pesoDesejado : {
												required : true
											},
											circunferenciaCintura : {
												required : true
											},
											circunferenciaCinturaDesejada : {
												required : true
											},
											agua : {
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
											objetivoConsulta : {
												required : "Descreva o objetivo da consulta do paciente."
											},
											altura : {
												required : "Informe a altura do paciente."
											},
											peso : {
												required : "Informe o peso do paciente."
											},
											pesoDesejado : {
												required : "Informe o peso desejado pelo paciente."
											},
											circunferenciaCintura : {
												required : "Informe a circunferência da cintura do paciente."
											},
											circunferenciaCinturaDesejada : {
												required : "Informe a cincunferência da cintura desejada pelo paciente."
											},
											agua : {
												required : "Informe a quantidade de copos de água consumidos pelo paciente."
											},
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
		string.value = string.value.replace(/\,/g, ".");
	}
}

function onlyNum(string) {
	string.value = string.value.replace(/[^1-9.,]+/, '');
}
