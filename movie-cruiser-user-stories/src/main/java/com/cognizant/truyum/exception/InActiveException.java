package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "All future or not active")
public class InActiveException extends Exception{
public InActiveException(String msg)
{
	super(msg);
}
}