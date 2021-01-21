package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class EmptyProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyProductException()  {
		super();	
	}

	public EmptyProductException(String message) {
		super(message);
	}

}
