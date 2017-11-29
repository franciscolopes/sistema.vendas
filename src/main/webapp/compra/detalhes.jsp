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
			<h1>Detalhes do produto</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codProduto}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Preço: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber
						type="currency" value="${item.preco}" /></li>
			</ul>
		</div>

		 <div>
			<a href="<%=request.getContextPath()%>/compra/comprar" class="btn btn-success">Voltar</a>
				
			
			
			<a href="<%=request.getContextPath()%>/compra/novo?codProduto=${x.codProduto}" 
			class="btn btn-success">Comprar</a>
				
		</div> 
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
