package com.qiumingkui.sample.imedia.blog.helper;

import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAdmin;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogMemberBuilder;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogReader;

public class MemberTestHelper {

	// public static Person buildPerson4AdminExample() {
	// return PersonBuilder.build("Zhangsan", "张三", true, false);
	// }
	//
	// public static Person buildPerson4CommonUserExample() {
	// return PersonBuilder.build("Lisi", "李四", false, true);
	// }
	//
	// public static Person buildPerson4AnonymousExample() {
	// return PersonBuilder.build("", "", "", false, false);
	// }

	public static BlogAdmin buildAdminExample(boolean aValidated) {
		return BlogMemberBuilder.buildAdmin("1", "Zhangsan", "张三", aValidated);
	}

	public static BlogAuthor buildAuthorExample(boolean aValidated) {
		return BlogMemberBuilder.buildAuthor("2", "Lisi", "李四", aValidated);
	}

	public static BlogReader buildReader(boolean aValidated) {
		return BlogMemberBuilder.buildReader("3", "wangwu", "王五", aValidated);
	}
	
	public static BlogOwner buildOwner(boolean aValidated) {
		return BlogMemberBuilder.buildOwner("4", "liumazi", "刘麻子", aValidated);
	}
}
