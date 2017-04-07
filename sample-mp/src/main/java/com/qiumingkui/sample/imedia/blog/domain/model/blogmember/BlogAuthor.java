package com.qiumingkui.sample.imedia.blog.domain.model.blogmember;

public class BlogAuthor extends BlogMember {

	public BlogAuthor(String aId, String aAccount, String aName, boolean aValidated) {
		super(aId, aAccount, aName, aValidated);
	}

	// public Author(Person person) {
	// super(person);
	// }
	//
	// @Override
	// protected void initPermitted(Person aPerson) {
	// if(aPerson.isAdmin()||aPerson.isCommonUser()){
	// setPermitted(true);
	// return ;
	// }
	// setPermitted(false);
	// }

}
