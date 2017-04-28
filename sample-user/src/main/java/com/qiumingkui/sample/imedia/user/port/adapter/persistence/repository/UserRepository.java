package com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;

public interface UserRepository {

	public User get(UserId aUserId);

	public User getUserByAccount(String account);
	
	public void save(User aUser);

	public void del(UserId aUserId);

}
