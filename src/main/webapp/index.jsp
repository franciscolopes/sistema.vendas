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
	
		String nomeUsuario = null;
		int codUsuario = 0;
		String produtos=""; 
		int quantidadeProdutos = 0;
		HttpSession sessaoAtual = request.getSession(false);
		//String nomeUsuarioLogado = (String) sessaoAtual.getAttribute("usuarioLogado");
		if (sessaoAtual.getAttribute("usuarioLogado") == null) {// sessaoAtual.getAttribute("usuarioLogado")
			response.sendRedirect("login.jsp");
		} else {
			nomeUsuario = (String) sessaoAtual.getAttribute("usuarioLogado");
			codUsuario = (Integer) sessaoAtual.getAttribute("codUsuarioLogado");
			quantidadeProdutos = (Integer) sessaoAtual.getAttribute("qtdeProdutos");
			String nome = null;
			String sessaoID = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("usuarioLogado"))
						nome = cookie.getValue();
					if (cookie.getName().equals("JSESSIONID"))
						sessaoID = cookie.getValue();
				}
				
				for (int i =0; i<quantidadeProdutos; i++){
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("codProdutoOlhado"+i)){
							produtos = produtos +";"+ cookie.getValue();
						}else {
							produtos = " sem cookie";
						}
							
				}
				}
				
				
			}
		}
	%>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<form action="Logout" method="POST">

	</form>
	<div class="container">
		<div class="page-header">
			<h1>
				Bem vindo(a),
				<%
				out.print(nomeUsuario);out.print(produtos);
			%>!
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