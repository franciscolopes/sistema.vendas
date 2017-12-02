<!-- Fixed navbar -->
<style>
.button {
	position: absolute;
	right: -800px;
	border-radius: 4px;
	background-color: #f4511e;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 15px;
	padding: 5px;
	width: 70px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 20px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}
</style>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/index.jsp">Sistema de Vendas</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/compra/listar">Minhas
						compras</a></li>
				<li><a href="<%=request.getContextPath()%>/compra/comprar">Nova
						compra</a></li>
				
				<li><form action="login.jsp" ><button type="submit" value="Sair" class="button"><span>Sair </span> </button></form></li>
				

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
