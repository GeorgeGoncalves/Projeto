package com.example.projetoCurso.servico.exception;

public class RecursoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
}
