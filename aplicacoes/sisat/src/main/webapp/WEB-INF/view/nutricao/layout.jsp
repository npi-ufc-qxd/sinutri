<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Layout</title>

	<link href="<c:url value="/webjars/bootstrap/3.3.2/css/bootstrap.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/css/bootstrap-flatly.min.css" />" rel="stylesheet" />
	<%-- <link href="<c:url value="/resources/css/bootstrap-journal.min.css" />" rel="stylesheet" /> --%>
	<%-- <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" /> --%>

	<style type="text/css">
	body{
		background: #ECEFEF;
	}
		.navbar-nav>li>a {
		  padding-top: 20px;
		  padding-bottom: 20px;
		}
		.logo-sinutri {
		  border: 0;
		  width: 215px;
		  margin: -18px -10px -2px -6px;
		  height: 60px;
		}

		.footer {
		  position: absolute;
		  bottom: 0;
		  width: 100%;
		  height: 40px;
		  background-color: #ECEFEF;
		  padding: 5px 0px 5px 0px;
		}
		
.text-muted {
  color: #22567B;
}		
		.thead {
  			background: #95A5A6;		
  		}
  		
		.table>thead>tr>th, .table>tbody>tr>th, .table>tfoot>tr>th, .table>thead>tr>td, .table>tbody>tr>td, .table>tfoot>tr>td {
			vertical-align: middle;
		}
  		
	</style>
</head>

<body>
	<div class="bs-component">
		<nav class="navbar navbar-static navbar-inverse">
			<div class="container">
				<div class="navbar-header">
				    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
				      <span class="sr-only">SiNutri</span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				    </button>
				    <a class="navbar-brand" href="#"><img src="<c:url value="/resources/images/logo-sinutri.png" />" alt="SiNutri" class="logo-sinutri"></a>
				</div>
	
	      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
			<ul class="nav navbar-nav">  
           		<li class="active"><a href="#">Paciente<span class="sr-only">(current)</span></a></li>
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
</div>

<div class="container">
	<div class="buscar-paciente">
		<c:if test="${not empty erro }"><div class="alert alert-danger" role="alert">${erro}</div></c:if>

		<c:if test="${not empty info }"><div class="alert alert-info" role="alert">${info}</div></c:if>

		<c:if test="${not empty success }"><div class="alert alert-success" role="alert">${success}</div></c:if>

		<h3>Buscar Paciente</h3>
		<form:form id="formBuscarPaciente" role="form" servletReltiveAction="/nutricao/buscar" method="POST" class="bs-component">	
			<div class="form-group">
			  <div class="input-group">
				<input id="busca" name="busca" type="text" class="form-control" placeholder="Nome ou CPF" size="40" required="required" value="${busca }"/>
			    <span class="input-group-btn">
			    	<button class="btn btn-default" name="submit" type="submit">Buscar <span class="glyphicon glyphicon-search"></span></button>
			    </span>
			  </div>
			</div>
		</form:form>
		
    <table class="table table-striped">
        <thead class="thead">
            <tr>
                <th></th>
                <th>Paciente</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Rayson Santos</td>
                <td>rayson@mail.com</td>
                <td align="right">
	              <a href="#" class="btn btn-info  btn-sm">Informações</a>
	              <a href="#" class="btn btn-success  btn-sm">Consulta</a>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Rayson Santos</td>
                <td>rayson@mail.com</td>
                <td align="right">
	              <a href="#" class="btn btn-info  btn-sm">Informações</a>
	              <a href="#" class="btn btn-success  btn-sm">Consulta</a>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Rayson Santos</td>
                <td>rayson@mail.com</td>
                <td align="right">
	              <a href="#" class="btn btn-info  btn-sm">Informações</a>
	              <a href="#" class="btn btn-success  btn-sm">Consulta</a>
                </td>
            </tr>
        </tbody>
    </table>

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
							<td><a href="<c:url value="/nutricao/detalhes/${pessoa.id}"></c:url>">${pessoa.nome}</a></td>
							<td align="right">
								<a id="detalhes" data-toggle="modal" href="detalhes/${pessoa.id}">
									<button class="btn btn-default">Detalhes <span class="glyphicon glyphicon-eye-open"></span></button>
								</a>

								<a id="consulta" data-toggle="modal" href="consulta/${pessoa.id}">
									<button class="btn btn-default">Consulta <span class="glyphicon glyphicon-plus"></span></button>
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

<footer class="footer">
	<div class="container" align="center">
		<p class="text-muted">Universidade Federal do Ceará - Todos os direitos reservados &copy;</p> 
	</div>
</footer>

<script src="<c:url value="/webjars/jquery/2.1.0/jquery.min.js" />"></script>
<script src="<c:url value="/webjars/bootstrap/3.3.2/js/bootstrap.min.js" />"></script>
</body>
</html>