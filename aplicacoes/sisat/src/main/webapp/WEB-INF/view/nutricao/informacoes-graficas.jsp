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
		<title>Informações Gráficas</title>
	</head>
<body>
	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
		<h3>Informações Gráficas</h3>
		<div id="patologiasFrequentes" style="width:100%; height:400px;"></div>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">

	$(function () { 
		
		$('#menu-graficos').addClass('active');
		
		$.ajax({
			url: '/sisat/nutricao/informacoes-graficas/patologias-frequentes.json',
			type: "GET",
			success: function(result) {
				  var dataJson = result;
				  var objJson;
				  var data;

				  objJson = '['
				  for (var key in dataJson.patologias) {
				      objJson = objJson + '{ "patologia":"'+ key +'", "pacientes":'+dataJson.patologias[key]+'}';
				  }
				  data = JSON.parse(objJson.replace(/}{/g,'}, {') + ']');

				//Definição da dimensão do gráfico
				var margin = {top: 20, right: 20, bottom: 70, left: 40},
				    width = 1100 - margin.left - margin.right,
				    height = 400 - margin.top - margin.bottom;

				//Definição dos vetores x e y do gráfico
				var x = d3.scale.ordinal().rangeRoundBands([0, width], .8);
				var y = d3.scale.linear().range([height, 0]);

				//Posicionamento do vetores
				var xAxis = d3.svg.axis()
				    .scale(x)
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
				    return "<strong>Pacientes:</strong> <span style='color:steelblue'>" + d.pacientes + "</span>";
				  })

				//Selecionar estrutura onde será localizado o gráfico
				var marginLeftAdjust = margin.left - 10;
				var svg = d3.select("#patologiasFrequentes").append("svg")
				    .attr("width", width + margin.left + margin.right)
				    .attr("height", height + margin.top + margin.bottom)
				    .append("g")
				    .attr("transform", 
				          "translate(" + marginLeftAdjust + "," + margin.top + ")");

				  //chamar Tooltip com informação individual da patologia.
				  svg.call(tip);

				  //Definindo dominio do gráfico
				  x.domain(data.map(function(d) { return d.patologia; }));
				  y.domain([0, 2*d3.max(data, function(d) { return d.pacientes; })]);

				  //Definição do eixo Y
				  var gy = svg.append("g")
				    .attr("class", "y axis")
				    .call(yAxis)
				    .append("text")
				      .attr("transform", "rotate(-90)")
				      .attr("y", 6)
				      .attr("dy", "-2em")
				      .style("text-anchor", "end")
				      .text("Quantidade de pacientes (nº)");
				  
				  //Titulo
				  svg.append("g")
				  	 .attr("class", "title")
				  	 .append("text")
				  	 	.attr("y",-9)
				  	 	.attr("dx", "35em")
				  	 	.style("text-anchor", "end")
				  	 	.text("Patologias mais frequentes");

				  //Definição do eixo X
				  svg.append("g")
				      .attr("class", "x axis")
				      .attr("transform", "translate(0," + height + ")")
				      .call(xAxis)
				    .selectAll("text");

				  //Definição do plot das barras
				  svg.selectAll(".bar")
				      .data(data)
				      .enter().append("rect")
				      .attr("class", "bar")
				    .transition()
				      .delay(function(d, i) { return i * 100; })
				      .duration(200)
				      .attr("x", function(d) { return x(d.patologia); })
				      .attr("width", x.rangeBand())
				      .attr("y", function(d) { return y(d.pacientes); })
				      .attr("height", function(d) { return height - y(d.pacientes); });

				  //Ação do Tooltipe em cada barra
				  svg.selectAll(".bar")
				      .on('mouseover', tip.show)
				      .on('mouseout', tip.hide);				
			}
		});
    });
	</script>

</body>
</html>