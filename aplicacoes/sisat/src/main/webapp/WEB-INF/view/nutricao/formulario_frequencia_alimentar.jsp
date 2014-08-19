<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
    <jsp:include page="../modulos/header-estrutura.jsp" />
    <title>Frequência Alimentar</title>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <jsp:include page="../modulos/header.jsp" />
     
     <div class="container">
		<div class="frequencia-alimentar" align="left">
			<div class="form" align="center">
               <h2>Formulario para Frequência Alimentar</h2>
				<form:form id="frequenciaAlimentar" role="form" commandName="frequenciaAlimentar" servletRelativeAction="/nutricao/formulario_frequência_alimentar" method="POST" cssClass="form-horizontal">
				
				     <div class="form-group">
						   <label for="horario" class="col-sm-2 control-label">Horário:</label>
						   <div class="col-sm-5">
						   <form:input id="horario" path="horario" cssClass="form-control" placeholder="Horario"/>
						   </div>
						</div>
					
					<div class="form-group">
						<label for="preparacaoAlmoco" class="col-sm-2 control-label">Preparar o Alimento:</label>
						<div class="col-sm-5">
							<form:textarea id="preparacaoAlmoco" path="preparacaoAlmoco" cssClass="form-control"  placeholder="Digite o Alimento" ></form:textarea>
						</div>
					</div>

		  <div class="checkbox">
                
              <label for="Refeicao" class="col-sm-2 control-label"> Almoço: </label>
              <div class="col-sm-5">
              <input type="checkbox">
     </div>
        </div>
					
					
					
					
					<div class="form-group">
						<label for="porcao" class="col-sm-2 control-label">Porção:</label>
						<div class="col-sm-5">
							<form:input id="porcao" path="porcao" cssClass="form-control" placeholder="Digite a Porção"/>
						</div>
					</div>
					
					
					
					
					<div class="controls">
						<input name="submit" type="submit" class="btn btn-primary" value="Cadastrar" />
						<a href="<c:url value="/projeto/index"></c:url>" class="btn btn-default">Cancelar</a>
					</div>
					</div>
	        </form:form>
	</div> 
	
	<jsp:include page="../modulos/footer.jsp" />            
</body>
</html>