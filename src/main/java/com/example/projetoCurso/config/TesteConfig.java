package com.example.projetoCurso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projetoCurso.entidades.Categoria;
import com.example.projetoCurso.entidades.ItemPedido;
import com.example.projetoCurso.entidades.Pedido;
import com.example.projetoCurso.entidades.Produto;
import com.example.projetoCurso.entidades.Usuario;
import com.example.projetoCurso.entidades.enums.StatusPedido;
import com.example.projetoCurso.repositorio.CategoriaRepositorio;
import com.example.projetoCurso.repositorio.ItemPedidoRepositorio;
import com.example.projetoCurso.repositorio.PedidoRepositorio;
import com.example.projetoCurso.repositorio.ProdutoRepositorio;
import com.example.projetoCurso.repositorio.UsuarioRepositorio;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio ur;
	
	@Autowired
	private PedidoRepositorio pr;
	
	@Autowired
	private CategoriaRepositorio cr;
	
	@Autowired
	private ProdutoRepositorio pp;
	
	@Autowired
	private ItemPedidoRepositorio ipp;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores");
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto pro1 = new Produto(null, "O Senhor dos Anéis",
				"A verdade é que a dor é importante, ela será acompanhada.",
				90.5, "");
		Produto pro2 = new Produto(null, "smart tv",
				"Nenhum dinheiro será pago por nada. Mecenas primeiro.",
				2190.0, "");
		Produto pro3 = new Produto(null, "Macbook Pro",
				"Pois o eleifend é um ótimo professor, mas gentil.",
				1250.0, "");
		Produto pro4 = new Produto(null, "PC Gamer",
				"Até que os caminhões odeiem e fujam.",
				1200.0, "");
		Produto pro5 = new Produto(null, "Trilhos para Leigos",
				"Cras fringilla valles sem vel faucibus.",
				100.99, "");
		
		pp.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));
		
		pro1.getCategorias().add(cat2);
		pro2.getCategorias().add(cat1);
		pro2.getCategorias().add(cat3);
		pro3.getCategorias().add(cat3);
		pro4.getCategorias().add(cat3);
		pro5.getCategorias().add(cat2);
		
		pp.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com",
				"988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com",
				"977777777", "123456"); 
		
		ur.saveAll(Arrays.asList(u1, u2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), 
				StatusPedido.PAGO, u1); 
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), 
				StatusPedido.AGUARDANDO_PAGAMENTO, u2); 
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), 
				StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		
		pr.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemPedido ip1 = new ItemPedido(p1, pro1, 2, pro1.getPreco()); 
		ItemPedido ip2 = new ItemPedido(p1, pro3, 1, pro3.getPreco()); 
		ItemPedido ip3 = new ItemPedido(p2, pro3, 2, pro3.getPreco()); 
		ItemPedido ip4 = new ItemPedido(p3, pro5, 2, pro5.getPreco()); 
		
		ipp.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));		
	}
}
