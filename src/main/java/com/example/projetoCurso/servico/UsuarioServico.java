package com.example.projetoCurso.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoCurso.entidades.Usuario;
import com.example.projetoCurso.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio respositorio;
	
	public List<Usuario> findAll(){
		return respositorio.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = respositorio.findById(id);
		return obj.get();
	}
}
