package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ProdutoDao;
import dao.Transaction;
import dominio.Produto;

public class ProdutoServico {


	private ProdutoDao dao;
	
	public ProdutoServico() {
		dao = DaoFactory.criarProdutoDao();
	}
	
	public void inserir(Produto x) throws ServicoException {
		try {
			Produto aux = dao.buscaNomeExato(x.getNome());
			if (aux != null) {
				throw new ServicoException("Já existe um produto com esse nome!", 1);
			}
			
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
	
	public void atualizar(Produto x)throws ServicoException {
		try {
			Produto aux = dao.buscaNomeExatoDiferente(x.getCodProduto(), x.getNome());
			if (aux != null) {
				throw new ServicoException("Já existe um Produto com esse nome!", 1);
			}
			
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
	
	public void excluir(Produto x)  throws ServicoException {
		try {
			x = dao.buscar(x.getCodProduto());
			if (!x.getItensCompra().isEmpty()) {
				throw new ServicoException("Exclusão não permitida: este Produto possui itens comprados!", 2);
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
	
	public Produto buscar(int codProduto) {
		return dao.buscar(codProduto);
	}
	
	public List<Produto> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Produto> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}

	
	public List<Produto> buscarPorNome(String trecho) {
		return dao.buscarPorNome(trecho);
	}

	
}
