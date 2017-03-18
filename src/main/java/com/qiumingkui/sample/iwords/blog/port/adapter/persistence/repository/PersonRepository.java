package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.domain.model.member.PersonId;

public interface PersonRepository {

	public Person get(PersonId aPersonId);

	public void save(Person aPerson);

	public void del(PersonId aPersonId);

}
