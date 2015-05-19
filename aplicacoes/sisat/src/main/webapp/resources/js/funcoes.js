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
	
	
	$("#altura").mask("9.99");
	$("#peso").mask("999.99");
	$("#cc").mask("99.99");
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
		var id = $(this).attr('id');
		e.preventDefault();
		bootbox.dialog({
			  message: "Tem certeza de que deseja excluir esse arquivo?",
			  title: "Excluir",
			  buttons: {
			    danger: {
			      label: "Excluir",
			      className: "btn-danger",
			      callback: function() {
			    	  $.ajax({
			    		  type: "POST",
			    		  url: "/gpa-pesquisa/documento/ajax/remover/"+id
			    	  })
		    		  .success(function( result ) {
		    			  if(result.result == 'ok') {
		    				  $(line).parent().parent().remove();
		    			  } else {
		    				  bootbox.alert(result.mensagem, function() {
		    				  });
		    			  }
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