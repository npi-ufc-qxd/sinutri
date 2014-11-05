<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<fieldset>
			<legend>Adicione as refeições</legend>
			
			
			
			<div class="form-group">
				<label for="horaAdd" class="col-sm-2 control-label">Horario:</label>
				<input id="horaAdd" type="time" name="horaAdd"/>
			</div>

			<div class="form-group">	
				<label for="refeicaoAdd" class="col-sm-2 control-label">Refeicao:</label>
				
			  <select name="refeicaoAdd" id="refeicaoAdd" class="col-xs-2">
				  <option value="DESJEJUM">Desjejum</option>
				  <option value="LANCHEMANHA">Lanche da Manhã</option>
				  <option value="ALMOCO">Alomoço</option>
				  <option value="LANCHETARDE">Lanche da Tarde</option>
				  <option value="JANTAR">Jantar</option>
				  <option value="CEIA">Ceia</option>
			</select>
			
			</div>	
			
			
			
			
			      <div class="col-sm-1">
						<a><input type="button" class="btn btn-primary" value="Adiciona Frequencia" id="addFrequencia" /></a>
					</div>
			      <!--  <a id="addFrequencia">Adiciona Frequencia</a>	-->
			      
			      
		</fieldset><br><br>
		
		<div id="frequenciasAdds">
			
			<c:forEach var="frequencia" items="${consultaNutricional.frequencias}" varStatus="contFreq">
				<fieldset>
					<legend>${ frequencia.horario }, ${ frequencia.refeicao.nome} </legend>
						<input type="hidden" name="frequencias[${contFreq.index }].id" value="${ frequencia.id }">
						<input type="hidden" name="frequencias[${contFreq.index }].horario" value="${ frequencia.horario }">
						<input type="hidden" name="frequencias[${contFreq.index }].refeicao" value="${ frequencia.refeicao }">		
						<table class="table">
						<thead><tr>
							<td width="40%">Alimento/Preparo</td>
							<td>Porção</td>
							<td><a class="addAlimento btn btn-primary" data-frequenciaalimentar="${contFreq.index}">adicionar alimentos</a></td>
						</tr>
						</thead>


					<tbody id="frequenciaAlimentar${contFreq.index}"> <%-- i.count-1 --%>
					<c:forEach var="alimento" items="${frequencia.alimentos}" varStatus="contAlim">
						<tr>
						<td><input type="hidden" name="frequencias[${ contFreq.index}].alimentos[${contAlim.index}].id" value="${ alimento.id }"></td>
						<td><input size="50" name="frequencias[${ contFreq.index}].alimentos[${contAlim.index}].alimento" cssclass="form-control" value="${ alimento.alimento }"></td>
						<td><input size="10" name="frequencias[${contFreq.index}].alimentos[${contAlim.index}].porcao" cssclass="form-control" value="${ alimento.porcao }"></td>

						<td><a href="javascript:deletarLinha(${contFreq.index}, ${contAlim.index})" class="delAlimento btn btn-danger glyphicon glyphicon-edit">Deletar alimentos</a></td>
						</tr>
				</c:forEach>
					</tbody>
				
				</table>
				
				
				</fieldset>
			</c:forEach>	
		</div>
	
		
<script type="text/javascript">

	var cont = 0;
	var contFrequencia = 0;
	
$(document).ready(function() {
		
		//ADICIONA FREQUENCIA
    $("#addFrequencia").click(function() {
    	var horaFrequencia = $("#horaAdd").val();
    	var refeicaoFrequencia = $("#refeicaoAdd").val();	
    	if(!$('#horaAdd').val() || !$('#refeicaoAdd').val() ) {
			//alert('Nome e email obrigatorio');		
			return false;
			
    	} else if(contFrequencia < 6){
			var fieldset = $("<fieldset>");
			var divnone = $("<div style='display:none;'>");
			fieldset.append($("<legend>").text($("#horaAdd").text() + ", " + refeicaoFrequencia));
			
			fieldset.append($("<input type='hidden' name='frequencias["+contFrequencia+"].horario' cssClass='form-control' value="+horaFrequencia+">"));
			fieldset.append($("<input type='hidden' name='frequencias["+contFrequencia+"].refeicao' cssClass='form-control' value="+refeicaoFrequencia+">"));

			fieldset.append(
					$("<table class='table'>")
					.append($("<thead>")
							.append($("<tr>")
									.append($("<td  width='40%'>").text("Alimento/Preparo"))
									.append($("<td>").text("Porção"))
									.append($("<td>").append($("<a class='addAlimento btn btn-primary' data-frequenciaAlimentar='"+contFrequencia+"'>adicionar alimentos</a>")))
							)
					)
					.append($("<tbody id='frequenciaAlimentar"+contFrequencia+"'>"))
			);
			$("#frequenciasAdds").append(fieldset);
			contFrequencia++;
		}			
    });
		

	 
    $("#frequenciasAdds").on('click', 'a.addAlimento', function() {
  	  var frequenciaAlimentar = $(this).data("frequenciaalimentar");
  		if(frequenciaAlimentar >= 0 && frequenciaAlimentar < 6){
  		var recipiente = "tbody#frequenciaAlimentar" + frequenciaAlimentar;
  		var contAlimentos = $(recipiente + " tr").length;				//siz = $( "#tabela > tbody tr" ).length;
  		$(recipiente)
  			.append($("<tr>")
  					.append($("<td>").append($("<input size='50' name='frequencias["+frequenciaAlimentar+"].alimentos["+contAlimentos+"].alimento' cssClass='form-control'/>")))
  					.append($("<td>").append($("<input size='10' name='frequencias["+frequenciaAlimentar+"].alimentos["+contAlimentos+"].porcao' cssClass='form-control'/>")))
  					.append($("<td>").append($("<a href='javascript:deletarLinha(" + frequenciaAlimentar + ", " + contAlimentos + ")' class='delAlimento btn btn-danger glyphicon glyphicon-edit'>Deletar alimentos</a>")))
  					
  			);
  		contAlimentos = $(recipiente + " tr").length;
 	}

    });

  });
  function deletarLinha(frequenciaAlimentar, index) {
		if(frequenciaAlimentar >= 0 && frequenciaAlimentar < 6){
			var recipiente = "tbody#frequenciaAlimentar" + frequenciaAlimentar;
			alert(recipiente);
			var size = $("table > "+recipiente+" tr" ).length;
			$( "table > "+recipiente+" tr" ).eq( index ).remove();
            
			size = $("table > "+recipiente+" tr" ).length;
			for( var i = 0; i < size; ++i){
				$( "table > "+recipiente+" tr:eq(" + i + ") td > a" ).attr("href", "javascript:deletarLinha(" + frequenciaAlimentar +", " + i + ")");
				$( "table > "+recipiente+" tr:eq(" + i + ") td > input[name$='alimento']" ).attr("name", "frequencias[" + frequenciaAlimentar + "].alimentos[" + i + "].alimento");
				$( "table > "+recipiente+" tr:eq(" + i + ") td > input[name$='porcao']" ).attr("name", "frequencias[" + frequenciaAlimentar + "].alimentos[" + i + "].porcao");
			}
		}
	}
 
				
</script>

<style type="text/css">




</style>


</html>

