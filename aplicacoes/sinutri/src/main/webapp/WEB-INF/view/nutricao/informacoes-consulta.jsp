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
			<div class="col-sm-8">
				<h3>
					Informações da Consulta <strong>${consulta.paciente.pessoa.nome}</strong>
				</h3>
			</div>

			<div class="col-sm-4" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span> Voltar</a> <a
					href="<c:url value="/paciente/consulta/${consulta.id}/plano-alimentar"></c:url>"
					class="btn btn-info btn-sm">Plano Alimentar</a> <a
					href="<c:url value="/paciente/${consulta.paciente.pessoa.cpf}/consulta/${consulta.id}/editar"/>"
					class="btn btn-warning btn-sm"><span
					class="glyphicon glyphicon-edit"></span> Editar</a>
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
					<li><a href="#documentos"> <span class="badge">4</span>
							Documentos
					</a></li>
					<li><a href="#inquerito"> <span class="badge">5</span>
							Inquerito Alimentar
					</a></li>
				</ul>

			</div>

			<div class="col-sm-9">
				<h3 id="avaliacao" class="section">Anamnese</h3>

				<div class="row">
						<label><strong> Objetivo da consulta: </strong></label>
						${consulta.objetivoConsulta }<br>
						<table class="table table-striped">
							<tbody>
								<tr>
									<td><strong>Data de Nascimento:</strong></td>
									<td><fmt:formatDate type="date" value="${consulta.paciente.pessoa.dataNascimento}" /></td>
									<td><strong>Idade:</strong></td>
									<td>${consulta.paciente.pessoa.idade}</td>
								</tr>
								<tr>
									<td><strong>Altura:</strong></td>
									<td>${consulta.altura}</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><strong>IMC:</strong></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="3"
											value="${consulta.IMC}" /></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><strong>Consumo de água:</strong></td>
									<td>${consulta.agua}</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="col-sm-3"><strong>Horário de Dormir:</strong></td>
									<td class="col-sm-3">
										<fmt:formatDate type="time" pattern="HH:mm" value="${consulta.horarioDormir}" />
									</td>
									<td class="col-sm-3"><strong>Horário de Acordar:</strong></td>
									<td class="col-sm-3">
										<fmt:formatDate type="time" pattern="HH:mm" value="${consulta.horarioAcordar}" />
									</td>
								</tr>
								
								<tr>
									<td class="col-sm-3"><strong>Peso:</strong></td>
									<td class="col-sm-3">${consulta.peso}</td>
									<td class="col-sm-3"><strong>Peso desejado:</strong></td>
									<td class="col-sm-3">${consulta.pesoDesejado}</td>
								</tr>
								<tr>
									<td class="col-sm-3"><strong>CC:</strong></td>
									<td class="col-sm-3">${consulta.circunferenciaCintura}-
										${consulta.classificacaoCC}</td>
									<td class="col-sm-3"><strong>CC Desejada:</strong></td>
									<td class="col-sm-3">${consulta.circunferenciaCinturaDesejada}</td>
								</tr>
								<tr>
									<td class="col-sm-3"><strong>Sistema
											Gastrointestinal:</strong></td>
									<td class="col-sm-3"><c:choose>
											<c:when test="${not empty consulta.sistemaGastrointestinal}"> ${consulta.sistemaGastrointestinal}</c:when>
											<c:otherwise> Sistema gastrointestinal não informado.</c:otherwise>
										</c:choose></td>
									<td class="col-sm-3"><strong>Sistema Urinário:</strong></td>
									<td class="col-sm-3"><c:choose>
											<c:when test="${not empty consulta.sistemaUrinario}"> ${consulta.sistemaUrinario}</c:when>
											<c:otherwise> Sistema urinário não informado.</c:otherwise>
										</c:choose></td>
								</tr>
								<tr>
									<td><strong>Atividade Física:</strong></td>
									<c:choose>
										<c:when test="${consulta.atividadeFisica}">
											<td>${consulta.atividadeFisicaComentario }</td>
											<td><strong>Vezes por semana:</strong></td>
											<td>${consulta.atividadeFisicaFrequenciaSemanal.tipo }</td>
										</c:when>
										<c:otherwise>
											<td>Não pratica atividades fisicas.</td>
											<td></td>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
								<tr>
									<td><strong>Consumo de bebida alcoolica:</strong></td>
									<c:choose>
										<c:when test="${consulta.bebidaAlcoolica }">
											<td>${consulta.bebidaAlcoolicaComentario }</td>
											<td><strong>Vezes por semana:</strong></td>
											<td>${consulta.bebidaAlcoolicaFrequenciaSemanal.tipo }</td>
										</c:when>
										<c:otherwise>
											<td>Não consome bebidas alcoolicas.</td>
											<td></td>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
								<tr>
									<td><strong>Consumo de Cigarro:</strong></td>
									<c:choose>
										<c:when test="${consulta.cigarro }">
											<td>${consulta.cigarroComentario }</td>
											<td><strong>Vezes por semana:</strong></td>
											<td>${consulta.cigarroFrequenciaSemanal.tipo }</td>
										</c:when>
										<c:otherwise>
											<td>Não consome cigarros.</td>
											<td></td>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
								
							</tbody>
						</table>

						<table class="table table-striped">
							<thead class="thead">
								<tr>
									<th>Patologias</th>
									<th>Comentário</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Disfagia</td>
									<td>${consulta.disfagia ? consulta.disfagiaComentario : "Não apresenta disfagia" }</td>
								</tr>
								<tr>
									<td>Odinofagia</td>
									<td>${consulta.odinofagia ? consulta.odinofagiaComentario : "Não apresenta disfagia" }</td>
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
								<tr>
									<td>Mastigação</td>
									<td>${consulta.mastigacao ? consulta.mastigacaoComentario  : "Não apresenta problemas na mastigação"}</td>
								</tr>
								<tr>
									<td>Alergia Alimentar</td>
									<td>${consulta.alergia ? consulta.alergiaComentario  : "Não possui alergia à alimentos"}</td>
								</tr>
								<tr>
									<td>Intolerância Alimentar</td>
									<td>${consulta.intolerancia ? consulta.intoleranciaComentario  : "Não possui intolerância à alimentos"}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<label><strong> Medicamentos:</strong></label>
				${consulta.medicamento ? consulta.medicamentoComentario  : "Não usa medicamentos"}
				<br> <label><strong> Patologias: </strong></label>
				${consulta.outrasPatologias ? consulta.outrasPatologiasComentario  : "Não possui outras patologias"}

				<h3 id="recordatorio" class="section">Recordatório</h3>

				<c:if test="${empty consulta.frequencias}">
					<div class="alert alert-dismissible alert-default">Não há
						informações sobre o recordatório alimentar.</div>
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
							<c:if
								test="${not empty consulta.glicemia and not empty consulta.classificacaoGlicemia}">
								<td>${consulta.glicemia }</td>
								<td>${consulta.classificacaoGlicemia }</td>
							</c:if>
							<c:if
								test="${empty consulta.glicemia and empty consulta.classificacaoGlicemia}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>

						<tr>
							<td><strong>LDC - C: </strong></td>
							<c:if
								test="${not empty consulta.ldlc and not empty consulta.classificacaoLdlc}">
								<td>${consulta.ldlc }</td>
								<td>${consulta.classificacaoLdlc }</td>
							</c:if>
							<c:if
								test="${empty consulta.ldlc and empty consulta.classificacaoLdlc}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>

						<tr>
							<td><strong>CT: </strong></td>
							<c:if
								test="${not empty consulta.ct and not empty consulta.classificacaoCt}">
								<td>${consulta.ct }</td>
								<td>${consulta.classificacaoCt }</td>
							</c:if>
							<c:if
								test="${empty consulta.ct and empty consulta.classificacaoCt}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>

						<tr>
							<td><strong>HDL - C: </strong></td>
							<c:if
								test="${not empty consulta.hdlc and not empty consulta.classificacaoHdlc}">
								<td>${consulta.hdlc }</td>
								<td>${consulta.classificacaoHdlc }</td>
							</c:if>
							<c:if
								test="${empty consulta.hdlc and empty consulta.classificacaoHdlc}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>

						<tr>
							<td><strong>TG: </strong></td>
							<c:if
								test="${not empty consulta.tg and not empty consulta.classificacaoTg}">
								<td>${consulta.tg }</td>
								<td>${consulta.classificacaoTg }</td>
							</c:if>
							<c:if
								test="${empty consulta.tg and empty consulta.classificacaoTg}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>
						<tr>
							<td><strong>HB: </strong></td>
							<c:if
								test="${not empty consulta.hb and not empty consulta.classificacaoHb}">
								<td>${consulta.hb }</td>
								<td>${consulta.classificacaoHb }</td>
							</c:if>
							<c:if
								test="${empty consulta.hb and empty consulta.classificacaoHb}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>

						<tr>
							<td><strong>TGO(AST): </strong></td>
							<c:if
								test="${not empty consulta.tgo and not empty consulta.classificacaoTgo}">
								<td>${consulta.tgo }</td>
								<td>${consulta.classificacaoTgo }</td>
							</c:if>
							<c:if
								test="${empty consulta.tgo and empty consulta.classificacaoTgo}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>
						<tr>
							<td><strong>TGP(ALT): </strong></td>
							<c:if
								test="${not empty consulta.tgp and not empty consulta.classificacaoTgp}">
								<td>${consulta.tgp }</td>
								<td>${consulta.classificacaoTgp }</td>
							</c:if>
							<c:if
								test="${empty consulta.tgp and empty consulta.classificacaoTgp}">
								<td colspan="2">Não informado</td>
							</c:if>
						</tr>
					</tbody>
				</table>
				<label><strong> Informações Complementares:</strong></label>
				<c:choose>
					<c:when
						test="${not empty consulta.informacoesComplementaresExames}">
						<span>${consulta.informacoesComplementaresExames}</span>
					</c:when>
					<c:otherwise>
						<span class="alert alert-dismissible alert-default">Não há
							informação complementar.</span>
					</c:otherwise>
				</c:choose>

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
						<div class="alert alert-dismissible alert-default">Esta
							consulta não possui documento(s) anexado(s) a ela.</div>
					</c:otherwise>
				</c:choose>

				<h3 id="inquerito" class="section">Inquerito Alimentar</h3>

				<table class="table table-striped">
					<thead class="thead">
						<tr>
							<th>Alimentos</th>
							<th>Frequencia</th>
							<th>Anotação</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Bovina</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.bovinaFrequenciaSemanal and consulta.inqueritoAlimentar.bovinaAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.bovinaFrequenciaSemanal and not empty consulta.inqueritoAlimentar.bovinaAnotacao}">
								<td>${consulta.inqueritoAlimentar.bovinaFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.bovinaAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Aves</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.avesFrequenciaSemanal and consulta.inqueritoAlimentar.avesAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.avesFrequenciaSemanal and not empty consulta.inqueritoAlimentar.avesAnotacao}">
								<td>${consulta.inqueritoAlimentar.avesFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.avesAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Peixe</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.peixeFrequenciaSemanal and consulta.inqueritoAlimentar.peixeAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.peixeFrequenciaSemanal and not empty consulta.inqueritoAlimentar.peixeAnotacao}">
								<td>${consulta.inqueritoAlimentar.peixeFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.peixeAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Visceras</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.viscerasFrequenciaSemanal and consulta.inqueritoAlimentar.viscerasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.viscerasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.viscerasAnotacao}">
								<td>${consulta.inqueritoAlimentar.viscerasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.viscerasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Leite e Derivados</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.leiteDerivadosFrequenciaSemanal and consulta.inqueritoAlimentar.leiteDerivadosAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.leiteDerivadosFrequenciaSemanal and not empty consulta.inqueritoAlimentar.leiteDerivadosAnotacao}">
								<td>${consulta.inqueritoAlimentar.leiteDerivadosFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.leiteDerivadosAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Ovos</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.ovosFrequenciaSemanal and consulta.inqueritoAlimentar.ovosAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.ovosFrequenciaSemanal and not empty consulta.inqueritoAlimentar.ovosAnotacao}">
								<td>${consulta.inqueritoAlimentar.ovosFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.ovosAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Leguminosas</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.leguminosasFrequenciaSemanal and consulta.inqueritoAlimentar.leguminosasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.leguminosasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.leguminosasAnotacao}">
								<td>${consulta.inqueritoAlimentar.leguminosasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.leguminosasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Cereais</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.cereaisFrequenciaSemanal and consulta.inqueritoAlimentar.cereaisAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.cereaisFrequenciaSemanal and not empty consulta.inqueritoAlimentar.cereaisAnotacao}">
								<td>${consulta.inqueritoAlimentar.cereaisFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.cereaisAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Massas</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.massasFrequenciaSemanal and consulta.inqueritoAlimentar.massasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.massasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.massasAnotacao}">
								<td>${consulta.inqueritoAlimentar.massasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.massasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Vegetais Crus</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.vegetaisCrusFrequenciaSemanal and consulta.inqueritoAlimentar.vegetaisCrusAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.vegetaisCrusFrequenciaSemanal and not empty consulta.inqueritoAlimentar.vegetaisCrusAnotacao}">
								<td>${consulta.inqueritoAlimentar.vegetaisCrusFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.vegetaisCrusAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Vegetais Cozidos</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.vegetaisCozidosFrequenciaSemanal and consulta.inqueritoAlimentar.vegetaisCozidosAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.vegetaisCozidosFrequenciaSemanal and not empty consulta.inqueritoAlimentar.vegetaisCozidosAnotacao}">
								<td>${consulta.inqueritoAlimentar.vegetaisCozidosFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.vegetaisCozidosAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Frutas</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.frutasFrequenciaSemanal and consulta.inqueritoAlimentar.frutasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.frutasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.frutasAnotacao}">
								<td>${consulta.inqueritoAlimentar.frutasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.frutasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Doces</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.docesFrequenciaSemanal and consulta.inqueritoAlimentar.docesAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.docesFrequenciaSemanal and not empty consulta.inqueritoAlimentar.docesAnotacao}">
								<td>${consulta.inqueritoAlimentar.docesFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.docesAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Óleo</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.oleoFrequenciaSemanal and consulta.inqueritoAlimentar.oleoAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.oleoFrequenciaSemanal and not empty consulta.inqueritoAlimentar.oleoAnotacao}">
								<td>${consulta.inqueritoAlimentar.oleoFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.oleoAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Margarina</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.margarinaFrequenciaSemanal and consulta.inqueritoAlimentar.margarinaAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.margarinaFrequenciaSemanal and not empty consulta.inqueritoAlimentar.margarinaAnotacao}">
								<td>${consulta.inqueritoAlimentar.margarinaFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.margarinaAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Manteiga</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.manteigaFrequenciaSemanal and consulta.inqueritoAlimentar.manteigaAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.manteigaFrequenciaSemanal and not empty consulta.inqueritoAlimentar.manteigaAnotacao}">
								<td>${consulta.inqueritoAlimentar.manteigaFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.manteigaAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Toucinho/Bacon</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.toucinhoBaconFrequenciaSemanal and consulta.inqueritoAlimentar.toucinhoBaconAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.toucinhoBaconFrequenciaSemanal and not empty consulta.inqueritoAlimentar.toucinhoBaconAnotacao}">
								<td>${consulta.inqueritoAlimentar.toucinhoBaconFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.toucinhoBaconAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Água</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.aguaFrequenciaSemanal and consulta.inqueritoAlimentar.aguaAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.aguaFrequenciaSemanal and not empty consulta.inqueritoAlimentar.aguaAnotacao}">
								<td>${consulta.inqueritoAlimentar.aguaFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.aguaAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Suco</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.sucoFrequenciaSemanal and consulta.inqueritoAlimentar.sucoAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.sucoFrequenciaSemanal and not empty consulta.inqueritoAlimentar.sucoAnotacao}">
								<td>${consulta.inqueritoAlimentar.sucoFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.sucoAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Bebidas Acoólicas</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.bebidasAlcoolicasFrequenciaSemanal and consulta.inqueritoAlimentar.bebidasAlcoolicasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.bebidasAlcoolicasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.bebidasAlcoolicasAnotacao}">
								<td>${consulta.inqueritoAlimentar.bebidasAlcoolicasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.bebidasAlcoolicasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Bebidas Gaseificadas</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.gaseificadasFrequenciaSemanal and consulta.inqueritoAlimentar.gaseificadasAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.gaseificadasFrequenciaSemanal and not empty consulta.inqueritoAlimentar.gaseificadasAnotacao}">
								<td>${consulta.inqueritoAlimentar.gaseificadasFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.gaseificadasAnotacao}</td>
							</c:if>
						</tr>

						<tr>
							<td>Infusões</td>
							<c:if
								test="${empty consulta.inqueritoAlimentar.infusoesFrequenciaSemanal and consulta.inqueritoAlimentar.infusoesAnotacao == 0}">
								<td colspan="2"></td>
							</c:if>
							<c:if
								test="${not empty consulta.inqueritoAlimentar.infusoesFrequenciaSemanal and not empty consulta.inqueritoAlimentar.infusoesAnotacao}">
								<td>${consulta.inqueritoAlimentar.infusoesFrequenciaSemanal}</td>
								<td>${consulta.inqueritoAlimentar.infusoesAnotacao}</td>
							</c:if>
						</tr>
					</tbody>
				</table>



			</div>
		</div>
	

	<jsp:include page="../modulos/footer.jsp" />
	<script
		src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

	<script type="text/javascript">
		$('#menu-paciente').addClass('active');
	</script>

</body>
</html>
