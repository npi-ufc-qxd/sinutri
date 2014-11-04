<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div id="header-page">
	<div class="row">
		<div class="col-md-4">
			<a href="http://www.quixada.ufc.br/" target="_blank"> <img
				width="370" src="<c:url value="/resources/images/brasao-qxd.png" />"
				alt="UFC Quixadá"
				title="Clique aqui para acessar o site da UFC Quixadá">
			</a>
		</div>
		<div class="col-md-4">
			<a href="/sisat/nutricao/buscar">
				<h1 style="color: #FFFFFF; text-align: center">
					<strong style="font-size: 125%">Sis</strong>tema de <strong
						style="font-size: 120%">At</strong>endimento
				</h1>
				<h4 style="color: #FFFFFF; text-align: center" align="rigth">Módulo
					Nutricional</h4>
			</a>
		</div>
	</div>
</div>
<div>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand"
						href="<c:url value="/nutricao/buscar" />">Paciente</a></li>
					
					<li><a class="navbar-brand" href="<c:url value="#" />">Agendamentos
					</a></li>


				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a style="font-weight: bold; text-transform: capitalize">Bem
							vindo, <sec:authentication property="principal.username" />!
					</a></li>
					<li><a style="font-weight: bold"
						href="<c:url value="/j_spring_security_logout" />">Sair <span
							class="glyphicon glyphicon-off"></span></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Mensagens -->

	<c:if test="${not empty success }">
		<div class="alert alert-success" role="alert">${success}</div>
	</c:if>
	<c:if test="${not empty info }">
		<div class="alert alert-info" role="alert">${info}</div>
	</c:if>
	<c:if test="${not empty warning }">
		<div class="alert alert-warning" role="alert">${warning}</div>
	</c:if>
	<c:if test="${not empty danger }">
		<div class="alert alert-danger" role="alert">${danger}</div>
	</c:if>
</div>
