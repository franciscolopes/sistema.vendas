package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em;

	public UsuarioDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserir(Usuario x) {

		if (x.getCodUsuario() != null) {
			x = em.merge(x);
		}
		em.persist(x);

	}

	@Override
	public void atualizar(Usuario x) {

		if (x.getCodUsuario() != null) {
			x = em.merge(x);
		}
		em.persist(x);

	}

	@Override
	public void excluir(Usuario x) {

		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Usuario buscar(int codUsuario) {
		return em.find(Usuario.class, codUsuario);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {

		String jpql = "SELECT x FROM Usuario x";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscaNomeExato(String nome) {
		String jpql = "SELECT x FROM Usuario x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Usuario> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscaNomeExatoDiferente(Integer codUsuario, String nome) {
		String jpql = "SELECT x FROM Produto x WHERE x.codUsuario <> :p0 AND x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codUsuario);
		query.setParameter("p1", nome);
		List<Usuario> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	
	/*----------LOGIN-----------*/
	@SuppressWarnings("unchecked")
	@Override
	public Boolean buscarUsuarioExato(String nome, String senha){
		String jpql = "SELECT x FROM Usuario x WHERE x.nomeUsuario = :p0 AND x.senhaUsuario = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", nome);
		query.setParameter("p1", senha);
		List<Usuario> aux = query.getResultList();
		//return (aux.size() > 0) ? aux.get(0) : null;
		return (aux.size() > 0) ? true : false;
	}

	/*----------LOGIN-----------*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Usuario x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Usuario x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}

	
	
	
}
