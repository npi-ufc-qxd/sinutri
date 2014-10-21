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
				<div class="controls">
					<a href="<c:url value="/nutricao/buscar"></c:url>"
						class="btn btn-default">Voltar</a>
				
					<a href="<c:url value="/nutricao/${pessoa.id }/realizar"></c:url>"
						class="btn btn-default">Realizar consulta</a>
				</div>
		<div class="novo-projeto" align="left">
			<div class="form">
				<h2>Paciente</h2>
				<table id="paciente" style="width:70%" >
					<tr>
						<td>Nome: ${pessoa.nome }</td>
	
						<td>Sexo: ${pessoa.sexo }</td>

						<td>
							Idade: ${pessoa.idade }
						</td>
					</tr>
					<tr>
						<td>E-mail: ${pessoa.email }    </td>
						
						<td colspan="2" >Telefone: ${pessoa.telefone }</td>
					</tr>
				</table>
			</div>
		</div>
		
		<c:if test="${not empty pessoa}">
				<div class="panel panel-default">

					<div class="panel-heading" align="center"></div>

					<!-- Table -->
					<table class="table" id="table">
						<thead>
							<tr>
								<th>Data</th>
								<th colspan="2" width="20%">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="consulta" items="${pessoa.paciente.consultas}">
								<tr class="linha">
									<td><a href="../${consulta.id}/detalhesConsulta">
									<fmt:formatDate type="both" pattern="dd-MM-yyyy HH-mm" value="${consulta.data}" />
									</a></td>
									<td><a id="detalhes" data-toggle="modal" href="../${consulta.id}/detalhesConsulta">
											<button class="btn btn-info">
												Detalhes <span class="glyphicon glyphicon-eye-open"></span>
											</button>
									</a></td>
									<td><a id="editar" data-toggle="modal" href="../${consulta.id}/editarConsulta">
											<button class="btn btn-warning">
												Editar <span class="glyphicon glyphicon-edit"></span>
											</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>
