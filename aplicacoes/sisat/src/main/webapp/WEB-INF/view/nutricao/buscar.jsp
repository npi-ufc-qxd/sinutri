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

	<div class="container">
		<div class="buscar-paciente" align="left">

			<c:if test="${not empty erro }">
				<div class="alert alert-danger" role="alert">${erro}</div>
			</c:if>
			<c:if test="${not empty info }">
				<div class="alert alert-info" role="alert">${info}</div>
			</c:if>
			<c:if test="${not empty success }">
				<div class="alert alert-success" role="alert">${success}</div>
			</c:if>


			<h3>Buscar Paciente</h3>
			<form:form id="buscarPacienteForm" role="form" servletReltiveAction="/nutricao/buscar" method="POST" class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-10">
						<input id="busca" name="busca" class="form-control" placeholder="Nome ou CPF" size="40"
						required="required" value="${busca }"/>
					</div>
					<div class="col-sm-2">
						<button class="btn btn-primary" name="submit" type="submit"
							class="btn btn-primary" value="Buscar">
							Buscar <span class="glyphicon glyphicon-search"></span>
						</button>
				    </div>
				</div>
				

			</form:form>

			<c:if test="${not empty pessoas}">

					<!-- Table -->
					<table class="table" id="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th align="right"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pessoa" items="${pessoas}">
								<tr class="linha">
									<td>
										<a href="<c:url value="/nutricao/detalhes/${pessoa.id}"></c:url>">${pessoa.nome}</a>
									</td>
									<td align="right">
										<a id="detalhes" data-toggle="modal" href="detalhes/${pessoa.id}">

											<button class="btn btn-default">
												Detalhes <span class="glyphicon glyphicon-eye-open"></span>
											</button>
										</a>

										<a id="consulta" data-toggle="modal" href="consulta/${pessoa.id}">

											<button class="btn btn-default">
												Consulta <span class="glyphicon glyphicon-plus"></span>
											</button>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
						
			</c:if>
			
			<c:if test="${not empty busca and empty pessoas}">
				<div class="alert alert-warning" role="alert">Nenhum resultado encontrado</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>