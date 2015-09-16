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
		
		<input id="cpf" type="hidden" value="${idPaciente}">

		<div id="historicoPeso" style="width:100%; height:400px;"></div><br>
		
		<div id="historicoIMC" style="width:100%; height:400px;"></div><br>
		
		<div id="historicoCC" style="width:100%; height:400px;"></div><br>
	</div>
	
	<jsp:include page="../modulos/footer.jsp" />
	
	<script type="text/javascript">

	$(function () { 
		
		var cpf = $("#cpf").val();
		
		$.ajax({
			url: '/sisat/nutricao/informacoes-graficas/paciente/'+ cpf +'/historico-peso.json',
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

				$.each( obj.pesos, function( index, value ) {
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
	
	
	
	
	
	
	
	
// 		$.ajax({
// 			url: '/sisat/nutricao/informacoes-graficas/peso-by-consulta.json',
// 			type: "GET",
// 			success: function(result) {
// 				var obj = result;
// 				var cat = [];
// 				var data = [];
// 				for (var key in obj.consulta) {
// 					cat.push(key);
// 					data.push( {name: "Chrome", y: data.push(obj.consulta[key].peso), drilldown: "Chrome" });
// 		        }

// 				$('#historicoCC').highcharts({
// 			        chart: {
// 			            type: 'column'
// 			        },
// 			        plotOptions: {
// 			            series: {
// 			                borderWidth: 0,
// 			                dataLabels: {
// 			                    enabled: true,
// 			                    format: '{point.y:.1f} kg'
// 			                }
// 			            }
// 			        },
// 			        tooltip: {
// 			            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
// 			            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f} kg</b><br/>'
// 			        },
			        
// 			        title: {
// 			            text: 'Peso'
// 			        },
// 			        xAxis: {
// 			        	title: {
// 			        		text: 'Data'
// 			        	},
// 			            categories: cat
// 			        },
// 			        yAxis: {
// 			            title: {
// 			                text: 'Peso'
// 			            }
// 			        },
// 			        series: [{
// 			            name: 'Peso',
// 			            data: data
// 			        }]
// 			    });
// 			},
// 			error: function(error) {
// 				alert('error')
// 			}
// 		});

// 	    $('#historicoIMC').highcharts({
// 	        chart: {
// 	            plotBackgroundColor: null,
// 	            plotBorderWidth: null,
// 	            plotShadow: false,
// 	            type: 'pie'
// 	        },
// 	        title: {
// 	            text: 'Browser market shares January, 2015 to May, 2015'
// 	        },
// 	        tooltip: {
// 	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
// 	        },
// 	        plotOptions: {
// 	            pie: {
// 	                allowPointSelect: true,
// 	                cursor: 'pointer',
// 	                dataLabels: {
// 	                    enabled: false
// 	                },
// 	                showInLegend: true
// 	            }
// 	        },
// 	        series: [{
// 	            name: "Brands",
// 	            colorByPoint: true,
// 	            data: [{
// 	                name: "CC",
// 	                y: 25,
// 	                legend: {
// 	                	title: 'yyyyyyyyyyyyyyyyyy',
// 	                }
// 	            }, {
// 	                name: "DD",
// 	                y: 24.03,
// 	                sliced: true,
// 	            }, {
// 	                name: "EC",
// 	                y: 25,
// 	            }, {
// 	                name: "ES",
// 	                y: 25,
// 	            }, {
// 	                name: "RC",
// 	                y: 25,
// 	            }, {
// 	                name: "SI",
// 	                y: 25,
// 	            }]
// 	        }]
// 	    });
// 	});	
	</script>

</body>
</html>