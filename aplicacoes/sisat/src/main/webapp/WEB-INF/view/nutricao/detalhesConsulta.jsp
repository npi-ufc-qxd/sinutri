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
<title>Detalhes: ${pessoa.nome}</title>
</head>
<body>

	<jsp:include page="../modulos/header.jsp" />



	<div class="container" style="margin-bottom: 70px;">
		<div class="controls inline">
			<h2>
				<a
					href="<c:url value="/nutricao/detalhes/${consulta.paciente.pessoa.id}"></c:url>"
					class="btn btn-default glyphicon glyphicon-arrow-left"> </a>
				Paciente
			</h2>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#avaliacao">Avaliação
					Nutricional</a></li>

			<li><a data-toggle="tab" href="#exame">Exames Laboratoriais</a></li>

			<li><a data-toggle="tab" href="#questionario">Questionario
					de Frequencia Alimentar</a></li>
					
			<li><a data-toggle="tab" href="#orientacoes">Orientações Individuais</a></li>
		</ul>

		<div class="tab-content">

			<!-- ABA DE AVALIACAO NUTRICIONAL -->
			<div id="avaliacao" class="tab-pane fade in active">

<div class="content">
	<br/>
	<table style="width: 70%">
		<tr>
			<td>${consulta.disfagia ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Disfagia</td>
			<td>${consulta.pirose ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				pirose</td>
			<td>${consulta.constipacao ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Constipação</td>
			<td>${consulta.diarreia ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Diarreia</td>
			<td>${consulta.nausea ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Naúsea</td>
			<td>${consulta.vomito ? "<span class='glyphicon glyphicon-ok'></span>" : "<span class='glyphicon glyphicon-remove'></span>" }
				Vômitos</td>
		</tr>
		<tr>
			<td><strong>Altura: </strong> ${consulta.paciente.altura }</td>
			<td><strong>Peso: </strong> ${consulta.peso}</td>
			<td><strong>IMC: </strong> ${consulta.imc}</td>
			<td><strong>CC: </strong>  ${consulta.circunferenciaCintura}
			 	${consulta.classificacaoCc}  </td> 
			<td></td>
		</tr>
	</table>
	<br /> <strong>Medicamentos: </strong>${consulta.medicamento ? consulta.medicamentoComentario  : "<em>Não usa medicamentos</em>"}
	<br /> <strong> Alergia alimentar: </strong>${consulta.alergia ? consulta.alergiaComentario  : "<em>Não possui alergia a alimentos</em>"}
	<br /> <strong> Atividade Fisica: </strong>
	<c:choose>
		<c:when test="${consulta.atividadeFisica }">
						${consulta.atividadeFisicaComentario } 
						<strong>Vezes por semana: </strong>${consulta.atividadeFisicaFrequenciaSemanal }
					</c:when>
		<c:otherwise>
			<em>Não pratica atividades fisicas.</em>
		</c:otherwise>
	</c:choose>
	<br /> <strong> Consumo de carne vermelha: </strong>
	${cosulta.carneVermelhaFrequencia }<br /> <strong> Consumo de
		bebida alcoolica: </strong>
	<c:choose>
		<c:when test="${consulta.bebidaAlcoolica }">
						${consulta.bebidaAlcoolicaComentario }
						<strong>Vezes por semana: </strong> ${consulta.bebidaAlcoolicaFrequenciaSemanal }
					</c:when>
		<c:otherwise>
			<em>Não consome bebidas alcoolicas.</em>
		</c:otherwise>
	</c:choose>
	<br /> <strong> Patologias: </strong> ${consulta.outrasPatologias ? consulta.outrasPatologiasComentario  : "<em>Não possui outras patologias</em>"}<br />

	<strong> Objetivo da consulta: </strong> ${consulta.objetivoConsulta }<br />
</div>
			</div>

			<!-- ABA DE EXAMES LABORATORIAS -->
			<div id="exame" class="tab-pane fade">
<div class="content">
	<br/>
	<table class="table table-bordered table-striped" style="width:300px">
		<thead>
			<tr>
				<th></th>
				<th>Valor</th>
				<th>Classificação</th>
			</tr>
		</thead>
		<tr>
			<td>
				<strong>Glicemia: </strong> 
			</td>
			<td>
				${consulta.glicemia }
			</td>
			<td>
				${consulta.classificacaoGlicemia }
			</td>
		</tr>
		<tr>
			<td>
				<strong>LDC - C: </strong> 
			</td>
			<td>
				${consulta.ldl }
			</td>
			<td>
				${consulta.classificacaoLdl }
			</td>
		</tr>
		<tr>
			<td>
				<strong>CT: </strong> 
			</td>
			<td>
				${consulta.ct }
			</td>
			<td>
				${consulta.classificacaoCt }
			</td>
		</tr>
		<tr>
			<td>
				<strong>HDL - C: </strong> 
			</td>
			<td>
				${consulta.hdl }
			</td>
			<td>
				${consulta.classificacaoHdl }
			</td>
		</tr><tr>
			<td>
				<strong>TG: </strong> 
			</td>
			<td>
				${consulta.tg }
			</td>
			<td>
				${consulta.classificacaoTg }
			</td>
		</tr>
		<tr>
			<td>
				<strong>HB: </strong> 
			</td>
			<td>
				${consulta.hb }
			</td>
			<td>
				${consulta.classificacaoHb }
			</td>
		</tr>
		<tr>
			<td>
				<strong>TGO(AST): </strong> 
			</td>
			<td>
				${consulta.tgo }
			</td>
			<td>
				${consulta.classificacaoTgo }
			</td>
		</tr>
		<tr>
			<td>
				<strong>TGP(ALT): </strong> 
			</td>
			<td>
				${consulta.tgp }
			</td>
			<td>
				${consulta.classificacaoTgp }
			</td>
		</tr>
		
		<!-- 
		Glicemia 
		LDC-C
		CT
		HDL - C
		TG
		HB
		TGO(AST)
		TGP(ALT)
		-->
		
	</table>
</div> 			</div>

			<!-- ABA DE QUESTIONARIO DE FRENQUENCIA ALIMENTAR -->
			<div id="questionario" class="tab-pane fade">

<div class="content">
	<br/>
	<c:forEach var="freq" items="${consulta.frequencias}">
		<table class="table table-bordered table-striped" >
			<caption align="left"><strong>${freq.horario } - ${freq.refeicao.nome }</strong></caption>
			<thead >
				<tr>
					<th>
						Alimento/Preparo
					</th>
					<th width="20%">
						Porção
					</th>
				</tr>
			</thead>
			<c:forEach var="alimento" items="${freq.alimentos }">
				<tr>
					<td>
						${alimento.alimento }
					</td>
					<td>
						${alimento.porcao }
					</td>
				</tr>
				
			</c:forEach>
		</table>
	</c:forEach>
	
	
	
</div>

			</div>
			
			<!-- ABA DE ORIENTACOES -->
			<div id="orientacoes" class="tab-pane fade">


<div class="content">
	<br/>
	
	<strong>Conduta Nutricional</strong><br/>
	${consulta.condutaNutricional}<br/>
	
	<strong>Orientacões Individuais</strong><br/>
	${consulta.orientacoesIndividuais}<br/>
	
	
</div>

			</div>
		</div>
	</div>
	<jsp:include page="../modulos/footer.jsp" />

</body>
</html>