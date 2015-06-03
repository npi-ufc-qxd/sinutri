$(document).ready(function() {
	
	$('.check').change(function(){
		var itemForm = $(this).parent().parent(); 		
		if($('.check').is(':checked')){
			$(itemForm).find("input").prop("disabled",false);			
		}else {
			$(itemForm).find("input[type=text]").prop("disabled",true);
			$(itemForm).removeClass('has-error');
			$(itemForm).find('span').remove();
			$(itemForm).find("input[type=text]").val(''); 
		}
	});
	
	$('#consultaNutricional').validate({
        rules: {
        	objetivoConsulta:{ 
        		required: true,
                maxlength: 250,
                minlength: 50
        	},
        	altura:{
        		requered: true,
        		number: true
        	},
        	peso:{
        		requered: true,
        		number: true
        	},
        	cc:{
        		requered: true,
        		number: true
        	},
        	medicamentoComentario:{
        		required: $('#checkMedicamento').val(),
        		required: true
			},
			mastigacaoComentario:{
        		required: $('#checkMastigacao').val(),
        		required: true
			},
			alergiaComentario:{
        		required: $('#checkAlergia').val(),
        		required: true
			},
			atividadeFisicaComentario:{
        		required: $('#checkAtividadeFisica').val(),
        		required: true
			},
			carneVermelhaComentario:{
        		required: $('#checkCarneVermelha').val(),
        		required: true
			},
			bebidaAlcoolicaComentario:{
        		required: $('#checkBebidaAlcoolica').val(),
        		required: true
			},
			outrasPatologiasComentario:{
        		required: $('#checkPatologia').val(),
        		required: true
			}
			
        },
        highlight: function(element) {
            $(element).closest('.form-item').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-item').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent().children().last());
        },
        messages:{
        	altura:{
        		required:"Somente valores numericos.",
        	},
        	cc:{
        		required:"Somente valores numericos.",
        	},        
        	peso:{
        		required:"Somente valores numericos.",
        	},  
        	objetivoConsulta:{
                required:"Preencha o campo de objetivo da consulta para o paciente.",
            },
            medicamentoComentario:{
            	required:"Preencha o campo de medicamentos da consulta.",
            },	
            mastigacaoComentario:{
            	required:"Preencha o campo de mastigação da consulta.",
            },
            alergiaComentario:{
            	required:"Preencha o campo de Alergia Alimentar da consulta.",
            },
            atividadeFisicaComentario:{
            	required:"Preencha o campo de Atividade Fisica da consulta.",
            },
            carneVermelhaComentario:{
            	required:"Preencha o campo de Carne Vermelha da consulta.",
            },
            bebidaAlcoolicaComentario:{
            	required:"Preencha o campo de Bebida Alcoólica da consulta.",
            },
            outrasPatologiasComentario:{
            	required:"Preencha o campo de Patologia da consulta.",
            }
        }
    });
		
	
	$("#agua").mask("99.99");
	$("#glicemia").mask("99999");
	$("#ct").mask("99999");
	$("#ldl").mask("99999");
	$("#hdl").mask("99999");
	$("#tg").mask("99999");
	$("#hb").mask("99999");
	$("#tgo").mask("99999");
	$("#tgp").mask("99999");	
	
	
	$('div.error-validation:has(span)').find('span').css('color', '#a94442');
	$('div.error-validation:has(span)').find('span').parent().parent().parent().addClass('has-error has-feedback');
	
	$("input.data").datepicker({
		format : "dd/mm/yyyy",
		todayBtn : "linked",
		autoclose : true,
		language : "pt-BR",
		todayHighlight : true
	});
	
	$('.tab a').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	});
	
	$('#confirm-delete').on('show.bs.modal', function(e) {
		$(this).find('.btn-danger').attr('href', $(e.relatedTarget).data('href'));
	});
	
	$('#confirm-submit').on('show.bs.modal', function(e) {
	    $(this).find('.btn-primary').attr('href', $(e.relatedTarget).data('href'));
	});
	
	$('.delete-document').on('click', function (e) {
		var line = this;
		var href = $(this).attr('href');
		e.preventDefault();
		bootbox.dialog({
			  message: "Tem certeza de que deseja excluir esse documento?",
			  title: "Excluir",
			  buttons: {
			    danger: {
			      label: "Excluir",
			      className: "btn-danger",
			      callback: function() {
			    	  $.ajax({
			    		  type: "GET",
			    		  url: href
			    	  })
		    		  .success(function( result ) {
		    			  var tr = $(line).parent().parent().remove();		    			  
		    		  });
			      }
			    },
			    main: {
			      label: "Cancelar",
			      className: "btn-default",
			      callback: function() {
			      }
			    }
			  }
			});
    });
	
	
	//Enviar
	$('.send-document').on('click', function (e) {
		var line = this;
		var href = $(line).attr('href');
		
		e.preventDefault();
		bootbox.dialog({
			  message: "<textarea id = 'mensagem' name='mensagem' rows='6' cols='72'></textarea>",
			  title: "Mensagem para o paciente",
			  buttons: {
			    danger: {
			      label: "Enviar",
			      className: "btn btn-warning",
			      callback: function() {
			    	  var mensagem = $('#mensagem').val();
			    	  href+=mensagem;
			    	  $.ajax({
			    		  type: "GET",
			    		  url: href
			    	  })
		    		  .success(function( result ) {
		    			  
		    		  });
			      }
			    },
			    main: {
			      label: "Cancelar",
			      className: "btn-default",
			      callback: function() {
			      }
			    }
			  }
			});
    });
	
	
	$('input[type=file]').bootstrapFileInput();
	
	$('.delete-file').click(function(){
		alert($(this).attr('id'));
	});	
});