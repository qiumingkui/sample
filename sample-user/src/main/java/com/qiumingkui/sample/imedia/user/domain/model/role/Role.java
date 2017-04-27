package com.qiumingkui.sample.imedia.user.domain.model.role;

public enum Role {

	ADMIN(-1), USER(0);

	private int code;

	public static Role create(int aCode) {
		if (aCode == ADMIN.code) {
			return ADMIN;
		}

		if (aCode == USER.code) {
			return USER;
		}
		
		return null;
	}

	private Role(int code) {
		this.code = code;
	}

	public int code() {
		return this.code;
	}

}
