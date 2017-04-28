package com.qiumingkui.sample.imedia.user.application;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.user.domain.model.UserData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationServiceTest {

	@Autowired
	private UserApplicationService userApplicationService;

	// private UserData userData;

	@Before
	public void init(){
		// userData = create();
	}
	
	@Test
	public void regist() {
		UserData userData = create();
		assertTrue(userData != null && userData.getId() != null && userData.getId().length() > 0);
		remove(userData);
	}

	@Test
	public void remove() {
		UserData userData = create();
		assertTrue(userData != null && userData.getId() != null && userData.getId().length() > 0);
		
		userApplicationService.removeUser(userData.getId());
		UserData ud = userApplicationService.getUserById(userData.getId());
		assertTrue(ud == null);
	}

	private UserData create() {
		Date date = new Date();
		String id = userApplicationService.regist("account:" + date, "nickname:" + date, "realname:" + date,
				"password:" + date);
		UserData userData = userApplicationService.getUserById(id);
		return userData;
	}
	
	private void remove(UserData userData) {
		userApplicationService.removeUser(userData.getId());
		UserData ud = userApplicationService.getUserById(userData.getId());
		assertTrue(ud == null);
	}

}
