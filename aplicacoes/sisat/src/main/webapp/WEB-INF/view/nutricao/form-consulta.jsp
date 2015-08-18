<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${action eq 'cadastrar' }">
	<c:url var="url" value="/consulta/realizar-consulta/${consultaNutricional.paciente.pessoa.cpf}"></c:url>
	<c:set var="titulo" value="Nova Consulta "></c:set>
	<c:set var="botao" value="Finalizar Consulta "></c:set>
</c:if>
<c:if test="${action eq 'editar' }">
	<c:url var="url" value="/consulta/editar-consulta/${consultaNutricional.id}/paciente/${consultaNutricional.paciente.pessoa.cpf}"></c:url>
	<c:set var="titulo" value="Editar Consulta  "></c:set>
	<c:set var="botao" value="Atualizar Consulta"></c:set>
</c:if>

<html>
	<head>
		<jsp:include page="../modulos/header-estrutura.jsp" />

		<title>${titulo}</title>
	</head>

<body data-spy="scroll" data-target="#myScrollspy">

	<jsp:include page="../modulos/header.jsp" />

	<div class="container">
	    <div class="row">
	    	<div class="tituloConsulta">
		    	<h2>${titulo} <small>${consultaNutricional.paciente.pessoa.nome}</small></h2> 
	    	</div>
    	</div>
	
	    <div class="row">
	        <div class="col-sm-3" id="myScrollspy">
	            <ul class="nav nav-tabs nav-stacked affix-top" data-spy="affix" data-offset-top="125">
					<li class="active">
						<a href="#avaliacao">
							<span class="badge">1</span> Anamnese
						</a>
					</li>
					<li>
						<a href="#recordatorio">
							<span class="badge">2</span> Recordatório Alimentar
						</a>
					</li>
					<li>
						<a href="#exame">
							<span class="badge">3</span> Exames Laboratoriais
						</a>
					</li>
					<li>
						<a href="#orientacoes">
							<span class="badge">4</span> Orientações Individuais
						</a>
					</li>
					<li>
						<a href="#documentos">
							<span class="badge">5</span> Documentos
						</a>
					</li>
	            </ul>
	
	        </div>
	
		    <div class="col-sm-9">
			<form:form servletRelativeAction="${url}" method="POST" id ="consultaNutricional" modelAttribute="consultaNutricional" commandName="consultaNutricional" acceptCharset="UTF-8" cssClass="form-horizontal" enctype="multipart/form-data">
				<form:hidden path="id" />
				<form:hidden path="paciente.id" />
				<form:hidden path="data" />
	
		    	<h3 id="avaliacao" class="section">Anamnese</h3>
		    	
				<div class="row form-group">
					<div class="form-item col-sm-12">
						<label for="objetivoConsulta" class="control-label"> Objetivo da Consulta:</label>
						<form:textarea id="objetivoConsulta" path="objetivoConsulta" class="form-control" rows="5" placeholder="Descreva aqui o objetivo da consulta..."/>
						<div class="error-validation"><form:errors path="objetivoConsulta"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="altura" class="control-label">Altura:</label>
						<form:input id="altura" name="altura" path="altura" cssClass="form-control" placeholder="0.00" />
						<div class="error-validation"><form:errors path="altura"></form:errors></div>
			        </div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-3">
							<label for="peso" class="control-label">Peso:</label>
							<form:input id="peso" name="peso" path="peso" cssClass="form-control" placeholder="00.00"/>
							<div class="error-validation"><form:errors path="peso"></form:errors></div>
					</div>
			        <div class="form-item col-sm-3">
						<label for="pesoDesejado" class="control-label">Peso desejado:</label>
						<form:input id="pesoDesejado" name="pesoDesejado" path="pesoDesejado" cssClass="form-control" placeholder="00.00"/>
						<div class="error-validation"><form:errors path="pesoDesejado"></form:errors></div>
			        </div>

			        <div class="form-item col-sm-3">
						<label for="circunferenciaCintura" class="control-label">CC:</label>
						<form:input id="circunferenciaCintura" name="cc" placeholder="00.00" path="circunferenciaCintura" cssClass="form-control" min="0"/>
						<div class="error-validation"><form:errors path="circunferenciaCintura"></form:errors></div>
			        </div>
			        <div class="form-item col-sm-3">
						<label for="circunferenciaCinturaDesejada" class="control-label">CC desejada:</label>
						<form:input id="circunferenciaCinturaDesejada" name="cc" placeholder="00.00" path="circunferenciaCinturaDesejada" cssClass="form-control" min="0"/>
						<div class="error-validation"><form:errors path="circunferenciaCinturaDesejada"></form:errors></div>
			        </div>
				</div>

		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="agua" class="control-label">Consumo de água:</label>
						<form:input id="agua" name="agua" path="agua" cssClass="form-control" placeholder="Consumo de água"/>
						<div class="error-validation"><form:errors path="agua"></form:errors></div>
			        </div>
				</div>

		        <div class="row form-group">
			        <div class="form-item col-sm-6">
						<label for="checkAtividadeFisica" class="control-label"><form:checkbox id="checkAtividadeFisica"  path="atividadeFisica" class="checkInputSelec"/> Atividade Física:</label>
						<form:input id="inputTextAtividadeFisica" path="atividadeFisicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.atividadeFisica}"/>
						<div class="error-validation"><form:errors path="atividadeFisicaComentario"></form:errors></div>
			        </div>
			        <div class="form-item col-sm-6">
			        	<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
						<form:select id="atividadeFisicaFrequenciaSemanal" path="atividadeFisicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.atividadeFisica}">
							<form:option value="">Quantas vezes por semana?</form:option>
							<form:options items="${frequencia}" itemLabel="tipo"/>
						</form:select>
						<div class="error-validation"><form:errors path="atividadeFisicaFrequenciaSemanal"></form:errors></div>
			        </div>
				</div>
		        <div class="row form-group">
			        <div class="form-item col-sm-6">
						<label for="checkCarneVermelha" class=" control-label"><form:checkbox id="checkCarneVermelha"  path="carneVermelha" class="checkInputSelec"/> Carne Vermelha:</label>
						<form:input id="inputTextCarneVermelha" path="carneVermelhaComentario" cssClass="form-control" placeholder="Que tipo de carne?" disabled="${not consultaNutricional.carneVermelha}"/>
						<div class="error-validation"><form:errors path="carneVermelhaComentario"></form:errors></div>
			        </div>
			        <div class="form-item col-sm-6">
			        	<label for="agua" class="control-label">&nbsp;&nbsp;&nbsp;</label>
						<form:select path="carneVermelhaFrequenciaSemanal" cssClass="form-control select" disabled="${not consultaNutricional.carneVermelha}">
							<form:option value="">Quantas vezes por semana?</form:option>
							<form:options items="${frequencia}" itemLabel="tipo"/>
						</form:select>
			        </div>
				</div>
				
		        <div class="row form-group">
			        <div class="form-item col-sm-6">
						<label for="checkBebidaAlcoolica" class=" control-label"><form:checkbox id="checkBebidaAlcoolica"  path="bebidaAlcoolica" class="checkInputSelec"/> Bebida alcoólica:</label>
						<form:input id="inputTextBebidaAlcoolica" path="bebidaAlcoolicaComentario" cssClass="form-control" placeholder="Qual atividade?" disabled="${not consultaNutricional.bebidaAlcoolica}"/>
						<div class="error-validation"><form:errors path="bebidaAlcoolicaComentario"></form:errors></div>
			        </div>
	
			        <div class="form-item col-sm-6">
			        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
						<form:select path="bebidaAlcoolicaFrequenciaSemanal" cssClass="form-control" disabled="${not consultaNutricional.bebidaAlcoolica}">
							<form:option value="">Quantas vezes por semana?</form:option>
							<form:options items="${frequencia}" itemLabel="tipo"/>
						</form:select>
			        </div>
				</div>
				
		        <div class="row form-group">
			        <div class="form-item col-sm-6">
						<label for="sistemaGastrointestinal" class=" control-label">Sistema Gastrointestinal:</label>
						<form:select id="sistemaGastrointestinal" path="sistemaGastrointestinal" cssClass="form-control">
							<form:option value="">Selecione</form:option>
							<form:options items="${sistemaGastrointestinal}" itemLabel="tipo"/>
						</form:select>
			        </div>

			        <div class="form-item col-sm-6">
						<label for="sistemaUrinario" class=" control-label">Sistema Urinário:</label>
						<form:select id="sistemaUrinario" path="sistemaUrinario" cssClass="form-control">
							<form:option value="">Selecione</form:option>
							<form:options items="${sistemaUrinario}" itemLabel="tipo"/>
						</form:select>
			        </div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="checkMedicamento" class=" control-label"><form:checkbox id="checkMedicamento"  path="medicamento" class="check"/> Medicamentos:</label>
						<form:input id="inputTextMedicamento" path="medicamentoComentario" cssClass="form-control" placeholder="Quais medicamentos você usa?" disabled="${not consultaNutricional.medicamento}"/>
						<div class="error-validation"><form:errors path="medicamentoComentario"></form:errors></div>
					</div>
				</div>
	
				<div class="row form-group">
					<div class="form-item col-sm-12">
						<label for="checkMastigacao" class=" control-label"><form:checkbox id="checkMastigacao"  path="mastigacao" class="check"/> Mastigação:</label>
						<form:input id="inputTextMastigacao" path="mastigacaoComentario" cssClass="form-control" placeholder="Como é sua mastigação?" disabled="${not consultaNutricional.mastigacao}"/>
						<div class="error-validation"><form:errors path="mastigacaoComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="disfagia" class=" control-label"><form:checkbox id="disfagia" path="disfagia"/> Disfagia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<form:input id="disfagiaComentario" path="disfagiaComentario" cssClass="form-control" placeholder="Comentário sobre disfagia" disabled="${not consultaNutricional.disfagia}"/>
						<div class="error-validation"><form:errors path="disfagiaComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="odinofagia" class="control-label"><form:checkbox id="odinofagia" path="odinofagia"/> Odinofagia</label>
						<form:input id="odinofagiaComentario" path="odinofagiaComentario" cssClass="form-control" placeholder="Comentário sobre odinofagia" disabled="${not consultaNutricional.odinofagia}"/>
						<div class="error-validation"><form:errors path="odinofagiaComentario"></form:errors></div>
					</div>
				</div>
				
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="pirose" class=" control-label"><form:checkbox id="pirose" path="pirose"/> Pirose</label>
						<form:input id="piroseComentario" path="piroseComentario" cssClass="form-control" placeholder="Comentário sobre pirose" disabled="${not consultaNutricional.pirose}"/>
						<div class="error-validation"><form:errors path="piroseComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="nausea" class=" control-label"><form:checkbox id="nausea" path="nausea"/> Náusea</label>
						<form:input id="nauseaComentario" path="nauseaComentario" cssClass="form-control" placeholder="Comentário sobre náusea" disabled="${not consultaNutricional.nausea}"/>
						<div class="error-validation"><form:errors path="nauseaComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="vomito" class=" control-label"><form:checkbox id="vomito" path="vomito"/> Vômitos</label>
						<form:input id="vomitoComentario" path="vomitoComentario" cssClass="form-control" placeholder="Comentário sobre vômito" disabled="${not consultaNutricional.vomito}"/>
						<div class="error-validation"><form:errors path="vomitoComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="diarreia" class=" control-label"><form:checkbox id="diarreia" path="diarreia"/> Diarreia</label>
						<form:input id="diarreiaComentario" path="diarreiaComentario" cssClass="form-control" placeholder="Comentário sobre diarreia" disabled="${not consultaNutricional.diarreia}"/>
						<div class="error-validation"><form:errors path="diarreiaComentario"></form:errors></div>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="constipacao" class=" control-label"><form:checkbox id="constipacao" path="constipacao"/> Constipação</label>
						<form:input id="constipacaoComentario" path="constipacaoComentario" cssClass="form-control" placeholder="Comentário sobre constipação" disabled="${not consultaNutricional.constipacao}"/>
						<div class="error-validation"><form:errors path="constipacaoComentario"></form:errors></div>
					</div>
				</div>

		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="diabetes" class=" control-label"><form:checkbox id="diabetes" path="diabetes"/> Diabetes</label>
					</div>
				</div>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="hipertensao" class=" control-label"><form:checkbox id="hipertensao" path="hipertensao"/> Hipertensão</label>
					</div>
				</div>
			
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
					<label for="checkAlergia" class=" control-label"><form:checkbox id="checkAlergia"  path="alergia" class="check"/> Alergia Alimentar:</label>
					<form:textarea id="inputTextAlergia" path="alergiaComentario" class="form-control" rows="5" placeholder="Qual sua alergia Alimentar?" disabled="${not consultaNutricional.alergia}"/>
					<div class="error-validation"><form:errors path="alergiaComentario"></form:errors></div>
				</div>
				</div>
			
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="checkPatologia" class=" control-label"><form:checkbox id="checkPatologia"  path="outrasPatologias" class="check"/> Patologias:</label>
						<form:textarea id="inputTextPatologia" path="outrasPatologiasComentario" class="form-control" rows="5" placeholder="Descreva aqui as patologias" disabled="${not consultaNutricional.outrasPatologias}"/>
						<div class="error-validation"><form:errors path="outrasPatologiasComentario"></form:errors></div>
					</div>
				</div>
	
	
		    	<h3 id="recordatorio" class="section">Recordatório</h3>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<fieldset>
							<h3>Adicione as refeições</h3>
							<table id="questionarioFrequenciaAlimentar"></table>
						</fieldset>
			        </div>
		        </div>


		        <h3 id="exame" class="section">Exames Laboratoriais</h3>
	
		        <div class="row">
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="glicemia" class="control-label">Glicemia:</label>
							<form:input id="glicemia" path="glicemia" cssClass="form-control" placeholder="glicemia" />			
							<div class="error-validation"><form:errors path="glicemia"></form:errors></div>
						</div>
			        </div>
	
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoGlicemia" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoGlicemia"></form:errors></div>
						</div>
					</div>
					
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="ct" class="control-label">CT:</label>
							<form:input id="ct" path="ct" cssClass="form-control" placeholder="ct" />
							<div class="error-validation"><form:errors path="ct"></form:errors></div>
						</div>
					</div>
	
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoCt" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoCt"></form:errors></div>
						</div>
					</div>
		 		</div> 
	
		        <div class="row">
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="ldlc" class="control-label">LDL-C:</label>
							<form:input id="ldlc" path="ldlc" cssClass="form-control" placeholder="LDL-C" />
							<div class="error-validation"><form:errors path="ldlc"></form:errors></div>
						</div>
					</div>
	
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoLdlc" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoLdlc"></form:errors></div>
						</div>
					</div>
		
					<div class="col-sm-3">
				        <div class="form-item">
							<label for="hdlc" class="control-label">HDL-C:</label>
							<form:input id="hdlc" path="hdlc" cssClass="form-control" placeholder="HDL-C" />
							<div class="error-validation"><form:errors path="hdlc"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoHdlc" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoHdlc"></form:errors></div>
						</div>
					</div>
		 		</div> 
	
		        <div class="row">
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="tg" class="control-label">TG:</label>
							<form:input id="tg" path="tg" cssClass="form-control" placeholder="TG" />
							<div class="error-validation"><form:errors path="tg"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoTg" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoTg"></form:errors></div>
						</div>
					</div>

			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="hb" class="control-label">HB:</label>
							<form:input id="hb" path="hb" cssClass="form-control" placeholder="HB" />
							<div class="error-validation"><form:errors path="hb"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoHb" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoHb"></form:errors></div>
						</div>
					</div>
		 		</div> 
	
		        <div class="row form-group">
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="tgo" class="control-label">TGO (AST):</label>
							<form:input id="tgo" path="tgo" cssClass="form-control" placeholder="tgo" />
							<div class="error-validation"><form:errors path="tgo"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoTgo" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoTgo"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
							<label for="tgp" class="control-label">TGP (ALT):</label>
							<form:input id="tgp" path="tgp" cssClass="form-control" placeholder="TGP (ALT)" />
							<div class="error-validation"><form:errors path="tgp"></form:errors></div>
						</div>
					</div>
		
			        <div class="col-sm-3">
				        <div class="form-item">
				        	<label class="control-label">&nbsp;&nbsp;&nbsp;</label>
							<form:select path="classificacaoTgp" cssClass="form-control">
								<form:option value="">Classificação</form:option>
								<form:options items="${classificacaoExames}" itemLabel="tipo"/>
							</form:select>
							<div class="error-validation"><form:errors path="classificacaoTgp"></form:errors></div>
						</div>
					</div>
		 		</div> 

		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="informacoesComplementaresExames" class="control-label"> Informações complementares:</label>
						<form:textarea id="informacoesComplementaresExames" path="informacoesComplementaresExames" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
						<div class="error-validation"><form:errors path="informacoesComplementaresExames"></form:errors></div>
					</div>
				</div>
	
		    	<h3 id="orientacoes" class="section">Orientações</h3>
	
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="condutaNutricional" class="control-label"> Conduta Nutricional:</label>
						<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
						<div class="error-validation"><form:errors path="condutaNutricional"></form:errors></div>
					</div>
				</div>
					
		        <div class="row form-group">
			        <div class="form-item col-sm-12">
						<label for="orientacoesIndividuais" class="control-label"> Orientações Individuais</label>
						<form:textarea id="orientacoesIndividuais" path="orientacoesIndividuais" class="form-control" rows="5" placeholder="Orientações Individuais"/>
						<div class="error-validation"><form:errors path="orientacoesIndividuais"></form:errors></div>
					</div>
				</div>
	
	
		    	<h3 id="documentos" class="section">Documentos</h3>
	
					<div id="documentos" class="tab-pane fade in ">
						<div class="form-group">
							<label for="arquivo" class="col-sm-2 control-label">Arquivos:</label>
							<div class="col-sm-5 files">
								<input type="file" id="files" name="files" class="file"	multiple="multiple"></input> <br>
								<input type="checkbox" id="enviar" name="enviar"> Enviar para o paciente
	
								<div class="error-validation" id="erro-Anexo">
									<label class="col-sm-10 control-label" id="label-erro"> ${anexoError} </label>
								</div>
	
								<table id="file-upload" role="presentation"	class="table table-striped">
									<thead class="files">
										<tr> 
											<th colspan="6"> Ducumentos para enviar ao paciente </th>
										</tr>
										<tr>
											<th>Nome do Arquivo</th>
											<th>Data</th>
											<th>Tipo</th>
											<th>Baixar</th>
											<th>Excluir</th>
											<th> Enviar </th>
										</tr>
									</thead>
	
									<tbody class="files">
										<c:forEach items="${documentosEnvio}" var="documento">
											<tr class="template-upload fade in">					
												<td>${documento.nome}<strong class="error text-danger"></strong></td>
												<td>${documento.data}<strong class="error text-danger"></strong></td>
												<td>${documento.tipo}<strong class="error text-danger"></strong></td>
	
												<td>
													<a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
														<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save"></span></button>
													</a>
												</td>						
	
												<td>
													<a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
														<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
													</a>
												</td>
	
												<td>
													<a id="send[${documento.id}]" href="../../nutricao/enviarDocumento/${documento.id}/" class="send-document">
														<button class="btn btn-warning"><span class="glyphicon glyphicon-send"></span></button>
													</a>
												</td>
											</tr>
	
										</c:forEach>
									</tbody>
								</table>
								
								<br>
								
								<table id="file-upload" role="presentation"	class="table table-striped">
									<thead class="files">
										<tr> 
											<th colspan="5"> Outros documentos </th>
										</tr>
										
										<tr>
											<th>Nome do Arquivo</th>
											<th>Data</th>
											<th>Tipo</th>
											<th>Baixar</th>
											<th>Excluir</th>
										</tr>
									</thead>
	
									<tbody class="files">
										<c:forEach items="${documentosNutricionista}" var="documento">
											<tr class="template-upload fade in">					
												<td>${documento.nome}<strong class="error text-danger"></strong></td>
												<td>${documento.data}<strong class="error text-danger"></strong></td>
												<td>${documento.tipo}<strong class="error text-danger"></strong></td>
												<td>
													<a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
														<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save"></span></button>
													</a>
												</td>						
												
												<td>
													<a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
														<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
													</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>			
					</div>
					

					<div class="col-xs-offset-0 col-xs-10" align="center">
						<button type="submit" class="btn btn-success">${botao}</button>
					</div>

		    	</form:form>
			</div>
		</div>
	</div>

	<jsp:include page="../modulos/footer.jsp" />
	<script type="text/javascript">
		
		$("input[type='checkbox']").change(function() {
			var itemForm = $(this).parent().parent().parent();

			if ($(this).is(":checked")) {
				$(itemForm).find("input[type='text']").attr("disabled", false);
				$(itemForm).find("select").attr("disabled", false);
				$(itemForm).find("textarea").attr("disabled", false);
			}               
			else if ($(this).not(":checked")) {
				var valueEmpty = "";
				$(itemForm).find("input[type='text']").attr ('value', valueEmpty);
				$(itemForm).find("input[type='text']").attr("disabled", true);
				$(itemForm).find("textarea").attr("disabled", true);
				$(itemForm).find("select").attr("disabled", true);
			}           
		});
	</script>
	
	<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>

</body>
</html>
