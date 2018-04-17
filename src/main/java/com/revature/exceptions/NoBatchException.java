package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Joshua Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
 * Last updated: 4/10/18
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoBatchException extends RuntimeException{

	private static final long serialVersionUID = 7691014160603213208L;
	
	private final String message;
	
	public NoBatchException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}