$(document).ready(function() {
	
	$("#altura").mask("9.9");
	$("#peso").mask("99.99");
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
			    		  url: "../../"+href
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