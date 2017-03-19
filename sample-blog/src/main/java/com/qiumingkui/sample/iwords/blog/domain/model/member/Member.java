package com.qiumingkui.sample.iwords.blog.domain.model.member;

public abstract class Member {

	// protected Person person;

	private String id;

	private String account;

	private String name;

	private boolean isPermitted;

	private Member() {
		super();
	}

	public Member(String aId, String aAccount, String aName, boolean aIsPermitted) {
		this();
		this.setId(aId);
		this.setAccount(aAccount);
		this.setName(aName);
		this.setPermitted(aIsPermitted);
	}

	// public Member(Person aPerson) {
	// this(aPerson.personId().id(),aPerson.account(),aPerson.name(),false);
	// initPermitted(aPerson);
	// }
	//
	// protected abstract void initPermitted(Person aPerson);

	public boolean isPermitted() {
		return isPermitted;
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

	private void setPermitted(boolean isPermitted) {
		this.isPermitted = isPermitted;
	}

}
