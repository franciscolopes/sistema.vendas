package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemCompraDao;
import dominio.ItemCompra;

public class ItemCompraDaoImpl implements ItemCompraDao {


	private EntityManager em;



	public ItemCompraDaoImpl() {
		this.em = EM.getLocalEm();
	}

	
	
	@Override
	public void inserir(ItemCompra x) {

		if (x.getCodItemCompra() != null) {
			x = em.merge(x);
		}
		em.persist(x);


	}
	
	
	@Override
	public void atualizar(ItemCompra x) {

		if (x.getCodItemCompra() != null) {
			x = em.merge(x);
		}
		em.persist(x);


	}
	

	@Override
	public void excluir(ItemCompra x) {

		x = em.merge(x);
		em.remove(x);


	}

	@Override
	public ItemCompra buscar(int codItemCompra) {
		return em.find(ItemCompra.class, codItemCompra);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCompra> buscarTodos() {

		String jpql = "SELECT x FROM ItemCompra x";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}

}
