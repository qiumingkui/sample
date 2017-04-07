package com.qiumingkui.sample.imedia.blog.domain.model.blogmember;

public abstract class BlogMember {

	private String id;

	private String account;

	private String name;

	private boolean validated;

	private BlogMember() {
		super();
	}

	public BlogMember(String aId, String aAccount, String aName, boolean aValidated) {
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
