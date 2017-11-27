package servico;

import java.util.List;

import dao.ItemCompraDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.ItemCompra;

public class ItemCompraServico {


	private ItemCompraDao dao;
	
	public ItemCompraServico() {
		dao = DaoFactory.criarItemCompraDao();
	}
	
	public void inserirAtualizar(ItemCompra x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(ItemCompra x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public ItemCompra buscar(int codItemCompra) {
		return dao.buscar(codItemCompra);
	}
	
	public List<ItemCompra> buscarTodos() {
		return dao.buscarTodos();
	}

	
}
