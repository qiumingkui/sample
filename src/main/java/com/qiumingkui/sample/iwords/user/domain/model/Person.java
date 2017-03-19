package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class Person {
	private PersonId personId;

	private String account;

	private String name;

	private boolean isAdmin;

	private boolean isCommonUser;

	private Person() {
		super();
	}

	public Person(PersonId aPersonId, String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		this();
		this.personId = aPersonId;
		this.account = aAccount;
		this.name = aName;
		this.isAdmin = aIsAdmin;
		this.isCommonUser = aIsCommonUser;

		if (aPersonId == null || aPersonId.id().trim().length() <= 0) {
			this.account = "anonymous";
			this.name = "匿名用户";
			this.isAdmin = false;
			this.isCommonUser = false;
		}
	}

	public PersonId personId() {
		return personId;
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
