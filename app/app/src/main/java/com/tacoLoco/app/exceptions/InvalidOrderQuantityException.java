package com.tacoLoco.app.exceptions;

public class InvalidOrderQuantityException extends RuntimeException{

	private static final long serialVersionUID = 6608059251184663200L;

	public InvalidOrderQuantityException(String message) {
		super(message);
	}
}
