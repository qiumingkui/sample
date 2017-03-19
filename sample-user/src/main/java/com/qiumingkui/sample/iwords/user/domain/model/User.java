package com.qiumingkui.sample.iwords.user.domain.model;

public class User {
	private UserId userId;

	private String account;

	private String name;

	private boolean isAdmin;

	private boolean isCommonUser;

	private User() {
		super();
	}

	public User(UserId aUserId, String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		this();
		this.userId = aUserId;
		this.account = aAccount;
		this.name = aName;
		this.isAdmin = aIsAdmin;
		this.isCommonUser = aIsCommonUser;

		if (aUserId == null || aUserId.id().trim().length() <= 0) {
			this.account = "anonymous";
			this.name = "匿名用户";
			this.isAdmin = false;
			this.isCommonUser = false;
		}
	}

	public UserId userId() {
		return userId;
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
