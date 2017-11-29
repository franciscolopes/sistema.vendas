<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Vendas</title>
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
			<h1>Escolha um produto</h1>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codProduto}</td>
						<td>${x.nome}</td>
						
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.preco}" /></td>
						
						
						<td><a href="<%=request.getContextPath()%>/compra/ProdutoDetalhes?codProduto=${x.codProduto}" 
						class="btn btn-primary btn-xs">Ver produto</a></td>
						
						<!--<td><a href="<%=request.getContextPath()%>/compra/detalhes.jsp" 
						class="btn btn-primary btn-xs">Ver produto</a></td>-->
						
						
						
						
						<!--<td><a href="<%=request.getContextPath()%>/compra/novo?codProduto=${x.codProduto}" 
						class="btn btn-primary btn-xs">Ver produto</a></td>-->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
