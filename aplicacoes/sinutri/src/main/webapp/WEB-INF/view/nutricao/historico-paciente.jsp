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
			<div class="col-sm-6"><h3>Paciente <strong>${pessoa.nome }</strong></h3></div>

			<div class="col-sm-6" align="right" style="margin-top: 15px;">
				<a href="<c:url value="/paciente/${pessoa.cpf}/verificar-paciente?acao=consulta"/>" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> Realizar Consulta</a>
				<a href='<c:url value="/nutricao/buscar"></c:url>' class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
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
										<td>${dataFormatada}</a></td>
										
						                <td align="right">
 										  <a href="<c:url value="/paciente/consulta/${consulta.id}/plano-alimentar"></c:url>" class="btn btn-info btn-sm">Plano Alimentar</a> 
 							              <a href="<c:url value="/paciente/consulta/${consulta.id}"/>" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-eye-open"> </> Detalhes </a>
							              <a href="<c:url value="/paciente/${pessoa.getPaciente().getId()}/consulta/${consulta.id}/editar"/>" class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-edit"></span> Editar</a>
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
				
					//Ajuste do json
					  var dataJson = result;
					  var objJson;
					  var data;

					  var histPeso = '[',
					      histIMC = '[',
					      histCC = '[';
					  var histPesoObj,
					      histIMCObj,
					      histCCObj;
					  var i = 0;
					  for (i; i < dataJson.consultas.length; i++) {
					      histPeso = histPeso + '{"value":'+ dataJson.consultas[i].peso.toFixed(2) 
					                          + ', "date":"' + formatDate(dataJson.consultas[i].data)
					                          + '"}';
					      histIMC = histIMC + '{"value":'+ dataJson.consultas[i].imc.toFixed(2)
					                          + ', "date":"' + formatDate(dataJson.consultas[i].data)
					                          + '"}';
					      histCC = histCC + '{"value":'+ dataJson.consultas[i].circunferenciaCintura.toFixed(2)  
					                          + ', "date":"' + formatDate(dataJson.consultas[i].data)
					                          + '"}';
					  }
					  histPeso = histPeso.replace(/}{/g,'}, {') + ']';
					  histIMC = histIMC.replace(/}{/g,'}, {') + ']';
					  histCC = histCC.replace(/}{/g,'}, {') + ']';
					  histPesoObj = JSON.parse(histPeso);
					  histIMCObj = JSON.parse(histIMC);
					  histCCObj = JSON.parse(histCC);
					//
					//Função para desenhar gráficos.
					function drawChart(data,idContainer){

					  //Definição da dimensão do gráfico
					  var margin = {top: 20, right: 20, bottom: 70, left: 40},
					      width = 1140 - margin.left - margin.right,
					      height = 400 - margin.top - margin.bottom;

					  //Definindo titulo do gráfico
					  var titleTpo;
					  if(idContainer=="#historicoPeso"){
					    titleTpo = "Histórico do peso";
					  }else if (idContainer=="#historicoIMC"){
					    titleTpo = "Histórico do IMC"
					  }else{
					    titleTpo = "Histórico da circunferência da cintura";
					  };

					  //Definição dos vetores x e y do gráfico
					  var x = d3.scale.ordinal().rangeRoundBands([0, width], .8);
					  var y = d3.scale.linear().range([height, 0]);

					  //Posicionamento do vetores
					  var xAxis = d3.svg.axis()
					    .scale(x)
					    .tickSize(-height)
					    .orient("bottom");

					  var yAxis = d3.svg.axis()
					    .scale(y)
					    .tickSize(width)
					    .orient("right");

					  //Tooltip exibir número de pacientes por barra
					var tip = d3.tip()
					  .attr('class', 'd3-tip')
					  .offset([-10, 0])
					  .html(function(d) {
					    return "<span style='color:white'>" + d.value + "</span>";
					  })

					  //Selecionar estrutura onde será localizado o gráfico
					  var svg = d3.select(idContainer).append("svg")
					    .attr("width", width + margin.left + margin.right)
					    .attr("height", height + margin.top + margin.bottom)
					    .append("g")
					    .attr("transform", 
					          "translate(" + (margin.left-6) + "," + margin.top + ")");

					  //chamar Tooltip com informação individual da patologia.
					  svg.call(tip);

					  //Definindo dominio do gráfico
					  x.domain(data.map(function(d) { return d.date; }));
					  y.domain([0, (1.5)*d3.max(data, function(d) { return d.value; })]);

					  //Definição do eixo Y
					  var gy = svg.append("g")
					    .attr("class", "y axis")
					    .call(yAxis)
					    .append("text")
					      .attr("class","titleText")
					      .text(titleTpo)
					      .attr("x",(width/3));

					  //Definição do eixo X
					  svg.append("g")
					      .attr("class", "x axis")
					      .attr("transform", "translate(0," + height + ")")
					      .call(xAxis)
					    .selectAll("text");

					  var line = d3.svg.line()
					    .interpolate("cardinal")
					    .x(function(d) { return x(d.date)+38; })
					    .y(function(d) { return y(d.value); });

					  svg.append("path")
					      .datum(data)
					      .attr("class", "line")
					      .attr("d", line);

					  //punti lungo il tracciato
					    var point = svg.append("g")
					        .attr("class", "line-point");

					    point.selectAll('circle')
					        .data(data)
					        .enter().append('circle')
					        .attr("cx", function(d, i) { return x(d.date)+38; })
					        .attr("cy", function(d, i) { return y(d.value) })
					        .attr("r", 5);

					    //Ação do Tooltipe em cada barra
					    svg.selectAll("circle")
					      .on('mouseover', tip.show)
					      .on('mouseout', tip.hide);

					}

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

					drawChart(histPesoObj,"#historicoPeso");
					drawChart(histIMCObj,"#historicoIMC");
					drawChart(histCCObj,"#historicoCC");
					
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
