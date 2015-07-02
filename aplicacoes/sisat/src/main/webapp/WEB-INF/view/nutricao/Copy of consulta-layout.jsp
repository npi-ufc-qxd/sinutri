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









.wizard > ul.steps,
.wizard > .steps-container > ul.steps {
  list-style: none outside none;
  padding: 0;
  margin: 0;
  width: 999999px;
}


.wizard > ul.steps li,
.wizard > .steps-container > ul.steps li {
  float: left;
  margin: 0;
  padding: 0 20px 0 30px;
  height: 46px;
  line-height: 46px;
  position: relative;
  background: #ededed;
  color: #999999;
  font-size: 16px;
  cursor: not-allowed;
}
.wizard > ul.steps li .chevron,
.wizard > .steps-container > 
ul.steps li .chevron {
  border: 24px solid transparent;
  border-left: 14px solid #d4d4d4;
  border-right: 0;
  display: block;
  position: absolute;
  right: -14px;
  top: 0;
  z-index: 1;
}
.wizard > ul.steps li .chevron:before,
.wizard > .steps-container > ul.steps li .chevron:before {
  border: 24px solid transparent;
  border-left: 14px solid #ededed;
  border-right: 0;
  content: "";
  display: block;
  position: absolute;
  right: 1px;
  top: -24px;
}

</style>
</head>

<body>
	<div class="bs-component">
		<nav class="navbar navbar-static navbar-fixed navbar-inverse">
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




</div>
	<div class="container">

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

		<h2>${titulo}</h2>

		<div class="wizard">
			<div class="steps-container">
				<ul class="steps nav nav-tabs ">
					<li class="active">
						<a><span class="badge">1</span>
						Recipients<span class="chevron"></span>
						</a>
					</li>

					<li><a data-toggle="tab" href="#avaliacao">Avaliação Nutricional</a></li>
					<li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>
					<li><a data-toggle="tab" href="#questionario">Questionario de Frequencia Alimentar</a></li>
					<li><a data-toggle="tab" href="#orientacoes">Orientações Individuais</a></li>
					<li><a data-toggle="tab" href="#documentos">Documentos</a></li>
				</ul>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
			<div class="steps-container">
				<ul class="steps nav nav-tabs">
					<li class="active">
						<span class="badge">1</span>
						Recipients<span class="chevron"></span>
					</li>
					<li>
						<span class="badge">2</span>
						Campaign<span class="chevron"></span>
					</li>
				</ul>


		<form:form servletRelativeAction="${url}" method="POST" id = "consultaNutricional" modelAttribute="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="tab-content">
				<form:hidden path="id" />
				<form:hidden path="paciente.id" />
				<form:hidden path="data" />

				<div id="avaliacao" class="tab-pane fade in active">
					<h3>Paciente</h3>
					<div class="form-group">
						<label for="altura" class="col-sm-2 control-label">Altura:</label>
						<div class="col-sm-3">
							<form:input id="altura" name="altura" type="number" path="paciente.altura" cssClass="form-control" placeholder="0.00" />

							<div class="error-validation"><form:errors path="paciente.altura"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="peso" class="col-sm-2 control-label">Peso:</label>
						<div class="col-sm-3">
							<form:input id="peso" name="peso" type="number" path="peso" cssClass="form-control" placeholder="00.00"/>
							
							<div class="error-validation"><form:errors path="peso"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="cc" class="col-sm-2 control-label">CC:</label>
						<div class="col-sm-3" >
							<form:input id="cc" name="cc" type="number" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
							
							<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
						</div>
					</div>

					<div class="form-group form-item">
						<label for="checkMedicamento" class="col-sm-2 control-label"><form:checkbox id="checkMedicamento"  path="medicamento" class="check"/> Medicamentos:</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMedicamento" path="medicamentoComentario" cssClass="form-control" placeholder="Quais medicamentos você usa?" disabled="${not consultaNutricional.medicamento}"/>
							
							<div class="error-validation"><form:errors path="medicamentoComentario"></form:errors></div>
						</div>
					</div>
				
				<h3>Alterações Gastrointestinais</h3>

					<div class="form-group">
						<label for="disfagia" class="col-sm-2 control-label"><form:checkbox id="disfagia" path="disfagia"/> Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<label for="pirose" class="col-sm-1 control-label"><form:checkbox id="pirose" path="pirose"/> Pirose</label>
						<label for="nausea" class="col-sm-2 control-label"><form:checkbox id="nausea" path="nausea"/> Náusea</label>
						<label for="vomito" class="col-sm-2 control-label"><form:checkbox id="vomito" path="vomito"/> Vômitos</label>
						<label for="diarreia" class="col-sm-2 control-label"><form:checkbox id="diarreia" path="diarreia"/> Diarreia</label>
						<label for="constipacao" class="col-sm-2 control-label"><form:checkbox id="constipacao" path="constipacao"/> Constipação</label>
					</div>
					<div class="form-group form-item">
						<label for="checkMastigacao" class="col-sm-2 control-label"><form:checkbox id="checkMastigacao"  path="mastigacao" class="check"/> Mastigação:</label>
						<div class="col-sm-10" >
							<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
							
							<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group form-item">
						<label for="checkAlergia" class="col-sm-2 control-label"><form:checkbox id="checkAlergia"  path="alergia" class="check"/> Alergia Alimentar:</label>
						<div class="col-sm-10" >
							<form:textarea id="inputTextAlergia" path="alergiaComentario" class="form-control" rows="5" placeholder="Qual sua alergia Alimentar?" disabled="${not consultaNutricional.alergia}"/>
							
							<div class="error-validation"><form:errors path="alergiaComentario"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group form-item" align="left">
						<label for="agua" class="col-sm-2 control-label">Consumo de água:</label>
						<div class="col-sm-10">
							<form:input id="agua" name="agua" type="number" path="agua" cssClass="form-control" placeholder="Consumo de água"/>
							
							<div class="error-validation"><form:errors path="agua"></form:errors></div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="form-item">
							<label for="checkAtividadeFisica" class="col-sm-2 control-label"><form:checkbox id="checkAtividadeFisica"  path="atividadeFisica" class="check"/> Atividade Física:</label>
							<div class="col-sm-7" >
								<form:input id="inputTextAtividadeFisica" path="atividadeFisicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.atividadeFisica}"/>

								<div class="error-validation"><form:errors path="atividadeFisicaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
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
						</div>
					</div>
					
					<div class="form-group">
						<div class="form-item">
							<label for="checkCarneVermelha" class="col-sm-2 control-label"><form:checkbox id="checkCarneVermelha"  path="carneVermelha" class="check"/> Carne Vermelha:</label>
							
							<div class="col-sm-7" >
								<form:input id="inputTextCarneVermelha" path="carneVermelhaComentario" cssClass="form-control" placeholder="Que tipo de carne?" disabled="${not consultaNutricional.carneVermelha}"/>
								
								<div class="error-validation"><form:errors path="carneVermelhaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
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
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="checkBebidaAlcoolica" class="col-sm-2 control-label"><form:checkbox id="checkBebidaAlcoolica"  path="bebidaAlcoolica" class="check"/> Bebida alcoólica:</label>
							<div class="col-sm-7" >
								<form:input id="inputTextBebidaAlcoolica" path="bebidaAlcoolicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.bebidaAlcoolica}"/>
								
								<div class="error-validation"><form:errors path="bebidaAlcoolicaComentario"></form:errors></div>
							</div>
				
							<div class="form-item">
								<div class="col-sm-3" >
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
						</div>
					</div>
				
					<div class="form-group form-item">
						<label for="checkPatologia" class="col-sm-2 control-label"><form:checkbox id="checkPatologia"  path="outrasPatologias" class="check"/> Patologias:</label>
						<div class="col-sm-10" >
							<form:textarea id="inputTextPatologia" path="outrasPatologiasComentario" class="form-control" rows="5" placeholder="Descreva aqui as patologias" disabled="${not consultaNutricional.outrasPatologias}"/>
							
							<div class="error-validation"><form:errors path="outrasPatologiasComentario"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group form-item">
						<label for="objetivoConsulta" class="col-sm-2 control-label"> Objetivo da Consulta:</label>
						<div class="col-sm-10" >
							<form:textarea id="objetivoConsulta" path="objetivoConsulta" class="form-control" rows="5" placeholder="Descreva aqui o objetivo da consulta..."/>
							
							<div class="error-validation"><form:errors path="objetivoConsulta"></form:errors></div>
						</div>
					</div>
				</div>

				<div id="exame" class="tab-pane fade">
					<h3>Seus exames</h3>

					<div class="form-group">
						<div class="form-item">
							<label for="glicemia" class="col-sm-2 control-label">Glicemia:</label>
							<div class="col-sm-2">
								<form:input id="glicemia" type="number" path="glicemia" cssClass="form-control" placeholder="glicemia" />			
								
								<div class="error-validation"><form:errors path="glicemia"></form:errors></div>
							</div>
							<div class="col-sm-2" >
								<form:select path="classificacaoGlicemia" cssClass="form-control" disabled="${not consultaNutricional.classificacaoGlicemia}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
				 		</div> 
					
				 		<div class="form-item">
							<label for="ct" class="col-sm-2 control-label">CT:</label>
							<div class="col-sm-2">
								<form:input id="ct" type="number" path="ct" cssClass="form-control" placeholder="ct" />
								
								<div class="error-validation"><form:errors path="ct"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoCt" cssClass="form-control" disabled="${not consultaNutricional.classificacaoCt}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="ldl" class="col-sm-2 control-label">LDL-C:</label>
							<div class="col-sm-2">
								<form:input id="ldl" type="number" path="ldl" cssClass="form-control" placeholder="LDL-C" />
								
								<div class="error-validation"><form:errors path="ldl"></form:errors></div>
							</div>
							<div class="col-sm-2" >
								<form:select path="classificacaoLdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoLdl}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
				
						<div class="form-item">
							<label for="hdl" class="col-sm-2 control-label">HDL-C:</label>
							<div class="col-sm-2">
								<form:input id="hdl" type="number" path="hdl" cssClass="form-control" placeholder="HDL-C" />
								
								<div class="error-validation"><form:errors path="hdl"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoHdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHdl}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="tg" class="col-sm-2 control-label">TG:</label>
							<div class="col-sm-2">
								<form:input id="tg" type="number" path="tg" cssClass="form-control" placeholder="TG" />
								
								<div class="error-validation"><form:errors path="tg"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoTg" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTg}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
				
						<div class="form-item">
							<label for="hb" class="col-sm-2 control-label">HB:</label>
							<div class="col-sm-2">
								<form:input id="hb" type="number" path="hb" cssClass="form-control" placeholder="HB" />
								
								<div class="error-validation"><form:errors path="hb"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoHb" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHb}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-item">
							<label for="tgo" class="col-sm-2 control-label">TGO (AST):</label>
							<div class="col-sm-2">
								<form:input id="tgo" type="number" path="tgo" cssClass="form-control" placeholder="tgo" />
								
								<div class="error-validation"><form:errors path="tgo"></form:errors></div>
							</div>
				
							<div class="col-sm-2" >
								<form:select path="classificacaoTgo" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgo}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					
				 		<div class="form-item"> 
							<label for="tgp" class="col-sm-2 control-label">TGP (ALT):</label>
							<div class="col-sm-2">
								<form:input id="tgp" type="number" path="tgp" cssClass="form-control" placeholder="TGP (ALT)" />
								
								<div class="error-validation"><form:errors path="tgp"></form:errors></div>
							</div>
				
						<div class="form-item">
							<div class="col-sm-2" >
								<form:select path="classificacaoTgp" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgp}">
									<form:option value="">Classificação</form:option>
									<form:options items="${classificacao}" itemLabel="tipo"/>
								</form:select>
							</div>
						</div>
					</div>
					</div>
				</div>

				<div id="questionario" class="tab-pane fade in ">
					<fieldset>
						<h3>Adicione as refeições</h3>

						<div class="form-group">
							<table id="questionarioFrequenciaAlimentar"></table>
						</div>
					</fieldset>
				</div>

				<div id="orientacoes" class="tab-pane fade in ">
					<h3>Orientações</h3>

					<div class="form-group">
						<label for="condutaNutricional" class="col-sm-2 control-label"> Conduta Nutricional:</label>
						<div class="col-sm-10" >
							<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
							
							<div class="error-validation"><form:errors path="condutaNutricional"></form:errors></div>
						</div>
					</div>
				
					<div class="form-group">
						<label for="orientacoesIndividuais" class="col-sm-2 control-label"> Orientações Individuais</label>
						<div class="col-sm-10" >
							<form:textarea id="orientacoesIndividuais" path="orientacoesIndividuais" class="form-control" rows="5" placeholder="Orientações Individuais"/>
							
							<div class="error-validation"><form:errors path="orientacoesIndividuais"></form:errors></div>
						</div>
					</div>
				</div>
				
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
			</div>

			<div class="col-xs-offset-0 col-xs-10" align="center">
				<button type="submit" class="btn btn-success">${botao}</button>
			</div>
		</form:form>
	</div>


<div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
              <h1 id="forms">Forms</h1>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <div class="well bs-component">
              <form class="form-horizontal">
                <fieldset>
                  <legend>Legend</legend>
                  <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                      <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> Checkbox
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="textArea" class="col-lg-2 control-label">Textarea</label>
                    <div class="col-lg-10">
                      <textarea class="form-control" rows="3" id="textArea"></textarea>
                      <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-lg-2 control-label">Radios</label>
                    <div class="col-lg-10">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                          Option one is this
                        </label>
                      </div>
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                          Option two can be something else
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Selects</label>
                    <div class="col-lg-10">
                      <select class="form-control" id="select">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                      <br>
                      <select multiple="" class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button type="reset" class="btn btn-default">Cancel</button>
                      <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>

        </div>
      </div>
		

	<jsp:include page="../modulos/footer.jsp" />
	<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
