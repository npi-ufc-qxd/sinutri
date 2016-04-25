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
		<title>Cadastrar Paciente</title>
	</head>
<body>

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
		
			<form:form servletRelativeAction="/paciente/cadastrar/paciente" method="POST"
					id="form-cadastro-paciente-externo" modelAttribute="pacienteExterno"
					acceptCharset="UTF-8">
			
				<div class="col-sm-12">
					<h3>Cadastrar Paciente</h3>
				</div>
				
				<div class="form-group col-sm-12">
					<div class="form-item">
						<label for="nome" class="control-label"> <i
							style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
							Nome:
						</label>
						<form:input id="nome" path="nome" class="form-control" 
							placeholder="Nome do paciente" />
						<div class="error-validation">
							<form:errors path="nome"></form:errors>
						</div>
					</div>
				</div>
				
				<div class="form-group col-sm-12">
					<div class="form-item">
						<label for="dataNascimento" class="control-label"> <i
							style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
							Data Nascimento:
						</label>
						<form:input id="dataNascimento" path="dataNascimento" class="form-control datepicker"
							placeholder="dd/mm/aaaa" type="date"/>
						<div class="error-validation">
							<form:errors path="dataNascimento"></form:errors>
						</div>
					</div>
				</div>
				
				<div class="form-group col-sm-12">
					<div class="form-item">
						<label for="vinculo" class="control-label"> <i
							style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
							Vinculo:
						</label>
						<form:input id="vinculo" path="vinculo" class="form-control" 
							placeholder="Qual o vinculo com a universidade?" />
						<div class="error-validation">
							<form:errors path="vinculo"></form:errors>
						</div>
					</div>
				</div>
				
				<div class="form-group col-sm-12">
					<div class="form-item">
						<label for="telefone" class="control-label"> <i
							style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
							Telefone:
						</label>
						<form:input id="telefone" path="telefone" class="form-control" 
							placeholder="(00) 00000-0000" />
						<div class="error-validation">
							<form:errors path="telefone"></form:errors>
						</div>
					</div>
				</div>
				
				<div class="form-group col-sm-12">
				 	<label for="email" class="control-label"> Email: </label>
				  <div class="form-item">
					<input id="email" name="email" type="text" class="form-control" placeholder="Email do paciente" size="40"/>
				  </div>
				</div>
				
				<div class="col-xs-offset-0 col-xs-10" align="center">
					<button type="submit" class="btn btn-success">Cadastrar</button>
				</div>
			
			</form:form>
	
	</div>
			
	
	<jsp:include page="../modulos/footer.jsp" />
	
</body>
</html>