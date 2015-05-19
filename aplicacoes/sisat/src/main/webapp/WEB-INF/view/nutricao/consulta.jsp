<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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

		<h2> ${titulo}</h2>
		
		<ul class="nav nav-tabs">
			<li><a data-toggle="tab" href="#avaliacao">Avaliação Nutricional</a></li>
			<li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>
			<li><a data-toggle="tab" href="#questionario">Questionario de Frequencia Alimentar</a></li>
			<li><a data-toggle="tab" href="#orientacoes">Orientações Individuais</a></li>
			<li><a data-toggle="tab" href="#documentos">Documentos</a></li>
		</ul>

		<form:form servletRelativeAction="${url}" method="POST" id = "consultaNutricional" modelAttribute="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="tab-content">
				<form:hidden path="id"/>
				<form:hidden path="paciente.id"/>
				<form:hidden path="data"/>
			
				<div id="avaliacao" class="tab-pane fade in active"><jsp:include page="abas/avaliacao.jsp" /></div>

				<div id="exame" class="tab-pane fade"><jsp:include page="abas/exame.jsp" /></div>

				<div id="questionario" class="tab-pane fade in "><jsp:include page="abas/questionario.jsp" /></div>

				<div id="orientacoes" class="tab-pane fade in "><jsp:include page="abas/orientacoes.jsp" /></div>
				
				<div id="documentos" class="tab-pane fade in "><jsp:include page="abas/documentos.jsp" /></div>
			</div>

			<div class="col-xs-offset-0 col-xs-10" align="center">
				<button type="submit" class="btn btn-success">
					${botao}</button>
			</div>
		</form:form>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
</body>
</html>
