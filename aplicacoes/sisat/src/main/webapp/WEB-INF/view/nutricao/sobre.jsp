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

		<h3>Sobre</h3>
		<div class="logo-sobre">
			<a><img src="<c:url value="/resources/images/logo-sinutri.png" />" alt="SiNutri" class="logo-sinutri-sobre"></a>
		</div>
		<div class="descript-sobre">
			<p>O Sinutri é uma ferramenta que permite a realização de consultas nutricionais realizadas pela nutricionista do campus,</p> 
			<p>poderá analisar, visualizar consultas, prescrever dietas e demais atividades realizadas durante a educação aliementar realizada no campus.</p>
		</div>
			
		</div>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">
		$('#menu-paciente').addClass('active');
	</script>

</body>
</html>