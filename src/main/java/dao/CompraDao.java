package dao;

import java.util.List;

import dominio.Compra;

public interface CompraDao {


	public void inserir(Compra x);
	public void atualizar(Compra x);
	public void excluir(Compra x);
	public Compra buscar(int codCompra);
	public List<Compra> buscarTodos();
	public List<Compra> buscarPorAno(int anoMin, int anoMax);
	

	
}
