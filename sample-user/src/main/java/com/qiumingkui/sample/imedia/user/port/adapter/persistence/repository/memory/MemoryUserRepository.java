package com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.memory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;
import com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.UserRepository;

//@Service
public class MemoryUserRepository implements UserRepository {

	private static Map<String, User> cache = new HashMap<String, User>();

	@Override
	public User get(UserId aPersonId) {
		return cache.get(aPersonId.key());
	}

	@Override
	public void save(User aPerson) {
		cache.put(aPerson.id().key(), aPerson);

	}

	@Override
	public void del(UserId aPersonId) {
		cache.remove(aPersonId.key());
	}

	@Override
	public User getUserByAccount(String account) {
		Collection<User> users = cache.values();
		for(User user:users){
			if(user.account().equals(account))
				return user;
		}
		return null;
	}

}
