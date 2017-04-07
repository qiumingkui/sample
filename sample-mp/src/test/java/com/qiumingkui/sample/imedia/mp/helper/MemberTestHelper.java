package com.qiumingkui.sample.imedia.mp.helper;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Admin;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.member.MemberBuilder;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Reader;

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
	
	public static Owner buildOwner(boolean aValidated) {
		return MemberBuilder.buildOwner("4", "liumazi", "刘麻子", aValidated);
	}
}
