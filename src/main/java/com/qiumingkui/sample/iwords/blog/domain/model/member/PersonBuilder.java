package com.qiumingkui.sample.iwords.blog.domain.model.member;

import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class PersonBuilder {

	public static Person build(String aId, String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		Person person = new Person(new PersonId(aId), aAccount, aName, aIsAdmin, aIsCommonUser);
		return person;
	}

	public static Person build(String aAccount, String aName, boolean aIsAdmin, boolean aIsCommonUser) {
		final String BLOG_ID = UUIDUtils.gen();
		Person person = build(BLOG_ID, aAccount, aName, aIsAdmin, aIsCommonUser);
		return person;
	}

}
