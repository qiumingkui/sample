package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.iwords.blog.domain.model.MemberTestHelper;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.domain.model.member.PersonId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void get() {
		Person padmin = MemberTestHelper.buildPerson4AdminExample();
		personRepository.save(padmin);

		PersonId aPersonId = padmin.personId();
		Person person = personRepository.get(aPersonId);
		assertThat(person != null).isTrue();
		assertThat(person.isAdmin()).isTrue();
		assertThat(person.isCommonUser()).isFalse();
	}

	@Test
	public void save() {
		Person padmin = MemberTestHelper.buildPerson4AdminExample();
		Person pcommon = MemberTestHelper.buildPerson4CommonUserExample();

		personRepository.save(padmin);
		personRepository.save(pcommon);

		Person padmin1 = personRepository.get(padmin.personId());
		Person pcommon1 = personRepository.get(pcommon.personId());

		assertThat(padmin1.isAdmin()).isTrue();
		assertThat(padmin1.isCommonUser()).isFalse();
		assertThat(pcommon1.isAdmin()).isFalse();
		assertThat(pcommon1.isCommonUser()).isTrue();
	}

	@Test
	public void del() {
		Person padmin = MemberTestHelper.buildPerson4AdminExample();
		personRepository.save(padmin);

		PersonId padminId = padmin.personId();
		Person padmin1 = personRepository.get(padminId);
		assertThat(padmin1 != null).isTrue();

		personRepository.del(padminId);
		padmin1 = personRepository.get(padminId);
		assertThat(padmin1 != null).isFalse();
	}

}
