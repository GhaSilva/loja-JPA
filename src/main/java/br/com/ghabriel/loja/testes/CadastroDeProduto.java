package br.com.ghabriel.loja.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ghabriel.loja.modelo.Produto;


public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi");
		celular.setDescricao("Xiaomi redmi 8");
		celular.setPreco(1500.0f);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}
}
