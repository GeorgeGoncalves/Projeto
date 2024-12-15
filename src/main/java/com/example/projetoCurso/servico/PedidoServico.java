package com.example.projetoCurso.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoCurso.entidades.Pedido;
import com.example.projetoCurso.repositorio.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio respositorio;
	
	public List<Pedido> findAll(){
		return respositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = respositorio.findById(id);
		return obj.get();
	}
}
