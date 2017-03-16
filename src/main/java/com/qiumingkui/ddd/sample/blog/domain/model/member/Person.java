package com.qiumingkui.ddd.sample.blog.domain.model.member;

public class Person {
	private String id;

	private String account;

	private String name;

	private boolean isAdmin;

	private boolean isCommonUser;

	private Person() {
		super();
	}

	public Person(String aId, String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		this();
		this.id=aId;
		this.account = aAccount;
		this.name = aName;
		this.isAdmin = aIsAdmin;
		this.isCommonUser = aIsCommonUser;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean isCommonUser() {
		return isCommonUser;
	}

}
