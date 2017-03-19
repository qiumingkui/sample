package com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.user.domain.model.Person;
import com.qiumingkui.sample.iwords.user.domain.model.PersonId;

public interface PersonRepository {

	public Person get(PersonId aPersonId);

	public void save(Person aPerson);

	public void del(PersonId aPersonId);

}
