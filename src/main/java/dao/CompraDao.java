package dao;

import java.util.List;

import dominio.Compra;

public interface CompraDao {


	public void inserirAtualizar(Compra x);
	public void excluir(Compra x);
	public Compra buscar(int codCompra);
	public List<Compra> buscarTodos();

	
}
