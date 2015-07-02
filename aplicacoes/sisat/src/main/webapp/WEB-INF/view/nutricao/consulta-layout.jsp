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


<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"> -->




	<link href="<c:url value="/webjars/bootstrap/3.3.2/css/bootstrap.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/css/bootstrap-flatly.min.css" />" rel="stylesheet" />
	<%-- <link href="<c:url value="/resources/css/bootstrap-journal.min.css" />" rel="stylesheet" /> --%>
	<%-- <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" /> --%>

<style type="text/css">
.scroll-area {
/* 	height: 200px; */
	position: static;
	overflow: hidden;
}


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
	
		
.well {
  min-height: 20px;
  padding: 19px;
  margin-bottom: 20px;
  background-color: #ecf0f1;
  border: 1px solid #DADADA;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
}



ul.steps {
  list-style: none outside none;
  padding: 0;
  margin: 0;
  width: 999999px;
}

ul.steps li {
  float: left;
  margin: 0;
  padding: 0 20px 0 30px;
  height: 46px;
  line-height: 46px;
  position: relative;
  background: #2c3e50;
  color: #999999;
  font-size: 16px;
}

.chevron {
  border: 24px solid transparent;
  border-left: 14px solid #d4d4d4;
  border-right: 0;
  display: block;
  position: absolute;
  right: -14px;
  top: 0;
  z-index: 1;
}
.chevron:before {
  border: 24px solid transparent;
  border-left: 14px solid #ededed;
  border-right: 0;
  content: "";
  display: block;
  position: absolute;
  right: 1px;
  top: -24px;
}

.badge {
  padding: 3px 6px;
  }

</style>



<style type="text/css">
/* Custom Styles */

ul.nav-tabs {
	width: 215px;
	margin-top: 20px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}
ul.nav-tabs li {
	margin: 0;
	border-top: 1px solid #ddd;
}
ul.nav-tabs li:first-child {
	border-top: none;
}
ul.nav-tabs li a {
	margin: 0;
	padding: 8px 16px;
	border-radius: 0;
}
ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}
ul.nav-tabs li:first-child a {
	border-radius: 4px 4px 0 0;
}
ul.nav-tabs li:last-child a {
	border-radius: 0 0 4px 4px;
}
/* ul.nav-tabs.affix { */
/* 	top: 70px; /* Set the top position of pinned element */ */
/* } */

.section {
	padding-top: 70px;
}



</style>



</head>

<body data-spy="scroll" data-target="#myScrollspy">
	<div class="bs-component">
<!-- 			<nav class="navbar navbar-static navbar-fixed navbar-inverse"> -->
			
<!-- 		<nav class="navbar navbar-static navbar-inverse"> -->

		<nav class="navbar navbar-inverse navbar-fixed-top">

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
           		<li class=""><a href="#">Paciente<span class="sr-only">(current)</span></a></li>
  				<li><a href="#">Documentos</a></li>
			</ul>

			<ul class="nav navbar-right navbar-nav">
				<li class="dropdown">
				<a href="#" class="," data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
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

<c:if test="${action eq 'cadastrar' }">
	<c:set var="url" value="/nutricao/consultar"></c:set>
	<c:set var="titulo" value="Nova Consulta "></c:set>
	<c:set var="botao" value="Finalizar Consulta "></c:set>
</c:if>

<c:if test="${action eq 'editar' }">
	<c:set var="url" value="/nutricao/editarConsulta"></c:set>
	<c:set var="titulo" value="Editar Consulta  "></c:set>
	<c:set var="botao" value="Atualizar Consulta"></c:set>
</c:if>

<div class="container">
    <div class="row">
    	<div align="center">
	    	<h1>Consulta Nutricional</h1>
    	</div>

        <div class="col-sm-3" id="myScrollspy">

            <ul class="nav nav-tabs nav-stacked affix-top" data-spy="affix" data-offset-top="125">
				<li class="active">
					<a href="#avaliacao">
						<span class="badge">1</span> Anamnese
					</a>
				</li>
				<li>
					<a href="#recordatorio">
						<span class="badge">2</span> Recordatório Alimentar
					</a>
				</li>
				<li>
					<a href="#exame">
						<span class="badge">3</span> Exames Laboratoriais
					</a>
				</li>
				<li>
					<a href="#orientacoes">
						<span class="badge">4</span> Orientações Individuais
					</a>
				</li>
				<li>
					<a href="#documentos">
						<span class="badge">5</span> Documentos
					</a>
				</li>
            </ul>

        </div>

	    <div class="col-sm-9" style="padding-top: 60px;">
		<form:form servletRelativeAction="${url}" method="POST" id ="consultaNutricional" modelAttribute="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal scroll-area" enctype="multipart/form-data">
			<form:hidden path="id" />
			<form:hidden path="paciente.id" />
			<form:hidden path="data" />

	    	<h2 id="avaliacao">Anamnese</h2>
	    	
			<div class="row form-group">
				<div class="form-item col-sm-12">
					<label for="objetivoConsulta" class="control-label"> Objetivo da Consulta:</label>
					<form:textarea id="objetivoConsulta" path="objetivoConsulta" class="form-control" rows="5" placeholder="Descreva aqui o objetivo da consulta..."/>
					<div class="error-validation"><form:errors path="objetivoConsulta"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="altura" class="control-label">Altura:</label>
					<form:input id="altura" name="altura" type="number" path="paciente.altura" cssClass="form-control" placeholder="0.00" />
					<div class="error-validation"><form:errors path="paciente.altura"></form:errors></div>
		        </div>
			</div>

			
	        <div class="row form-group">
		        <div class="form-item col-sm-6">
						<label for="peso" class="control-label">Peso:</label>
						<form:input id="peso" name="peso" type="number" path="peso" cssClass="form-control" placeholder="00.00"/>
						<div class="error-validation"><form:errors path="peso"></form:errors></div>
				</div>
		        <div class="form-item col-sm-6">
					<label for="peso" class="control-label">Peso desejado:</label>
					<form:input id="peso" name="peso" type="number" path="peso" cssClass="form-control" placeholder="00.00"/>
					<div class="error-validation"><form:errors path="peso"></form:errors></div>
		        </div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-6">
					<label for="cc" class="control-label">CC:</label>
					<form:input id="cc" name="cc" type="number" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
					<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
		        </div>
		        <div class="form-item col-sm-6">
					<label for="cc" class="control-label">CC desejada:</label>
					<form:input id="cc" name="cc" type="number" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
					<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
		        </div>
	        </div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="agua" class="control-label">Consumo de água:</label>
					<form:input id="agua" name="agua" type="number" path="agua" cssClass="form-control" placeholder="Consumo de água"/>
					<div class="error-validation"><form:errors path="agua"></form:errors></div>
		        </div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-6">
					<label for="checkAtividadeFisica" class="control-label"><form:checkbox id="checkAtividadeFisica"  path="atividadeFisica" class="check"/> Atividade Física:</label>
					<form:input id="inputTextAtividadeFisica" path="atividadeFisicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.atividadeFisica}"/>
					<div class="error-validation"><form:errors path="atividadeFisicaComentario"></form:errors></div>
		        </div>
		        <div class="form-item col-sm-6">
		        	<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select id="atividadeFisicaFrequenciaSemanal" path="atividadeFisicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.atividadeFisica}">
						<form:option value="">Quantas vezes por semana?</form:option>
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
						<form:option value="5">5</form:option>
						<form:option value="6">6</form:option>
						<form:option value="7">7</form:option>
					</form:select>
		        </div>
			</div>
	        <div class="row form-group">
		        <div class="form-item col-sm-6">
					<label for="checkCarneVermelha" class=" control-label"><form:checkbox id="checkCarneVermelha"  path="carneVermelha" class="check"/> Carne Vermelha:</label>
					<form:input id="inputTextCarneVermelha" path="carneVermelhaComentario" cssClass="form-control" placeholder="Que tipo de carne?" disabled="${not consultaNutricional.carneVermelha}"/>
					<div class="error-validation"><form:errors path="carneVermelhaComentario"></form:errors></div>
		        </div>
		        <div class="form-item col-sm-6">
		        	<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="carneVermelhaFrequenciaSemanal" cssClass="form-control select" disabled="${not consultaNutricional.carneVermelha}">
						<form:option value="">Quantas vezes por semana?</form:option>
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
						<form:option value="5">5</form:option>
						<form:option value="6">6</form:option>
						<form:option value="7">7</form:option>
					</form:select>
		        </div>
			</div>
			
	        <div class="row form-group">
		        <div class="form-item col-sm-6">
					<label for="checkBebidaAlcoolica" class=" control-label"><form:checkbox id="checkBebidaAlcoolica"  path="bebidaAlcoolica" class="check"/> Bebida alcoólica:</label>
					<form:input id="inputTextBebidaAlcoolica" path="bebidaAlcoolicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.bebidaAlcoolica}"/>
					<div class="error-validation"><form:errors path="bebidaAlcoolicaComentario"></form:errors></div>
		        </div>

		        <div class="form-item col-sm-6">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="bebidaAlcoolicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.bebidaAlcoolica}">
						<form:option value="">Quantas vezes por semana?</form:option>
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
						<form:option value="5">5</form:option>
						<form:option value="6">6</form:option>
						<form:option value="7">7</form:option>
					</form:select>
		        </div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="checkMedicamento" class=" control-label"><form:checkbox id="checkMedicamento"  path="medicamento" class="check"/> Medicamentos:</label>
					<form:input id="inputTextMedicamento" path="medicamentoComentario" cssClass="form-control" placeholder="Quais medicamentos você usa?" disabled="${not consultaNutricional.medicamento}"/>
					<div class="error-validation"><form:errors path="medicamentoComentario"></form:errors></div>
				</div>
			</div>

			<div class="row form-group">
		        <div class="form-item col-sm-12">
				<label for="checkMastigacao" class=" control-label"><form:checkbox id="checkMastigacao"  path="mastigacao" class="check"/> Mastigação:</label>
				<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
				<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
			</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="disfagia" class=" control-label"><form:checkbox id="disfagia" path="disfagia"/> Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="disfagia" class=" control-label"><form:checkbox id="disfagia" path="disfagia"/> Odinofagia</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>
			
	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="pirose" class=" control-label"><form:checkbox id="pirose" path="pirose"/> Pirose</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="nausea" class=" control-label"><form:checkbox id="nausea" path="nausea"/> Náusea</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="vomito" class=" control-label"><form:checkbox id="vomito" path="vomito"/> Vômitos</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="diarreia" class=" control-label"><form:checkbox id="diarreia" path="diarreia"/> Diarreia</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="constipacao" class=" control-label"><form:checkbox id="constipacao" path="constipacao"/> Constipação</label>
					<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
					<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
				</div>
			</div>
		
	        <div class="row form-group">
		        <div class="form-item col-sm-12">
				<label for="checkAlergia" class=" control-label"><form:checkbox id="checkAlergia"  path="alergia" class="check"/> Alergia Alimentar:</label>
				<form:textarea id="inputTextAlergia" path="alergiaComentario" class="form-control" rows="5" placeholder="Qual sua alergia Alimentar?" disabled="${not consultaNutricional.alergia}"/>
				<div class="error-validation"><form:errors path="alergiaComentario"></form:errors></div>
			</div>
			</div>
		
	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="checkPatologia" class=" control-label"><form:checkbox id="checkPatologia"  path="outrasPatologias" class="check"/> Patologias:</label>
					<form:textarea id="inputTextPatologia" path="outrasPatologiasComentario" class="form-control" rows="5" placeholder="Descreva aqui as patologias" disabled="${not consultaNutricional.outrasPatologias}"/>
					<div class="error-validation"><form:errors path="outrasPatologiasComentario"></form:errors></div>
				</div>
			</div>


	    	<h2 id="recordatorio">Recordatório</h2>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<fieldset>
						<h3>Adicione as refeições</h3>
						<table id="questionarioFrequenciaAlimentar"></table>
					</fieldset>
		        </div>
	        </div>
	        
	        
	        <h2 id="exame">Exames Laboratoriais</h2>

	        <div class="row form-group">
		        <div class="form-item col-sm-3">
					<label for="glicemia" class="control-label">Glicemia:</label>
					<form:input id="glicemia" type="number" path="glicemia" cssClass="form-control" placeholder="glicemia" />			
					<div class="error-validation"><form:errors path="glicemia"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoGlicemia" cssClass="form-control" disabled="${not consultaNutricional.classificacaoGlicemia}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>
				
		        <div class="form-item col-sm-3">
					<label for="ct" class="control-label">CT:</label>
					<form:input id="ct" type="number" path="ct" cssClass="form-control" placeholder="ct" />
					<div class="error-validation"><form:errors path="ct"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoCt" cssClass="form-control" disabled="${not consultaNutricional.classificacaoCt}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>
	 		</div> 

	        <div class="row form-group">

		        <div class="form-item col-sm-3">
					<label for="ldl" class="control-label">LDL-C:</label>
					<form:input id="ldl" type="number" path="ldl" cssClass="form-control" placeholder="LDL-C" />
					<div class="error-validation"><form:errors path="ldl"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoLdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoLdl}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>

		        <div class="form-item col-sm-3">
					<label for="hdl" class="control-label">HDL-C:</label>
					<form:input id="hdl" type="number" path="hdl" cssClass="form-control" placeholder="HDL-C" />
					<div class="error-validation"><form:errors path="hdl"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoHdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHdl}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>
	 		</div> 

	        <div class="row form-group">
		        <div class="form-item col-sm-3">
					<label for="tg" class="control-label">TG:</label>
					<form:input id="tg" type="number" path="tg" cssClass="form-control" placeholder="TG" />
					<div class="error-validation"><form:errors path="tg"></form:errors></div>
		        
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoTg" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTg}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>

		        <div class="form-item col-sm-3">
					<label for="hb" class="control-label">HB:</label>
					<form:input id="hb" type="number" path="hb" cssClass="form-control" placeholder="HB" />
					<div class="error-validation"><form:errors path="hb"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoHb" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHb}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>
	 		</div> 

	        <div class="row form-group">
		        <div class="form-item col-sm-3">
					<label for="tgo" class="control-label">TGO (AST):</label>
					<form:input id="tgo" type="number" path="tgo" cssClass="form-control" placeholder="tgo" />
					<div class="error-validation"><form:errors path="tgo"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoTgo" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgo}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>

		        <div class="form-item col-sm-3">
					<label for="tgp" class="control-label">TGP (ALT):</label>
					<form:input id="tgp" type="number" path="tgp" cssClass="form-control" placeholder="TGP (ALT)" />
					<div class="error-validation"><form:errors path="tgp"></form:errors></div>
				</div>

		        <div class="form-item col-sm-3">
		        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
					<form:select path="classificacaoTgp" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgp}">
						<form:option value="">Classificação</form:option>
						<form:options items="${classificacao}" itemLabel="tipo"/>
					</form:select>
				</div>
	 		</div> 

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="condutaNutricional" class="control-label"> Informações complementares:</label>
					<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
					<div class="error-validation"><form:errors path="condutaNutricional"></form:errors></div>
				</div>
			</div>

	    	<h2 id="orientacoes">Orientações</h2>

	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="condutaNutricional" class="control-label"> Conduta Nutricional:</label>
					<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
					<div class="error-validation"><form:errors path="condutaNutricional"></form:errors></div>
				</div>
			</div>
				
	        <div class="row form-group">
		        <div class="form-item col-sm-12">
					<label for="orientacoesIndividuais" class="control-label"> Orientações Individuais</label>
					<form:textarea id="orientacoesIndividuais" path="orientacoesIndividuais" class="form-control" rows="5" placeholder="Orientações Individuais"/>
					<div class="error-validation"><form:errors path="orientacoesIndividuais"></form:errors></div>
				</div>
			</div>


	    	<h2 id="documentos">Documentos</h2>

				<div id="documentos" class="tab-pane fade in ">
					<h3>Documentos</h3>
					
					<div class="form-group">
						<label for="arquivo" class="col-sm-2 control-label">Arquivos:</label>
						<div class="col-sm-5 files">
							<input type="file" id="files" name="files" class="file"	multiple="multiple"></input> <br>
							<input type="checkbox" id="enviar" name="enviar"> Enviar para o paciente

							<div class="error-validation" id="erro-Anexo">
								<label class="col-sm-10 control-label" id="label-erro"> ${anexoError} </label>
							</div>

							<table id="file-upload" role="presentation"	class="table table-striped">
								<thead class="files">
									<tr> 
										<th colspan="6"> Ducumentos para enviar ao paciente </th>
									</tr>
									<tr>
										<th>Nome do Arquivo</th>
										<th>Data</th>
										<th>Tipo</th>
										<th>Baixar</th>
										<th>Excluir</th>
										<th> Enviar </th>
									</tr>
								</thead>

								<tbody class="files">
									<c:forEach items="${documentosEnvio}" var="documento">
										<tr class="template-upload fade in">					
											<td>${documento.nome}<strong class="error text-danger"></strong></td>
											<td>${documento.data}<strong class="error text-danger"></strong></td>
											<td>${documento.tipo}<strong class="error text-danger"></strong></td>

											<td>
												<a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
													<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save"></span></button>
												</a>
											</td>						

											<td>
												<a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
													<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
												</a>
											</td>

											<td>
												<a id="send[${documento.id}]" href="../../nutricao/enviarDocumento/${documento.id}/" class="send-document">
													<button class="btn btn-warning"><span class="glyphicon glyphicon-send"></span></button>
												</a>
											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table><br>
							
							<table id="file-upload" role="presentation"	class="table table-striped">
								<thead class="files">
									<tr> 
										<th colspan="5"> Outros documentos </th>
									</tr>
									
									<tr>
										<th>Nome do Arquivo</th>
										<th>Data</th>
										<th>Tipo</th>
										<th>Baixar</th>
										<th>Excluir</th>
									</tr>
								</thead>

								<tbody class="files">
									<c:forEach items="${documentosNutricionista}" var="documento">
										<tr class="template-upload fade in">					
											<td>${documento.nome}<strong class="error text-danger"></strong></td>
											<td>${documento.data}<strong class="error text-danger"></strong></td>
											<td>${documento.tipo}<strong class="error text-danger"></strong></td>
											<td>
												<a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
													<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save"></span></button>
												</a>
											</td>						
											
											<td>
												<a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
													<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
												</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>			
				</div>






    	</form:form>
		</div>
	</div>
</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
