package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CompraDao;
import dominio.Compra;

public class CompraDaoImpl implements CompraDao {


	private EntityManager em;



	public CompraDaoImpl() {
		this.em = EM.getLocalEm();
	}

	
	
	@Override
	public void inserir(Compra x) {

		if (x.getCodCompra() != null) {
			x = em.merge(x);
		}
		em.persist(x);


	}
	
	@Override
	public void atualizar(Compra x) {

		if (x.getCodCompra() != null) {
			x = em.merge(x);
		}
		em.persist(x);


	}
	

	@Override
	public void excluir(Compra x) {

		x = em.merge(x);
		em.remove(x);


	}

	@Override
	public Compra buscar(int codCompra) {
		return em.find(Compra.class, codCompra);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> buscarTodos() {

		String jpql = "SELECT x FROM Compra x ORDER BY x.horarioCompra";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> buscarPorAno(int anoMin, int anoMax) {
		String jpql = "SELECT x FROM Compra x WHERE x.ano >= :p2 AND x.ano <= :p3";
		Query query = em.createQuery(jpql);
		query.setParameter("p2", anoMin);
		query.setParameter("p3", anoMax);
		return query.getResultList();
	}

	

}
