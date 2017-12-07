package web;

import javax.servlet.http.HttpServletRequest;

import dominio.Compra;
import dominio.ItemCompra;
import dominio.Produto;
import servico.CompraServico;
import servico.ProdutoServico;

public class Instanciar {

	public static ItemCompra itemCompra(HttpServletRequest request) {
		
		ProdutoServico ps = new ProdutoServico();
		CompraServico cs = new CompraServico();
		
		ItemCompra aux = new ItemCompra();
		String s;
		
		
		s = request.getParameter("codItemCompra");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodItemCompra(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codItemCompra invalido");
			}
		}
		
		s = request.getParameter("desconto");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDesconto(Double.parseDouble(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: desconto invalido");
			}
		}
		
		s = request.getParameter("preco");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDesconto(Double.parseDouble(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: preco invalido");
			}
		}
		
		s = request.getParameter("quantidade");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDesconto(Double.parseDouble(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: quantidade invalido");
			}
		}
		

		s = request.getParameter("codCompra");
		if (s != null && !s.isEmpty()) {
			try {
				Compra x = cs.buscar(Integer.parseInt(s));
				aux.setCompra(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codCompra invalido");
			}
		}

		s = request.getParameter("codProduto");
		if (s != null && !s.isEmpty()) {
			try {
				Produto x = ps.buscar(Integer.parseInt(s));
				aux.setProduto(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codProduto invalido");
			}
		}

		return aux;
	}
	
	
}
