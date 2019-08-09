package it.piksel.censa.exception;

public class TokenVerificationException extends RuntimeException {

	private static final long serialVersionUID = -2492407141691620175L;

	public TokenVerificationException(Throwable t) {
		super(t);
	}
}
