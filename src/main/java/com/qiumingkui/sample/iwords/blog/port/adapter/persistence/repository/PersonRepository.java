package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;

public interface PersonRepository {

	public Person get(String aPersonId);

	public void save(Person aPerson);
	
	public void del(String aPersonId);

}
