package com.example.projetoCurso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projetoCurso.entidades.Categoria;
import com.example.projetoCurso.entidades.Pedido;
import com.example.projetoCurso.entidades.Usuario;
import com.example.projetoCurso.entidades.enums.StatusPedido;
import com.example.projetoCurso.repositorio.CategoriaRepositorio;
import com.example.projetoCurso.repositorio.PedidoRepositorio;
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
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores");
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
		
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
	}

}
