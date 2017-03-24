package com.qiumingkui.sample.imedia.mp.domain.model.member;

public abstract class Member {

	private String id;

	private String account;

	private String name;

	private boolean validated;

	private Member() {
		super();
	}

	public Member(String aId, String aAccount, String aName, boolean aValidated) {
		this();
		this.setId(aId);
		this.setAccount(aAccount);
		this.setName(aName);
		this.setValidated(aValidated);
	}

	public boolean isValidated() {
		return validated;
	}

	public String id() {
		return id;
	}

	public String account() {
		return account;
	}

	public String name() {
		return name;
	}

	private void setId(String id) {
		this.id = id;
	}

	private void setAccount(String account) {
		this.account = account;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setValidated(boolean aValidated) {
		this.validated = aValidated;
	}

}
