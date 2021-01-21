package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String message) {
		super(message);
	}

}
