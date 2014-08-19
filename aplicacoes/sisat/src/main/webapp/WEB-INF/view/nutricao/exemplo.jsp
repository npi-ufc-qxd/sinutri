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
	<title>Horários de Atendimento</title>
</head>
<body>
	<jsp:include page="../modulos/header.jsp" />
	
	<div class="container">
		<table class="table" id="table">
		<h1>Exemplo</h1>	
				<tr>
					<th>Data</th>
					<th>Inicio</th>
					<th>Final</th>
					<th>Ação</th>
				</tr>

				<tr>
					<form:form id="exemplo" commandName="exemplo" servletRelativeAction="nutricao/exemplo" method="POST">
						<th><form:input id="data" path="data" placeholder="Data de Atendimento"/></th>
						<th><form:input id="inicio" path="fim" placeholder="Inicio de Atendimento"/></th>
						<th><form:input id="fim" path="fim" placeholder="Fim do Atendimento"/></th>
						<th><a href="#" class="btn btn-large btn-primary"><span class="glyphicon glyphicon-plus"></span></a>
						</th>
					</form:form>
				</tr>

				<tr>
					<th>Data</th>
					<th>Inicio</th>
					<th>Final</th>
					<th><a href="#" class="btn btn-large btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
				</tr>
		</table>
	</div>

	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>