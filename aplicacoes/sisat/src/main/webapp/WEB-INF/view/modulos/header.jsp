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

	<style type="text/css">
	body{
		background: #F9F9F9;
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

</body>
</html>
