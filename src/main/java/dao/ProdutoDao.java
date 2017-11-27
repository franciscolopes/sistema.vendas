package dao;

import java.util.List;

import dominio.Produto;

public interface ProdutoDao {


	public void inserir(Produto x);
	public void atualizar(Produto x);
	public void excluir(Produto x);
	public Produto buscar(int codProduto);
	public List<Produto> buscarTodos();
	public Produto buscaNomeExato(String nome);
	public Produto buscaNomeExatoDiferente(Integer codProduto, String nome);
	public List<Produto> buscarTodosOrdenadosPorNome();
	public List<Produto> buscarPorNome(String trecho);
}
