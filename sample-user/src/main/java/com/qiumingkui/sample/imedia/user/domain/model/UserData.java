package com.qiumingkui.sample.imedia.user.domain.model;

import java.io.Serializable;

public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String account;

	private String nickname;

	private String realname;

	private String password;

	private int role;

	public UserData(User aUser) {

		this(aUser.id().key(), aUser.account(), aUser.name().nickname(), aUser.name().realname(), aUser.password(),
				aUser.role().code());
	}

	public UserData(String id, String account, String nickname, String realname, String password, int role) {
		super();
		this.id = id;
		this.account = account;
		this.nickname = nickname;
		this.realname = realname;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getAccount() {
		return account;
	}

	public String getNickname() {
		return nickname;
	}

	public String getRealname() {
		return realname;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
