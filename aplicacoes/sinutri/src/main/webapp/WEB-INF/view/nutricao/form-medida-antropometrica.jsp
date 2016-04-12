<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="../modulos/header-estrutura.jsp" />
	<title>Cadastrar Medida Antropométrica</title>
</head>
<body>
	<jsp:include page="../modulos/header.jsp" />
	
	<section>
		<div class="container">
			<div class="row">
				<fieldset>
					<div class="col-sm-offset-2 col-sm-10">
						<legend>Cadastrar Medida Antropométrica</legend>
					</div>
					
					<c:if test="${ not empty info }">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="alert alert-info" role="alert">
								${ info }
							</div>
						</div>
					</c:if>
										
					<c:if test="${ not empty erro }">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="alert alert-danger" role="alert">
							  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							  <span class="sr-only">Error:</span>
							  ${ erro }
							</div>
						</div>
					</c:if>
					
					<form:form id="form-medida-antropometrica-cadastrar" modelAttribute="medidaAntropometrica" 
						role="form" servletRelativeAction="/nutricao/medida-antropometrica/cadastrar" method="POST" 
						cssClass="form-horizontal" acceptCharset="UTF-8">
						<div class="form-group">
							<div class="form-item">
								<label class="col-sm-2 control-label">Nome: </label>
								<div class="col-sm-10">
									<form:input path="nome" name="nome" cssClass="form-control" placeholder="Nome" 
										autofocus="autofocus" type="text"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-item">
								<label class="col-sm-2 control-label">Unidade: </label>
								<div class="col-sm-10">
									<form:select path="unidade" cssClass="form-control">
										<form:option value="">Selecione uma unidade</form:option>
										<form:option value="m">m</form:option>
										<form:option value="dm">dm</form:option>
										<form:option value="cm">cm</form:option>
										<form:option value="mm">mm</form:option>
									</form:select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Cadastrar</button>
							</div>
						</div>
					</form:form>
				</fieldset>
			</div>
		</div>
	</section>
	
	<jsp:include page="../modulos/footer.jsp" />
</body>
</html>