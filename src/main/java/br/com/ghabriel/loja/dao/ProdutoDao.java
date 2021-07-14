package br.com.ghabriel.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

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

	public Produto buscarPorId(int id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		String jqpl = "select p from Produto p";
		return em.createQuery(jqpl, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jqpl = "select p from Produto p where p.nome = ?1";
		return em.createQuery(jqpl, Produto.class).setParameter(1, nome).getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		String jqpl = "select p from Produto p where p.categoria.nome = ?1";
		return em.createQuery(jqpl, Produto.class).setParameter(1, nome).getResultList();
	}

	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jqpl = "select p.preco from Produto p where p.nome = ?1";
		return em.createQuery(jqpl, BigDecimal.class).setParameter(1, nome).getSingleResult();
	}

}
