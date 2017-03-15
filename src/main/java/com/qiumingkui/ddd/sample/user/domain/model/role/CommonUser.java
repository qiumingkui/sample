package com.qiumingkui.ddd.sample.user.domain.model.role;

public class CommonUser implements Role{
	public static final int COMMON_USER = 0;

	@Override
	public int code() {
		return COMMON_USER;
	}

}
