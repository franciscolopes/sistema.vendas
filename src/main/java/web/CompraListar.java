package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Compra;
import servico.CompraServico;

@WebServlet("/compra/listar")
public class CompraListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
  	
	private static String DESTINO = "/compra/listar.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	CompraServico cs = new CompraServico();
    	HttpSession sessaoAtual = request.getSession(false);
    	//int codUsuario = 2;
    	int codUsuario = 0;
    	//codUsuario = (Integer) sessaoAtual.getAttribute("codUsuarioLogado");
    	//nomeUsuario = (String) sessaoAtual.getAttribute("usuarioLogado");
    	
    	String codigo="";
    	Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("codUsuarioLogado"))
					codigo = cookie.getValue();
				
			}
		}
		codUsuario = Integer.parseInt(codigo);
    	
		List<Compra> itens = cs.buscarTodosUsuario(codUsuario);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
    
    }

}
