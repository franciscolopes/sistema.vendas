<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Pagina inicial</h1>
		</div>
		<p class="lead">Sistema de Vendas desenvolvido na Disciplina
			Protocolos e Programa��o para Internet</p>
		<p>
			Instituto Federal do Tri�ngulo Mineiro - <a
				href="http://www.iftm.edu.br">www.iftm.edu.br</a>
		</p>
		<h2>P�gina de Login das Tarefas</h2>
		<form action="efetuaLogin" method="post">
			Login: <input type="text" name="login" /> <br /> Senha: <input
				type="password" name="senha" /> <br /> <input type="submit"
				value="Entrar nas tarefas" />
		</form>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>