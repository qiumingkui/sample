package com.qiumingkui.sample.iwords.blog.domain.model;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.domain.model.member.PersonBuilder;

public class MemberTestHelper {

	public static Person buildPerson4AdminExample() {
		return PersonBuilder.build("Zhangsan", "张三", true, false);
	}

	public static Person buildPerson4CommonUserExample() {
		return PersonBuilder.build("Lisi", "李四", false, true);
	}

	public static Person buildPerson4AnonymousExample() {
		return PersonBuilder.build("", "", "", false, false);
	}
	
}
