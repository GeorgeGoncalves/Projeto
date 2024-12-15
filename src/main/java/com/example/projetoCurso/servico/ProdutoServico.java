package com.example.projetoCurso.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoCurso.entidades.Produto;
import com.example.projetoCurso.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio respositorio;
	
	public List<Produto> findAll(){
		return respositorio.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = respositorio.findById(id);
		return obj.get();
	}
}
