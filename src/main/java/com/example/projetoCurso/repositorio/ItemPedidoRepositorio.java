package com.example.projetoCurso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoCurso.entidades.ItemPedido;
import com.example.projetoCurso.entidades.pk.ItemPedidoPK;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, ItemPedidoPK>{

}
