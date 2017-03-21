package com.qiumingkui.sample.iwords.user.domain.model;

public class AuthenticateResult {

	private boolean validated;

	private String message;

	public AuthenticateResult(boolean aValidated) {
		this(aValidated, "The validated is " + aValidated+" !");
	}

	public AuthenticateResult(boolean aValidated, String aMessage) {
		super();
		this.validated = aValidated;
		this.message = aMessage;
	}

	public boolean validated() {
		return validated;
	}

	public String message() {
		return message;
	}

}
