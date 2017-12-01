package dao;

import java.util.List;

import dominio.Usuario;

public interface UsuarioDao {


	public void inserir(Usuario x);
	public void atualizar(Usuario x);
	public void excluir(Usuario x);
	public Usuario buscar(int codUsuario);
	public List<Usuario> buscarTodos();
	public Usuario buscaNomeExato(String nome);
	public Usuario buscaNomeExatoDiferente(Integer codUsuario, String nome);
	public List<Usuario> buscarTodosOrdenadosPorNome();
	public List<Usuario> buscarPorNome(String trecho);
	public Boolean buscarUsuarioExato(String nome, String senha);
}
