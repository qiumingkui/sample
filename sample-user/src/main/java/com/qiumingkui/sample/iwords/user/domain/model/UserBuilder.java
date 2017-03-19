package com.qiumingkui.sample.iwords.user.domain.model;

import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class UserBuilder {

	public static User build(String aId, String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		User user = new User(new UserId(aId), aAccount, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

	public static User build(String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		final String BLOG_ID = UUIDUtils.gen();
		User user = build(BLOG_ID, aAccount, aName, aIsAdmin, aIsCommonUser);
		return user;
	}

}
