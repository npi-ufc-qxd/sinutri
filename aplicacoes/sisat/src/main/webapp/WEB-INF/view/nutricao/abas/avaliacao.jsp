<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-sm-12">
	<label style="cursor: pointer;"> <input type="checkbox" id="check" onclick="habilitar();" /> Medicamentos
	</label> <input type=text size='50' disabled="disabled" id="inputText"> <br/><br/>
</div>

<div class="col-sm-12">
	Alterações Gastrointestinais <br/>
	<label class="col-sm-2"><input type="checkbox" id="check1" onclick="verificar();" name="opcao"/>Disfagia</label>
	<label class="col-sm-2"><input type="checkbox" name="opcao" value="false"/>Pirose</label>
	<label class="col-sm-2"><input type="checkbox" name="opcao" value="false"/>Náusea</label>
	<label class="col-sm-2"><input type="checkbox" name="opcao" value="false"/>Vômitos</label>
	<label class="col-sm-2"><input type="checkbox" name="opcao" value="false"/>Diarreia</label>
	<label class="col-sm-2"><input type="checkbox" name="opcao" value="false"/>Constipação</label> <br/>
</div>

<div class="col-sm-12">
	<label class="col-sm-12" style="cursor: pointer;"> 
		<input class="col-sm-0" type="checkbox" id="check" onclick="habilitar();"/>Mastigação
		<input type=text name="mastigacaoComentario" value="" size='140' disabled="disabled" id="inputText">
	</label> 
</div> <br/> <br/>

<div class="col-sm-12">
	Alergia Alimentar <br/>
	<textarea rows="2" cols="75" name="alergiaComentario"/></textarea> <br/><br/>
</div>		
	
<div class="col-sm-6">
	Consumo de água <input type="text" name="agua" size="10"> 
	<select style="width: 70px" class="form-control-inline">
		<option>Dia</option>
	</select>
</div>		

<div class="col-sm-6">	
	Consumo de carne vermelha <input type="text" name="carneVermelhaFrequencia" size="10"> 
	<select
		style="width: 70px" class="form-control-inline">
		<option>Dia</option>
	</select> <br/>
</div>	
	
<div class="form-group">
	<div class="col-sm-3">
 		Consumo de álcool
 		<input type="radio" name="bebidaAlcoolica" value="true">Sim
		<input type="radio" name="bebidaAlcoolica" value="false">Nao
	</div>
			
	<div class="col-sm-3">	
		Frequência em dias
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
		/semana
	</div>
	
	<div class="col-sm-3">
		Tipos de bebidas: <input type="text" name="bebidadaAlcoolicaComentario" size="10">
	</div>
</div> <br/>

<div class="col-sm-12">
	<label style="cursor: pointer;"> <input type="checkbox"
		id="checkPatologia" onclick="habilitar();" /> Patologias
	</label> <br/>
	<textarea rows="2" cols="75" name="outrasPatologiasComentario" disabled="disabled" id="inputTextPatologia"></textarea> <br/><br/>
</div>

<div class="col-sm-12">
	Objetivo da Consulta <br/>
	<textarea rows="2" cols="75" name="objetivoConsulta"> </textarea> <br/><br/>
</div>

	
<script>
	function habilitar() {
		if (document.getElementById('check').checked) {
			document.getElementById('inputText').disabled = false;
		} else {
			document.getElementById('inputText').disabled = true;
		}
		if (document.getElementById('checkPatologia').checked) {
			document.getElementById('inputTextPatologia').disabled = false;
		} else {
			document.getElementById('inputTextPatologia').disabled = true;
		}
	}
</script>

<script>
	verificar();
	function verificar() {
		if (document.getElementById('check1').checked) {
			document.getElementById('check1').value = true;
		} else {
			document.getElementById('check1').value = false;
		}
	}
</script>