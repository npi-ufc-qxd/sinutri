<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<jsp:include page="../modulos/header-estrutura.jsp" />

		<title>Layout</title>
		<style type="text/css">
	 		.footer {
	 			position:relative;
	 			margin-top: 30px;
	 		}
		</style>
	</head>

<body data-spy="scroll" data-target="#myScrollspy">

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">

	    <div class="row">
			<div class="col-sm-4"><h2>Informações da Consulta</h2></div>

			<div class="col-sm-8" align="right" style="margin-top: 15px;">
				<a href="<c:url value="/nutricao/buscar"></c:url>" class="btn btn-default">Voltar</a>
				<a href="<c:url value="#/nutricao/plano-alimentar"></c:url>" class="btn btn-info">Criar Plano Alimentar</a>
				<a href="<c:url value="/consulta/paciente/${consulta.paciente.id }"></c:url>" class="btn btn-success">Realizar consulta</a>
				<a href="<c:url value="#/consulta/editar-consulta/${consulta.id }/paciente/${consulta.paciente.id }"></c:url>" class="btn btn-warning">Editar</a>
			</div>
    	</div>
	
	    <div class="row">
	        <div class="col-sm-3" id="myScrollspy">
	            <ul class="nav nav-tabs nav-stacked affix-top" data-spy="affix" data-offset-top="125">
					<li class="active">
						<a href="#avaliacao">
							<span class="badge">1</span> Anamnese
						</a>
					</li>
					<li>
						<a href="#recordatorio">
							<span class="badge">2</span> Recordatório Alimentar
						</a>
					</li>
					<li>
						<a href="#exame">
							<span class="badge">3</span> Exames Laboratoriais
						</a>
					</li>
					<li>
						<a href="#orientacoes">
							<span class="badge">4</span> Orientações Individuais
						</a>
					</li>
					<li>
						<a href="#documentos">
							<span class="badge">5</span> Documentos
						</a>
					</li>
	            </ul>
	
	        </div>
	
		    <div class="col-sm-9">
		    	<h3 id="avaliacao" class="section">Anamnese</h3>

		        
	<table>
		<tr>
			<td>${consulta.disfagia ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Disfagia</td>
			<td>${consulta.pirose ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				pirose</td>
			<td>${consulta.constipacao ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Constipação</td>
			<td>${consulta.diarreia ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Diarreia</td>
			<td>${consulta.nausea ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Naúsea</td>
			<td>${consulta.vomito ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Vômitos</td>
		</tr>
		<tr>
			<td><strong>Altura: </strong> ${consulta.paciente.alturaAtual }</td>
			<td><strong>Peso: </strong> ${consulta.peso}</td>
			<td><strong>IMC: </strong> ${consulta.imc}</td>
			<td><strong>CC: </strong>  ${consulta.circunferenciaCintura}
			 	${consulta.classificacaoCc}  </td> 
			<td></td>
		</tr>
	</table>
	<br /> <strong>Medicamentos: </strong>${consulta.medicamento ? consulta.medicamentoComentario  : "<em>Não usa medicamentos</em>"}
	<br /> <strong> Alergia alimentar: </strong>${consulta.alergia ? consulta.alergiaComentario  : "<em>Não possui alergia a alimentos</em>"}
	<br /> <strong> Atividade Fisica: </strong>
	<c:choose>
		<c:when test="${consulta.atividadeFisica }">
						${consulta.atividadeFisicaComentario } 
						<strong>Vezes por semana: </strong>${consulta.atividadeFisicaFrequenciaSemanal }
					</c:when>
		<c:otherwise>
			<em>Não pratica atividades fisicas.</em>
		</c:otherwise>
	</c:choose>
	<br /> <strong> Consumo de carne vermelha: </strong>
	${cosulta.carneVermelhaFrequencia }<br /> <strong> Consumo de
		bebida alcoolica: </strong>
	<c:choose>
		<c:when test="${consulta.bebidaAlcoolica }">
						${consulta.bebidaAlcoolicaComentario }
						<strong>Vezes por semana: </strong> ${consulta.bebidaAlcoolicaFrequenciaSemanal }
					</c:when>
		<c:otherwise>
			<em>Não consome bebidas alcoolicas.</em>
		</c:otherwise>
	</c:choose>
	<br /> <strong> Patologias: </strong> ${consulta.outrasPatologias ? consulta.outrasPatologiasComentario  : "<em>Não possui outras patologias</em>"}<br />

	<strong> Objetivo da consulta: </strong> ${consulta.objetivoConsulta }<br />




		    	<h3 id="recordatorio" class="section">Recordatório</h3>
		    	
	    		<c:forEach var="freq" items="${consulta.frequencias}">
		    		<div class="row">
						<fmt:formatDate var="horaFormatada" type="time" dateStyle="short" timeStyle="short" value="${freq.horario}" />
			    		
			    		<div class="col-sm-2 label-horario" align="center"> 
			    			<h4><strong class="label label-info">${freq.refeicao.nome }</strong></h4>
		    			    <h1><span class="label label-primary">${horaFormatada}</span></h1>
			    		</div>

			    		<div class="col-sm-10">
						    <table class="table table-striped">
						        <thead class="thead">
						            <tr>
										<th>Alimento/Preparo</th>
										<th>Porção</th>
						            </tr>
						        </thead>
						        <tbody>
									<c:forEach var="alimento" items="${freq.alimentos }">
										<tr>
											<td> ${alimento.alimento } </td>
											<td> ${alimento.porcao } </td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
			    		</div>
		    		</div>
		    	</c:forEach>

		        <h3 id="exame" class="section">Exames Laboratoriais</h3>
		        

			    <table class="table table-striped">
			        <thead class="thead">
			            <tr>
							<th>Exame</th>
							<th>Valor </th>
							<th>Classificação</th>
			            </tr>
			        </thead>
			        <tbody>
						<tr>
							<td> <strong>Glicemia: </strong> </td>
							<td> ${consulta.glicemia } </td>
							<td> ${consulta.classificacaoGlicemia } </td>
						</tr>

						<tr>
							<td> <strong>LDC - C: </strong> </td>
							<td> ${consulta.ldlc } </td>
							<td> ${consulta.classificacaoLdlc } </td>
						</tr>
						
						<tr>
							<td> <strong>CT: </strong> </td>
							<td> ${consulta.ct } </td>
							<td> ${consulta.classificacaoCt } </td>
						</tr>
						
						<tr>
							<td> <strong>HDL - C: </strong></td>
							<td> ${consulta.hdlc } </td>
							<td> ${consulta.classificacaoHdlc } </td>
						</tr>
						
						<tr>
							<td> <strong>TG: </strong> </td>
							<td> ${consulta.tg } </td>
							<td> ${consulta.classificacaoTg } </td>
						</tr>
						<tr>
							<td> <strong>HB: </strong> </td>
							<td> ${consulta.hb } </td> 
							<td> ${consulta.classificacaoHb } </td>
						</tr>

						<tr>
							<td> <strong>TGO(AST): </strong> </td>
							<td> ${consulta.tgo } </td>
							<td> ${consulta.classificacaoTgo } </td>
						</tr>
						<tr>
							<td> <strong>TGP(ALT): </strong> </td>
							<td> ${consulta.tgp } </td>
							<td> ${consulta.classificacaoTgp } </td>
						</tr>
			        </tbody>
			    </table>

		    	<h3 id="orientacoes" class="section">Orientações</h3>

		    	<h3 id="documentos" class="section">Documentos</h3>
			</div>
		</div>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
