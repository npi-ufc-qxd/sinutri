<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${action eq 'cadastrar' }">
	<c:url var="url"
		value="/paciente/${consultaNutricional.paciente.pessoa.cpf}/consulta"></c:url>
	<c:set var="titulo" value="Nova Consulta "></c:set>
	<c:set var="botao" value="Finalizar Consulta "></c:set>
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url"
		value="/paciente/${consultaNutricional.paciente.pessoa.cpf}/consulta/${consultaNutricional.id}/editar"></c:url>
	<c:set var="titulo" value="Editar Consulta "></c:set>
	<c:set var="botao" value="Atualizar Consulta"></c:set>
</c:if>

<html>
<head>
<jsp:include page="../modulos/header-estrutura.jsp" />

<title>${titulo}</title>
</head>

<body data-spy="scroll" data-target="#myScrollspy">

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">

		<c:if test="${not empty erro}">
			<div class="alert alert-danger alert-dismissible fade in"
				role="alert" id="alert-erro">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${erro}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty info}">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert" id="alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${info}"></c:out>
			</div>
		</c:if>

		<div class="row">
			<div class="col-sm-9">
				<h3>${titulo}
					<strong>${consultaNutricional.paciente.pessoa.nome}</strong>
				</h3>
			</div>

			<div class="col-sm-3" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3" id="myScrollspy">
				<ul class="nav nav-tabs nav-stacked affix-top" data-spy="affix"
					data-offset-top="125">
					<li class="active"><a href="#avaliacao"> <span
							class="badge">1</span> Anamnese
					</a></li>
					<li><a href="#recordatorio"> <span class="badge">2</span>
							Recordatório Alimentar
					</a></li>
					<li><a href="#exame"> <span class="badge">3</span> Exames
							Laboratoriais
					</a></li>
					<li><a href="#orientacoes"> <span class="badge">4</span>
							Orientações Individuais
					</a></li>
					<li><a href="#documentos"> <span class="badge">5</span>
							Documentos
					</a></li>
					<li><a href="#inquerito"> <span class="badge">6</span>
							Inquerito Alimentar
					</a></li>
				</ul>

			</div>

			<div class="col-sm-9">
				<form:form servletRelativeAction="${url}" method="POST"
					id="form-consulta" modelAttribute="consultaNutricional"
					commandName="consultaNutricional" acceptCharset="UTF-8"
					cssClass="form-horizontal" enctype="multipart/form-data">
					<form:hidden path="id" />
					<form:hidden path="paciente.id" />
					<form:hidden path="inqueritoAlimentar.id" />
					<form:hidden path="data" />


					<h4 id="avaliacao" class="section">
						<strong>Anamnese</strong>
					</h4>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="objetivoConsulta" class="control-label"> <i
								style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								Objetivo da Consulta:
							</label>
							<form:textarea id="objetivoConsulta" path="objetivoConsulta"
								class="form-control" rows="5"
								placeholder="Descreva aqui o objetivo da consulta..." />
							<div class="error-validation">
								<form:errors path="objetivoConsulta"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="altura" class="control-label"><i
								style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								Altura (m):</label>
							<form:input type="number" id="altura" name="altura" path="altura"
								cssClass="form-control valid-num" placeholder="0.00" />
							<div class="error-validation">
								<form:errors path="altura"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-3">
							<label for="peso" class="control-label"><i
								style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								Peso (Kg):</label>
							<form:input type="number" id="peso" name="peso" path="peso"
								cssClass="form-control valid-num" placeholder="00.00" />
							<div class="error-validation">
								<form:errors path="peso"></form:errors>
							</div>
						</div>
						<div class="form-item col-sm-3">
							<label for="pesoDesejado" class="control-label"><i
								style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								Peso desejado (Kg):</label>
							<form:input id="pesoDesejado" name="pesoDesejado"
								path="pesoDesejado" type="number"
								cssClass="form-control valid-num" placeholder="00.00" />
							<div class="error-validation">
								<form:errors path="pesoDesejado"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-3">
							<label for="circunferenciaCintura" class="control-label">
								<i style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								CC (cm):
							</label>
							<form:input id="circunferenciaCintura" name="cc"
								placeholder="00.00" path="circunferenciaCintura" type="number"
								cssClass="form-control valid-num" min="0" />
							<div class="error-validation">
								<form:errors path="circunferenciaCintura"></form:errors>
							</div>
						</div>
						<div class="form-item col-sm-3">
							<label for="circunferenciaCinturaDesejada" class="control-label">
								<i style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								CC desejada (cm):
							</label>
							<form:input id="circunferenciaCinturaDesejada" name="cc"
								type="number" placeholder="00.00"
								path="circunferenciaCinturaDesejada"
								cssClass="form-control valid-num" min="0" />
							<div class="error-validation">
								<form:errors path="circunferenciaCinturaDesejada"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="agua" class="control-label"><i
								style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
								Consumo de água:</label>
							<form:input type="text" id="agua" name="agua" path="agua"
								cssClass="form-control" placeholder="Consumo de água" />
							<div class="error-validation">
								<form:errors path="agua"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkAtividadeFisica" class="control-label"><form:checkbox
									id="checkAtividadeFisica" path="atividadeFisica"
									class="checkboxInputSelect" /> Atividade Física:</label>
							<form:input id="inputTextAtividadeFisica"
								path="atividadeFisicaComentario" cssClass="form-control"
								placeholder="Qual atividade?"
								disabled="${not consultaNutricional.atividadeFisica}" />
							<div class="error-validation">
								<form:errors path="atividadeFisicaComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select id="atividadeFisicaFrequenciaSemanal"
								path="atividadeFisicaFrequenciaSemanal" cssClass="form-control"
								disabled="${not consultaNutricional.atividadeFisica}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="atividadeFisicaFrequenciaSemanal"></form:errors>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkCarneVermelha" class=" control-label"><form:checkbox
									id="checkCarneVermelha" path="carneVermelha"
									class="checkboxInputSelect" /> Carne Vermelha:</label>
							<form:input id="inputTextCarneVermelha"
								path="carneVermelhaComentario" cssClass="form-control"
								placeholder="Que tipo de carne?"
								disabled="${not consultaNutricional.carneVermelha}" />
							<div class="error-validation">
								<form:errors path="carneVermelhaComentario"></form:errors>
							</div>
						</div>
						<div class="form-item col-sm-6">
							<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="carneVermelhaFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.carneVermelha}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="carneVermelhaFrequenciaSemanal"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkBebidaAlcoolica" class=" control-label"><form:checkbox
									id="checkBebidaAlcoolica" path="bebidaAlcoolica"
									class="checkboxInputSelect" /> Bebida alcoólica:</label>
							<form:input id="inputTextBebidaAlcoolica"
								path="bebidaAlcoolicaComentario" cssClass="form-control"
								placeholder="Qual bebida alcoólica?"
								disabled="${not consultaNutricional.bebidaAlcoolica}" />
							<div class="error-validation">
								<form:errors path="bebidaAlcoolicaComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="bebidaAlcoolicaFrequenciaSemanal"
								cssClass="form-control"
								disabled="${not consultaNutricional.bebidaAlcoolica}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="bebidaAlcoolicaFrequenciaSemanal"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="sistemaGastrointestinal" class=" control-label">Sistema
								Gastrointestinal:</label>
							<form:select id="sistemaGastrointestinal"
								path="sistemaGastrointestinal" cssClass="form-control">
								<form:option value="">Selecione</form:option>
								<form:options items="${sistemaGastrointestinal}"
									itemLabel="tipo" />
							</form:select>
						</div>

						<div class="form-item col-sm-6">
							<label for="sistemaUrinario" class=" control-label">Sistema
								Urinário:</label>
							<form:select id="sistemaUrinario" path="sistemaUrinario"
								cssClass="form-control">
								<form:option value="">Selecione</form:option>
								<form:options items="${sistemaUrinario}" itemLabel="tipo" />
							</form:select>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="diabetes" class=" control-label"><form:checkbox
									id="diabetes" path="diabetes" /> Diabetes</label>
						</div>

						<div class="form-item col-sm-6">
							<label for="hipertensao" class=" control-label"><form:checkbox
									id="hipertensao" path="hipertensao" /> Hipertensão</label>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="checkMedicamento" class=" control-label"><form:checkbox
									id="checkMedicamento" path="medicamento" class="checkboxInput" />
								Medicamentos:</label>
							<form:input id="inputTextMedicamento"
								path="medicamentoComentario" cssClass="form-control"
								placeholder="Quais medicamentos você usa?"
								disabled="${not consultaNutricional.medicamento}" />
							<div class="error-validation">
								<form:errors path="medicamentoComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkMastigacao" class=" control-label"><form:checkbox
									id="checkMastigacao" path="mastigacao" class="checkboxInput" />
								Mastigação:</label>
							<form:input id="inputTextMastigacao" path="mastigacaoComentario"
								cssClass="form-control" placeholder="Como é sua mastigação?"
								disabled="${not consultaNutricional.mastigacao}" />
							<div class="error-validation">
								<form:errors path="mastigacaoComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="disfagia" class="control-label"><form:checkbox
									cssClass="checkboxInput" id="disfagia" path="disfagia" />
								Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<form:input id="disfagiaComentario" path="disfagiaComentario"
								cssClass="form-control" placeholder="Comentário sobre disfagia"
								disabled="${not consultaNutricional.disfagia}" />
							<div class="error-validation">
								<form:errors path="disfagiaComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="odinofagia" class="control-label"><form:checkbox
									cssClass="checkboxInput" id="odinofagia" path="odinofagia" />
								Odinofagia</label>
							<form:input id="odinofagiaComentario" path="odinofagiaComentario"
								cssClass="form-control"
								placeholder="Comentário sobre odinofagia"
								disabled="${not consultaNutricional.odinofagia}" />
							<div class="error-validation">
								<form:errors path="odinofagiaComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="pirose" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="pirose" path="pirose" /> Pirose</label>
							<form:input id="piroseComentario" path="piroseComentario"
								cssClass="form-control" placeholder="Comentário sobre pirose"
								disabled="${not consultaNutricional.pirose}" />
							<div class="error-validation">
								<form:errors path="piroseComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="nausea" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="nausea" path="nausea" /> Náusea</label>
							<form:input id="nauseaComentario" path="nauseaComentario"
								cssClass="form-control" placeholder="Comentário sobre náusea"
								disabled="${not consultaNutricional.nausea}" />
							<div class="error-validation">
								<form:errors path="nauseaComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="vomito" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="vomito" path="vomito" /> Vômitos</label>
							<form:input id="vomitoComentario" path="vomitoComentario"
								cssClass="form-control" placeholder="Comentário sobre vômito"
								disabled="${not consultaNutricional.vomito}" />
							<div class="error-validation">
								<form:errors path="vomitoComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="diarreia" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="diarreia" path="diarreia" />
								Diarreia</label>
							<form:input id="diarreiaComentario" path="diarreiaComentario"
								cssClass="form-control" placeholder="Comentário sobre diarreia"
								disabled="${not consultaNutricional.diarreia}" />
							<div class="error-validation">
								<form:errors path="diarreiaComentario"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="constipacao" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="constipacao" path="constipacao" />
								Constipação</label>
							<form:input id="constipacaoComentario"
								path="constipacaoComentario" cssClass="form-control"
								placeholder="Comentário sobre constipação"
								disabled="${not consultaNutricional.constipacao}" />
							<div class="error-validation">
								<form:errors path="constipacaoComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="checkAlergia" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="checkAlergia" path="alergia"
									class="check" /> Alergia Alimentar:</label>
							<form:textarea id="inputTextAlergia" path="alergiaComentario"
								class="form-control" rows="5"
								placeholder="Qual sua alergia Alimentar?"
								disabled="${not consultaNutricional.alergia}" />
							<div class="error-validation">
								<form:errors path="alergiaComentario"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="checkPatologia" class=" control-label"><form:checkbox
									cssClass="checkboxInput" id="checkPatologia"
									path="outrasPatologias" class="check" /> Patologias:</label>
							<form:textarea id="inputTextPatologia"
								path="outrasPatologiasComentario" class="form-control" rows="5"
								placeholder="Descreva aqui as patologias"
								disabled="${not consultaNutricional.outrasPatologias}" />
							<div class="error-validation">
								<form:errors path="outrasPatologiasComentario"></form:errors>
							</div>
						</div>
					</div>

					<h4 id="recordatorio" class="section">
						<strong>Recordatório</strong>
					</h4>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<table id="questionarioFrequenciaAlimentar" class="table"></table>
						</div>
					</div>


					<h4 id="exame" class="section">
						<strong>Exames Laboratoriais</strong>
					</h4>

					<div class="row form-group">
						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="glicemia" class="control-label">Glicemia:</label>
									<form:input type="number" id="glicemia" path="glicemia"
										cssClass="form-control exame valid-num" placeholder="glicemia" />
									<div class="error-validation">
										<form:errors path="glicemia"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoGlicemia"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoGlicemia"></form:errors>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="ct" class="control-label">CT:</label>
									<form:input type="number" id="ct" path="ct"
										cssClass="form-control exame valid-num" placeholder="ct" />
									<div class="error-validation">
										<form:errors path="ct"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoCt"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoCt"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="ldlc" class="control-label">LDL-C:</label>
									<form:input type="number" id="ldlc" path="ldlc"
										cssClass="form-control exame valid-num" placeholder="LDL-C" />
									<div class="error-validation">
										<form:errors path="ldlc"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoLdlc"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoLdlc"></form:errors>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="hdlc" class="control-label">HDL-C:</label>
									<form:input type="number" id="hdlc" path="hdlc"
										cssClass="form-control exame valid-num" placeholder="HDL-C" />
									<div class="error-validation">
										<form:errors path="hdlc"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoHdlc"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoHdlc"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="tg" class="control-label">TG:</label>
									<form:input type="number" id="tg" path="tg"
										cssClass="form-control exame valid-num" placeholder="TG" />
									<div class="error-validation">
										<form:errors path="tg"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoTg"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoTg"></form:errors>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="hb" class="control-label">HB:</label>
									<form:input type="number" id="hb" path="hb"
										cssClass="form-control exame valid-num" placeholder="HB" />
									<div class="error-validation">
										<form:errors path="hb"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoHb"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoHb"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="tgo" class="control-label">TGO (AST):</label>
									<form:input type="number" id="tgo" path="tgo"
										cssClass="form-control exame valid-num" placeholder="tgo" />
									<div class="error-validation">
										<form:errors path="tgo"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoTgo"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoTgo"></form:errors>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group-exame">
							<div class="col-sm-3">
								<div class="form-item">
									<label for="tgp" class="control-label">TGP (ALT):</label>
									<form:input type="number" id="tgp" path="tgp"
										cssClass="form-control exame valid-num"
										placeholder="TGP (ALT)" />
									<div class="error-validation">
										<form:errors path="tgp"></form:errors>
									</div>
								</div>
							</div>

							<div class="col-sm-3">
								<div class="form-item">
									<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
									<form:select path="classificacaoTgp"
										cssClass="form-control classificacao">
										<form:option value="">Classificação</form:option>
										<form:options items="${classificacaoExames}" itemLabel="tipo" />
									</form:select>
									<div class="error-validation">
										<form:errors path="classificacaoTgp"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="informacoesComplementaresExames"
								class="control-label"> Informações complementares:</label>
							<form:textarea id="informacoesComplementaresExames"
								path="informacoesComplementaresExames" class="form-control"
								rows="5" placeholder="Conduta Nutricional" />
							<div class="error-validation">
								<form:errors path="informacoesComplementaresExames"></form:errors>
							</div>
						</div>
					</div>

					<h4 id="orientacoes" class="section">
						<strong>Orientações</strong>
					</h4>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="condutaNutricional" class="control-label">
								Conduta Nutricional:</label>
							<form:textarea id="condutaNutricional" path="condutaNutricional"
								class="form-control" rows="5" placeholder="Conduta Nutricional" />
							<div class="error-validation">
								<form:errors path="condutaNutricional"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<label for="orientacoesIndividuais" class="control-label">
								Orientações Individuais</label>
							<form:textarea id="orientacoesIndividuais"
								path="orientacoesIndividuais" class="form-control" rows="5"
								placeholder="Orientações Individuais" />
							<div class="error-validation">
								<form:errors path="orientacoesIndividuais"></form:errors>
							</div>
						</div>
					</div>

					<h4 id="documentos" class="section">
						<strong>Documentos</strong>
					</h4>

					<div class="row form-group">
						<div class="form-item col-sm-12">
							<div id="enviarDocumento">
								<input type="checkbox" id="enviar" name="enviar"><label
									for="enviar">Enviar para o paciente</label>
							</div>

							<input id="anexos" type="file" name="files"
								class="anexo file-loading" multiple="multiple"></input>

							<div class="error-validation" id="erro-Anexo">
								<label class="col-sm-10 control-label" id="label-erro">
									${anexoError} </label>
							</div>

							<table id="file-upload" role="presentation"
								class="table table-striped">
								<thead class="files">
									<tr>
										<th colspan="6">Ducumentos para enviar ao paciente</th>
									</tr>
									<tr>
										<th>Nome do Arquivo</th>
										<th>Data</th>
										<th>Tipo</th>
										<th>Baixar</th>
										<th>Excluir</th>
										<th>Enviar</th>
									</tr>
								</thead>

								<tbody class="files">
									<c:forEach items="${documentosEnvio}" var="documento">
										<tr class="template-upload fade in">
											<td>${documento.nome}<strong class="error text-danger"></strong></td>
											<td>${documento.data}<strong class="error text-danger"></strong></td>
											<td>${documento.tipo}<strong class="error text-danger"></strong></td>

											<td><a id="download[${documento.id}]"
												href="<c:url value="/nutricao/downloadDocumento/${documento.id }" ></c:url>"
												class="save-document">
													<button type="button" class="btn btn-primary">
														<span class="glyphicon glyphicon-save"></span>
													</button>
											</a></td>

											<td><a id="delete[${documento.id}]" href="#"
												class="btn btn-danger"
												data-href="<c:url value="/nutricao/${consultaNutricional.id }/paciente/${consultaNutricional.paciente.pessoa.cpf }/deletarDocumento/${documento.id }" ></c:url>"
												class="delete-document" data-toggle="modal"
												data-target="#confirm-delete"> <span
													class="glyphicon glyphicon-trash"></span>
											</a></td>



											<td><a id="send[${documento.id}]"
												href="../../nutricao/enviarDocumento/${documento.id}/"
												class="send-document">
													<button class="btn btn-warning">
														<span class="glyphicon glyphicon-send"></span>
													</button>
											</a></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>

							<br>

							<table id="file-upload" role="presentation"
								class="table table-striped">
								<thead class="files">
									<tr>
										<th colspan="5">Outros documentos</th>
									</tr>

									<tr>
										<th>Nome do Arquivo</th>
										<th>Data</th>
										<th>Tipo</th>
										<th>Baixar</th>
										<th>Excluir</th>
									</tr>
								</thead>
								<tbody class="files">
									<c:forEach items="${documentosNutricionista}" var="documento">
										<tr class="template-upload fade in">
											<td>${documento.nome}<strong class="error text-danger"></strong></td>
											<td>${documento.data}<strong class="error text-danger"></strong></td>
											<td>${documento.tipo}<strong class="error text-danger"></strong></td>
											<td><a id="download[${documento.id}]"
												href="<c:url value="/nutricao/downloadDocumento/${documento.id }" ></c:url>"
												class="save-document">
													<button type="button" class="btn btn-primary">
														<span class="glyphicon glyphicon-save"></span>
													</button>
											</a></td>

											<td><a id="delete[${documento.id}]" href="#"
												class="btn btn-danger"
												data-href="<c:url value="/nutricao/${consultaNutricional.id }/paciente/${consultaNutricional.paciente.pessoa.cpf }/deletarDocumento/${documento.id }" ></c:url>"
												class="delete-document" data-toggle="modal"
												data-target="#confirm-delete"> <span
													class="glyphicon glyphicon-trash"></span>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>

					<h4 id="inquerito" class="section">
						<strong>Inquerito Alimentar</strong>
					</h4>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkBovinoGosta" class="control-label"><form:checkbox
									id="checkBovinoGosta" path="inqueritoAlimentar.bovinaGosta"
									class="checkInquerito" /> Gosta de Carne Bovina?</label>
							<form:select path="inqueritoAlimentar.bovinaFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.bovinaGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.bovinaFrequenciaSemanal"></form:errors>
							</div>
						</div> 
	
						<div class="form-item col-sm-6">
							<label for="bovinaQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextBovina"
								path="inqueritoAlimentar.bovinaQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.bovinaGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.bovinaQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkAvesGosta" class="control-label"><form:checkbox
									id="checkAvesGosta" path="inqueritoAlimentar.avesGosta"
									class="checkInquerito" /> Gosta de Carne de Ave?</label>

							<form:select path="inqueritoAlimentar.avesFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.avesGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.avesFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="avesQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextAves"
								path="inqueritoAlimentar.avesQuantidade" cssClass="form-control"
								placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.avesGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.avesQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkPeixeGosta" class="control-label"><form:checkbox
									id="checkPeixeGosta" path="inqueritoAlimentar.peixeGosta"
									class="checkInquerito" /> Gosta de Carne de Peixe?</label>

							<form:select path="inqueritoAlimentar.peixeFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.peixeGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.peixeFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="peixeQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextPeixe"
								path="inqueritoAlimentar.peixeQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.peixeGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.peixeQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkVicerasGosta" class="control-label"><form:checkbox
									id="checkVicerasGosta" path="inqueritoAlimentar.viscerasGosta"
									class="checkInquerito" /> Gosta de Visceras?</label>

							<form:select path="inqueritoAlimentar.viscerasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.viscerasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.viscerasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="viscerasQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextVisceras"
								path="inqueritoAlimentar.viscerasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.viscerasGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.viscerasQuantidade"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkLeiteDerivadosGosta" class="control-label"><form:checkbox
									id="checkLeiteDerivadosGosta"
									path="inqueritoAlimentar.leiteDerivadosGosta"
									class="checkInquerito" /> Gosta de Derivados do Leite?</label>

							<form:select
								path="inqueritoAlimentar.leiteDerivadosFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.leiteDerivadosGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.leiteDerivadosFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="leiteDerivadosQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextLeiteDerivados"
								path="inqueritoAlimentar.leiteDerivadosQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.leiteDerivadosGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.leiteDerivadosQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkOvosGosta" class="control-label"><form:checkbox
									id="checkOvosGosta" path="inqueritoAlimentar.ovosGosta"
									class="checkInquerito" /> Gosta de Ovos?</label>

							<form:select path="inqueritoAlimentar.ovosFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.ovosGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.ovosFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="ovosQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextOvos"
								path="inqueritoAlimentar.ovosQuantidade" cssClass="form-control"
								placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.ovosGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.ovosQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkLeguminosasGosta" class="control-label"><form:checkbox
									id="checkLeguminosasGosta"
									path="inqueritoAlimentar.leguminosasGosta"
									class="checkInquerito" /> Gosta de Leguminosas?</label>

							<form:select
								path="inqueritoAlimentar.leguminosasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.leguminosasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.leguminosasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="leguminosasQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextLeguminosas"
								path="inqueritoAlimentar.leguminosasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.leguminosasGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.leguminosasQuantidade"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkCereaisGosta" class="control-label"><form:checkbox
									id="checkCereaisGosta" path="inqueritoAlimentar.cereaisGosta"
									class="checkInquerito" /> Gosta de Cereais?</label>

							<form:select path="inqueritoAlimentar.cereaisFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.cereaisGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.cereaisFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="cereaisQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextCereais"
								path="inqueritoAlimentar.cereaisQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.cereaisGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.cereaisQuantidade"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkMassasGosta" class="control-label"><form:checkbox
									id="checkMassasGosta" path="inqueritoAlimentar.massasGosta"
									class="checkInquerito" /> Gosta de Massas?</label>

							<form:select path="inqueritoAlimentar.massasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.massasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.massasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="massasQuantidade" class="control-label">Anotação</label>

							<form:input id="inputTextMassas"
								path="inqueritoAlimentar.massasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.massasGosta}" />

							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.massasQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkVegetaisCrusGosta" class="control-label"><form:checkbox
									id="checkVegetaisCrusGosta"
									path="inqueritoAlimentar.vegetaisCrusGosta"
									class="checkInquerito" /> Gosta de Vegetais Crus?</label>
							<form:select
								path="inqueritoAlimentar.vegetaisCrusFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.vegetaisCrusGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.vegetaisCrusFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="vegetaisCrusQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextVegetaisCrus"
								path="inqueritoAlimentar.vegetaisCrusQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.vegetaisCrusGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.vegetaisCrusQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkVegetaisCozidosGosta" class="control-label"><form:checkbox
									id="checkVegetaisCozidosGosta"
									path="inqueritoAlimentar.vegetaisCozidosGosta"
									class="checkInquerito" /> Gosta de Vegetais Cozidos?</label>
							<form:select
								path="inqueritoAlimentar.vegetaisCozidosFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.vegetaisCozidosGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.vegetaisCozidosFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="vegetaisCozidosQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextVegetaisCozidos"
								path="inqueritoAlimentar.vegetaisCozidosQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.vegetaisCozidosGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.vegetaisCozidosQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkFrutasGosta" class="control-label"><form:checkbox
									id="checkFrutasGosta" path="inqueritoAlimentar.frutasGosta"
									class="checkInquerito" /> Gosta de Frutas?</label>
							<form:select path="inqueritoAlimentar.frutasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.frutasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.frutasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="frutasQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextFrutas"
								path="inqueritoAlimentar.frutasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.frutasGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.frutasQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkDocesGosta" class="control-label"><form:checkbox
									id="checkDocesGosta" path="inqueritoAlimentar.docesGosta"
									class="checkInquerito" /> Gosta de Doces?</label>
							<form:select path="inqueritoAlimentar.docesFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.docesGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.docesFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="docesQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextDoces"
								path="inqueritoAlimentar.docesQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.docesGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.docesQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkOleoGosta" class="control-label"><form:checkbox
									id="checkOleoGosta" path="inqueritoAlimentar.oleoGosta"
									class="checkInquerito" /> Gosta de Óleo?</label>
							<form:select path="inqueritoAlimentar.oleoFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.oleoGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.oleoFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="oleoQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextOleo"
								path="inqueritoAlimentar.oleoQuantidade" cssClass="form-control"
								placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.oleoGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.oleoQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkMargarinaGosta" class="control-label"><form:checkbox
									id="checkMargarinaGosta"
									path="inqueritoAlimentar.margarinaGosta" class="checkInquerito" />
								Gosta de Margarina?</label>
							<form:select path="inqueritoAlimentar.margarinaFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.margarinaGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.margarinaFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="margarinaQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextMargarina"
								path="inqueritoAlimentar.margarinaQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.margarinaGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.margarinaQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkManteigaGosta" class="control-label"><form:checkbox
									id="checkManteigaGosta" path="inqueritoAlimentar.manteigaGosta"
									class="checkInquerito" /> Gosta de Manteiga?</label>
							<form:select path="inqueritoAlimentar.manteigaFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.manteigaGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.manteigaFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="manteigaQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextManteiga"
								path="inqueritoAlimentar.manteigaQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.manteigaGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.manteigaQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkToucinhoBaconGosta" class="control-label"><form:checkbox
									id="checkToucinhoBaconGosta"
									path="inqueritoAlimentar.toucinhoBaconGosta"
									class="checkInquerito" /> Gosta de Toucinho/Bacon?</label>
							<form:select
								path="inqueritoAlimentar.toucinhoBaconFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.toucinhoBaconGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.toucinhoBaconFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="toucinhoBaconQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextToucinhoBacon"
								path="inqueritoAlimentar.toucinhoBaconQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.toucinhoBaconGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.toucinhoBaconQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkAguaGosta" class="control-label"><form:checkbox
									id="checkAguaGosta" path="inqueritoAlimentar.aguaGosta"
									class="checkInquerito" /> Gosta de Água?</label>
							<form:select path="inqueritoAlimentar.aguaFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.aguaGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.aguaFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="aguaQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextAgua"
								path="inqueritoAlimentar.aguaQuantidade" cssClass="form-control"
								placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.aguaGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.aguaQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkSucoGosta" class="control-label"><form:checkbox
									id="checkSucoGosta" path="inqueritoAlimentar.sucoGosta"
									class="checkInquerito" /> Gosta de Suco?</label>
							<form:select path="inqueritoAlimentar.sucoFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.sucoGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.sucoFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="sucoQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextSuco"
								path="inqueritoAlimentar.sucoQuantidade" cssClass="form-control"
								placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.sucoGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.sucoQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkBebidasAlcoolicasGosta" class="control-label"><form:checkbox
									id="checkBebidasAlcoolicasGosta"
									path="inqueritoAlimentar.bebidasAlcoolicasGosta"
									class="checkInquerito" /> Gosta de Bebidas Alcoólicas?</label>
							<form:select
								path="inqueritoAlimentar.bebidasAlcoolicasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.bebidasAlcoolicasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.bebidasAlcoolicasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="bebidasAlcoolicasQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextBebidasAlcoolicas"
								path="inqueritoAlimentar.bebidasAlcoolicasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.bebidasAlcoolicasGosta}" />
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.bebidasAlcoolicasQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkGaseificadasGosta" class="control-label"><form:checkbox
									id="checkGaseificadasGosta"
									path="inqueritoAlimentar.gaseificadasGosta"
									class="checkInquerito" /> Gosta de Bebidas Geseificadas?</label>
							<form:select
								path="inqueritoAlimentar.gaseificadasFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.gaseificadasGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors
									path="inqueritoAlimentar.gaseificadasFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="gaseificadasQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextGaseificadas"
								path="inqueritoAlimentar.gaseificadasQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.gaseificadasGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.bovinaQuantidade"></form:errors>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="form-item col-sm-6">
							<label for="checkInfusoesGosta" class="control-label"><form:checkbox
									id="checkInfusoesGosta" path="inqueritoAlimentar.infusoesGosta"
									class="checkInquerito" /> Gosta de Infusões?</label>
							<form:select path="inqueritoAlimentar.infusoesFrequenciaSemanal"
								cssClass="form-control select"
								disabled="${not consultaNutricional.inqueritoAlimentar.infusoesGosta}">
								<form:option value="">Quantas vezes por semana?</form:option>
								<form:options items="${frequencia}" itemLabel="tipo" />
							</form:select>
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.infusoesFrequenciaSemanal"></form:errors>
							</div>
						</div>

						<div class="form-item col-sm-6">
							<label for="infusoesQuantidade" class="control-label">Anotação</label>
							<form:input id="inputTextInfusoes"
								path="inqueritoAlimentar.infusoesQuantidade"
								cssClass="form-control" placeholder="Anotação"
								disabled="${not consultaNutricional.inqueritoAlimentar.infusoesGosta}" />
							<div class="error-validation">
								<form:errors path="inqueritoAlimentar.infusoesQuantidade"></form:errors>
							</div>
						</div>
					</div>


					<div class="col-xs-offset-0 col-xs-10" align="center">
						<button type="submit" class="btn btn-success">${botao}</button>
					</div>
					<br>
					<br>
					<br>
					<br>

				</form:form>
			</div>
		</div>
	</div>
	<br>
	<br>

	<div id="confirm-delete" class="modal" role="dialog" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirmar Deleção</h4>
				</div>
				<div class="modal-body">
					<p>Você está a ponto de excluir um documento da consulta, esse
						procedimento é irreversível.</p>
					<p>Você deseja continuar?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<a class="btn btn-danger btn-ok">Deletar</a>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script
		src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>
	<script src="<c:url value="/resources/js/inquerito-alimentar.js" />"></script>

	<script type="text/javascript">
		$('#menu-paciente').addClass('active');
		loadFrequenciaAlimentar("RECORDATORIO");
		$(".anexo").fileinput(
				{
					uploadUrl : "/file-upload-batch/2",
					showUpload : false,
					showRemove : false,
					language : 'pt-BR',
					uploadAsync : false,
					fileselectnone : true,
					allowedPreviewTypes : null,
					// 	    	allowedPreviewMimeTypes: ['image/jpeg'],
					layoutTemplates : {
						actions : '<div class="file-actions">\n'
								+ '    <div class="file-footer-buttons">\n'
								+ '        {delete}' + '    </div>\n'
								+ '    <div class="clearfix"></div>\n'
								+ '</div>'
					}
				});
	</script>

</body>
</html>