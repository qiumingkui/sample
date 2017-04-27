package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

public class User implements IdentityEntity<UserId> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserId id;

	private String account;

	private String password;

	private String name;

	private Role role;

	private User() {
		super();
	}

	public User(UserId aId, String aAccount, String aPassword, String aName, Role aRole) {
		this();

		this.setId(aId);
		this.setAccount(aAccount);
		this.setPassword(aPassword);
		this.setName(aName);
		this.setRole(aRole);

		if (aId == null || aId.key().trim().length() <= 0) {
			this.setAccount("anonymous");
			this.setPassword(null);
			this.setName("匿名用户");
			this.setRole(null);
		}
	}

	public UserId id() {
		return id;
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

	public Role role(){
		return role;
	}
	
	public void changeRole(Role aRole){
		this.setRole(aRole);
	}
	
	public void changeName(String name) {
		this.setName(name);
	}

	public void changePassword(String aPasswordOriginalText) {
		String passwordCipherText = PasswordServcie.encryptPassword(aPasswordOriginalText);
		this.setPassword(passwordCipherText);
	}

	private void setId(UserId userId) {
		this.id = userId;
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

	private void setRole(Role role) {
		this.role = role;
	}

}
