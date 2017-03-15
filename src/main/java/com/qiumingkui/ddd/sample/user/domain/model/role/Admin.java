package com.qiumingkui.ddd.sample.user.domain.model.role;

public class Admin implements Role{
	public static final int ADMIN = -1;

	@Override
	public int code() {
		return ADMIN;
	}

}
