<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
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
				    <a class="navbar-brand" href="<c:url value="/nutricao/buscar"></c:url>"><img src="<c:url value="/resources/images/logo-sinutri.png" />" alt="SiNutri" class="logo-sinutri"></a>
				</div>
	
	      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
			<ul class="nav navbar-nav">  
           		<li id="menu-paciente"><a href="<c:url value="/nutricao/buscar"></c:url>"><span class="glyphicon glyphicon-search"></span> Paciente<span class="sr-only">(current)</span></a></li>
           		<li id="menu-graficos"><a href="<c:url value="/nutricao/informacoes-graficas"></c:url>"><span class="glyphicon glyphicon-stats"></span> Gráfico<span class="sr-only">(current)</span></a></li>
           		<li id="menu-cadastro"><a href="<c:url value="/paciente/cadastrar/paciente"></c:url>"><span class="glyphicon glyphicon-plus"></span> Cadastrar Paciente<span class="sr-only">(current)</span></a></li>
			</ul>

			<ul class="nav navbar-right navbar-nav">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/j_spring_security_logout" />"><i class="glyphicon glyphicon-off"></i> Sair</a></li>
		      			<li class="divider"></li>
						<li><a href="<c:url value="/nutricao/sobre" />"><i class="glyphicon glyphicon-info-sign"></i> Sobre</a></li>
					</ul>
				</li>  
			</ul>
      </div>
    </div>
  </nav>
</div>

</body>
</html>
