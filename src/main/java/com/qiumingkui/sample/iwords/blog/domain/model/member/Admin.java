package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class Admin extends Member {

	public Admin(String aId, String aAccount, String aName, boolean aIsPermitted) {
		super(aId, aAccount, aName, aIsPermitted);
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
