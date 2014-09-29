<%@page import="com.itextpdf.text.pdf.codec.Base64.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content"><br/>
	<div class="col-xs-4" align="center">
		<div class="form-group">
		
			<!-- Glicemia -->
			<label for="glicemia" class="col-sm-3 control-label">Glicemia:</label>
			<form:input id="glicemia" path="glicemia" cssClass="form-control" type="text"/>
			
			<select name="classificacaoGlicemia" id="classificacaoGlicemia" path="classificacaoGlicemia" class="col-xs-5">
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select>
			<br/><br/><br/>
			
				<!-- CT -->
			<label for="ct" class="col-sm-3 control-label">CT:</label>
			<form:input id="ct" path="ct" cssClass="form-control" type="text"/>
		
			<select name="classificacaoCt" id="classificacaoCt" class="col-xs-5" path="classificacaoCt">
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- LDL-C -->
			<label for="ldl" class="col-sm-3 control-label">LDL-C:</label>
			<form:input id="ldl" path="ldl" cssClass="form-control" type="text"/>
			
			<select name="classificacaoLdl" id="classificacaoLdl" class="col-xs-5" path="classificacaoLdl" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- HDL-C -->
			<label for="hdl" class="col-sm-3 control-label">HDL-C:</label>
			<form:input id="hdl" path="hdl" cssClass="form-control" type="text"/>
			
			<select name="classificacaoHdl" id="classificacaoHdl" class="col-xs-5" path="classificacaoHdl" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select>
			
		</div>
	</div>	

	<div class="col-xs-4" align="center">
	
		<div class="form-group">
			 
			 <!-- TG -->
			<label for="tg" class="col-sm-3 control-label">TG:</label>
			<form:input id="tg" path="tg" cssClass="form-control" type="text"/>
			
			<select name="classificacaoTg" id="classificacaoTg" class="col-xs-5" path="classificacaoTg" >
				
				<c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
				
			
			</select><br/><br/><br/>
			
			<!-- HB -->
			<label for="hb" class="col-sm-2 control-label">HB:</label>
			<form:input id="hb" path="hb" cssClass="form-control" type="text"/>
			
			<select name="classificacaoHb" id="classificacaoHb" class="col-xs-5" path="classificacaoHb" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- TGO(AST) -->
			<label for="tgo" class="col-sm-4 control-label">TGO (AST):</label>
			<form:input id="tgo" path="tgo" cssClass="form-control" type="text"/>
			
			<select name="classificacaoTgo" id="classificacaoTgo" class="col-xs-5" path="classificacaoTgo" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- TGP(ALT) -->
			<label for="tgp" class="col-sm-4 control-label">TGP (ALT):</label>
			<form:input id="tgp" path="tgp" cssClass="form-control" type="text"/>
			
			<select name="classificacaoTgp" id="classificacaoTgp" class="col-xs-5" path="classificacaoTgp" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
  						<option value="${c}">${c.tipo}</option>
				</c:forEach>
			</select><br/><br/><br/>
			
			
		</div>
	</div>

</div>