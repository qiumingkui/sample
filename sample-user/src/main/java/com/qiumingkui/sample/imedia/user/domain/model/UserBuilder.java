package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;

public class UserBuilder {

	public static User build(String aId, String aAccount, String aPassword, String aName, boolean aIsAdmin,
			boolean aIsCommonUser) {
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		User user = new User(new UserId(aId), aAccount, passwordCipherText, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

	public static User build(String aAccount, String aPassword, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		final String BLOG_ID = UUIDUtils.gen();
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		User user = build(BLOG_ID, aAccount, passwordCipherText, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

}
