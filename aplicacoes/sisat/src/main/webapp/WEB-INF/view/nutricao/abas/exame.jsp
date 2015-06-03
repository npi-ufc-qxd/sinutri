<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Seus exames</h3>
	<div class="form-group">
		<div class="form-item">
			<label for="glicemia" class="col-sm-2 control-label">Glicemia:</label>
			<div class="col-sm-2">
				<form:input id="glicemia" type="number" path="glicemia" cssClass="form-control" placeholder="glicemia" />			
				<div class="error-validation">
					<form:errors path="glicemia"></form:errors>
				</div>
			</div>
			<div class="col-sm-2" >
				<form:select path="classificacaoGlicemia" cssClass="form-control" disabled="${not consultaNutricional.classificacaoGlicemia}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
 		</div> 
	
 		<div class="form-item">
			<label for="ct" class="col-sm-2 control-label">CT:</label>
			<div class="col-sm-2">
				<form:input id="ct" type="number" path="ct" cssClass="form-control" placeholder="ct" />
				<div class="error-validation">
					<form:errors path="ct"></form:errors>
				</div>
			</div>

			<div class="col-sm-2" >
				<form:select path="classificacaoCt" cssClass="form-control" disabled="${not consultaNutricional.classificacaoCt}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="form-item">
			<label for="ldl" class="col-sm-2 control-label">LDL-C:</label>
			<div class="col-sm-2">
				<form:input id="ldl" type="number" path="ldl" cssClass="form-control" placeholder="LDL-C" />
				<div class="error-validation">
					<form:errors path="ldl"></form:errors>
				</div>
			</div>
			<div class="col-sm-2" >
				<form:select path="classificacaoLdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoLdl}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>

		<div class="form-item">
			<label for="hdl" class="col-sm-2 control-label">HDL-C:</label>
			<div class="col-sm-2">
				<form:input id="hdl" type="number" path="hdl" cssClass="form-control" placeholder="HDL-C" />
				<div class="error-validation">
					<form:errors path="hdl"></form:errors>
				</div>
			</div>

			<div class="col-sm-2" >
				<form:select path="classificacaoHdl" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHdl}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="form-item">
			<label for="tg" class="col-sm-2 control-label">TG:</label>
			<div class="col-sm-2">
				<form:input id="tg" type="number" path="tg" cssClass="form-control" placeholder="TG" />
				<div class="error-validation">
					<form:errors path="tg"></form:errors>
				</div>
			</div>

			<div class="col-sm-2" >
				<form:select path="classificacaoTg" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTg}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>

		<div class="form-item">
			<label for="hb" class="col-sm-2 control-label">HB:</label>
			<div class="col-sm-2">
				<form:input id="hb" type="number" path="hb" cssClass="form-control" placeholder="HB" />
				<div class="error-validation">
					<form:errors path="hb"></form:errors>
				</div>
			</div>

			<div class="col-sm-2" >
				<form:select path="classificacaoHb" cssClass="form-control" disabled="${not consultaNutricional.classificacaoHb}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="form-item">
			<label for="tgo" class="col-sm-2 control-label">TGO (AST):</label>
			<div class="col-sm-2">
				<form:input id="tgo" type="number" path="tgo" cssClass="form-control" placeholder="tgo" />
				<div class="error-validation">
					<form:errors path="tgo"></form:errors>
				</div>
			</div>

			<div class="col-sm-2" >
				<form:select path="classificacaoTgo" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgo}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>
	
 		<div class="form-item"> 
			<label for="tgp" class="col-sm-2 control-label">TGP (ALT):</label>
			<div class="col-sm-2">
				<form:input id="tgp" type="number" path="tgp" cssClass="form-control" placeholder="TGP (ALT)" />
				<div class="error-validation">
					<form:errors path="tgp"></form:errors>
				</div>
			</div>

		<div class="form-item">
			<div class="col-sm-2" >
				<form:select path="classificacaoTgp" cssClass="form-control" disabled="${not consultaNutricional.classificacaoTgp}">
					<form:option value="">Classificação</form:option>
					<form:options items="${classificacao}" itemLabel="tipo"/>
				</form:select>
			</div>
		</div>
	</div>
	</div>
