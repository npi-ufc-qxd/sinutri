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
		value="/paciente/${avaliacaoAntropometrica.paciente.pessoa.cpf}/Antropometria"></c:url>
	<c:set var="titulo" value="Nova Avaliação Antropometrica "></c:set>
	<c:set var="botao" value="Finalizar Avaliação Antropometrica "></c:set>
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url"
		value="/paciente/${avaliacaoAntropometrica.paciente.pessoa.cpf}/Antropometria/${avaliacaoAntropometrica.id}/editar"></c:url>
	<c:set var="titulo" value="Editar Avaliação Antropometrica "></c:set>
	<c:set var="botao" value="Atualizar Avaliação Antropometrica"></c:set>
</c:if>

<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastrar Avaliação Antropometrica</title>
	<jsp:include page="../../modulos/header-estrutura.jsp" />
</head>
<body>
	<jsp:include page="../../modulos/header.jsp" />
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
					<strong>${avaliacaoAntropometrica.paciente.pessoa.nome}</strong>
				</h3>
			</div>

			<div class="col-sm-3" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
			</div>
		</div>
		
		<div class="row">
			<form:form servletRelativeAction="${url}" method="POST"
					id="form-antropometria" modelAttribute="avaliacaoAntropometrica"
					commandName="avaliacaoAntropometrica" acceptCharset="UTF-8"
					cssClass="form-horizontal" enctype="multipart/form-data">
				<form:hidden path="id" />
				<form:hidden path="paciente.id" />
				<form:hidden path="data" />
			</form:form>
		</div>
		
		
	
	</div>
</body>
<jsp:include page="../../modulos/footer.jsp" />
</html>