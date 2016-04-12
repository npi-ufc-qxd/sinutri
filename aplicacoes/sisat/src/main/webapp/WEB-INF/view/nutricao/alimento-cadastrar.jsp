<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${action eq 'cadastrar' }">
	<c:url var="url" value="/nutricao/alimento-substituto/cadastrar" />
	<c:set var="titulo" value="Novo Alimento" />
	<c:set var="botao" value="Cadastrar Alimento" />
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url"
		value="/nutricao/alimento-substituto/editar/${alimentoSubstituto.id }" />
	<c:set var="titulo" value="Editar Alimento" />
	<c:set var="botao" value="Atualizar Alimento" />
</c:if>

<html>
<head>
<jsp:include page="../modulos/header-estrutura.jsp" />
<title>${titulo }</title>
</head>
<body>
	<jsp:include page="../modulos/header.jsp" />

	<div class="container">

		<c:if test="${not empty erro}">
			<div class="alert alert-danger alert-dismissible" role="alert"
				id="alert-erro">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${erro}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty info}">
			<div class="alert alert-success alert-dismissible" role="alert"
				id="alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${info}"></c:out>
			</div>
		</c:if>

		<div class="row">
			<div class="col-sm-9">
				<h3>${titulo}</h3>
			</div>
			<div class="col-sm-3" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span>Voltar</a>
			</div>
		</div>
		
		<div class="row">
		<div class="col-sm-12">
		<form:form id="form-alimento-subst" servletRelativeAction="${url }"
			method="POST" commandName="alimentoSubstituto" acceptCharset="UTF-8"
			cssClass="form-inline">

			<div class="form-group">
				<div class="form-item">
					<label for="nomeAlimento" class="control-label">Nome do Alimento: </label>
					<form:input id="nomeAlimento" type="text" name="nomeAlimento"
						placeholder="Nome do alimento substituto..." path="nomeAlimento"
						cssClass="form-control" size="44"/>
					<div class="error-validation">
						<form:errors path="nomeAlimento" />
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="form-item">
					<label for="grupo" class="control-label">Grupo do Alimento: </label>
					<form:select id="grupo" name="grupo" path="grupo"
						cssClass="form-control">
						<form:option value="" label="Selecione o grupo do alimento" />
						<form:options items="${grupos }" itemLabel="tipo" />
					</form:select>
					<div class="error-validation label-erro-select">
						<form:errors path="grupo"></form:errors>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-success ">${botao }</button>
		</form:form>
		</div>
		</div>
		
		<br> <br>
		
		<h3 class="section"> Alimentos Substitutos </h3>

		<c:if test="${empty alimentosSubstitutos}">
			<div class="alert alert-dismissible alert-info">Não há alimentos substitutos cadastrados.</div>
		</c:if>

		<c:if test="${not empty alimentosSubstitutos}">
			    <table class="table table-striped">
			        <thead class="thead">
			            <tr>
			                <th>Alimento</th>
			                <th>Grupo</th>
			                <th>Editar</th>
			                <th>Excluir</th>
			            </tr>
			        </thead>
			        <tbody>
						<c:forEach items="${alimentosSubstitutos}" var="alimento">
				            <tr>
				            	<td>${alimento.nomeAlimento}</td>
				            	<td>${alimento.grupo.tipo}</td>
				            	<td> <a href="<c:url value="/nutricao/alimento-substituto/editar/${alimento.id}"></c:url>"
				            			class="btn btn-info btn-sm">
				            			<span class="glyphicon glyphicon-pencil"></span>
				            	</a></td>
				            	<td> <a href="<c:url value="/nutricao/alimento-substituto/excluir/${alimento.id}"></c:url>"
				            			class="btn btn-danger btn-sm">
				            			<span class="glyphicon glyphicon-trash"></span>
				            	</a></td>
				            </tr>
						</c:forEach>
			        </tbody>
			    </table>
			</c:if>
	</div>
	<jsp:include page="../modulos/footer.jsp" />
</body>
</html>