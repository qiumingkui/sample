package com.qiumingkui.sample.imedia.user.helper;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserBuilder;
import com.qiumingkui.sample.imedia.user.domain.model.role.ADMIN;
import com.qiumingkui.sample.imedia.user.domain.model.role.IMP;

public class UserTestHelper {

	public static User buildUser4AdminExample() {
		return UserBuilder.build("Zhangsan", "11111111", "张三", new ADMIN());
	}

	public static User buildUser4ImpExample() {
		return UserBuilder.build("Lisi", "11111111", "李四", new IMP());
	}

	public static User buildUser4AnonymousExample() {
		return UserBuilder.build("", "", "", null);
	}

}
