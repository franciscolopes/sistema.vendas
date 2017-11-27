package instanciacao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Compra;
import dominio.ItemCompra;
import dominio.Produto;
import dominio.Usuario;
import servico.CompraServico;
import servico.ItemCompraServico;
import servico.ProdutoServico;
import servico.UsuarioServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Usuario u1 = new Usuario(null, "Joao", "123", "10090510674");
			Usuario u2 = new Usuario(null, "Maria", "456", "10056710674");
			
			Compra c1 = new Compra(null, sdf.parse("20/10/2016"), u1);
			u1.addCompra(c1);
			Compra c2 = new Compra(null, sdf.parse("23/11/2016"), u1);
			u1.addCompra(c2);
			Compra c3 = new Compra(null, sdf.parse("21/10/2016"), u2);
			u2.addCompra(c3);
			Compra c4 = new Compra(null, sdf.parse("10/05/2016"), u2);
			u2.addCompra(c4);
			
			Produto p1 = new Produto(null, "Sabao", 5.80);
			Produto p2 = new Produto(null, "Arroz", 10.50);
			Produto p3 = new Produto(null, "Feijao", 9.20);
			Produto p4 = new Produto(null, "Lampada", 2.20);
			
			ItemCompra iC1 = new ItemCompra(null, 0.5, 5.80, 1, c1, p1);
			c1.addItemCompra(iC1);
			p1.addItemCompra(iC1);
			ItemCompra iC2 = new ItemCompra(null, 0.5, 10.50, 2, c1, p2);
			c1.addItemCompra(iC2);
			p2.addItemCompra(iC2);
			
			ItemCompra iC3 = new ItemCompra(null, 0.5, 5.80, 3, c2, p1);
			c2.addItemCompra(iC3);
			p1.addItemCompra(iC3);
			ItemCompra iC4 = new ItemCompra(null, 0.5, 9.20, 4, c2, p3);
			c2.addItemCompra(iC4);
			p3.addItemCompra(iC4);
			
			
			ItemCompra iC5 = new ItemCompra(null, 0.5, 5.80, 2, c3, p1);
			c3.addItemCompra(iC5);
			p1.addItemCompra(iC5);
			ItemCompra iC6 = new ItemCompra(null, 0.5, 2.20, 1, c3, p4);
			c3.addItemCompra(iC6);
			p4.addItemCompra(iC6);
			
			ItemCompra iC7 = new ItemCompra(null, 0.5, 5.80, 2, c4, p1);
			c4.addItemCompra(iC7);
			p1.addItemCompra(iC7);
			ItemCompra iC8 = new ItemCompra(null, 0.5, 2.20, 1, c4, p4);
			c4.addItemCompra(iC8);
			p4.addItemCompra(iC8);
			ItemCompra iC9 = new ItemCompra(null, 0.5, 9.20, 4, c4, p3);
			c4.addItemCompra(iC9);
			p3.addItemCompra(iC9);
			
			System.out.println("Teste do preco total da compra: Preco total da compra"+c1+":"); 
			System.out.println(c1.getPreçoTotal());

			
/*
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(u1);
			em.persist(u2);
			
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(c4);
			
			
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			
			em.persist(iC1);
			em.persist(iC2);
			em.persist(iC3);
			em.persist(iC4);
			em.persist(iC5);
			em.persist(iC6);
			em.persist(iC7);
			em.persist(iC8);
			em.persist(iC9);
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();*/
			
			UsuarioServico us = new UsuarioServico();
			CompraServico cs = new CompraServico();
			ProdutoServico ps = new ProdutoServico();
			ItemCompraServico iCs = new ItemCompraServico();
			
			us.inserirAtualizar(u1);
			us.inserirAtualizar(u2);
			
			cs.inserirAtualizar(c1);
			cs.inserirAtualizar(c2);
			cs.inserirAtualizar(c3);
			cs.inserirAtualizar(c4);
			
			
			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			ps.inserirAtualizar(p3);
			ps.inserirAtualizar(p4);
			
			iCs.inserirAtualizar(iC1);
			iCs.inserirAtualizar(iC2);
			iCs.inserirAtualizar(iC3);
			iCs.inserirAtualizar(iC4);
			iCs.inserirAtualizar(iC5);
			iCs.inserirAtualizar(iC6);
			iCs.inserirAtualizar(iC7);
			iCs.inserirAtualizar(iC8);
			iCs.inserirAtualizar(iC9);
			
			response.getWriter().append("Fim");

			
			
			
		}

		catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		
	}

}
