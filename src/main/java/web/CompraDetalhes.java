package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import dominio.ItemCompra;
import servico.CompraServico;
import servico.ItemCompraServico;

@WebServlet("/compra/CompraDetalhes")
public class CompraDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/compra/CompraDetalhes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CompraServico cs = new CompraServico();
		int codCompra = Integer.parseInt(request.getParameter("codCompra"));
		Compra compra = cs.buscar(codCompra);
		
		ItemCompraServico iCs = new ItemCompraServico();
		List<ItemCompra> itens = new ArrayList<ItemCompra>();
		
		for(ItemCompra x : compra.getItensCompra()){
			
				itens.add(x);
			
		}
		
		
		request.setAttribute("compra", compra);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
