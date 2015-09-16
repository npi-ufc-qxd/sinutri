<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<jsp:include page="../modulos/header-estrutura.jsp" />
		<title>Historico</title>
	</head>

<body>
	<jsp:include page="../modulos/header.jsp" />


	<div class="container">
	    <div class="row">
			<div class="col-sm-6"><h2>Paciente: ${pessoa.nome }</h2></div>

			<div class="col-sm-6" align="right" style="margin-top: 15px;">
				<a href="<c:url value="/nutricao/buscar"></c:url>" class="btn btn-primary">Voltar</a>
				<a href="<c:url value="/consulta/realizar-consulta/${pessoa.cpf}"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Realizar Consulta</a>
				<a href="<c:url value="/nutricao/informacoes-graficas/paciente/${pessoa.cpf}"/>" class="btn btn-info"><span class="fa fa-line-chart"></span> Gráficos</a>
			</div>
    	</div>
	
	    <div class="row">
	  	  <div class="col-sm-5">
	    
		    <h4><b>Informações do Paciente</b></h4>

		    <ul class="list-group">
		        <li class="list-group-item"><b>Email:</b> ${pessoa.email }</li>
		        <li class="list-group-item"><b>Telefone:</b> ${pessoa.telefone }</li>        
		        <li class="list-group-item"><b>Sexo:</b> <c:out value="${pessoa.sexo eq 'F' ? 'Feminino' : 'Masculino'}"></c:out></li>
		        <li class="list-group-item"><b>Idade:</b> ${pessoa.idade }</li>
		    </ul>
		</div>	        

	        <div class="col-sm-7">
				    <h4><b>Histórico de Consultas</b></h4>
					<c:if test="${not empty pessoa.paciente.consultas}">
		
					    <table class="table table-striped">
					        <thead class="thead">
					            <tr>
					                <th>ª Consulta</th>
									<th>Data</th>
					                <th></th>
					            </tr>
					        </thead>
					        <tbody>
								<c:forEach var="consulta" items="${pessoa.paciente.consultas}" varStatus="cont">
									<fmt:formatDate var="dataFormatada" type="both" pattern="dd/MM/yyyy HH:mm" value="${consulta.data}" />
						            <tr>
						                <td>${cont.count }ª Consulta</td>
										<td><a href="<c:url value="/consulta/informacoes-consulta/${consulta.id}"/>">${dataFormatada}</a></td>
		
						                <td align="right">
							              <a href="<c:url value="/consulta/relatorio-orientacoes/${consulta.id}"/>" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-file"></span> Relatorio</a>
							              <a href="<c:url value="/consulta/editar-consulta/${consulta.id}/paciente/${consulta.paciente.pessoa.cpf}"/>" class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-edit"></span> Editar</a>
						                </td>
						            </tr>
								</c:forEach>
					        </tbody>
					    </table>
					</c:if>

					<c:if test="${empty pessoa.paciente.consultas}">
						<div class="alert alert-warning" role="alert">Não há consultas cadastradas para esse paciente.</div>
					</c:if>
  				</div>
  				</div>
  				</div>


	<jsp:include page="../modulos/footer.jsp" />
	
</body>
</html>
