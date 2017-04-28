package com.qiumingkui.sample.imedia.user.helper;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserFactory;

public class UserTestHelper {

	public static User buildUser4AdminExample() {
		User user = UserFactory.create("Zhangsan", "zs", "张三", "11111111");
		user.assignAdmin();
		return user;
	}

	public static User buildUser4UserExample() {
		return UserFactory.create("Lisi","ls","李四", "11111111");
	}

	public static User buildUser4AnonymousExample() {
		User user = UserFactory.create("", "", "", null);
		return user;
	}

}
