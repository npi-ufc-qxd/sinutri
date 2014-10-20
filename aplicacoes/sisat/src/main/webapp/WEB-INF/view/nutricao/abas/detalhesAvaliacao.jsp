<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<td><strong>CC: </strong> ${consulta.circunferenciaCintura}
				${consulta.classificacaoCc}</td>
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
						${consulta.bebidadaAlcoolicaComentario }
						<strong>Vezes por semana: </strong> ${consulta.bebidaAlcoolicaFrequenciaSemanal }
					</c:when>
		<c:otherwise>
			<em>Não consome bebidas alcoolicas.</em>
		</c:otherwise>
	</c:choose>
	<br /> <strong> Patologias: </strong> ${consulta.outrasPatologias ? consulta.outrasPatologiasComentario  : "<em>Não possui outras patologias</em>"}<br />

	<strong> Objetivo da consulta: </strong> ${consulta.objetivoConsulta }<br />
</div>