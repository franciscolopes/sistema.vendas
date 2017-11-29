package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;

@WebServlet("/compra/comprar")
public class ProdutoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/listarProdutos.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProdutoServico ps = new ProdutoServico();
		List<Produto> itens = ps.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
