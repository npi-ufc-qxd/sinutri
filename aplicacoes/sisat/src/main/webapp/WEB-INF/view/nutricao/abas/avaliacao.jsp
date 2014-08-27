<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	function habilitar() {
		if (document.getElementById('check').checked) {
			document.getElementById('inputText').disabled = false;
		} else {
			document.getElementById('inputText').disabled = true;
		}
	}
</script>

			<label style="cursor: pointer;"> <input type="checkbox"
				id="check" onclick="habilitar();" /> Medicamentos
			</label> <input type=text size='50' disabled="disabled"
				id="inputText"> </br> </br> 
				
			Alterações Gastrointestinais </br>
			
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox1" value="option1"> Disfagia </label>
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox2" value="option2"> Pirose </label>
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3" value="option3"> Náusea </label>
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox4" value="option4"> Vômitos </label>
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox5" value="option5"> Diarreia </label>
			<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox6" value="option6"> Constipação </label> </br> <label style="cursor: pointer;"> <input type="checkbox"
				id="check" onclick="habilitar();" /> Mastigação
			</label> <input type=text size='55' disabled="disabled"
				id="inputText"> </br> </br> 
			
			Alergia Alimentar </br>
			<textarea rows="2" cols="75"> </textarea> 
			</br> </br>

			<div>
				Consumo de água <input type="text" name="consumoagua" size="10"> 
				<select
					style="width: 70px" class="form-control-inline">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
				
				Consumo de carne vermelha <input type="text" name="consumocarne" size="10"> 
				<select
					style="width: 70px" class="form-control-inline">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select> </br>
				
				Consumo de álcool
				<select
					style="width: 70px" class="form-control-inline">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
				<input type="text" placeholder="Quantidade" size="10">
				<select
					style="width: 70px" class="form-control-inline">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select> </br> </br> 
				
			</div>
			
				<label style="cursor: pointer;"> <input type="checkbox"
					id="check" onclick="habilitar();" /> Patologias
				</label> </br>
				<textarea rows="2" cols="75" disabled="disabled" id="inputText"> </textarea> </br> </br>

				Objetivo da Consulta </br>
				<textarea rows="2" cols="75"> </textarea>
				</br> </br>
				
				<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="btn btn-success">Finalizar Consulta</button>
				</div>
				
				</html>
 