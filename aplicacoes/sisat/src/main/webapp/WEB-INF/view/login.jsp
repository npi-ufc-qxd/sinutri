<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Página de Login</title>

	<link href="<c:url value="/resources/css/bootstrap-flatly.min.css" />" rel="stylesheet" />
	<script src="<c:url value="/webjars/jquery/2.1.0/jquery.js" />"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.2/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/webjars/jquery-maskedinput/1.3.1/jquery.maskedinput.min.js" />"></script> 
	<script src="<c:url value="/webjars/jquery-validation/1.12.0/jquery.validate.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>

<style>
body {
	background-color: #149C82;
}

.form-signin input[type="text"] {
	margin-bottom: 5px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.vertical-offset-100 {
	padding-top: 100px;
}

.img-responsive {
	display: block;
	max-width: 100%;
	height: auto;
	margin: auto;
}

.panel {
	margin-bottom: 20px;
	background-color: rgba(255, 255, 255, 0.75);
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.error {
	color: red;
	margin-bottom: 5px;
}

#login{
	margin-top: 15px;
}
</style>
</head>

<body onload='document.f.j_username.focus();'>
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row-fluid user-row">
							<img src="<c:url value="/resources/images/logo-sinutri.png" />" alt="SiNutri" class="logo-sinutri img-responsive">
						</div>
					</div>
					<div class="panel-body">
					
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
						
						<form name='f' action="<c:url value='j_spring_security_check' />"
							method='POST' accept-charset="UTF-8" role="form"
							class="form-signin" id="login-form">
							<fieldset>
								<input class="form-control" placeholder="Usuário" id="username" type="text" name='j_username' > 
								<input class="form-control" placeholder="Senha" id="password" type="password" name='j_password' >
								<input class="btn btn-lg btn-success btn-block" type="submit" id="login" value="Login »"> 
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>