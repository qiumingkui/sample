package com.qiumingkui.sample.iwords.blog.helper;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Admin;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.MemberBuilder;
//import com.qiumingkui.sample.iwords.user.domain.model.Person;
//import com.qiumingkui.sample.iwords.user.domain.model.PersonBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Reader;

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

	public static Admin buildAdminExample(boolean aValidated) {
		return MemberBuilder.buildAdmin("1", "Zhangsan", "张三", aValidated);
	}

	public static Author buildAuthorExample(boolean aValidated) {
		return MemberBuilder.buildAuthor("2", "Lisi", "李四", aValidated);
	}

	public static Reader buildReader(boolean aValidated) {
		return MemberBuilder.buildReader("3", "wangwu", "王五", aValidated);
	}
}
