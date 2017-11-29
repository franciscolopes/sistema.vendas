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
			<h1>Suas compras</h1>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/compra/comprar">
					<button type="submit" class="btn btn-primary">Nova compra</button>
				</form>
			</div>
			
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Data</th>
					<th>Preço total</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCompra}</td>

						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.horarioCompra}"/></td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.getPreçoTotal()}" /></td>						
						<td><a href="<%=request.getContextPath()%>/compra/CompraDetalhes?codCompra=${x.codCompra}" class="btn btn-primary btn-xs">Ver detalhes</a></td>
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
