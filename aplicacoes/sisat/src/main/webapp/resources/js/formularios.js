function habilitar() {
	if (document.getElementById('checkMedicamento').checked) {
		document.getElementById('inputTextMedicamento').disabled = false;
	} else {
		document.getElementById('inputTextMedicamento').disabled = true;
	}
	if (document.getElementById('checkMastigacao').checked) {
		document.getElementById('inputTextMastigacao').disabled = false;
	} else {
		document.getElementById('inputTextMastigacao').disabled = true;
	}
	if (document.getElementById('checkAlergia').checked) {
		document.getElementById('inputTextAlergia').disabled = false;
	} else {
		document.getElementById('inputTextAlergia').disabled = true;
	}
	if (document.getElementById('checkCarneVermelha').checked) {
		document.getElementById('inputTextCarneVermelha').disabled = false;
	} else {
		document.getElementById('inputTextCarneVermelha').disabled = true;
	}
	if (document.getElementById('checkAtividadeFisica').checked) {
		document.getElementById('inputTextAtividadeFisica').disabled = false;
	} else {
		document.getElementById('inputTextAtividadeFisica').disabled = true;
	}
	if (document.getElementById('checkBebidaAlcoolica').checked) {
		document.getElementById('inputTextBebidaAlcoolica').disabled = false;
	} else {
		document.getElementById('inputTextBebidaAlcoolica').disabled = true;
	}
	if (document.getElementById('checkPatologia').checked) {
		document.getElementById('inputTextPatologia').disabled = false;
	} else {
		document.getElementById('inputTextPatologia').disabled = true;
	}
}

function habilitarEditaAvaliacao() {
	if (document.getElementById('checkMedicamento').checked) {
		document.getElementById('inputTextMedicamento').disabled = false;
	} else {
		document.getElementById('inputTextMedicamento').disabled = true;
	}
	if (document.getElementById('checkMastigacao').checked) {
		document.getElementById('inputTextMastigacao').disabled = false;
	} else {
		document.getElementById('inputTextMastigacao').disabled = true;
	}
	if (document.getElementById('checkAlergia').checked) {
		document.getElementById('inputTextAlergia').disabled = false;
	} else {
		document.getElementById('inputTextAlergia').disabled = true;
	}
	if (document.getElementById('checkCarneVermelha').checked) {
		document.getElementById('inputTextCarneVermelha').disabled = false;
	} else {
		document.getElementById('inputTextCarneVermelha').disabled = true;
	}
	if (document.getElementById('checkAtividadeFisica').checked) {
		document.getElementById('inputTextAtividadeFisica').disabled = false;
	} else {
		document.getElementById('inputTextAtividadeFisica').disabled = true;
	}
	if (document.getElementById('checkBebidaAlcoolica').checked) {
		document.getElementById('inputTextBebidaAlcoolica').disabled = false;
	} else {
		document.getElementById('inputTextBebidaAlcoolica').disabled = true;
	}
	if (document.getElementById('checkPatologia').checked) {
		document.getElementById('inputTextPatologia').disabled = false;
	} else {
		document.getElementById('inputTextPatologia').disabled = true;
	}
}

function digitos(event){
	  if (window.event) {
	    // IE
	    key = event.keyCode;
	  } 
	  else if (event.which) {
	    // netscape
	    key = event.which;
	  }
	  if (key != 8 || key != 13 || key < 48 || key > 57)
	    return (((key > 47) && (key < 58)) || (key == 8 ) || (key == 13) || (key == 46));
	    return true;
	}