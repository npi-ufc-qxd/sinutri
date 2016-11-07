$(function() {
	$(".bt-excluir-plano-alimentar").click( function(event) {
		$("#modal-exclusao-plano-alimentar").removeClass("sn-display-none");
		var dialog = sn_base.doRegistryDialog({
			title: "Excluir Plano Alimentar",
			dialog: "#modal-exclusao-plano-alimentar",
			buttons: [
		          {
		        	  label: "SIM",
		        	  attrs: {href: $(this).attr("href")}, 
                      action: function() {
                          dialog.close();
                      }
		          },
		          {
		        	  label: "NÃO",
		        	  action: function() {
		        		  dialog.close();
		        	  }
		          }
			]
		});
		
		dialog.showModal();
		event.preventDefault();
	});
});


function gerarPdf() {
	var pdf = new jsPDF('p', 'pt', 'letter'), source = $('#tableToPDF')[0], specialElementHandlers = {
		// element with id of "bypass" - jQuery style selector
		'#naoAparecer' : function(element, renderer) {
			return true
		}
	}

	, margins = {
		top : 45,
		bottom : 20,
		left : 75,
		width : 922
	};

	pdf.fromHTML(source // HTML string or DOM elem ref.
			, margins.left // x coord
			, margins.top // y coord
			, {
		'width' : margins.width // max width of content on PDF
		,
		'elementHandlers' : specialElementHandlers
	}, function(dispose) {
		pdf.setFontSize(14);
		pdf.text(200, 40, "PLANO ALIMENTAR SUGERIDO");
		pdf.setFontSize(12);
		var splitTitle = pdf.splitTextToSize("Este plano proposto é adequado ao seu momento atual. Assim, qualquer alteração no seu estado físico, na sua saúde ou exames necessita ser revista. Mantenha o seu tratamento comparecendo às consultas de retorno conforme marcado.", 500);
		pdf.text(75, 650, splitTitle);
		pdf.text(250, 700, "Ana Cláudia");
		pdf.setLineWidth(1);
		pdf.line(75, 705, 555, 705);
		pdf.text(250, 717, "Nutricionista");
		pdf.line(75, 722, 555, 722);
		pdf.save('Plano Alimentar.pdf');
	}, margins)

}

