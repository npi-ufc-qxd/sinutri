<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta charset="UTF-8"/>
	<jsp:include page="../modulos/header-estrutura.jsp" />
	<title>Consulta</title>
</head>

<body>
	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
	
	
	
	<h2>${consulta.id}</h2>
	
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#avaliacao">Avaliação Nutricional</a></li>

        <li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>
        
        <li><a data-toggle="tab" href="#questionario">Questionario de Frequencia Alimentar</a></li>
    </ul>

	<form:form servletRelativeAction="../consulta" method="POST" modelAttribute="consulta">
	    <div class="tab-content">
	    <input type="hidden" name="paciente.id" value="${id}">
		
			<!-- ABA DE AVALIACAO NUTRICIONAL -->
	        <div id="avaliacao" class="tab-pane fade in active">
				<jsp:include page="abas/avaliacao.jsp" />
	        </div>
	
			<!-- ABA DE EXAMES LABORATORIAS -->
	        <div id="exame" class="tab-pane fade">
				<jsp:include page="abas/exame.jsp" />
	        </div>
	
			<!-- ABA DE QUESTIONARIO DE FRENQUENCIA ALIMENTAR -->
	        <div id="questionario" class="tab-pane fade">
				<jsp:include page="abas/questionario.jsp" />
	        </div>
	    </div>

		<div class="col-xs-offset-0 col-xs-10" align="center">
			<button type="submit" class="btn btn-success">Finalizar Consulta</button>
		</div>
	</form:form>
</div>

<jsp:include page="../modulos/footer.jsp" />
</body>
</html>
