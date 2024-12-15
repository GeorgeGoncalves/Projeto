package com.example.projetoCurso.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoCurso.entidades.Categoria;
import com.example.projetoCurso.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio respositorio;
	
	public List<Categoria> findAll(){
		return respositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = respositorio.findById(id);
		return obj.get();
	}
}
