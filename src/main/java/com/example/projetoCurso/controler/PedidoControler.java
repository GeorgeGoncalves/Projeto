package com.example.projetoCurso.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoCurso.entidades.Pedido;
import com.example.projetoCurso.servico.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoControler {

		@Autowired
		private PedidoServico servico;
		
		@GetMapping
		public ResponseEntity<List<Pedido>> findAll(){
			List<Pedido> lista = servico.findAll();
			return ResponseEntity.ok().body(lista);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Pedido> findById(@PathVariable Long id){
			Pedido obj = servico.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
