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
<jsp:include page="../../modulos/header-estrutura.jsp" />
<title>Cadastro de Projetos</title>
</head>
<body>

	<jsp:include page="../../modulos/header.jsp" />



	<div class="container">
		<div class="Cadastro paciente" align="left">
			

				<form>
					<fieldset>
						<legend>Cadastro de paciente</legend>
						
						<label>CPF: </label> 
						<input type="text" placeholder="CPF do paciente">
						
						<label>Altura: </label>
						<input type="text" placeholder="Altura do paciente">
						
						<button type="submit" class="btn">Adicionar</button>
					</fieldset>
				</form>
				
				<form:form id="adicionarPacienteForm" role="form" commandName="paciente" servletRelativeAction="/projeto/cadastrar" method="POST" cssClass="form-horizontal">
				
				</form:form>


			
		</div>
	</div>
	
	





	<jsp:include page="../../modulos/footer.jsp" />

</body>
</html>