package com.example.projetoCurso.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.projetoCurso.entidades.Usuario;
import com.example.projetoCurso.repositorio.UsuarioRepositorio;
import com.example.projetoCurso.servico.exception.BDException;
import com.example.projetoCurso.servico.exception.RecursoNaoEncontrado;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontrado(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new BDException(e.getMessage());
		}
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
	}

	private void updateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
