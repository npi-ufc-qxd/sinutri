<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Alterações Gastrointestinais </br>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" path="disfagia" value="1"/>Disfagia</label>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" value="pirose"/>Pirose</label>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" value="nausea"/>Náusea</label>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" value="vomito"/>Vômitos</label>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" value="diarreia"/>Diarreia</label>
	<label class="checkbox-inline"><input type="checkbox" name="opcao" value="constipacao"/>Constipação</label> </br> 
	
	<label style="cursor: pointer;"> <input type="checkbox"
		id="check" onclick="habilitar();" /> Mastigação
	</label> <input type=text name="mastigacaoComentario" value="" size='55' disabled="disabled" id="inputText"> </br> </br> 
		
	Alergia Alimentar </br>
	<textarea rows="2" cols="75" name="alergiaComentario"/></textarea>
	</br> </br>
		
		<div>
			Consumo de água <input type="text" name="agua" size="10"> 
			<select style="width: 70px" class="form-control-inline">
				<option>Dia</option>
			</select>
				
			Consumo de carne vermelha <input type="text" name="carneVermelhaFrequencia" size="10"> 
			<select
				style="width: 70px" class="form-control-inline">
				<option>Dia</option>
				
			</select> </br>
				
			Consumo de álcool
			<select
				style="width: 70px" class="form-control-inline">
				<option>Cachaça</option>
				<option>Vodka</option>
				<option>Rum</option>
			</select>
			<input type="text" name="bebidadaAlcoolicaComentario" placeholder="Quantidade" size="10">
			<select
				style="width: 70px" class="form-control-inline">
				<option>Dia</option>
			</select> </br> </br> 
		</div>
		
		<label style="cursor: pointer;"> <input type="checkbox"
					id="checkPatologia" onclick="habilitar();" /> Patologias
		</label> </br>
		<textarea rows="2" cols="75" name="outrasPatologiasComentario" disabled="disabled" id="inputTextPatologia"></textarea> </br> </br>
		
		Objetivo da Consulta </br>
		<textarea rows="2" cols="75" name="objetivoConsulta"> </textarea> </br> </br>
		
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