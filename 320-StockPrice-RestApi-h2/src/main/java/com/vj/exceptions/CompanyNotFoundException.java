package com.vj.exceptions;

public class CompanyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompanyNotFoundException(String msg) {
		super(msg);
	}
}
