package com.qiumingkui.ddd.sample.blog.domain.model.member;

public class Admin extends Member{

	
	public Admin(Person person) {
		super(person);
	}

	public boolean permitted(){
		if(person.isAdmin()){
			return true;
		}
		return false;
	}
	
}
