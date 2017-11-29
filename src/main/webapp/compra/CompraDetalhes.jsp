<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes da compra</h1>
		</div>

		<div>
			
				<ul class="list-group">
					<li class="list-group-item">Código: ${compra.codCompra}</li>

					<li class="list-group-item">Data compra: <fmt:formatDate
							type="date" pattern="dd/MM/yyyy" value="${compra.horarioCompra}" /></li>
					<li class="list-group-item">Preço:<fmt:setLocale value="pt_BR" />
						<fmt:formatNumber type="currency" value="${compra.getPreçoTotal()}" /></li>

				</ul>
			



		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Nome do produto</th>
					<th>Código</th>
					<th>Desconto</th>
					<th>Preço</th>
					<th>Quantidade</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.getProduto().getNome()}</td>
						<td>${x.codItemCompra}</td>
						<td>${x.desconto}</td>
						<td>${x.preco}</td>
						<td>${x.quantidade}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<a href="<%=request.getContextPath()%>/compra/listar"
				class="btn btn-success">Voltar</a>



		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
