package servico;

import java.util.List;

import dao.DaoFactory;
import dao.Transaction;
import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioServico {


	private UsuarioDao dao;
	
	public UsuarioServico() {
		dao = DaoFactory.criarUsuarioDao();
	}
	
	public void inserir(Usuario x)throws ServicoException {
		try {
			Usuario aux = dao.buscaNomeExato(x.getNome());
			if (aux != null) {
				throw new ServicoException("Já existe um Usuario com esse nome!", 1);
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
	
	
	public void atualizar(Usuario x) throws ServicoException {
		try {
			Usuario aux = dao.buscaNomeExatoDiferente(x.getCodUsuario(), x.getNome());
			if (aux != null) {
				throw new ServicoException("Já existe um Usuario com esse nome!", 1);
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
	
	public void excluir(Usuario x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodUsuario());
			if (!x.getCompras().isEmpty()) {
				throw new ServicoException("Exclusão não permitida: este Usuario possui compras!", 2);
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
	
	public Usuario buscar(int codUsuario) {
		return dao.buscar(codUsuario);
	}
	
	public List<Usuario> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Usuario> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}

	
	public List<Usuario> buscarPorNome(String trecho) {
		return dao.buscarPorNome(trecho);
	}


	
}
