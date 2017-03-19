package com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.user.domain.model.User;
import com.qiumingkui.sample.iwords.user.domain.model.UserId;
import com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository.UserRepository;

@Service
public class MemoryUserRepository implements UserRepository {

	private static Map<String, User> cache = new HashMap<String, User>();

	@Override
	public User get(UserId aPersonId) {
		return cache.get(aPersonId.id());
	}

	@Override
	public void save(User aPerson) {
		cache.put(aPerson.userId().id(), aPerson);

	}

	@Override
	public void del(UserId aPersonId) {
		cache.remove(aPersonId.id());
	}

}
