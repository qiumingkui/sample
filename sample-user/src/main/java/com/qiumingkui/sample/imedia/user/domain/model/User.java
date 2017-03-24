package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

public class User {
	private UserId userId;

	private String account;

	private String password;

	private String name;

	// private boolean isAdmin = false;
	//
	// private boolean isCommonUser = false;

	private Role role;

	// private boolean isIndividualPublisher = false;
	//
	// private boolean isPublicPublisher = false;

	private User() {
		super();
	}

	public User(UserId aUserId, String aAccount, String aPassword, String aName, Role aRole) {
		this();

		this.setUserId(aUserId);
		this.setAccount(aAccount);
		this.setPassword(aPassword);
		this.setName(aName);
		this.setRole(aRole);

		if (aUserId == null || aUserId.id().trim().length() <= 0) {
			this.setAccount("anonymous");
			this.setName("匿名用户");
			this.setRole(null);
		}
	}

	public UserId userId() {
		return userId;
	}

	public String account() {
		return account;
	}

	public String password() {
		return password;
	}

	public String name() {
		return name;
	}

	public boolean isAdmin() {
		if (this.role != null && this.role.isAdmin()) {
			return true;
		}
		return false;
	}

	public boolean isIMP() {
		if (this.role != null && this.role.isIMP()) {
			return true;
		}
		return false;
	}

	public boolean isPMP() {
		if (this.role != null && this.role.isPMP()) {
			return true;
		}
		return false;
	}

	public void changeName(String name) {
		this.setName(name);
	}

	public void changePassword(String aPasswordOriginalText) {
		String passwordCipherText = PasswordServcie.encryptPassword(aPasswordOriginalText);
		this.setPassword(passwordCipherText);
	}

	private void setUserId(UserId userId) {
		this.userId = userId;
	}

	private void setAccount(String account) {
		this.account = account;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	private void setRole(Role role) {
		this.role = role;
	}

}
