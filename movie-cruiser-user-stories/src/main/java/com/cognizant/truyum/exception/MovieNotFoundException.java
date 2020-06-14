package com.cognizant.truyum.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Movie Not Found")
public class MovieNotFoundException extends Exception{
	public MovieNotFoundException(String msg)
	{
		super(msg);
	}
}