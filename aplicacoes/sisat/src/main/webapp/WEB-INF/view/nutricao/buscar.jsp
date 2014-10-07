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
			

			<form:form id="buscarPacienteForm" role="form"
				servletReltiveAction="/nutricao/buscar" method="POST"
				cssClass="form-horizontal" class="inline">
				<select name="tipoPesquisa" cssClass="form-control">
					<option value="nome">Nome</option>
					<option value="cpf">CPF</option>
				</select>
				<input id="campo" name="campo" cssClass="form-control"
					placeholder="Digite sua busca aqui..." size="40" required="required" autofocus="true"/>
				<button class="btn btn-primary" name="submit" type="submit" class="btn btn-primary"
					value="Buscar" >
					 Buscar
					 <span class="glyphicon glyphicon-search"/> 
				</button>
				
 			</form:form>

			<c:if test="${not empty pessoas}">
				<div class="panel panel-default">

					<div class="panel-heading" align="center"></div>

					<!-- Table -->
					<table class="table" id="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th align="right" >Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pessoa" items="${pessoas}">
								<tr class="linha">
									<td><a href="<c:url value="/nutricao/${pessoa.id}/detalhes"></c:url>">${pessoa.nome}
									</a></td>
									<td align="right">
										<a id="detalhes" data-toggle="modal" href="${pessoa.id}/detalhes">
											<button class="btn btn-info">
												<span class="glyphicon glyphicon-eye-open"></span>
												Detalhes 
											</button>
											
										</a>
										<a id="consulta" data-toggle="modal" href="${pessoa.id}/realizar">
											<button class="btn btn-info">
												<span class="glyphicon glyphicon-plus"></span>
												Consulta 
											</button>
										</a>
									</td>
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
