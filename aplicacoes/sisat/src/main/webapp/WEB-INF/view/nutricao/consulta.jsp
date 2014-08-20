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
<title>Cadastro de Consulta</title>
</head>
<body>

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
		
		<div class="form" align="center">
			<h2>Consulta Nutricional</h2>
		</div>
		
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">Exames Laboratoriais</a></li>
			<li><a href="#">Avaliação nutricional</a></li>
			<li><a href="#">Questionario de frequência alimentar</a></li>
		</ul>
		
		<br><br>
		<div class="col-xs-4" align="left">
			<form>
				<fieldset>
					<label>Glicemia:</label> <input type="text" >
					<span class="help-block"> </span> <label class="checkbox"> </label>
					
					<label>LDL: </label> <input type="text" > 
					<span class="help-block"> </span> <label class="checkbox"> </label>
					
				</fieldset>
			</form>

		</div>

		<div class="col-xs-4" align="center">
			<form>
				<fieldset>
				
					<label>TGL: </label> <input type="text" >
					<span class="help-block"> </span> <label class="checkbox"> </label>
					
					 <label>HDL: </label> <input type="text" >
					 <span class="help-block"> </span> <label class="checkbox"> </label>

					
					<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="btn btn-success">Finalizar Consulta</button>
					</div>
						
				</fieldset>
			</form>
		</div>
		
		<div class="col-xs-4" align="center">
			<form>
				<fieldset>
					
					<label>HB: </label> <input type="text" >
					<span class="help-block"> </span> <label class="checkbox"> </label>
					
					<label>HT: </label> <input type="text" > 
					<span class="help-block"></span> <label class="checkbox"> </label>
				
				</fieldset>
			</form>
		</div>


		<div class="error-validation">
			<form:errors path="nome"></form:errors>
		</div>
	</div>

	<jsp:include page="../modulos/footer.jsp" />

</body>


<script type="text/javascript">
	$(document).ready(function($) {

	}(jQuery));
</script>

</html>