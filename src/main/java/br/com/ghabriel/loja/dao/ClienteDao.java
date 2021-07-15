package br.com.ghabriel.loja.dao;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.modelo.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public Cliente buscarPorId(int id) {
		return em.find(Cliente.class, id);
	}
}
