<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<fieldset>
	<h3>Adicione as refeições</h3>

	<div class="form-group">
		<label for="horaAdd" class="col-sm-1 control-label">Horario:</label>
		<div class="col-sm-2">
			<form:input id="horaAdd" type="time" path=""  name="horaAdd" cssClass="form-control" placeholder="horario"/>
		</div>

		<label for="refeicaoAdd" class="col-sm-1 control-label">Refeicao:</label>
		<div class="col-sm-2">
			<form:select path="" id="refeicaoAdd" name="refeicaoAdd" cssClass="form-control">
				<form:options items="${refeicoes}" itemLabel="nome"/>
			</form:select>
		</div>
	
		<div class="col-sm-2">
			<a><input type="button" class="btn btn-primary" value="Adiciona Frequencia" id="addFrequencia" /></a>
		</div>
	</div>
</fieldset>



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
						<td><input size="50" name="frequencias[${ contFreq.index}].alimentos[${contAlim.index}].alimento" class="form-control" value="${ alimento.alimento }"></td>
						<td><input id="porcao" size="10" name="frequencias[${contFreq.index}].alimentos[${contAlim.index}].porcao" class="form-control" value="${ alimento.porcao }"></td>

						<td><a href="javascript:deletarLinha(${contFreq.index}, ${contAlim.index})" class="delAlimento btn btn-danger glyphicon glyphicon-edit">Deletar alimentos</a></td>
						</tr>
				</c:forEach>
					</tbody>
				
				</table>
				
				
				</fieldset>
			</c:forEach>	
		</div>
	
		
<script	src="<c:url value="../../resources/js/questionario-frequencia-alimentar.js" />"></script>

</html>

