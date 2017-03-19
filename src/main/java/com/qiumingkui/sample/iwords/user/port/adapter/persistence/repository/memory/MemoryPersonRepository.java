package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.domain.model.member.PersonId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.PersonRepository;

@Service
public class MemoryPersonRepository implements PersonRepository {

	private static Map<String, Person> cache = new HashMap<String, Person>();

	@Override
	public Person get(PersonId aPersonId) {
		return cache.get(aPersonId.id());
	}

	@Override
	public void save(Person aPerson) {
		cache.put(aPerson.personId().id(), aPerson);

	}

	@Override
	public void del(PersonId aPersonId) {
		cache.remove(aPersonId.id());
	}

}
