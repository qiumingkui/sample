package com.qiumingkui.ddd.sample.blog.domain.model.member;

public class Author extends Member{

	
	public Author(Person person) {
		super(person);
	}

	public boolean permitted(){
		if(person.isAdmin()||person.isCommonUser()){
			return true;
		}
		return false;
	}
	
}
