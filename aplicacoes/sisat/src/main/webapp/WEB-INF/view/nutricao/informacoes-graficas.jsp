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
<!-- 		<div id="chart" style="width:100%; height:400px;"></div> -->
		
		<div id="patologiasFrequentes" style="width:100%; height:400px;"></div>
		
<!-- 		<div id="cursosFrequentes" style="width:100%; height:400px;"></div> -->
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">

	$(function () { 
		$.ajax({
			url: '/sisat/nutricao/informacoes-graficas/patologias-frequentes.json',
			type: "GET",
			success: function(result) {
				var obj = result;
				var cat = [];
				var data = [];
				for (var key in obj.patologias) {
					cat.push(key);
					data.push(obj.patologias[key])
		        }

				$('#patologiasFrequentes').highcharts({
			        chart: {
			            type: 'bar'
			        },
			        title: {
			            text: 'Patologias mais frequentes'
			        },
			        xAxis: {
			            categories: cat
			        },
			        yAxis: {
			            title: {
			                text: 'Número de Pacientes'
			            }
			        },
			        series: [{
			        	name: 'Total de pacientes',
			            data: data
			        }]
			    });				
			}
		});
    });
	</script>

</body>
</html>