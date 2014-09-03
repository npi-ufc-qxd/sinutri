<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="content"><br/>

	<div class="col-xs-2" align="center">
		<div class="form-group">
			<label for="glicemia" class="col-sm-2 control-label">Glicemia:</label>
			<form:input id="glicemia" path="glicemia" cssClass="form-control" placeholder="glicemia do paciente" type="text"/>
			<form:input id="classificacaoGlicemia" path="classificacaoGlicemia" cssClass="form-control" placeholder="classificação Glicemia" type="text"/><br/>
			
			<label for="tgl" class="col-sm-2 control-label">TGL:</label>
			<form:input id="tgl" path="tgl" cssClass="form-control" placeholder="Tgl do paciente" type="text"/>
			<form:input id="classificacaoTgl" path="classificacaoTgl" cssClass="form-control" placeholder="classificação Tgl " type="text"/><br/>
			
			<label for="hdl" class="col-sm-2 control-label">HDL:</label>
			<form:input id="hdl" path="hdl" cssClass="form-control" placeholder="HDl do paciente" type="text"/>
			<form:input id="classificacaoHdl" path="classificacaoHdl" cssClass="form-control" placeholder="classificação HDl" type="text"/>
			
		</div>
	</div>	

	<div class="col-xs-2" align="center">
	
		<div class="form-group">
			<label for="ldl" class="col-sm-2 control-label">LDL:</label>
			<form:input id="ldl" path="ldl" cssClass="form-control" placeholder="Ldl do paciente" type="text"/>
		 	<form:input id="classificacaoLdl" path="classificacaoLdl" cssClass="form-control" placeholder="classificação Ldl" type="text"/><br/>
		 	
			<label for="ht" class="col-sm-2 control-label">HT:</label>
			<form:input id="ht" path="ht" cssClass="form-control" placeholder="HT do paciente" type="text"/>
			<form:input id="classificacaoHt" path="classificacaoHt" cssClass="form-control" placeholder="classificação HT" type="text"/><br/>
			
			<label for="hb" class="col-sm-2 control-label">HB:</label>
			<form:input id="hb" path="hb" cssClass="form-control" placeholder="Hb do paciente" type="text"/>
			<form:input id="classificacaoHb" path="classificacaoHb" cssClass="form-control" placeholder="classificação Hb" type="text"/>
		</div>
	</div>

</div>