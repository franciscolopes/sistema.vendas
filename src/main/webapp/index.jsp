<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Vendas</title>
<link rel="stylesheet" href="src/main/webapp/resources/css/style.css">



<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>
	<%
	HttpSession sessaoAtual = request.getSession(false);
	String nomeUsuario ="";
	int codUsuario = 0;
	if (sessaoAtual != null) {
		if (sessaoAtual.getAttribute("usuarioLogado") != null) {
		nomeUsuario = (String) sessaoAtual.getAttribute("usuarioLogado");
		codUsuario = (Integer) sessaoAtual.getAttribute("codUsuarioLogado");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}
	%>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>
				Bem vindo(a),
				<%out.print(codUsuario);%>!
			</h1>

		</div>
		<p class="lead">Sistema de Vendas desenvolvido na Disciplina
			Protocolos e Programação para Internet</p>


	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>