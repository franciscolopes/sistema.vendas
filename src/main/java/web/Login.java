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
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		UsuarioServico servicoUsuario = new UsuarioServico();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		///*
		String nomeVerificado = "";
		String senhaVerificada = "";
		
		Boolean usuarioExiste = servicoUsuario.existeUsuario(nome, senha);
		if(usuarioExiste==true){
			nomeVerificado = nome;
			senhaVerificada = senha;
		}
		
		int codUsuario = servicoUsuario.retornaCodUsuario(nome, senha);
		
		
		if ((nome==nomeVerificado) && (senha==senhaVerificada)) {
			
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuarioLogado", nome);
			sessao.setAttribute("codUsuarioLogado", codUsuario);
			sessao.setMaxInactiveInterval(30); // 30 seconds
			response.sendRedirect("index.jsp");
			
		}

		else {
			
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Usuário ou senha incorretos.</font>");
			rs.include(request, response);
		}

	}

}
