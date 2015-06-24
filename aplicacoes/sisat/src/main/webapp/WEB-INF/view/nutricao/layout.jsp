<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
<link href="<c:url value="/webjars/bootstrap/3.3.2/css/bootstrap.min.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" />

		<title>Layout</title>
		<style type="text/css">

			@media (min-width: 768px){
			}

			.navbar-nav>li>a {
			  padding-top: 20px;
			  padding-bottom: 20px;
			}


			.logo-sinutri {
			  border: 0;
			  width: 222px;
			  margin: -14px -10px -2px -6px;
			  height: 60px;
			}

		</style>
	</head>
<body>
<nav class="navbar navbar-static">
    <div class="container">
      <a class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
        <span class="glyphicon glyphicon-chevron-down"></span>
      </a>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">SiNutri</span>
				<span class="icon-bar"></span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/nutricao/buscar" />">
			<img src="<c:url value="/resources/images/logo-sinutri-2.png" />" alt="SiNutri" class="logo-sinutri">
			</a>
		</div>
		
      <div class="nav-collapse collase">
        <ul class="nav navbar-nav">  
          <li><a href="#">Paciente</a></li>
          <li><a href="#">Documentos</a></li>
        </ul>
        <ul class="nav navbar-right navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="#">Perfil</a></li>
              <li><a href="#">Sair</a></li>
              <li class="divider"></li>
              <li><a href="#">Sobre</a></li>
             </ul>
          </li>  
        </ul>
      </div>		
    </div>
</nav>



	<div class="container">
	
	<form class="form-inline" role="form">
        <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>

	
<br>	
<br>	
<br>	
<br>	
<br>	
<br>	
<br>	
	
		<div class="buscar-paciente">

			<c:if test="${not empty erro }"><div class="alert alert-danger" role="alert">${erro}</div></c:if>

			<c:if test="${not empty info }"><div class="alert alert-info" role="alert">${info}</div></c:if>

			<c:if test="${not empty success }"><div class="alert alert-success" role="alert">${success}</div></c:if>

			<h3>Buscar Paciente</h3>

			<form:form id="buscarPacienteForm" role="form" servletReltiveAction="/nutricao/buscar" method="POST" class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-10">
						<input id="busca" name="busca" class="form-control" placeholder="Nome ou CPF" size="40" required="required" value="${busca }"/>
					</div>
					<div class="col-sm-2">
						<button class="btn btn-primary" name="submit" type="submit" class="btn btn-primary" value="Buscar"> 
							Buscar <span class="glyphicon glyphicon-search"></span>
						</button>
				    </div>
				</div>
			</form:form>

			<c:if test="${not empty pessoas}">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th align="right"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pessoa" items="${pessoas}">
							<tr class="linha">
								<td>
									<a href="<c:url value="/nutricao/detalhes/${pessoa.id}"></c:url>">${pessoa.nome}</a>
								</td>
								<td align="right">
									<a id="detalhes" data-toggle="modal" href="detalhes/${pessoa.id}">
										<button class="btn btn-default">
											Detalhes <span class="glyphicon glyphicon-eye-open"></span>
										</button>
									</a>

									<a id="consulta" data-toggle="modal" href="consulta/${pessoa.id}">
										<button class="btn btn-default">
											Consulta <span class="glyphicon glyphicon-plus"></span>
										</button>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			
			<c:if test="${not empty busca and empty pessoas}">
				<div class="alert alert-warning" role="alert">Nenhum resultado encontrado</div>
			</c:if>
		</div>
	</div>

<div id="footer">
	<div id="text-ufc">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<p class="text-muted">Universidade Federal do Ceará - Todos os direitos reservados &copy;</p>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</div>

<script src="<c:url value="/webjars/jquery/2.1.0/jquery.min.js" />"></script>
<script src="<c:url value="/webjars/bootstrap/3.3.2/js/bootstrap.min.js" />"></script>

</body>
</html>