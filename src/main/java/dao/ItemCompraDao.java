package dao;

import java.util.List;

import dominio.ItemCompra;

public interface ItemCompraDao {


	public void inserir(ItemCompra x);
	public void atualizar(ItemCompra x);
	public void excluir(ItemCompra x);
	public ItemCompra buscar(int codItemCompra);
	public List<ItemCompra> buscarTodos();

	
}
