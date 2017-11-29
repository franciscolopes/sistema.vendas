package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import servico.UsuarioServico;

@WebServlet("/usuario/listar")
public class UsuarioListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
  	
	private static String DESTINO = "/usuario/listar.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	UsuarioServico us = new UsuarioServico();
		List<Usuario> itens = us.buscarTodosOrdenadosPorNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
    
    }

}
