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

	private UserName name;

	private Role role;

	private User() {
		super();
	}

	public User(UserId aId, String aAccount, UserName aUserName, String aPassword) {
		this();
		this.init(aId, aAccount, aUserName, aPassword, Role.USER);
		
		// if (aId == null || aId.key().trim().length() <= 0) {
		// this.setAccount("anonymous");
		// this.setPassword(null);
		// this.setName(new UserName("anonymous", "匿名用户"));
		// this.setRole(null);
		// }
	}

	public User(UserId aId, String aAccount, UserName aUserName, String aPassword, Role aRole) {
		this();
		this.init(aId, aAccount, aUserName, aPassword, aRole);
	}

	public void init(UserId aId, String aAccount, UserName aUserName, String aPassword, Role aRole) {
		this.setId(aId);
		this.setAccount(aAccount);
		this.setPassword(aPassword);
		this.setName(aUserName);
		this.setRole(aRole);
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

	public UserName name() {
		return name;
	}

	public Role role() {
		return role;
	}

	public void changeNickname(String aNickname) {
		this.setName(new UserName(aNickname, this.name().realname()));
	}

	public void changeRealname(String aRealname) {
		this.setName(new UserName(this.name().nickname(), aRealname));
	}

	public void changePassword(String aPassword) {
		// String passwordCipherText =
		// PasswordServcie.encryptPassword(aPasswordOriginalText);
		this.setPassword(aPassword);
	}

	
	public void assignAdmin(){
		this.setRole(Role.ADMIN);
	}
	
	public void unassignAdmin(){
		this.setRole(Role.USER);
	}
	
	public void assignUser(){
		this.setRole(Role.USER);
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

	private void setName(UserName aUserName) {
		this.name = aUserName;
	}

	private void setRole(Role role) {
		this.role = role;
	}

}
