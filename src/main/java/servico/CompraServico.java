package servico;

import java.util.List;

import dao.CompraDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Compra;

public class CompraServico {


	private CompraDao dao;
	
	public CompraServico() {
		dao = DaoFactory.criarCompraDao();
	}
	
	public void inserir(Compra x)  throws ServicoException {
		try {
			
			
			Transaction.begin();
			dao.inserir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
}
	
	
	
	public void atualizar(Compra x) throws ServicoException {
		try {
			
			
			Transaction.begin();
			dao.atualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}


	}
	
	
	
	
	
	
	public void excluir(Compra x)  throws ServicoException {
		try {
			x = dao.buscar(x.getCodCompra());
			if (!x.getItensCompra().isEmpty()) {
				throw new ServicoException("Exclusão não permitida: este compra possui itens associados!", 2);
			}
			
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	
	
	public Compra buscar(int codCompra) {
		return dao.buscar(codCompra);
	}
	
	public List<Compra> buscarTodos() {
		return dao.buscarTodos();
	}

	/*-------retorna compras do usuario---------*/
	public List<Compra> buscarTodosUsuario(int codUsuario) {
		return dao.buscarComprasUsuario(codUsuario);
	}
	
	/*-------retorna compras do usuario---------*/
	
	
	
	
	public List<Compra> buscarPorAno(int anoMin, int anoMax) {
		return dao.buscarPorAno(anoMin, anoMax);
	}

	
	
}
