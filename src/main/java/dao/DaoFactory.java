package dao;

import dao.impl.CompraDaoImpl;
import dao.impl.ItemCompraDaoImpl;
import dao.impl.ProdutoDaoImpl;
import dao.impl.UsuarioDaoImpl;

public class DaoFactory {


	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoImpl();
	}


	public static CompraDao criarCompraDao() {
		return new CompraDaoImpl();
	}


	public static ProdutoDao criarProdutoDao() {
		return new ProdutoDaoImpl();
	}


	public static ItemCompraDao criarItemCompraDao() {
		return new ItemCompraDaoImpl();
	}

}
