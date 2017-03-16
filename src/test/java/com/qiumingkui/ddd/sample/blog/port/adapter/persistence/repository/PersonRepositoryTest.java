package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.ddd.sample.blog.domain.model.member.Person;
import com.qiumingkui.ddd.sample.blog.domain.model.member.PersonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void get() {
		Person zhang = buildAdminExample();
		personRepository.save(zhang);

		String aPersonId = zhang.id();
		Person person = personRepository.get(aPersonId);
		assertThat(person != null).isTrue();
		assertThat(person.isAdmin()).isTrue();
		assertThat(person.isCommonUser()).isFalse();
	}

	@Test
	public void save() {
		Person zhang = buildAdminExample();
		Person li = buildCommonUserExample();

		personRepository.save(zhang);
		personRepository.save(li);

		Person zhang1 = personRepository.get(zhang.id());
		Person li1 = personRepository.get(li.id());

		assertThat(zhang1.isAdmin()).isTrue();
		assertThat(zhang1.isCommonUser()).isFalse();
		assertThat(li1.isAdmin()).isFalse();
		assertThat(li1.isCommonUser()).isTrue();
	}

	@Test
	public void del() {
		Person zhang = buildAdminExample();
		personRepository.save(zhang);

		String aPersonId = zhang.id();
		Person person = personRepository.get(aPersonId);
		assertThat(person != null).isTrue();

		personRepository.del(aPersonId);
		person = personRepository.get(aPersonId);
		assertThat(person != null).isFalse();
	}

	private Person buildAdminExample() {
		return PersonBuilder.build("Zhangsan", "张三", true, false);
	}

	private Person buildCommonUserExample() {
		return PersonBuilder.build("Lisi", "李四", false, true);
	}
}
