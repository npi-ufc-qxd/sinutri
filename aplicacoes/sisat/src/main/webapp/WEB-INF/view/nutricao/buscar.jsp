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
		<title>Buscar paciente</title>
	</head>
<body>

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
		<div class="buscar-paciente" align="left">

		<h3>Buscar Paciente</h3>
		<form:form id="formBuscarPaciente" role="form" servletReltiveAction="/nutricao/buscar" method="POST" class="bs-component">	
			<div class="form-group">
			  <div class="input-group">
				<input id="busca" name="busca" type="text" class="form-control" placeholder="Nome ou CPF" size="40" required="required" value="${busca }" autofocus="autofocus"/>
			    <span class="input-group-btn">
			    	<button class="btn btn-default" name="submit" type="submit"><span class="glyphicon glyphicon-search"></span> Buscar</button>
			    </span>
			  </div>
			</div>
		</form:form>

			<c:if test="${not empty erro }"><div class="alert alert-danger" role="alert">${erro}</div></c:if>

			<c:if test="${not empty info }"><div class="alert alert-info" role="alert">${info}</div></c:if>

			<c:if test="${not empty success }"><div class="alert alert-success" role="alert">${success}</div></c:if>

			<c:if test="${not empty busca and empty pessoas}"><div class="alert alert-warning" role="alert">Nenhum resultado encontrado</div></c:if>

			<c:if test="${not empty pessoas}">
			    <table class="table table-striped">
			        <thead class="thead">
			            <tr>
			                <th>Paciente</th>
			                <th>Email</th>
			                <th></th>
			            </tr>
			        </thead>
			        <tbody>
						<c:forEach var="pessoa" items="${pessoas}">
				            <tr>
				                <td><a href="<c:url value="/consulta/historico-paciente/${pessoa.cpf}"></c:url>">${pessoa.nome}</a></td>
				                <td>${pessoa.email}</td>
				                <td align="right">
				                	<a href="<c:url value="/consulta/historico-paciente/${pessoa.cpf}"/>" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-eye-open"></span> Historico</a>
				                	<a href="<c:url value="/consulta/realizar-consulta/${pessoa.cpf}"/>" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> Consulta</a>
				                </td>
				            </tr>
						</c:forEach>
			        </tbody>
			    </table>
			</c:if>
			
		</div>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>