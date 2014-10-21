<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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