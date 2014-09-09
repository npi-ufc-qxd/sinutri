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


				<table >
				<div class="inline">
			<form:form id="buscarPacienteForm" role="form"
				servletReltiveAction="/nutricao/buscar" method="POST"
				cssClass="form-horizontal">
					<div class="form-group">
						<td>
							<select name="tipoPesquisa">
								<option value="nome">Nome</option>
								<option value="cpf">CPF</option>
							</select>
							</td>
							<td> 
							<input id="campo" name="campo" cssClass="form-control"
								placeholder="" size="40" required="required"/>
								</td>
					</div>
					<div class="controls">
					<td>
						<input name="submit" type="submit" class="btn btn-primary"
							value="Buscar" />
					</td>
					</div>
			</form:form>
				</div>
				</table>



			<%-- <c:if test="${empty pessoas}">
				<div class="alert alert-warning" role="alert">Pessoa não
					encontrada.</div>
			</c:if> --%>
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
									<td><a href="<c:url value="/nutricao/${pessoa.id}/detalhes"></c:url>">${pessoa.nome}
									</a></td>
									<td><a id="detalhes" data-toggle="modal" href="${pessoa.id}/detalhes">
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
	<jsp:include page="../modulos/footer.jsp" />

</body>

</html>