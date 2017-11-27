package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemCompraDao;
import dao.Transaction;
import dominio.ItemCompra;

public class ItemCompraServico {


	private ItemCompraDao dao;
	
	public ItemCompraServico() {
		dao = DaoFactory.criarItemCompraDao();
	}
	
	public void inserir(ItemCompra x) throws ServicoException {
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
	
	
	public void atualizar(ItemCompra x) throws ServicoException {
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
	
	public void excluir(ItemCompra x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodItemCompra());
			if (!(x.getCompra()==null)) {
				throw new ServicoException("Exclusão não permitida: este item esta em uma compra!", 2);
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
	
	public ItemCompra buscar(int codItemCompra) {
		return dao.buscar(codItemCompra);
	}
	
	public List<ItemCompra> buscarTodos() {
		return dao.buscarTodos();
	}

	
}
