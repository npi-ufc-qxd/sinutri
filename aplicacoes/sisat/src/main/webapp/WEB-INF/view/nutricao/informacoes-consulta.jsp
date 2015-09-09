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

<title>Informações da Consulta</title>
<style type="text/css">
.footer {
	position: relative;
	margin-top: 30px;
}
</style>
</head>

<body data-spy="scroll" data-target="#myScrollspy">

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">

		<div class="row">
			<div class="col-sm-4">
				<h2>
					Informações da Consulta: <em><small>${consulta.paciente.pessoa.nome}</small></em>
				</h2>
			</div>

			<div class="col-sm-8" align="right" style="margin-top: 15px;">
				<a
					href="<c:url value="/consulta/historico-paciente/${consulta.paciente.pessoa.cpf}"></c:url>"
					class="btn btn-primary">Voltar</a> <a
					href="<c:url value="#/nutricao/plano-alimentar"></c:url>"
					class="btn btn-info">Criar Plano Alimentar</a> <a
					href="<c:url value="/consulta/editar-consulta/${consulta.id}/paciente/${consulta.paciente.pessoa.cpf}"/>"
					class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>
					Editar</a>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3" id="myScrollspy">
				<ul class="nav nav-tabs nav-stacked affix-top" data-spy="affix"
					data-offset-top="125">
					<li class="active"><a href="#avaliacao"> <span
							class="badge">1</span> Anamnese
					</a></li>
					<li><a href="#recordatorio"> <span class="badge">2</span>
							Recordatório Alimentar
					</a></li>
					<li><a href="#exame"> <span class="badge">3</span> Exames
							Laboratoriais
					</a></li>
					<li><a href="#orientacoes"> <span class="badge">4</span>
							Orientações Individuais
					</a></li>
					<li><a href="#documentos"> <span class="badge">5</span>
							Documentos
					</a></li>
				</ul>

			</div>

			<div class="col-sm-9">
				<h3 id="avaliacao" class="section">Anamnese</h3>
				
				<div class="row">
					<div class="col-sm-12">
						<label><strong>Consumo de água: </strong></label>${consulta.agua} copos/dia<br>

						<label><strong>Altura: </strong></label>${consulta.altura}
						<br><label><strong>Peso: </strong></label>${consulta.peso}
						<br><label><strong>Peso Desejado: </strong></label>${consulta.pesoDesejado}
						<br><label><strong>CC: </strong></label>${consulta.circunferenciaCintura} - ${consulta.classificacaoCc}
						<br><label><strong>CC Desejada: </strong></label>${consulta.circunferenciaCinturaDesejada}
						<br><label><strong>IMC: </strong></label>${consulta.imc}
						<br><label><strong>Medicamentos: </strong></label>${consulta.medicamento ? consulta.medicamentoComentario  : "Não usa medicamentos"}
						<br><label><strong>Alergia alimentar: </strong></label>${consulta.alergia ? consulta.alergiaComentario  : "Não possui alergia a alimentos"}
		
						<br><label><strong> Atividade Fisica: </strong></label>
						<c:choose>
							<c:when test="${consulta.atividadeFisica }">
								${consulta.atividadeFisicaComentario } 
								<strong>Vezes por semana: </strong>${consulta.atividadeFisicaFrequenciaSemanal.tipo }
							</c:when>
							<c:otherwise>
								<em>Não pratica atividades fisicas.</em>
							</c:otherwise>
						</c:choose>
		
						<br><label><strong> Consumo de carne vermelha: </strong></label>
						<c:choose>
							<c:when test="${consulta.carneVermelha }">
								${consulta.carneVermelhaComentario } <strong>Vezes por semana: </strong>${consulta.carneVermelhaFrequenciaSemanal.tipo }
							</c:when>
							<c:otherwise>
								<em>Não consome carne vermelha.</em>
							</c:otherwise>
						</c:choose>
						
						<br><label><strong> Consumo de bebida alcoolica: </strong></label>
						<c:choose>
							<c:when test="${consulta.bebidaAlcoolica }">
								${consulta.bebidaAlcoolicaComentario } <strong>Vezes por semana: </strong> ${consulta.bebidaAlcoolicaFrequenciaSemanal.tipo }
							</c:when>
							<c:otherwise>
								<em>Não consome bebidas alcoolicas.</em>
							</c:otherwise>
						</c:choose>
						
						<br><label><strong> Patologias: </strong></label> ${consulta.outrasPatologias ? consulta.outrasPatologiasComentario  : "<em>Não possui outras patologias</em>"}
		
						<br><label><strong> Objetivo da consulta: </strong></label> ${consulta.objetivoConsulta }

						<table class="table table-striped">
							<thead class="thead">
								<tr>
									<th>Patologias</th>
									<th>Cometário</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Disfagia</td>
									<td>${consulta.disfagia ? consulta.disfagiaComentario : "Não apresenta disfagia" }</td>
								</tr>
								<tr>
									<td>Pirose</td>
									<td>${consulta.pirose? consulta.piroseComentario : "Não apresenta pirose" }</td>
								</tr>
								<tr>
									<td>Constipacao</td>
									<td>${consulta.constipacao? consulta.constipacaoComentario : "Não apresenta constipacao" }</td>
								</tr>
								<tr>
									<td>Diarreia</td>
									<td>${consulta.diarreia? consulta.diarreiaComentario : "Não apresenta diarreia" }</td>
								</tr>
								<tr>
									<td>Nausea</td>
									<td>${consulta.nausea? consulta.nauseaComentario : "Não apresenta nausea" }</td>
								</tr>
								<tr>
									<td>Vômito</td>
									<td>${consulta.vomito? consulta.vomitoComentario : "Não apresenta vomito" }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<h3 id="recordatorio" class="section">Recordatório</h3>
				
				<c:if test="${empty consulta.frequencias}">
					<div class="alert alert-dismissible alert-info">
						Não há informações sobre o recordatório alimentar.
					</div>				
				</c:if>
				
				<c:forEach var="freq" items="${consulta.frequencias}">
					<div class="row">
						<fmt:formatDate var="horaFormatada" type="time" dateStyle="short"
							timeStyle="short" value="${freq.horario}" />

						<div class="col-sm-2 label-horario" align="center">
							<h4>
								<strong class="label label-info">${freq.refeicao.nome }</strong>
							</h4>
							<h1>
								<span class="label label-primary">${horaFormatada}</span>
							</h1>
						</div>

						<div class="col-sm-10">
							<table class="table table-striped">
								<thead class="thead">
									<tr>
										<th>Alimento/Preparo</th>
										<th>Porção</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="alimento" items="${freq.alimentos }">
										<tr>
											<td>${alimento.alimento }</td>
											<td>${alimento.porcao }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:forEach>

				<h3 id="exame" class="section">Exames Laboratoriais</h3>


				<table class="table table-striped">
					<thead class="thead">
						<tr>
							<th>Exame</th>
							<th>Valor</th>
							<th>Classificação</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><strong>Glicemia: </strong></td>
							<td>${consulta.glicemia }</td>
							<td>${consulta.classificacaoGlicemia }</td>
						</tr>

						<tr>
							<td><strong>LDC - C: </strong></td>
							<td>${consulta.ldlc }</td>
							<td>${consulta.classificacaoLdlc }</td>
						</tr>

						<tr>
							<td><strong>CT: </strong></td>
							<td>${consulta.ct }</td>
							<td>${consulta.classificacaoCt }</td>
						</tr>

						<tr>
							<td><strong>HDL - C: </strong></td>
							<td>${consulta.hdlc }</td>
							<td>${consulta.classificacaoHdlc }</td>
						</tr>

						<tr>
							<td><strong>TG: </strong></td>
							<td>${consulta.tg }</td>
							<td>${consulta.classificacaoTg }</td>
						</tr>
						<tr>
							<td><strong>HB: </strong></td>
							<td>${consulta.hb }</td>
							<td>${consulta.classificacaoHb }</td>
						</tr>

						<tr>
							<td><strong>TGO(AST): </strong></td>
							<td>${consulta.tgo }</td>
							<td>${consulta.classificacaoTgo }</td>
						</tr>
						<tr>
							<td><strong>TGP(ALT): </strong></td>
							<td>${consulta.tgp }</td>
							<td>${consulta.classificacaoTgp }</td>
						</tr>
					</tbody>
				</table>

				<h3 id="orientacoes" class="section">Orientações</h3>
				
				<div class="row">
					<div class="col-sm-12">
						<p>${consulta.orientacoesIndividuais}</p>
					</div>
				</div>
				
				

				<h3 id="documentos" class="section">Documentos</h3>
				<c:choose>
					<c:when test="${not empty consulta.documentos }">
						<table class="table table-striped">
							<thead class="thead">
								<tr>
									<th>Nome</th>
									<th>Download</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="documento" items="${consulta.documentos }"
									varStatus="cont">
									<tr>
										<td>${ documento.nome}</td>
										<td><a
											href="<c:url value="/nutricao/downloadDocumento/${documento.id }" ></c:url>"
											class="btn btn-danger"> <span
												class="glyphicon glyphicon-download"></span> Download
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h4>Essa consulta não possui nenhum documento anexado a ela.</h4>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script
		src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
