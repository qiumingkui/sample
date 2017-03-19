package com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.user.domain.model.User;
import com.qiumingkui.sample.iwords.user.domain.model.UserId;

public interface UserRepository {

	public User get(UserId aPersonId);

	public void save(User aPerson);

	public void del(UserId aPersonId);

}
