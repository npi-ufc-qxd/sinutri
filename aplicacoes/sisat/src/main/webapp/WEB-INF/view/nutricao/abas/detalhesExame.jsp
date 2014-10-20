<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
</div> 