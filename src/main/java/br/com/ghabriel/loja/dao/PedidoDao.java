package br.com.ghabriel.loja.dao;




import java.math.BigDecimal;
import java.util.List;

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
	public BigDecimal valorTotalVentido() {
		String jqpl ="select sum(p.valorTotal) from Pedido p";
		return em.createQuery(jqpl, BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVendas(){
		String jpql = "select produto.nome, sum(item.quantidade), MAX(pedido.data) from Pedido pedido join pedido.items item join item.produto group by produto.nome "
				+ "order by item.quantidade desc";
		return em.createQuery(jpql, Object[].class).getResultList();
	}
	
	


}
