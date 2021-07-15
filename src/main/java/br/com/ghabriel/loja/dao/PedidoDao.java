package br.com.ghabriel.loja.dao;




import javax.persistence.EntityManager;
import br.com.ghabriel.loja.modelo.Pedido;


public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

}
