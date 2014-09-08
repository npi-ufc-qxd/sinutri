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
<title>Buscar paciente</title>
</head>
<body>

	<jsp:include page="../modulos/header.jsp" />



	<div class="container" style="margin-bottom: 70px;">
		<div class="novo-projeto" align="left">
			<div class="form">
				<h2>Paciente</h2>
				<table id="paciente" style="width:70%" >
					<tr>
						<td>Nome: ${pessoa.nome }</td>
	
						<td>Sexo: ${pessoa.sexo }</td>

						<td>Idade: ${pessoa.dataNascimento }</td>
					</tr>
					<tr>
						<td>E-mail: ${pessoa.email }    </td>
						
						<td colspan="2" >Telefone: ${pessoa.telefone }</td>
					</tr>
					
					
				</table>
				
				<div class="controls">
					<a href="<c:url value="/nutricao/buscar"></c:url>"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>