package com.example.projetoCurso.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoCurso.entidades.Usuario;
import com.example.projetoCurso.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControler {

		@Autowired
		private UsuarioServico servico;
		
		@GetMapping
		public ResponseEntity<List<Usuario>> findAll(){
			List<Usuario> lista = servico.findAll();
			return ResponseEntity.ok().body(lista);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Usuario> findById(@PathVariable Long id){
			Usuario obj = servico.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
