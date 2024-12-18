package com.example.projetoCurso.servico.exception;

public class BDException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BDException(String msg) {
		super(msg);
	}
}
