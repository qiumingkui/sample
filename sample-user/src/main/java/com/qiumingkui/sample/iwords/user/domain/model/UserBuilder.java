package com.qiumingkui.sample.iwords.user.domain.model;

import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class UserBuilder {

	public static User build(String aId, String aAccount, String aPassword, String aName, boolean aIsAdmin,
			boolean aIsCommonUser) {
		User user = new User(new UserId(aId), aAccount, aPassword, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

	public static User build(String aAccount, String aPassword, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		final String BLOG_ID = UUIDUtils.gen();
		User user = build(BLOG_ID, aAccount, aPassword, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

}
