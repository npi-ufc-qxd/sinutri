<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-sm-12">
	<br/><br/>
	<label>Informações do Paciente</label> <br/><br/>
	<div class="col-sm-3">
		<label>Altura</label><input type="text" name="paciente.altura" size="10" value="${paciente.altura }">
	</div>
	<div class="col-sm-3">
		<label>Peso</label><input type="text" name="peso" size="10">
	</div>
	<div class="col-sm-3">
		<label>CC</label><input type="text" name="circunferenciaCintura" size="10">
	</div>
</div>

<div class="col-sm-12">
	<div style="cursor: pointer;"></div> <br/>
	<input type="checkbox" name="medicamento" id="checkMedicamento" onclick="habilitar();"/><label>Medicamentos</label>
	<input type=text name="medicamentoComentario" size='123' disabled="disabled" id="inputTextMedicamento"/> <br/><br/>
</div>

<div class="col-sm-12">
	<label>Alterações Gastrointestinais</label> <br/>
	<div class="col-sm-2"><input type="checkbox" name="disfagia" value="true"/><label>Disfagia</label></div>
	<div class="col-sm-2"><input type="checkbox" name="pirose" value="true"/><label>Pirose</label></div>
	<div class="col-sm-2"><input type="checkbox" name="nausea" value="true"/><label>Náusea</label></div>
	<div class="col-sm-2"><input type="checkbox" name="vomito" value="true"/><label>Vômitos</label></div>
	<div class="col-sm-2"><input type="checkbox" name="diarreia" value="true"/><label>Diarreia</label></div>
	<div class="col-sm-2"><input type="checkbox" name="constipacao" value="true"/><label>Constipação</label></div>
	
	<div class="col-sm-12" style="cursor: pointer;">
		<input class="col-sm-0" type="checkbox" name="mastigacao" id="checkMastigacao" onclick="habilitar();"/><label>Mastigação</label>
		<input type=text name="mastigacaoComentario" value="" size='123' disabled="disabled" id="inputTextMastigacao"/>
	</div>
</div>

<div class="col-sm-12">
	<div style="cursor: pointer;"></div> <br/>
	<input type="checkbox" name="alergia" id="checkAlergia" onclick="habilitar();"/><label>Alergia Alimentar</label>
	<textarea rows="2" cols="140" name="alergiaComentario" disabled="disabled" id="inputTextAlergia"></textarea>
</div>

<div class="col-sm-12">
	<label>Consumo de água</label><input type="text" name="agua" size="10"><label>Litros</label>
</div>

<div class="col-sm-12">
	<div style="cursor: pointer;"></div>
		<input type="checkbox" name="carneVermelha" id="checkCarneVermelha" onclick="habilitar();"/><label>Carne Vermelha</label>
		<input type=text name="carneVermelhaComentario" size='20' disabled="disabled" id="inputTextCarneVermelha"/>
	
	<label>Frequência de</label>
	<select name="carneVermelhaFrequenciaSemanal" id="carneVermelhaFrequenciaSemanal" style="width: 70px" class="form-control-inline">
		<option value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
	<label>dias por semana</label>
</div>

<div class="col-sm-12">
	<div style="cursor: pointer;"></div>
		<input type="checkbox" name="atividadeFisica" id="checkAtividadeFisica" onclick="habilitar();"/><label>Atividade Física</label>
		<input type=text name="atividadeFisicaComentario" size='20' disabled="disabled" id="inputTextAtividadeFisica"/>

	<label>Frequência de</label>
	<select name="atividadeFisicaFrequenciaSemanal" id="atividadeFisicaFrequenciaSemanal" style="width: 70px" class="form-control-inline">
		<option value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
	<label>dias por semana</label>
</div>

<div class="col-sm-12">
	<div style="cursor: pointer;"></div>
	<input type="checkbox" name="bebidaAlcoolica" id="checkBebidaAlcoolica" onclick="habilitar();"/><label>Bebida alcoólica</label>
	<input type=text name="bebidaAlcoolicaComentario" size='20' disabled="disabled" id="inputTextBebidaAlcoolica"/>

	<label>Frequência de</label>
	<select name="bebidaAlcoolicaFrequenciaSemanal" id="bebidaAlcoolicaFrequenciaSemanal" style="width: 70px" class="form-control-inline">
		<option value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
	<label>dias por semana</label>
</div>	

<div class="col-sm-12">
	<div style="cursor: pointer;"></div> <br/>
	<input type="checkbox" name="outrasPatologias" id="checkPatologia" onclick="habilitar();"/><label>Patologias</label><br/>
	<textarea rows="2" cols="140" name="outrasPatologiasComentario" disabled="disabled" id="inputTextPatologia"></textarea> <br/><br/>
</div>

<div class="col-sm-12">
	<label>Objetivo da Consulta</label> <br/>
	<textarea rows="2" cols="140" name="objetivoConsulta"> </textarea> <br/><br/>
</div>

<script>
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
</script>