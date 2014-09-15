<%@page import="com.itextpdf.text.pdf.codec.Base64.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content"><br/>
	<div class="col-xs-4" align="center">
		<div class="form-group">
		
			<!-- Glicemia -->
			<label for="glicemia" class="col-sm-3 control-label">Glicemia:</label>
			<input id="glicemia" name="consultaNutricional.glicemia" type="text" value="${ consultaNutricional.glicemia }"/>
			
			<select name="classificacaoGlicemia" id="classificacaoGlicemia" path="classificacaoGlicemia" class="col-xs-8">
			  <c:forEach var="c" items="${classificacao}" varStatus="i">
			  		<c:choose>
						<c:when
							test="${c.tipo == consultaNutricional.classificacaoGlicemia }">
							<option selected value="${c.tipo}">${c.tipo}</option>
						</c:when>
						<c:otherwise>
							<option value="${c.tipo}">${c.tipo}</option>
						</c:otherwise>
					</c:choose>



				</c:forEach>
			</select><br/><br/><br/>


		</div>
	</div>

</div>