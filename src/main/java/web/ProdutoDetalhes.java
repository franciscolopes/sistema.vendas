package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;

@WebServlet("/compra/ProdutoDetalhes")
public class ProdutoDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/detalhes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoServico ps = new ProdutoServico();
		int codProduto = Integer.parseInt(request.getParameter("codProduto"));
		Produto produto = ps.buscar(codProduto);
		
		Cookie produtoOlhado = new Cookie("codProdutoOlhado"+codProduto, Integer.toString(codProduto));
		produtoOlhado.setMaxAge(5*60);
		
		response.addCookie(produtoOlhado);
		
		request.setAttribute("item", produto);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
