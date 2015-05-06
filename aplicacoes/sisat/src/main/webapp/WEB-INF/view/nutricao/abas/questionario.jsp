<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<script	src="<c:url value="/resources/js/questionario-frequencia-alimentar.js" />"></script>
<fieldset>
	<h3>Adicione as refeições</h3>
	${consultaNutricional.frequencias}
	<div class="form-group">
		<table id="tblAppendGrid">
		</table>
	</div>
</fieldset>
</html>

