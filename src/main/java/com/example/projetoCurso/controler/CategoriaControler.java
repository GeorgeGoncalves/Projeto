package com.example.projetoCurso.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoCurso.entidades.Categoria;
import com.example.projetoCurso.servico.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControler {

		@Autowired
		private CategoriaServico servico;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> findAll(){
			List<Categoria> lista = servico.findAll();
			return ResponseEntity.ok().body(lista);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Categoria> findById(@PathVariable Long id){
			Categoria obj = servico.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
