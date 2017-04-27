package com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;
import com.qiumingkui.sample.imedia.user.helper.UserTestHelper;
import com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private User aUser4Admin;
	private UserId aUser4AdminId;
	private User aUser4CommonUser;
	private UserId aUser4CommonUserId;

	@Before
	public void save4Create() {
		aUser4Admin = UserTestHelper.buildUser4AdminExample();
		aUser4AdminId = aUser4Admin.id();
		userRepository.save(aUser4Admin);

		aUser4CommonUser = UserTestHelper.buildUser4ImpExample();
		aUser4CommonUserId = aUser4CommonUser.id();
		userRepository.save(aUser4CommonUser);
	}

	@Test
	public void get() {
		User user = userRepository.get(aUser4AdminId);
		assertThat(user != null).isTrue();
		assertThat(user.role()==Role.ADMIN).isTrue();
		assertThat(user.role()==Role.USER).isFalse();
	}

	@Test
	public void save4Update() {
		User user4Admin1 = userRepository.get(aUser4AdminId);
		userRepository.save(user4Admin1);
		user4Admin1 = userRepository.get(aUser4AdminId);
		assertThat(user4Admin1.role()==Role.ADMIN).isTrue();
		assertThat(user4Admin1.role()==Role.USER).isFalse();

		User user4CommonUser1 = userRepository.get(aUser4CommonUserId);
		userRepository.save(user4CommonUser1);
		user4CommonUser1 = userRepository.get(aUser4CommonUserId);
		assertThat(user4CommonUser1.role()==Role.ADMIN).isFalse();
		assertThat(user4CommonUser1.role()==Role.USER).isTrue();
	}

	@Test
	public void del() {
		userRepository.del(aUser4AdminId);
		User person4Admin1 = userRepository.get(aUser4AdminId);
		assertThat(person4Admin1 != null).isFalse();
	}

}
