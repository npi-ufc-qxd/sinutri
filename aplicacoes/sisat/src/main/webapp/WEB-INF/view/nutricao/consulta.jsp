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
	<meta charset= iso-8859-1/>
	<jsp:include page="../modulos/header-estrutura.jsp" />
	<title>Consulta</title>
</head>

<body>
	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#avaliacao">Avaliação Nutricional</a></li>
        
        <li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>
        
        <li><a data-toggle="tab" href="#questionario">Questionario de Frequencia Alimentar</a></li>
    </ul>

	<form:form id="adicionarConsulta" role="form" commandName="consulta" servletRelativeAction="/nutricao/consulta" method="POST">
	    <div class="tab-content">
		
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
	</form:form>
</div>

<jsp:include page="../modulos/footer.jsp" />
</body>
</html>