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

		<div class="row">
			<div class="col-sm-9">
				<h3>${titulo}
					<strong>${consultaNutricional.paciente.pessoa.nome}</strong>
				</h3>
			</div>
			<div class="col-sm-3" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span>Voltar</a>
			</div>
		</div>

		<form:form id="form-alimento-subst" servletRelativeAction="${url }"
			method="POST" commandName="alimentoSubstituto" acceptCharset="UTF-8"
			cssClass="form-inline">

			<div class="row form-group">
				<div class="form-item col-sm-12">
					<label for="nomeAlimento" class="control-label">Nome do
						Alimento: </label>
					<form:input id="nomeAlimento" type="text" name="nomeAlimento"
						placeholder="Nome do alimento substituto..." path="nomeAlimento"
						cssClass="form-control" />
					<div class="error-validation">
						<form:errors path="nomeAlimento"></form:errors>
					</div>
				</div>
			</div>
			<div class="row form-group">
				<div class="form-item col-sm-12">
					<label for="grupo" class="control-label">Grupo do
						Alimento: </label>
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
			<button type="submit" class="btn btn-success">${botao }</button>
		</form:form>
	</div>
	<jsp:include page="../modulos/footer.jsp" />
</body>
</html>