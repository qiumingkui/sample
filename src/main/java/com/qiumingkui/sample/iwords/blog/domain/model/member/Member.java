package com.qiumingkui.sample.iwords.blog.domain.model.member;

public abstract class Member {

	protected Person person;

	private Member() {
		super();
	}

	public Member(Person person) {
		this();
		this.person = person;
	}

	public String id() {
		return person.id();
	}
	
	public String account() {
		return person.account();
	}

	public String name() {
		return person.name();
	}

	public abstract boolean permitted();
}
