package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import dominio.ItemCompra;
import dominio.Produto;
import servico.CompraServico;
import servico.ProdutoServico;

@WebServlet("/compra/novo")
public class CompraNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		ProdutoServico ps = new ProdutoServico();
		CompraServico cs = new CompraServico();

		int codProduto = Integer.parseInt(request.getParameter("codProduto"));
		Produto produto = ps.buscar(codProduto);

		ItemCompra nova = new ItemCompra();
		produto.addItemCompra(nova);
		
		List<Compra> compras = cs.buscarTodos();
		
		request.setAttribute("item", nova);
		request.setAttribute("compras", compras);
		request.setAttribute("compraSelecionada", null);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
