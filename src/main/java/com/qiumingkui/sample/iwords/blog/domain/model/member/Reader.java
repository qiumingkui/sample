package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class Reader extends Member {

	public Reader(Person person) {
		super(person);
	}

	@Override
	public boolean permitted() {
		return true;
	}

}
