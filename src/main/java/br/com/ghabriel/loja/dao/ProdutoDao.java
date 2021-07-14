package br.com.ghabriel.loja.dao;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.modelo.Categoria;
import br.com.ghabriel.loja.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
		
	}
	
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
		
	}
	
}
