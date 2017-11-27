package servico;

import java.util.List;

import dao.CompraDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Compra;

public class CompraServico {


	private CompraDao dao;
	
	public CompraServico() {
		dao = DaoFactory.criarCompraDao();
	}
	
	public void inserirAtualizar(Compra x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Compra x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Compra buscar(int codCompra) {
		return dao.buscar(codCompra);
	}
	
	public List<Compra> buscarTodos() {
		return dao.buscarTodos();
	}

	
}
