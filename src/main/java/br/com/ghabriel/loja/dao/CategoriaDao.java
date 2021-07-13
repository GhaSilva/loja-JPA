package br.com.ghabriel.loja.dao;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.modelo.Categoria;


public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
