package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
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