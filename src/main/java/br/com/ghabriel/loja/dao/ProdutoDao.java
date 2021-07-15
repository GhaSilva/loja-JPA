package br.com.ghabriel.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	public List<Produto> buscarPorParametroComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		if(nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if(preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		
		if(dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
