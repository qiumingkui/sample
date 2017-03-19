package com.qiumingkui.sample.iwords.user.helper;

import com.qiumingkui.sample.iwords.user.domain.model.User;
import com.qiumingkui.sample.iwords.user.domain.model.UserBuilder;

public class UserTestHelper {

	public static User buildUser4AdminExample() {
		return UserBuilder.build("Zhangsan", "张三", true, false);
	}

	public static User buildUser4CommonUserExample() {
		return UserBuilder.build("Lisi", "李四", false, true);
	}

	public static User buildUser4AnonymousExample() {
		return UserBuilder.build("", "", "", false, false);
	}

}
