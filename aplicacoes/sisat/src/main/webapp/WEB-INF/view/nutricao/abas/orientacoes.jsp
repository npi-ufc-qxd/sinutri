<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Orientações</h3>
	<div class="form-group">
		<label for="condutaNutricional" class="col-sm-2 control-label"> Conduta Nutricional:</label>
		<div class="col-sm-10" >
			<form:textarea id="condutaNutricional" path="condutaNutricional" class="form-control" rows="5" placeholder="Conduta Nutricional"/>
			<div class="error-validation">
				<form:errors path="condutaNutricional"></form:errors>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="orientacoesIndividuais" class="col-sm-2 control-label"> Orientações Individuais</label>
		<div class="col-sm-10" >
			<form:textarea id="orientacoesIndividuais" path="orientacoesIndividuais" class="form-control" rows="5" placeholder="Orientações Individuais"/>
			<div class="error-validation">
				<form:errors path="orientacoesIndividuais"></form:errors>
			</div>
		</div>
	</div>
