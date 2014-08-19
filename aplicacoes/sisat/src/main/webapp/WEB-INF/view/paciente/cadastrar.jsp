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
	<title>Cadastro de Projetos</title>
</head>
<body>

	<jsp:include page="../modulos/header.jsp" />
	
	
	
	 <div class="container">
		<div class="Cadastro paciente" align="left">
			<div class="form" align="center">
				<h2>Cadastro de paciente</h2>
				<form:form id="adicionarProjetoForm" role="form" commandName="projeto" servletRelativeAction="/projeto/cadastrar" method="POST" cssClass="form-horizontal">

					
					
					<div class="controls">
						<input name="submit" type="submit" class="btn btn-primary" value="Cadastrar" />
						<a href="<c:url value="/projeto/index"></c:url>" class="btn btn-default">Cancelar</a>
					</div>

				</form:form>
			</div>
		</div>
	</div>
	
	
	

	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>