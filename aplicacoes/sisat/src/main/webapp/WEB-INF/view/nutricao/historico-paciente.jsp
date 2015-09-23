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
			<div class="col-sm-6"><h2>Paciente <strong>${pessoa.nome }</strong></h2></div>

			<div class="col-sm-6" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary back"><span class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
				<a href="<c:url value="/consulta/realizar-consulta/${pessoa.cpf}"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Realizar Consulta</a>
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

	<div class="container">
		<h3>Informações Gráficas</h3>
		
		<input id="cpf" type="hidden" value="${pessoa.cpf}">

		<div id="historicoPeso" style="width:100%; height:400px;"></div><br>
		
		<div id="historicoIMC" style="width:100%; height:400px;"></div><br>
		
		<div id="historicoCC" style="width:100%; height:400px;"></div><br>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	<script type="text/javascript">
		$(function () { 
			$('#menu-paciente').addClass('active');
			
			var cpf = $("#cpf").val();
			
			$.ajax({
				url: '/sisat/nutricao/informacoes-graficas/paciente/'+ cpf +'/historico-consultas.json',
				type: "GET",
				success: function(result) {
					var obj = result;
					var cat = [];
					var catCC = [];
					var catIMC = [];
					
					var dataPesos = [];
					var dataIMC = [];
					var dataCC = [];
					var i = 1;
	
					$.each( obj.consultas, function( index, value ) {
						cat.push(index+1 + "ª Consulta<br>" + formatDate(value.data));
						catCC.push(value.classificacaoCC + "<br>" + (index + 1) + "ª Consulta<br>" + formatDate(value.data));
						catIMC.push(value.classificacaoIMC + "<br>" + (index + 1) + "ª Consulta<br>" + formatDate(value.data));
	
						dataPesos.push(value.peso);
						dataCC.push(value.circunferenciaCintura);
						dataIMC.push(value.imc);
					});				
					
				    $('#historicoPeso').highcharts({
				        title: {
				            text: 'Histórico do Peso',
				        },
				        xAxis: {
				            categories: cat
				        },
				        yAxis: {
				            title: {
				                text: ''
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }],		            
				        },
				        tooltip: {
				            valueSuffix: 'kg'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				        	name: 'Peso',
				            data: dataPesos
				        }]
				    });
				    
				    $('#historicoIMC').highcharts({
				        title: {
				            text: 'Histórico IMC',
				        },
				        xAxis: {
				            categories: catIMC
				        },
				        yAxis: {
				            title: {
				                text: ''
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				        	name: 'IMC',
				            data: dataIMC
				        }]
				    });
				    
				    $('#historicoCC').highcharts({
				        title: {
				            text: 'Histórico CC',
				        },
				        xAxis: {
				            categories: catCC
				        },
				        yAxis: {
				            title: {
				                text: ''
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				        	name: 'CC',
				            data: dataCC
				        }]
				    });
				}
			});
		});
	
		function formatDate(dateObject) {
		    var d = new Date(dateObject);
		    var day = d.getDate();
		    var month = d.getMonth() + 1;
		    var year = d.getFullYear();
		    if (day < 10) {
		        day = "0" + day;
		    }
		    if (month < 10) {
		        month = "0" + month;
		    }
		    var date = day + "/" + month + "/" + year;
	
		    return date;
		};
	</script>	
	
</body>
</html>
