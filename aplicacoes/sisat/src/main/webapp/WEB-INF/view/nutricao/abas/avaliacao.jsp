<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Paciente</h3>
	<div class="form-group">
		<label for="altura" class="col-sm-2 control-label">Altura:</label>
		<div class="col-sm-3">
			<form:input id="altura" type="number" path="paciente.altura" cssClass="form-control" placeholder="Altura" />
			<div class="error-validation">
				<form:errors path="paciente.altura"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="peso" class="col-sm-2 control-label">Peso:</label>
		<div class="col-sm-3">
			<form:input id="peso" type="number" path="peso" cssClass="form-control" placeholder="Peso"/>
			<div class="error-validation">
				<form:errors path="peso"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="cc" class="col-sm-2 control-label">CC:</label>
		<div class="col-sm-3" >
			<form:input id="cc" type="number" placeholder="Circunferência da cintura" path="circunferenciaCintura" cssClass="form-control" min="0"/>
			<div class="error-validation">
				<form:errors path="circunferenciaCintura"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="checkMedicamento" class="col-sm-2 control-label"><form:checkbox id="checkMedicamento" onclick="habilitar();" path="medicamento"/> Medicamentos:</label>
		<div class="col-sm-10" >
			<form:input id="inputTextMedicamento" path="medicamentoComentario" cssClass="form-control" placeholder="Quais medicamentos você usa?" disabled="${not consultaNutricional.medicamento}"/>
			<div class="error-validation">
				<form:errors path="medicamentoComentario"></form:errors>
			</div>
		</div>
	</div>

<h3>Alterações Gastrointestinais</h3>
	<div class="form-group">
		<label for="disfagia" class="col-sm-2 control-label"><form:checkbox id="disfagia" path="disfagia"/> Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<label for="pirose" class="col-sm-1 control-label"><form:checkbox id="pirose" path="pirose"/> Pirose</label>
		<label for="nausea" class="col-sm-2 control-label"><form:checkbox id="nausea" path="nausea"/> Náusea</label>
		<label for="vomito" class="col-sm-2 control-label"><form:checkbox id="vomito" path="vomito"/> Vômitos</label>
		<label for="diarreia" class="col-sm-2 control-label"><form:checkbox id="diarreia" path="diarreia"/> Diarreia</label>
		<label for="constipacao" class="col-sm-2 control-label"><form:checkbox id="constipacao" path="constipacao"/> Constipação</label>
	</div>
	<div class="form-group">
		<label for="checkMastigacao" class="col-sm-2 control-label"><form:checkbox id="checkMastigacao" onclick="habilitar();" path="mastigacao"/> Mastigação:</label>
		<div class="col-sm-10" >
			<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
			<div class="error-validation">
				<form:errors path="mastigacaoComentario"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="checkAlergia" class="col-sm-2 control-label"><form:checkbox id="checkAlergia" onclick="habilitar();" path="alergia"/> Alergia Alimentar:</label>
		<div class="col-sm-10" >
			<form:textarea id="inputTextAlergia" path="alergiaComentario" class="form-control" rows="5" placeholder="Qual sua alergia Alimentar?" disabled="${not consultaNutricional.alergia}"/>
			<div class="error-validation">
				<form:errors path="alergiaComentario"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group form-item" align="left">
		<label for="agua" class="col-sm-2 control-label">Consumo de água:</label>
		<div class="col-sm-10">
			<form:input id="agua" name="agua" type="number" path="agua" cssClass="form-control" placeholder="Consumo de água"/>
			<div class="error-validation">
				<form:errors path="agua"></form:errors>
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<div class="form-item">
			<label for="checkAtividadeFisica" class="col-sm-2 control-label"><form:checkbox id="checkAtividadeFisica" onclick="habilitar();" path="atividadeFisica"/> Atividade Física:</label>
			<div class="col-sm-7" >
				<form:input id="inputTextAtividadeFisica" path="atividadeFisicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.atividadeFisica}"/>
				<div class="error-validation">
					<form:errors path="atividadeFisicaComentario"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-item">
			<div class="col-sm-3" >
				<form:select path="atividadeFisicaFrequenciaSemanal" cssClass="form-control">
					<form:option value="">Quantas vezes por semana?</form:option>
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
				</form:select>
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<div class="form-item">
			<label for="checkCarneVermelha" class="col-sm-2 control-label"><form:checkbox id="checkCarneVermelha" onclick="habilitar();" path="carneVermelha"/> Carne Vermelha:</label>
			<div class="col-sm-7" >
				<form:input id="inputTextCarneVermelha" path="carneVermelhaComentario" cssClass="form-control" placeholder="Que tipo de carne?" disabled="${not consultaNutricional.carneVermelha}"/>
				<div class="error-validation">
					<form:errors path="carneVermelhaComentario"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-item">
			<div class="col-sm-3" >
				<form:select path="carneVermelhaFrequenciaSemanal" cssClass="form-control">
					<form:option value="">Quantas vezes por semana?</form:option>
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
				</form:select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="form-item">
			<label for="checkBebidaAlcoolica" class="col-sm-2 control-label"><form:checkbox id="checkBebidaAlcoolica" onclick="habilitar();" path="bebidaAlcoolica"/> Bebida alcoólica:</label>
			<div class="col-sm-7" >
				<form:input id="inputTextBebidaAlcoolica" path="bebidaAlcoolicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.bebidaAlcoolica}"/>
				<div class="error-validation">
					<form:errors path="bebidaAlcoolicaComentario"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-item">
			<div class="col-sm-3" >
				<form:select path="bebidaAlcoolicaFrequenciaSemanal" cssClass="form-control">
					<form:option value="">Quantas vezes por semana?</form:option>
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
				</form:select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="checkPatologia" class="col-sm-2 control-label"><form:checkbox id="checkPatologia" onclick="habilitar();" path="outrasPatologias"/> Patologias:</label>
		<div class="col-sm-10" >
			<form:textarea id="inputTextPatologia" path="outrasPatologiasComentario" class="form-control" rows="5" placeholder="Descreva aqui as patologias" disabled="${not consultaNutricional.outrasPatologias}"/>
			<div class="error-validation">
				<form:errors path="outrasPatologiasComentario"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="objetivoConsulta" class="col-sm-2 control-label"> Objetivo da Consulta:</label>
		<div class="col-sm-10" >
			<form:textarea id="objetivoConsulta" path="objetivoConsulta" class="form-control" rows="5" placeholder="Descreva aqui o objetivo da consulta..."/>
			<div class="error-validation">
				<form:errors path="objetivoConsulta"></form:errors>
			</div>
		</div>
	</div>
