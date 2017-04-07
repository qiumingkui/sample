package com.qiumingkui.sample.imedia.mp.helper;

import java.util.Date;

import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.BlogEntryFactory;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;

public class BlogEntryTestHelper {

	public static BlogEntry buildPostExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberTestHelper.buildAuthorExample(true);
		return BlogEntryFactory.create("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
