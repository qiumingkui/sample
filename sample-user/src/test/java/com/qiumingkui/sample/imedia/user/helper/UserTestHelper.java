package com.qiumingkui.sample.imedia.user.helper;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserBuilder;

public class UserTestHelper {

	public static User buildUser4AdminExample() {
		return UserBuilder.build("Zhangsan", "11111111","张三", true, false);
	}

	public static User buildUser4CommonUserExample() {
		return UserBuilder.build("Lisi","11111111", "李四", false, true);
	}

	public static User buildUser4AnonymousExample() {
		return UserBuilder.build("", "", "", false, false);
	}

}
