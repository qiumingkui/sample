package com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.iwords.user.helper.UserTestHelper;
import com.qiumingkui.sample.iwords.user.domain.model.User;
import com.qiumingkui.sample.iwords.user.domain.model.UserId;
import com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository.UserRepository;

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
		aUser4AdminId = aUser4Admin.userId();
		userRepository.save(aUser4Admin);

		aUser4CommonUser = UserTestHelper.buildUser4CommonUserExample();
		aUser4CommonUserId = aUser4CommonUser.userId();
		userRepository.save(aUser4CommonUser);
	}

	@Test
	public void get() {
		User user = userRepository.get(aUser4AdminId);
		assertThat(user != null).isTrue();
		assertThat(user.isAdmin()).isTrue();
		assertThat(user.isCommonUser()).isFalse();
	}

	@Test
	public void save4Update() {
		User user4Admin1 = userRepository.get(aUser4AdminId);
		userRepository.save(user4Admin1);
		user4Admin1 = userRepository.get(aUser4AdminId);
		assertThat(user4Admin1.isAdmin()).isTrue();
		assertThat(user4Admin1.isCommonUser()).isFalse();

		User user4CommonUser1 = userRepository.get(aUser4CommonUserId);
		userRepository.save(user4CommonUser1);
		user4CommonUser1 = userRepository.get(aUser4CommonUserId);
		assertThat(user4CommonUser1.isAdmin()).isFalse();
		assertThat(user4CommonUser1.isCommonUser()).isTrue();
	}

	@Test
	public void del() {
		userRepository.del(aUser4AdminId);
		User person4Admin1 = userRepository.get(aUser4AdminId);
		assertThat(person4Admin1 != null).isFalse();
	}

}
