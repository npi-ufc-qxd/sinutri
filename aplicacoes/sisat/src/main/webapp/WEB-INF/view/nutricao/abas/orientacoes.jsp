<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="col-sm-12">

    <br/>
    <label>Conduta Nutricional</label> <br/>
	<textarea rows="5" cols="140" name="condutaNutricional"> ${consulta.condutaNutricional}</textarea> <br/><br/>

	<label>Orientações Individuais</label> <br/>
	<textarea rows="10" cols="140" name="orientacoesIndividuais"> ${consulta.orientacoesIndividuais}</textarea> <br/><br/>
	
</div>