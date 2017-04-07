package com.qiumingkui.sample.imedia.blog.domain.model.blogmember;

public class BlogAdmin extends BlogMember {

	public BlogAdmin(String aId, String aAccount, String aName, boolean aValidated) {
		super(aId, aAccount, aName, aValidated);
	}

	// public Admin(Person person) {
	// super(person);
	// }
	//
	//
	// @Override
	// protected void initPermitted(Person aPerson) {
	// if(aPerson.isAdmin()){
	// setPermitted(true);
	// return ;
	// }
	// setPermitted(false);
	// }

}
