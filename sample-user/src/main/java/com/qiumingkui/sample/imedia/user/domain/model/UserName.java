package com.qiumingkui.sample.imedia.user.domain.model;

public class UserName {

	private String nickname;

	private String realname;

	public UserName(String aNickname, String aRealname) {
		super();
		init(aNickname, aRealname);
	}

	private void init(String aNickname, String aRealname) {
		this.setNickname(aNickname);
		this.setRealname(aRealname);
	}

	public String nickname() {
		return nickname;
	}

	public String realname() {
		return realname;
	}

	private void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private void setRealname(String realname) {
		this.realname = realname;
	}

}
