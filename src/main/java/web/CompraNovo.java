package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import dominio.ItemCompra;
import dominio.Produto;
import dominio.Usuario;
import servico.CompraServico;
import servico.ProdutoServico;
import servico.UsuarioServico;

@WebServlet("/compra/novo")
public class CompraNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			
		
		ProdutoServico ps = new ProdutoServico();
		CompraServico cs = new CompraServico();
		UsuarioServico us = new UsuarioServico();

		int codUsuario = 0;
    	
    	String codigo="";
    	Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("codUsuarioLogado"))
					codigo = cookie.getValue();
				
			}
		}
		codUsuario = Integer.parseInt(codigo);
		Usuario usuarioAtual = us.buscar(codUsuario);
		
		Date dataAtual = new Date();
		Compra novaCompra = new Compra(null, dataAtual, usuarioAtual);
		//Compra novaCompra = new Compra();
		usuarioAtual.addCompra(novaCompra);
		
		int codProduto = Integer.parseInt(request.getParameter("codProduto"));
		Produto produto = ps.buscar(codProduto);
		
		ItemCompra novoItemCompra = new ItemCompra();
		novaCompra.addItemCompra(novoItemCompra);
		produto.addItemCompra(novoItemCompra);
		
		/*ItemCompra nova = new ItemCompra();
		produto.addItemCompra(nova);*/
		
		//List<Compra> compras = cs.buscarTodos();
		
		request.setAttribute("prod", produto);
		request.setAttribute("compra", novaCompra);
		request.setAttribute("usuario", usuarioAtual);
		request.setAttribute("item", novoItemCompra);
		//request.setAttribute("compraSelecionada", null);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		

		
		
	}
}
