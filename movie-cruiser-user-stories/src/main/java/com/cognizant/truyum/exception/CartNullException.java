package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart Empty")
public class CartNullException extends Exception {
	public CartNullException(String msg) {
		super(msg);
	}

	public CartNullException() {
	}
}
