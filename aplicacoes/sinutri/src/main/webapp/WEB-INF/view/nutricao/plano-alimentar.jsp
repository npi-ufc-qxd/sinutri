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
		<title>Informações do Plano Alimentar</title>
	</head>
<body>
	<jsp:include page="../modulos/header.jsp" />
	<div class="container">
			<div class="row">
			<div class="col-sm-8">
				<h3>
					Plano Alimentar <strong>${consultaRecordatorio.paciente.pessoa.nome}</strong>
				</h3>
			</div>

			<div class="col-sm-4" align="right" style="margin-top: 15px;">
					<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
					
				<c:if test="${not empty consultaPlanoAlimentar.frequencias}">
					<a 
						data-href="<c:url value="/paciente/consulta/${idConsulta}/plano-alimentar/deletar"></c:url>"
						data-toggle="modal" 
						data-target="#confirm-delete-plano-alimentar" 
						class="btn btn-danger btn-sm"> 
						<span class="glyphicon glyphicon-remove"></span>Excluir
					</a>
				</c:if>
				
				<c:if test="${action eq 'editar' }">
					<a href="<c:url value="/paciente/consulta/${consultaRecordatorio.id}/form-plano-alimentar"></c:url>"
					class="btn btn-warning btn-sm"> <span
					class="glyphicon glyphicon-edit"></span>Editar Plano Alimentar</a> 
				</c:if>
				
				<c:if test="${action eq 'cadastrar' }">
					<a href="<c:url value="/paciente/consulta/${consultaRecordatorio.id}/form-plano-alimentar"></c:url>"
					class="btn btn-info btn-sm">Cadastrar Plano Alimentar</a> 
				</c:if>	
				
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<h3 class="section">Recordatório</h3>
				<c:if test="${empty consultaRecordatorio.frequencias}">
					<div class="alert alert-dismissible alert-default">Não há informações sobre o recordatório alimentar.</div>
				</c:if>				
				<c:forEach var="freq" items="${consultaRecordatorio.frequencias}">
					<fmt:formatDate var="horaFormatada" type="time" dateStyle="short" timeStyle="short" value="${freq.horario}" />
		
					<div class="col-sm-12" align="left">
						<h4><strong class="label label-info">${freq.refeicao.nome }</strong>
						<span class="label label-primary">${horaFormatada}</span></h4>
					</div>
		 	
					<div class="col-sm-12" align="left">
						<table class="table table-striped">
							<thead class="thead">
								<tr>
									<th>Alimento/Preparo</th>
									<th>Porção</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="alimento" items="${freq.alimentos }">
								<tr>
									<td>${alimento.alimento }</td>
									<td>${alimento.porcao }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</c:forEach>			
			</div> 

			<div class="col-sm-6">				
				<h3 class="section">Plano Alimentar</h3>
				<c:if test="${empty consultaPlanoAlimentar.frequencias}">
					<div class="alert alert-dismissible alert-default">Não há informações sobre o plano alimentar.</div>
				</c:if>		
						
				<c:forEach var="freq" items="${consultaPlanoAlimentar.frequencias}">
					<fmt:formatDate var="horaFormatada" type="time" dateStyle="short" timeStyle="short" value="${freq.horario}" />
		
					<div class="col-sm-12" align="left">
						<h4><strong class="label label-info">${freq.refeicao.nome }</strong>
						<span class="label label-primary">${horaFormatada}</span></h4>
					</div>
		 	
					<div class="col-sm-12" align="left">
						<table class="table table-striped">
							<thead class="thead">
								<tr>
									<th>Alimento/Preparo</th>
									<th>Porção</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="alimento" items="${freq.alimentos }">
								<tr>
									<td>${alimento.alimento }</td>
									<td>${alimento.porcao }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</c:forEach>			
			</div> 		
			</div>
			
			</div>					
			<!-- MODAL EXCLUSAO PLANO ALIMENTAR -->
			<div id="confirm-delete-plano-alimentar" class="modal" role="dialog" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Confirmar Deleção</h4>
							</div>
							<div class="modal-body">
								<p>Você está a ponto de excluir o plano alimentar, esse procedimento é irreversível.</p>
								<p>Você deseja continuar?</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<a class="btn btn-danger btn-ok">Deletar</a>
							</div>
						</div>
					</div>
				</div>
				
	<jsp:include page="../modulos/footer.jsp" />
	<script src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>
</body>

</html>
