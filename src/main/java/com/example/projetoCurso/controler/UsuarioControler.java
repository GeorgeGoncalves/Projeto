package com.example.projetoCurso.controler;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		@PostMapping
		public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
			obj = servico.insert(obj);
			URI uri = ServletUriComponentsBuilder.
					fromCurrentRequest().path("/{id}").
					buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			servico.delete(id);
			return ResponseEntity.noContent().build();
		}
}
