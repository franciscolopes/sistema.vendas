package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import dominio.ItemCompra;
import dominio.Produto;
import servico.CompraServico;
import servico.ItemCompraServico;
import servico.ProdutoServico;
import servico.ServicoException;

@WebServlet("/compra/itemInserir")
public class ItemInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/detalhesCompleto.jsp";
	//private static String FORM = "/compra/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CompraServico cs = new CompraServico();
			ItemCompraServico iCs = new ItemCompraServico();
			ProdutoServico ps = new ProdutoServico();
		
			
			int codCompra = Integer.parseInt(request.getParameter("codCompra"));
			Compra compra = cs.buscar(codCompra);
			
			/*int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
			Compra Usuario = us.buscar(codUsuario);*/
			
			int codProduto = Integer.parseInt(request.getParameter("codProduto"));
			Produto produto = ps.buscar(codProduto);
			
			//ItemCompra x = Instanciar.itemCompra(request);
			double desconto = Double.parseDouble(request.getParameter("desconto"));
			double preco = Double.parseDouble(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			
			ItemCompra x = new ItemCompra(null, desconto, preco, quantidade, compra, produto);
			iCs.inserir(x);

			request.setAttribute("compra", compra);
			request.setAttribute("itemCompra", x);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}

	}
}
