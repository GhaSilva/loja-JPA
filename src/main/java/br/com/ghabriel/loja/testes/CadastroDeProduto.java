package br.com.ghabriel.loja.testes;

import javax.persistence.EntityManager;


import br.com.ghabriel.loja.dao.ProdutoDao;
import br.com.ghabriel.loja.modelo.Produto;
import br.com.ghabriel.loja.util.JPAUtil;


public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi");
		celular.setDescricao("Xiaomi redmi 8");
		celular.setPreco(1500.0f);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
