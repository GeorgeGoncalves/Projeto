package com.example.projetoCurso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoCurso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
