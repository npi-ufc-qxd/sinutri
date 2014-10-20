<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<jsp:include page="../modulos/header-estrutura.jsp" />
<title>Detalhes: ${pessoa.nome}</title>
</head>
<body>

	<jsp:include page="../modulos/header.jsp" />



	<div class="container" style="margin-bottom: 70px;">
		<div class="controls inline">
			<h2>
				<a
					href="<c:url value="/nutricao/${ consulta.paciente.pessoa.id}/detalhes"></c:url>"
					class="btn btn-default glyphicon glyphicon-arrow-left"> </a>
				Paciente
			</h2>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#avaliacao">Avaliação
					Nutricional</a></li>

			<li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>

			<li><a data-toggle="tab" href="#questionario">Questionario
					de Frequencia Alimentar</a></li>
		</ul>

		<div class="tab-content">

			<!-- ABA DE AVALIACAO NUTRICIONAL -->
			<div id="avaliacao" class="tab-pane fade in active">
				<jsp:include page="abas/detalhesAvaliacao.jsp" />
			</div>

			<!-- ABA DE EXAMES LABORATORIAS -->
			<div id="exame" class="tab-pane fade">
				<jsp:include page="abas/detalhesExame.jsp" />
			</div>

			<!-- ABA DE QUESTIONARIO DE FRENQUENCIA ALIMENTAR -->
			<div id="questionario" class="tab-pane fade">
				<jsp:include page="abas/detalhesQuestionario.jsp" /> 
			</div>
		</div>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>