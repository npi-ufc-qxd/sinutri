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
		<div id="chart" style="width:100%; height:400px;"></div>
		
		<div id="patologiasFrequentes" style="width:100%; height:400px;"></div>
		
		<div id="cursosFrequentes" style="width:100%; height:400px;"></div>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">

	$(function () { 
	    $('#patologiasFrequentes').highcharts({
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: 'Patologias mais frequentes'
	        },
	        xAxis: {
	            categories: ['pato1','pato2','pato3','pato4','pato5','pato6']
	        },
	        yAxis: {
	            title: {
	                text: 'Número de Alunos(as)'
	            }
	        },
	        series: [{
	        	name: 'CC',
	            data: [1,2,3,4,5,6]
	        }, {
	        	name: 'DD',
	            data: [1,2,3,4,5,6]
	        }, {
	        	name: 'EC',
	            data: [1,2,3,4,5,6]
	        }, {
	        	name: 'ES',
	            data: [1,2,3,4,5,6]
	        }, {
	        	name: 'RC',
	            data: [1,2,3,4,5,6]
	        }, {
	        	name: 'SI',
	            data: [1,2,3,4,5,6]
	        }]
	    });
	});	
	
	function graficoPesoByConsulta() {
			$.ajax({
				url: '/sisat/nutricao/informacoes-graficas/peso-by-consulta.json',
				type: "GET",
				success: function(result) {
					var obj = result;
					var cat = [];
					var data = [];
					for (var key in obj.consulta) {
						cat.push(key);
						data.push( {name: "Chrome", y: data.push(obj.consulta[key].peso), drilldown: "Chrome" });
			        }

					$('#chart').highcharts({
				        chart: {
				            type: 'column'
				        },
				        plotOptions: {
				            series: {
				                borderWidth: 0,
				                dataLabels: {
				                    enabled: true,
				                    format: '{point.y:.1f} kg'
				                }
				            }
				        },
				        tooltip: {
				            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
				            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f} kg</b><br/>'
				        },
				        
				        title: {
				            text: 'Peso'
				        },
				        xAxis: {
				        	title: {
				        		text: 'Data'
				        	},
				            categories: cat
				        },
				        yAxis: {
				            title: {
				                text: 'Peso'
				            }
				        },
				        series: [{
				            name: 'Peso',
				            data: data
				        }]
				    });
				},
				error: function(error) {
					alert('error')
				}
			});
	};	
	
    $('#cursosFrequentes').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Browser market shares January, 2015 to May, 2015'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            name: "Brands",
            colorByPoint: true,
            data: [{
                name: "CC",
                y: 25,
                legend: {
                	title: 'yyyyyyyyyyyyyyyyyy',
                }
            }, {
                name: "DD",
                y: 24.03,
                sliced: true,
            }, {
                name: "EC",
                y: 25,
            }, {
                name: "ES",
                y: 25,
            }, {
                name: "RC",
                y: 25,
            }, {
                name: "SI",
                y: 25,
            }]
        }]
    });
	
	
	graficoPesoByConsulta();
	</script>

</body>
</html>