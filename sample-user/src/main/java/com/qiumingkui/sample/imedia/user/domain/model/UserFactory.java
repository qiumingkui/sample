package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.ext.util.UUIDUtil;

public class UserFactory {

	public static User create(String aAccount, String aNickname, String aRealname, String aPassword) {
		final String BLOG_ID = UUIDUtil.gen();
		String passwordCipherText = PasswordServcie.encryptPassword(aPassword);
		User user = new User(new UserId(BLOG_ID), aAccount, new UserName(aNickname, aRealname), passwordCipherText);
		return user;
	}

}
