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
		<title>Plano Alimentar</title>
	</head>
<body>
	<jsp:include page="../modulos/header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3 class="section">Recordatório</h3>
				<c:if test="${empty consultaNutricional.frequencias}">
					<div class="alert alert-dismissible alert-default">Não há informações sobre o recordatório alimentar.</div>
				</c:if>				
				<c:forEach var="freq" items="${consultaNutricional.frequencias}">
					<fmt:formatDate var="horaFormatada" type="time" dateStyle="short" timeStyle="short" value="${freq.horario}" />
		
					<div class="col-sm-12" align="left">
						<h4><strong class="label label-info">${freq.refeicao.nome }</strong>
						<span class="label label-primary">${horaFormatada}</span></h4>
					</div>
		
					<div class="col-sm-12" align="left">
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
									<td>${alimento.alimento }</td>
									<td>${alimento.porcao }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</c:forEach>			
			</div> 

			<div class="col-sm-6">	
				<h3 class="section">Plano Alimentar</h3>
				<form:form servletRelativeAction="${url}" method="POST" id="plano-alimentar" modelAttribute="consulta" commandName="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal" enctype="multipart/form-data">
									
				<div class="row form-group">
					<div class="col-sm-12">
						<table id="questionarioFrequenciaAlimentar" class="table"></table>
					</div>
				</div>
				<div class="col-xs-offset-0 col-xs-10" align="right">
				<button type="submit" class="btn btn-success">Atualizar Plano Alimentar</button>						
				</div>	
				</form:form>		
			</div>
			
		</div>						
		
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	<script src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>
</body>
	
</html>