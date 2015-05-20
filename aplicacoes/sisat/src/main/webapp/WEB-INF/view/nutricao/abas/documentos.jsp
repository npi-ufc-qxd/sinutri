<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Documentos</h3>

<div class="form-group">
	<label for="arquivo" class="col-sm-2 control-label">Arquivos:</label>
	<div class="col-sm-5 files">
		<input type="file" id="files" name="files" class="file"	multiple="multiple"></input>
		<div class="error-validation" id="erro-Anexo">
			<label class="col-sm-10 control-label" id="label-erro"> ${anexoError} </label>
		</div>
		<table id="file-upload" role="presentation"	class="table table-striped">
			<thead class="files">
				<tr>
					<th>Nome do Arquivo</th>
					<th>Data</th>
					<th>Tipo</th>
					<th>Baixar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody class="files">
				<c:forEach items="${consultaNutricional.documentos}" var="documento">
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