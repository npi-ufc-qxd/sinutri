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
<title>Buscar paciente</title>
</head>
<body>

	<jsp:include page="../../modulos/header.jsp" />



	<div class="container">
		<div class="buscar-paciente" align="left">

			<c:if test="${not empty erro }">
				<div class="alert alert-danger" role="alert">${erro}</div>
			</c:if>
			<c:if test="${not empty info }">
				<div class="alert alert-info" role="alert">${info}</div>
			</c:if>
			
			
			<form:form id="buscarPacienteForm" role="form" commandName="pessoa" servletRelativeAction="/nutricao/paciente/buscar" method="POST" cssClass="form-horizontal">
				
				<div class="form-group">
					<label for="cpf" class="col-sm-2 control-label">Cpf:</label>
					<div class="col-sm-10">
						<form:input id="cpf" path="cpf"	cssClass="form-control" placeholder="Cpf do paciente" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome:</label>
					<div class="col-sm-10">
						<form:input id="nome" path="nome"
							cssClass="form-control" placeholder="Nome do paciente" />
					</div>
				</div>
				
				<div class="controls">
					<input name="submit" type="submit" class="btn btn-primary" value="Buscar" />
				</div>
				
			</form:form>



			<c:if test="${empty pessoas}">
				<div class="alert alert-warning" role="alert">Pessoa não
					encontrada.</div>
			</c:if>
			<c:if test="${not empty pessoas}">
				<div class="panel panel-default">

					<div class="panel-heading" align="center"></div>

					<!-- Table -->
					<table class="table" id="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pessoa" items="${pessoas}">
								<tr class="linha">
									<td><a href="<c:url value="www.google.com"></c:url>">${pessoa.nome}
									</a></td>
									<td><a id="detalhes" data-toggle="modal"
										href="http://www.google.com"
										data-href="<c:url value="www.google.com" ></c:url>">
											<button class="btn btn-info">
												Detalhes <span class="glyphicon glyphicon-eye-open"></span>
											</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="../../modulos/footer.jsp" />

</body>
</html>