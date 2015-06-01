<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Documentos</h3>

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
						<td><a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
								<button type="button" class="btn btn-primary">
									<span class="glyphicon glyphicon-save"></span>
								</button>
						</a></td>						
						<td><a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
						</a></td>
						<td><a id="send[${documento.id}]" href="../../nutricao/enviarDocumento/${documento.id}/" class="send-document">
								<button class="btn btn-warning">
									<span class="glyphicon glyphicon-send"></span>
								</button>
						</a></td>
						
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
						<td><a id="download[${documento.id}]" href="../../nutricao/downloadDocumento/${documento.id}" class="save-document">
								<button type="button" class="btn btn-primary">
									<span class="glyphicon glyphicon-save"></span>
								</button>
						</a></td>						
						<td><a id="delete[${documento.id}]" href="../../nutricao/deletarDocumento/${documento.id}" class="delete-document">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>