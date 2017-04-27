package com.qiumingkui.sample.imedia.user.helper;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserFactory;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

public class UserTestHelper {

	public static User buildUser4AdminExample() {
		return UserFactory.create("Zhangsan", "11111111", "张三", Role.ADMIN);
	}

	public static User buildUser4ImpExample() {
		return UserFactory.create("Lisi", "11111111", "李四", Role.USER);
	}

	public static User buildUser4AnonymousExample() {
		return UserFactory.create("", "", "", null);
	}

}
