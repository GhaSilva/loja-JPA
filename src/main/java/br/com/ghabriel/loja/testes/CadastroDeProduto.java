package br.com.ghabriel.loja.testes;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.dao.CategoriaDao;
import br.com.ghabriel.loja.dao.ProdutoDao;
import br.com.ghabriel.loja.modelo.Categoria;
import br.com.ghabriel.loja.modelo.Produto;
import br.com.ghabriel.loja.util.JPAUtil;


public class CadastroDeProduto {
	public static void main(String[] args) {
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
