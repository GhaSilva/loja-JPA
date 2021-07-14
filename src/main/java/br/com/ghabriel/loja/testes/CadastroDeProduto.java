package br.com.ghabriel.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.dao.CategoriaDao;
import br.com.ghabriel.loja.dao.ProdutoDao;
import br.com.ghabriel.loja.modelo.Categoria;
import br.com.ghabriel.loja.modelo.Produto;
import br.com.ghabriel.loja.util.JPAUtil;


public class CadastroDeProduto {
	public static void main(String[] args) {
		//cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPorId(1);
		System.out.println(p);
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
	}

	private static void cadastrarProduto() {
		Categoria celulares= new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi", "Xiaomi redmi 8", 1500.0f, celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
