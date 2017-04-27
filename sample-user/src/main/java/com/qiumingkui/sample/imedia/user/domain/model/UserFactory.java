package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.ext.util.UUIDUtil;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

public class UserFactory {

	public static User create(String aAccount, String aPassword, String aName, Role aRole) {
		final String BLOG_ID = UUIDUtil.gen();
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		User user = new User(new UserId(BLOG_ID), aAccount, passwordCipherText, aName, aRole);
		return user;
	}

}
