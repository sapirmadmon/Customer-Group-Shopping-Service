package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidProdQuantityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProdQuantityException() {
		super();
	}

	public InvalidProdQuantityException(String message) {
		super(message);
	}
}