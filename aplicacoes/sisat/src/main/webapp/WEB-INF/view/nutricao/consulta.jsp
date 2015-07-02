<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<html>
	<head>
		<meta charset="UTF-8" />
		<jsp:include page="../modulos/header-estrutura.jsp" />
		<title>Consulta</title>
	</head>
<body>
	<jsp:include page="../modulos/header.jsp" />

	<div class="container">

		<c:if test="${action eq 'cadastrar' }">
			<c:set var="url" value="/nutricao/consultar"></c:set>
			<c:set var="titulo" value="Nova Consulta "></c:set>
			<c:set var="botao" value="Finalizar Consulta "></c:set>
		</c:if>

		<c:if test="${action eq 'editar' }">
			<c:set var="url" value="/nutricao/editarConsulta"></c:set>
			<c:set var="titulo" value="Editar Consulta  "></c:set>
			<c:set var="botao" value="Atualizar Consulta"></c:set>
		</c:if>

		<h2>${titulo}</h2>

		<ul class="nav nav-pills">
			<li class="active"><a data-toggle="tab" href="#avaliacao"><span class="badge">1</span> Anamnese</a></li>
			<li><a data-toggle="tab" href="#exame"><span class="badge">2</span> Exames Laboratoriais</a></li>
			<li><a data-toggle="tab" href="#questionario"><span class="badge">3</span> Recordatório Alimentar</a></li>
			<li><a data-toggle="tab" href="#orientacoes"><span class="badge">4</span> Orientações Individuais</a></li>
			<li><a data-toggle="tab" href="#documentos"><span class="badge">5</span> Documentos</a></li>
		</ul>

		<form:form servletRelativeAction="${url}" method="POST" id = "consultaNutricional" modelAttribute="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="tab-content">
				<form:hidden path="id" />
				<form:hidden path="paciente.id" />
				<form:hidden path="data" />

				<div id="avaliacao" class="tab-pane fade in active">
					<h3></h3>
					<div class="form-group form-item">
						<label for="objetivoConsulta" class="col-sm-2 control-label"> Objetivo da Consulta:</label>
						<div class="col-sm-10" >
							<form:textarea id="objetivoConsulta" path="objetivoConsulta" class="form-control" rows="5" placeholder="Descreva aqui o objetivo da consulta..."/>
							
							<div class="error-validation"><form:errors path="objetivoConsulta"></form:errors></div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="altura" class="col-sm-2 control-label">Altura:</label>
						<div class="col-sm-4">
							<form:input id="altura" name="altura" type="number" path="paciente.altura" cssClass="form-control" placeholder="0.00" />

							<div class="error-validation"><form:errors path="paciente.altura"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="peso" class="col-sm-2 control-label">Peso:</label>
						<div class="col-sm-4">
							<form:input id="peso" name="peso" type="number" path="peso" cssClass="form-control" placeholder="00.00"/>
							
							<div class="error-validation"><form:errors path="peso"></form:errors></div>
						</div>
						<label for="peso" class="col-sm-2 control-label">Peso desejado:</label>
						<div class="col-sm-4">
							<form:input id="peso" name="peso" type="number" path="peso" cssClass="form-control" placeholder="00.00"/>
							
							<div class="error-validation"><form:errors path="peso"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="cc" class="col-sm-2 control-label">CC:</label>
						<div class="col-sm-4" >
							<form:input id="cc" name="cc" type="number" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
							
							<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
						</div>
						<label for="cc" class="col-sm-2 control-label">CC desejada:</label>
						<div class="col-sm-4" >
							<form:input id="cc" name="cc" type="number" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
							
							<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
						</div>
					</div>

					<div class="form-group form-item" align="left">
						<label for="agua" class="col-sm-2 control-label">Consumo de água:</label>
						<div class="col-sm-10">
							<form:input id="agua" name="agua" type="number" path="agua" cssClass="form-control" placeholder="Consumo de água"/>
							
							<div class="error-validation"><form:errors path="agua"></form:errors></div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="form-item">
							<label for="checkAtividadeFisica" class="col-sm-2 control-label"><form:checkbox id="checkAtividadeFisica"  path="atividadeFisica" class="check"/> Atividade Física:</label>
							<div class="col-sm-7" >
								<form:input id="inputTextAtividadeFisica" path="atividadeFisicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.atividadeFisica}"/>

								<div class="error-validation"><form:errors path="atividadeFisicaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
									<form:select id="atividadeFisicaFrequenciaSemanal" path="atividadeFisicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.atividadeFisica}">
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
					</div>
					
					<div class="form-group">
						<div class="form-item">
							<label for="checkCarneVermelha" class="col-sm-2 control-label"><form:checkbox id="checkCarneVermelha"  path="carneVermelha" class="check"/> Carne Vermelha:</label>
							
							<div class="col-sm-7" >
								<form:input id="inputTextCarneVermelha" path="carneVermelhaComentario" cssClass="form-control" placeholder="Que tipo de carne?" disabled="${not consultaNutricional.carneVermelha}"/>
								
								<div class="error-validation"><form:errors path="carneVermelhaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
									<form:select path="carneVermelhaFrequenciaSemanal" cssClass="form-control select" disabled="${not consultaNutricional.carneVermelha}">
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
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="checkBebidaAlcoolica" class="col-sm-2 control-label"><form:checkbox id="checkBebidaAlcoolica"  path="bebidaAlcoolica" class="check"/> Bebida alcoólica:</label>
							<div class="col-sm-7" >
								<form:input id="inputTextBebidaAlcoolica" path="bebidaAlcoolicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.bebidaAlcoolica}"/>
								
								<div class="error-validation"><form:errors path="bebidaAlcoolicaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
									<form:select path="bebidaAlcoolicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.bebidaAlcoolica}">
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
					</div>

				
					<div class="form-group form-item">
						<label for="checkMedicamento" class="col-sm-2 control-label"><form:checkbox id="checkMedicamento"  path="medicamento" class="check"/> Medicamentos:</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMedicamento" path="medicamentoComentario" cssClass="form-control" placeholder="Quais medicamentos você usa?" disabled="${not consultaNutricional.medicamento}"/>
							
							<div class="error-validation"><form:errors path="medicamentoComentario"></form:errors></div>
						</div>
					</div>
				
				
					<div class="form-group form-item">
						<label for="checkMastigacao" class="col-sm-2 control-label"><form:checkbox id="checkMastigacao"  path="mastigacao" class="check"/> Mastigação:</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>

					<div class="form-group form-item">
						<label for="disfagia" class="col-sm-2 control-label"><form:checkbox id="disfagia" path="disfagia"/> Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>

					<div class="form-group form-item">
						<label for="disfagia" class="col-sm-2 control-label"><form:checkbox id="disfagia" path="disfagia"/> Odinofagia</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
					
					<div class="form-group form-item">
						<label for="pirose" class="col-sm-2 control-label"><form:checkbox id="pirose" path="pirose"/> Pirose</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
					<div class="form-group form-item">
						<label for="nausea" class="col-sm-2 control-label"><form:checkbox id="nausea" path="nausea"/> Náusea</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
					<div class="form-group form-item">
						<label for="vomito" class="col-sm-2 control-label"><form:checkbox id="vomito" path="vomito"/> Vômitos</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
					<div class="form-group form-item">
						<label for="diarreia" class="col-sm-2 control-label"><form:checkbox id="diarreia" path="diarreia"/> Diarreia</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
					<div class="form-group form-item">
						<label for="constipacao" class="col-sm-2 control-label"><form:checkbox id="constipacao" path="constipacao"/> Constipação</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group form-item">
						<label for="checkAlergia" class="col-sm-2 control-label"><form:checkbox id="checkAlergia"  path="alergia" class="check"/> Alergia Alimentar:</label>
						<div class="col-sm-10" >
							<form:textarea id="inputTextAlergia" path="alergiaComentario" class="form-control" rows="5" placeholder="Qual sua alergia Alimentar?" disabled="${not consultaNutricional.alergia}"/>
							
							<div class="error-validation"><form:errors path="alergiaComentario"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group form-item">
						<label for="checkPatologia" class="col-sm-2 control-label"><form:checkbox id="checkPatologia"  path="outrasPatologias" class="check"/> Patologias:</label>
						<div class="col-sm-10" >
							<form:textarea id="inputTextPatologia" path="outrasPatologiasComentario" class="form-control" rows="5" placeholder="Descreva aqui as patologias" disabled="${not consultaNutricional.outrasPatologias}"/>
							
							<div class="error-validation"><form:errors path="outrasPatologiasComentario"></form:errors></div>
						</div>
					</div>
				</div>

				<div id="exame" class="tab-pane fade">
					<h3>Seus exames</h3>

					<div class="form-group">
						<div class="form-item">
							<label for="glicemia" class="col-sm-2 control-label">Glicemia:</label>
							<div class="col-sm-2">
								<form:input id="glicemia" type="number" path="glicemia" cssClass="form-control" placeholder="glicemia" />			
								
								<div class="error-validation"><form:errors path="glicemia"></form:errors></div>
							</div>
							<div class="col-sm-2" >
								<form:select path="classificacaoGlicemia" cssClass="form-control" disabled="${not consultaNutricional.classificacaoGlicemia}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
				 		</div> 
					
				 		<div class="form-item">
							<label for="ct" class="col-sm-2 control-label">CT:</label>
							<div class="col-sm-2">
								<form:input id="ct" type="number" path="ct" cssClass="form-control" placeholder="ct" />
								
								<div class="error-validation"><form:errors path="ct"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoCt" cssClass="form-control" disabled="${not consultaNutricional.classificacaoCt}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="ldl" class="col-sm-2 control-label">LDL-C:</label>
							<div class="col-sm-2">
								<form:input id="ldl" type="number" path="ldl" cssClass="form-control" placeholder="LDL-C" />
								
								<div class="error-validation"><form:errors path="ldl"></form:errors></div>
							</div>
							<div class="col-sm-2" >
								<form:select path="classificacaoLdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoLdl}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
				
						<div class="form-item">
							<label for="hdl" class="col-sm-2 control-label">HDL-C:</label>
							<div class="col-sm-2">
								<form:input id="hdl" type="number" path="hdl" cssClass="form-control" placeholder="HDL-C" />
								
								<div class="error-validation"><form:errors path="hdl"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoHdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHdl}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="tg" class="col-sm-2 control-label">TG:</label>
							<div class="col-sm-2">
								<form:input id="tg" type="number" path="tg" cssClass="form-control" placeholder="TG" />
								
								<div class="error-validation"><form:errors path="tg"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoTg" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTg}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
				
						<div class="form-item">
							<label for="hb" class="col-sm-2 control-label">HB:</label>
							<div class="col-sm-2">
								<form:input id="hb" type="number" path="hb" cssClass="form-control" placeholder="HB" />
								
								<div class="error-validation"><form:errors path="hb"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoHb" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHb}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="tgo" class="col-sm-2 control-label">TGO (AST):</label>
							<div class="col-sm-2">
								<form:input id="tgo" type="number" path="tgo" cssClass="form-control" placeholder="tgo" />
								
								<div class="error-validation"><form:errors path="tgo"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoTgo" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgo}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					
				 		<div class="form-item"> 
							<label for="tgp" class="col-sm-2 control-label">TGP (ALT):</label>
							<div class="col-sm-2">
								<form:input id="tgp" type="number" path="tgp" cssClass="form-control" placeholder="TGP (ALT)" />
								
								<div class="error-validation"><form:errors path="tgp"></form:errors></div>
							</div>
				
						<div class="form-item">
							<div class="col-sm-2" >
								<form:select path="classificacaoTgp" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgp}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
					</div>
				</div>

				<div id="questionario" class="tab-pane fade in ">
					<fieldset>
						<h3>Adicione as refeições</h3>

						<div class="form-group">
							<table id="questionarioFrequenciaAlimentar"></table>
						</div>
					</fieldset>
				</div>

				<div id="orientacoes" class="tab-pane fade in ">
					<h3>Orientações</h3>

					<div class="form-group">
						<label for="condutaNutricional" class="col-sm-2 control-label"> Conduta Nutricional:</label>
						<div class="col-sm-10" >
							<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
							
							<div class="error-validation"><form:errors path="condutaNutricional"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="orientacoesIndividuais" class="col-sm-2 control-label"> Orientações Individuais</label>
						<div class="col-sm-10" >
							<form:textarea id="orientacoesIndividuais" path="orientacoesIndividuais" class="form-control" rows="5" placeholder="Orientações Individuais"/>
							
							<div class="error-validation"><form:errors path="orientacoesIndividuais"></form:errors></div>
						</div>
					</div>
				</div>
				

			</div>

			<div class="col-xs-offset-0 col-xs-10" align="center">
				<button type="submit" class="btn btn-success">${botao}</button>
			</div>
		</form:form>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
