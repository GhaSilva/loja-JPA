package br.com.ghabriel.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.ghabriel.loja.dao.CategoriaDao;
import br.com.ghabriel.loja.dao.ClienteDao;
import br.com.ghabriel.loja.dao.PedidoDao;
import br.com.ghabriel.loja.dao.ProdutoDao;
import br.com.ghabriel.loja.modelo.Categoria;
import br.com.ghabriel.loja.modelo.Cliente;
import br.com.ghabriel.loja.modelo.ItemPedido;
import br.com.ghabriel.loja.modelo.Pedido;
import br.com.ghabriel.loja.modelo.Produto;
import br.com.ghabriel.loja.util.JPAUtil;

public class CadastroDePedido {
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		Produto produto = produtoDao.buscarPorId(1);
		Cliente cliente = clienteDao.buscarPorId(1);
		em.getTransaction().begin();
		

		Pedido pedido = new Pedido(cliente );
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		em.getTransaction().commit();

	}
		private static void popularBancoDeDados() {
			Categoria celulares= new Categoria("CELULARES");
			Produto celular = new Produto("Iphone", "Xiaomi redmi 8", new BigDecimal(1500), celulares);
			
			
			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDao produtoDao = new ProdutoDao(em);
			CategoriaDao categoriaDao = new CategoriaDao(em);
			Cliente cliente = new Cliente("Rodrigo", "123456");
			ClienteDao clienteDao = new ClienteDao(em);
			
			em.getTransaction().begin();
			categoriaDao.cadastrar(celulares);
			clienteDao.cadastrar(cliente);
			produtoDao.cadastrar(celular);
			em.getTransaction().commit();
			em.close();
		

}
}