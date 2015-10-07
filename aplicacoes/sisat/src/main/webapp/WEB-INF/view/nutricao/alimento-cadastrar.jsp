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
	<c:set var="titulo" value="Novo Alimento"/>
	<c:set var="botao" value="Cadastrar Alimento"/>
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url" value="/nutricao/alimento-substituto/editar/${alimentoSubstituto.id }" />
	<c:set var="titulo" value="Editar Alimento"/>
	<c:set var="botao" value="Atualizar Alimento"/>
</c:if>

<html>
<head>
	<jsp:include page="../modulos/header-estrutura.jsp" />
</head>
<body>
	<jsp:include page="../modulos/footer.jsp" />
</body>
</html>