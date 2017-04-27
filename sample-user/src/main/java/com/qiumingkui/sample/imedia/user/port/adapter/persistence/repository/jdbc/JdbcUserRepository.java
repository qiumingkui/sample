package com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;
import com.qiumingkui.sample.imedia.user.port.adapter.persistence.dao.UserDao;
import com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.UserRepository;


@Service
public class JdbcUserRepository implements UserRepository {
	@Autowired
	private UserDao userDao;

	@Override
	public User get(UserId aUserId) {
		return userDao.retrieve(aUserId);
	}

	@Override
	public void save(User aUser) {
		User retrieveUser = userDao.retrieve(aUser.id());
		if (retrieveUser != null) {
			userDao.update(aUser);
		} else {
			userDao.create(aUser);
		}

	}

	@Override
	public void del(UserId aUserId) {
		userDao.delete(aUserId);
	}
}
