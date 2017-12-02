package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		response.setContentType("text/html;charset=UTF-8");
		HttpSession sessaoAtual = request.getSession(false);
		// String nomeUsuario ="";
		sessaoAtual = null;
		if (sessaoAtual == null) {

			response.sendRedirect("login.jsp");

		}

		// HttpSession sessaoAtual = request.getSession(false);
		// sessaoAtual.setAttribute("usuarioLogado", null);
		// sessaoAtual.removeAttribute("usuarioLogado");
		// sessaoAtual.getMaxInactiveInterval();
*/
	}

}
