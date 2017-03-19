package com.qiumingkui.sample.iwords.user.helper;

import com.qiumingkui.sample.iwords.user.domain.model.Person;
import com.qiumingkui.sample.iwords.user.domain.model.PersonBuilder;

public class PersonTestHelper {

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
