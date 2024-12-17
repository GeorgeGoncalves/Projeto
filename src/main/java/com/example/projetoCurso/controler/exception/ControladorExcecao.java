package com.example.projetoCurso.controler.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.projetoCurso.servico.exception.RecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControladorExcecao {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(
			RecursoNaoEncontrado e,	HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String erro = "Recurso não encontrado.";
		ErroPadrao err = new ErroPadrao(
				Instant.now(), status.value(), e.getMessage(), erro ,
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
