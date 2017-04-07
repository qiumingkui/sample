package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.util.UUIDUtil;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

public class UserBuilder {

	public static User build(String aId, String aAccount, String aPassword, String aName, Role aRole) {
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		User user = new User(new UserId(aId), aAccount, passwordCipherText, aName, aRole);
		return user;
	}

	public static User build(String aAccount, String aPassword, String aName, Role aRole) {
		final String BLOG_ID = UUIDUtil.gen();
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		// Role role = new IMP();
		User user = build(BLOG_ID, aAccount, passwordCipherText, aName, aRole);
		return user;
	}

}
