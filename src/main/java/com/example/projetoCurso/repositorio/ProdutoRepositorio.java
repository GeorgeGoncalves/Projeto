package com.example.projetoCurso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoCurso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
