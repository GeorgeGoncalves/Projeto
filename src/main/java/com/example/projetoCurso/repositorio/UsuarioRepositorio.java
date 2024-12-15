package com.example.projetoCurso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoCurso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
