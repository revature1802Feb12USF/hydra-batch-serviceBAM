package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Joshua Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
 * Last updated: 4/10/18
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BatchUpdateException extends RuntimeException {

	private static final long serialVersionUID = 6173194688911103752L;

	private final String message;

	public BatchUpdateException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}