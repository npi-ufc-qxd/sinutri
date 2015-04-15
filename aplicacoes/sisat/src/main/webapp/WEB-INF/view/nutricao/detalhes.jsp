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
		<div id="dados-pessoais" align="left">
			<h3>Paciente</h3>
			<div class="form-horizontal">
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome:</label>
					<div class="col-sm-4">
						<label id="nome" class="control-label">${pessoa.nome }</label>
					</div>
					<label for="nome" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-4">
						<label id="nome" class="control-label">${pessoa.email }</label>
					</div>
				</div>
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Sexo:</label>
					<div class="col-sm-2">
						<label id="nome" class="control-label">${pessoa.sexo }</label>
					</div>
					<label for="nome" class="col-sm-2 control-label">Idade:</label>
					<div class="col-sm-2">
						<label id="nome" class="control-label">${pessoa.idade }</label>
					</div>
					<label for="nome" class="col-sm-2 control-label">Telefone:</label>
					<div class="col-sm-2">
						<label id="nome" class="control-label">${pessoa.telefone }</label>
					</div>
			</div>
			</div>
		</div>
		
		<h3>Consultas</h3>

		<c:if test="${not empty pessoa.paciente.consultas}">
			<!-- Table -->
			<table class="table" id="consultas">
				<thead>
					<tr>
						<th>Data</th>
						<th colspan="2" width="20%">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="consulta" items="${pessoa.paciente.consultas}">
						<tr class="linha">
							<td><a href="../detalhesConsulta/${consulta.id}/"> <fmt:formatDate
										type="both" pattern="dd-MM-yyyy HH-mm"
										value="${consulta.data}" />
							</a></td>
							<td><a id="detalhes" data-toggle="modal"
								href="../detalhesConsulta/${consulta.id}">
									<button class="btn btn-info">
										Detalhes <span class="glyphicon glyphicon-eye-open"></span>
									</button>
							</a></td>
							<td><a id="editar" data-toggle="modal"
								href="../editarConsulta/${consulta.id}">
									<button class="btn btn-warning">
										Editar <span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${empty pessoa.paciente.consultas}">
			<div class="alert alert-warning" role="alert">Não há consultas cadastradas para esse paciente.</div>
		</c:if>

		<div class="controls">
			<a href="<c:url value="/nutricao/buscar"></c:url>" class="btn btn-default">Voltar</a>
			<a href="<c:url value="/nutricao/consulta/${pessoa.id }"></c:url>" class="btn btn-primary">Realizar consulta</a>
		</div>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>
