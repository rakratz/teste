package br.edu.ipog.exceptions;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8230744852282544952L;

	public ValidationException(String message) {
		super(message);
	}

}
