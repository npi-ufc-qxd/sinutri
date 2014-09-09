<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset>
			<legend>Adicione as refeições</legend>
			
			<div class="form-group">
				<label for="horaAdd" class="col-sm-2 control-label">Horario:</label>
				<input id="horaAdd" name="horaAdd"/>
			</div>
			
			<div class="form-group">	
				<label for="refeicaoAdd" class="col-sm-2 control-label">Refeicao:</label>
				<input id="refeicaoAdd" name="refeicaoAdd" />
			</div>	
			       <a id="addFrequencia">Adiciona Frequencia</a>	
		</fieldset><br><br>
		
		<div id="frequenciasAdds">
			
		</div>
		
<script type="text/javascript">

	var cont = 0;
	var contFrequencia = 0;
	
$(document).ready(function() {
		
		//ADICIONA FREQUENCIA
    $("a#addFrequencia").click(function() {
    	var horaFrequencia = $("#horaAdd").val();
    	var refeicaoFrequencia = $("#refeicaoAdd").val();	
    	if(!$('#horaAdd').val() || !$('#refeicaoAdd').val() ) {
			alert('Nome e email obrigatorio');		
			return false;
			
    	} else if(contFrequencia < 6){
			var fieldset = $("<fieldset>");
			fieldset.append($("<legend>").text(horaFrequencia + ", " + refeicaoFrequencia));
			
			fieldset.append($("<input type='hidden' name='frequenciasAlimentares["+contFrequencia+"].horario' cssClass='form-control' value="+horaFrequencia+">"));
			fieldset.append($("<input type='hidden' name='frequenciasAlimentares["+contFrequencia+"].refeicao' cssClass='form-control' value="+refeicaoFrequencia+">"));
			
			fieldset.append(
					$("<table>")
					.append($("<thead>")
							.append($("<tr>")
									.append($("<td>").text("Alimento/Preparo"))
									.append($("<td>").text("Porção"))
									.append($("<td>").append($("<a class='addAlimento' data-frequenciaAlimentar='"+contFrequencia+"'>adicionar alimentos</a>")))
							)
					)
					.append($("<tbody id='frequenciaAlimentar"+contFrequencia+"'>"))
			);
			$("#frequenciasAdds").append(fieldset);
			contFrequencia++;
		}			
    });
		
});
	    	
				
</script>




