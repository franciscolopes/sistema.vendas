package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import servico.UsuarioServico;

@WebServlet("/efetuaLogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioServico servicoUsuario;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("nome");
		String pass = request.getParameter("senha");
		int n1 = 1;
		int n2 = 2;

		
		//if (servicoUsuario.existeUsuario(nome, senha)==true) {
		if (name.equals("ana")) {
			out.print("Welcome, " + name);
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuarioLogado", name);
			sessao.setMaxInactiveInterval(30); // 30 seconds
			response.sendRedirect("index.jsp");
			//RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			//rs.include(request, response);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		else {
			//out.println("Usuário ou senha incorretos");
			//RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rs.include(request, response);
		}

	}

}
