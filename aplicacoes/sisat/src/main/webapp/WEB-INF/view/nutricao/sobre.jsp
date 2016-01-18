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
		<title>Sobre</title>
	</head>
<body>

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
		<div class="sobre" align="left">

		<div class="logo-sobre">
			<a><img src="<c:url value="/resources/images/logo-sinutri.png" />" alt="SiNutri" class="logo-sinutri-sobre"></a>
		</div>
		<div class="descript-sobre">
			<p>SISAT - Sistema de atendimento a serviços de psicologia, nutrição para a comunidade acadêmica da UFC.</p>
			<p>Sinutri está destinado ao uso no atendimento de nutrição para a comunidade acadêmica.</p><br/><br/>
			<p class="text-muted"> &copy; 2016 Universidade Federal do Ceará - Campus Quixadá. Todos os direitos reservados </p>
		</div>
			
		</div>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">
		$('#menu-paciente').addClass('active');
	</script>

</body>
</html>