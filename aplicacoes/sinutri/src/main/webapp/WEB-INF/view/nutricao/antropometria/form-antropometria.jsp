<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${action eq 'cadastrar' }">
	<c:url var="url" value="/paciente/${avaliacaoAntropometrica.paciente.pessoa.cpf}/Antropometria"></c:url>
	<c:set var="titulo" value="Nova Avaliação Antropometrica "></c:set>
	<c:set var="botao" value="Finalizar Avaliação Antropometrica "></c:set>
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url" value="/paciente/${avaliacaoAntropometrica.paciente.pessoa.cpf}/Antropometria/${avaliacaoAntropometrica.id}/editar"></c:url>
	<c:set var="titulo" value="Editar Avaliação Antropometrica "></c:set>
	<c:set var="botao" value="Atualizar Avaliação Antropometrica"></c:set>
</c:if>

<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastrar Avaliação Antropometrica</title>
	<jsp:include page="../../modulos/header-estrutura.jsp" />
</head>
<body>
	<jsp:include page="../../modulos/header.jsp" />
	<div class="container">
		<c:if test="${not empty erro}">
			<div class="alert alert-danger alert-dismissible fade in"
				role="alert" id="alert-erro">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${erro}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty info}">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert" id="alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${info}"></c:out>
			</div>
		</c:if>
		
		<div class="row">
			<div class="col-sm-9">
				<h3>${titulo}
					<strong>${avaliacaoAntropometrica.paciente.pessoa.nome}</strong>
				</h3>
			</div>

			<div class="col-sm-3" align="right" style="margin-top: 15px;">
				<a href="#" class="btn btn-primary btn-sm back"><span
					class="glyphicon glyphicon-chevron-left"></span> Voltar</a>
			</div>
		</div>
		
		<div class="row">
		<div class="panel-group" id="accordionAntropometria">
			<form:form servletRelativeAction="${url}" method="POST"
					id="form-antropometria" modelAttribute="avaliacaoAntropometrica"
					commandName="avaliacaoAntropometrica" acceptCharset="UTF-8"
					cssClass="form-horizontal" enctype="multipart/form-data">
				<form:hidden path="id" />
				<form:hidden path="atualizadoEm" />
				<form:hidden path="nutricionista.id" />
				<form:hidden path="paciente.id" />
				<div class="panel panel-primary">
					<div class="panel-heading">
				        <h4 class="panel-title">
				        	<a data-toggle="collapse" data-parent="#accordionAntropometria" href="#collapse1">GERAL</a>
				        </h4>
				    </div>
				    <div id="collapse1" class="panel-collapse collapse in">
						<div class="panel-body">	
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="criadoEm" class="control-label"> <i
										style="color: #F56954;" class="glyphicon glyphicon-asterisk"></i>
										Data:
									</label>
									<form:input id="criadoEm" path="criadoEm" class="form-control datepicker"
										placeholder="dd/mm/aaaa" type="date"/>
									<div class="error-validation">
										<form:errors path="criadoEm"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="altura" class="control-label">
										Altura (m):</label>
									<form:input type="number" id="altura" name="altura" path="altura"
										cssClass="form-control valid-num" min="0" placeholder="0.00" />
									<div class="error-validation">
										<form:errors path="altura"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="peso" class="control-label">
										Peso (Kg):</label>
									<form:input type="number" id="peso" name="peso" path="peso"
										cssClass="form-control valid-num" min="0" placeholder="00.00" />
									<div class="error-validation">
										<form:errors path="peso"></form:errors>
									</div>
								</div>
								<div class="form-item col-sm-3">
									<label for="pesoDesejado" class="control-label">
										Peso desejado (Kg):</label>
									<form:input id="pesoDesejado" name="pesoDesejado"
										path="pesoDesejado" type="number"
										cssClass="form-control valid-num" min="0" placeholder="00.00" />
									<div class="error-validation">
										<form:errors path="pesoDesejado"></form:errors>
									</div>
								</div>
							</div>
							
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="cintura" class="control-label">
										Cintura (cm):
									</label>
									<form:input id="cintura" name="cintura"
										placeholder="00.00" path="cintura" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="cintura"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="abdomen" class="control-label">
										Abdomen (cm):
									</label>
									<form:input id="abdomen" name="abdomen"
										placeholder="00.00" path="abdomen" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="abdomen"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="quadril" class="control-label">
										Quadril (cm):
									</label>
									<form:input id="quadril" name="quadril"
										placeholder="00.00" path="quadril" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="quadril"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="punho" class="control-label">
										Punho (cm):
									</label>
									<form:input id="punho" name="punho"
										placeholder="00.00" path="punho" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="punho"></form:errors>
									</div>
								</div>
							</div>
							
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="antebraco" class="control-label">
										Antebraco (cm):
									</label>
									<form:input id="antebraco" name="antebraco"
										placeholder="00.00" path="antebraco" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="antebraco"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-primary">
					<div class="panel-heading">
				        <h4 class="panel-title">
				        	<a data-toggle="collapse" data-parent="#accordionAntropometria" href="#collapse2">CIRCUNFERÊNCIAS</a>
				        </h4>
				    </div>
				    <div id="collapse2" class="panel-collapse collapse">
						<div class="panel-body">
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="ombro" class="control-label">
										Ombro (cm):
									</label>
									<form:input id="ombro" name="ombro"
										placeholder="00.00" path="ombro" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="ombro"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="peitoral" class="control-label">
										Peitoral (cm):
									</label>
									<form:input id="peitoral" name="peitoral"
										placeholder="00.00" path="peitoral" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="peitoral"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="panturrilhaDireita" class="control-label">
										Panturrilha Direita (cm):
									</label>
									<form:input id="panturrilhaDireita" name="panturrilhaDireita"
										placeholder="00.00" path="panturrilhaDireita" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="panturrilhaDireita"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="panturrilhaEsquerda" class="control-label">
										Panturrilha Esquerda (cm):
									</label>
									<form:input id="panturrilhaEsquerda" name="panturrilhaEsquerda"
										placeholder="00.00" path="panturrilhaEsquerda" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="panturrilhaEsquerda"></form:errors>
									</div>
								</div>
								
							</div>
						
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="pescoco" class="control-label">
										Pescoço (cm):
									</label>
									<form:input id="pescoco" name="pescoco"
										placeholder="00.00" path="pescoco" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="pescoco"></form:errors>
									</div>
								</div>
							</div>
							
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="coxaDireita" class="control-label">
										Coxa Direita (cm):
									</label>
									<form:input id="coxaDireita" name="coxaDireita"
										placeholder="00.00" path="coxaDireita" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="coxaDireita"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="coxaEsquerda" class="control-label">
										Coxa Esquerda (cm):
									</label>
									<form:input id="coxaEsquerda" name="coxaDireita"
										placeholder="00.00" path="coxaEsquerda" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="coxaEsquerda"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="coxaProximalDireita" class="control-label">
										Coxa Proximal Direita (cm):
									</label>
									<form:input id="coxaProximalDireita" name="coxaProximalDireita"
										placeholder="00.00" path="coxaProximalDireita" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="coxaProximalDireita"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="coxaProximalEsquerda" class="control-label">
										Coxa Proximal Esquerda (cm):
									</label>
									<form:input id="coxaProximalEsquerda" name="coxaProximalDireita"
										placeholder="00.00" path="coxaProximalEsquerda" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="coxaProximalEsquerda"></form:errors>
									</div>
								</div>
							</div>
							
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="bracoRelaxadoDireito" class="control-label">
										Braco Relaxado Direito (cm):
									</label>
									<form:input id="bracoRelaxadoDireito" name="bracoRelaxadoDireito"
										placeholder="00.00" path="bracoRelaxadoDireito" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="bracoRelaxadoDireito"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="bracoRelaxadoEsquerdo" class="control-label">
										Braco Relaxado Esquerdo (cm):
									</label>
									<form:input id="bracoRelaxadoEsquerdo" name="bracoRelaxadoEsquerdo"
										placeholder="00.00" path="bracoRelaxadoEsquerdo" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="bracoRelaxadoEsquerdo"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="bracoContraidoDireito" class="control-label">
										Braco Contraído Direito (cm):
									</label>
									<form:input id="bracoContraidoDireito" name="bracoContraidoDireito"
										placeholder="00.00" path="bracoContraidoDireito" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="bracoContraidoDireito"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="bracoContraidoEsquerdo" class="control-label">
										Braco Contraido Esquerdo (cm):
									</label>
									<form:input id="bracoContraidoEsquerdo" name="bracoContraidoEsquerdo"
										placeholder="00.00" path="bracoContraidoEsquerdo" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="bracoContraidoEsquerdo"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-primary">
					<div class="panel-heading">
				        <h4 class="panel-title">
				        	<a data-toggle="collapse" data-parent="#accordionAntropometria" href="#collapse3">DiÂMETROS ÓSSEOS</a>
				        </h4>
				    </div>
				    <div id="collapse3" class="panel-collapse collapse">
						<div class="panel-body">
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="diametroPunho" class="control-label">
										Diametro Punho (cm):
									</label>
									<form:input id="diametroPunho" name="diametroPunho"
										placeholder="00.00" path="diametroPunho" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="diametroPunho"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="diametroFemur" class="control-label">
										Diametro Fêmur (cm):
									</label>
									<form:input id="diametroFemur" name="diametroFemur"
										placeholder="00.00" path="diametroFemur" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="diametroFemur"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-primary">
					<div class="panel-heading">
				        <h4 class="panel-title">
				        	<a data-toggle="collapse" data-parent="#accordionAntropometria" href="#collapse4">COMPOSIÇÃO CORPORAL</a>
				        </h4>
				    </div>
				    <div id="collapse4" class="panel-collapse collapse">
						<div class="panel-body">
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="biceps" class="control-label">
										Biceps (cm):
									</label>
									<form:input id="biceps" name="biceps"
										placeholder="00.00" path="biceps" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="biceps"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="triceps" class="control-label">
										Triceps (cm):
									</label>
									<form:input id="triceps" name="triceps"
										placeholder="00.00" path="triceps" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="triceps"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="axilarMedia" class="control-label">
										Axilar Média (cm):
									</label>
									<form:input id="axilarMedia" name="axilarMedia"
										placeholder="00.00" path="axilarMedia" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="axilarMedia"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="torax" class="control-label">
										Tórax (cm):
									</label>
									<form:input id="torax" name="torax"
										placeholder="00.00" path="torax" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="torax"></form:errors>
									</div>
								</div>
							</div>
							
							<div class="row form-group">
								<div class="form-item col-sm-3">
									<label for="panturrilhaMedial" class="control-label">
										Panturrilha Medial (cm):
									</label>
									<form:input id="panturrilhaMedial" name="panturrilhaMedial"
										placeholder="00.00" path="panturrilhaMedial" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="panturrilhaMedial"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="abdominal" class="control-label">
										Abdominal (cm):
									</label>
									<form:input id="abdominal" name="abdominal"
										placeholder="00.00" path="abdominal" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="abdominal"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="suprailiaca" class="control-label">
										Suprailíaca (cm):
									</label>
									<form:input id="suprailiaca" name="suprailiaca"
										placeholder="00.00" path="suprailiaca" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="suprailiaca"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="subescapular" class="control-label">
										Subescapular (cm):
									</label>
									<form:input id="subescapular" name="subescapular"
										placeholder="00.00" path="subescapular" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="subescapular"></form:errors>
									</div>
								</div>
								
								<div class="form-item col-sm-3">
									<label for="coxa" class="control-label">
										Coxa (cm):
									</label>
									<form:input id="coxa" name="coxa"
										placeholder="00.00" path="coxa" type="number"
										cssClass="form-control valid-num" min="0" />
									<div class="error-validation">
										<form:errors path="coxa"></form:errors>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-xs-offset-0 col-xs-10" align="center">
					</br>
					<button type="submit" class="btn btn-success">${botao}</button>
				</div>
			</form:form>
		</div>
		</div>
	</div>
</body>
<jsp:include page="../../modulos/footer.jsp" />
</html>