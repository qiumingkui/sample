package com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;

public interface UserRepository {

	public User get(UserId aPersonId);

	public void save(User aPerson);

	public void del(UserId aPersonId);

}
