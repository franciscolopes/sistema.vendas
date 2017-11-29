package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import servico.CompraServico;

@WebServlet("/compra/listar")
public class CompraListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
  	
	private static String DESTINO = "/compra/listar.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	CompraServico cs = new CompraServico();
		List<Compra> itens = cs.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
    
    }

}
