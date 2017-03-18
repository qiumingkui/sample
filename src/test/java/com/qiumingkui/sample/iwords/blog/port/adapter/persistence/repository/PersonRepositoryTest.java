package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.domain.model.member.PersonId;
import com.qiumingkui.sample.iwords.blog.helper.MemberTestHelper;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	private Person aPerson4Admin;
	private PersonId aPerson4AdminId;
	private Person aPerson4CommonUser;
	private PersonId aPerson4CommonUserId;

	@Before
	public void save4Create() {
		aPerson4Admin = MemberTestHelper.buildPerson4AdminExample();
		aPerson4AdminId = aPerson4Admin.personId();
		personRepository.save(aPerson4Admin);

		aPerson4CommonUser = MemberTestHelper.buildPerson4CommonUserExample();
		aPerson4CommonUserId = aPerson4CommonUser.personId();
		personRepository.save(aPerson4CommonUser);
	}

	@Test
	public void get() {
		Person person = personRepository.get(aPerson4AdminId);
		assertThat(person != null).isTrue();
		assertThat(person.isAdmin()).isTrue();
		assertThat(person.isCommonUser()).isFalse();
	}

	@Test
	public void save4Update() {
		Person person4Admin1 = personRepository.get(aPerson4AdminId);
		personRepository.save(person4Admin1);
		person4Admin1 = personRepository.get(aPerson4AdminId);
		assertThat(person4Admin1.isAdmin()).isTrue();
		assertThat(person4Admin1.isCommonUser()).isFalse();

		Person person4CommonUser1 = personRepository.get(aPerson4CommonUserId);
		personRepository.save(person4CommonUser1);
		person4CommonUser1 = personRepository.get(aPerson4CommonUserId);
		assertThat(person4CommonUser1.isAdmin()).isFalse();
		assertThat(person4CommonUser1.isCommonUser()).isTrue();
	}

	@Test
	public void del() {
		personRepository.del(aPerson4AdminId);
		Person person4Admin1 = personRepository.get(aPerson4AdminId);
		assertThat(person4Admin1 != null).isFalse();
	}

}
