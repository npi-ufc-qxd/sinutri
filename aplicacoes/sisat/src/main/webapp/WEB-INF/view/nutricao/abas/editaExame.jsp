<%@page import="com.itextpdf.text.pdf.codec.Base64.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content"><br/>
	<div class="col-xs-3" align="center">
		<div class="form-group">

		
			<!-- Glicemia -->
			<label for="glicemia">Glicemia:</label>
			<input id="glicemia" name="glicemia" type="text" value="${ consultaNutricional.glicemia }"/>
			
			<select name="classificacaoGlicemia" id="classificacaoGlicemia" path="classificacaoGlicemia">
				<c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoGlicemia == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- CT -->
			<label for="ct">CT:</label>
			<input id="ct" name="ct" type="text" value="${ consultaNutricional.ct}"/>
		
			<select name="classificacaoCt" id="classificacaoCt" path="classificacaoCt">
				<c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoCt == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>

		
			<!-- LDL-C -->
			<label for="ldl">LDL-C:</label>
			<input id="ldl" name="ldl" type="text" value="${ consultaNutricional.ldl}"/>
			
			<select name="classificacaoLdl" id="classificacaoLdl" path="classificacaoLdl" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoLdl == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- HDL-C -->
			<label for="hdl"">HDL-C:</label>
			<input id="hdl" name="hdl" type="text" value="${ consultaNutricional.hdl}"/>
			
			<select name="classificacaoHdl" id="classificacaoHdl" path="classificacaoHdl" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoHdl == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
	</div>
</div>	

	<div class="col-xs-3" align="center">
	
		<div class="form-group">	
			 
			 <!-- TG -->
			<label for="tg">TG:</label>
			<input id="tg" name="tg" type="text" value="${ consultaNutricional.tg}"/>
			
			<select name="classificacaoTg" id="classificacaoTg" path="classificacaoTg" >
				
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoTg == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- HB -->
			<label for="hb">HB:</label>
			<input id="hb" name="hb" type="text" value="${ consultaNutricional.hb}"/>
			
			<select name="classificacaoHb" id="classificacaoHb" path="classificacaoHb" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoHb == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- TGO(AST) -->
			<label for="tgo">TGO (AST):</label>
			<input id="tgo" name="tgo" type="text" value="${ consultaNutricional.tgo}"/>
			
			<select name="classificacaoTgo" id="classificacaoTgo" path="classificacaoTgo" >
				 <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoTgo == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			<!-- TGP(ALT) -->
			<label for="tgp">TGP (ALT):</label>
			<input id="tgp" name="tgp" type="text" value="${ consultaNutricional.tgp}"/>
			
			<select name="classificacaoTgp" id="classificacaoTgp" path="classificacaoTgp" >
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
					<c:choose>
						<c:when test="${consultaNutricional.classificacaoTgp == c }">  
							<option selected value="${c}">${c.tipo}</option>
						</c:when>  
						<c:otherwise>  
							<option value="${c}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br/><br/><br/>
			
			
		</div>
	</div>
	
</div>