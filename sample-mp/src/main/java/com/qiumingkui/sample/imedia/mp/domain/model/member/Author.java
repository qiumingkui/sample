package com.qiumingkui.sample.imedia.mp.domain.model.member;

public class Author extends Member {

	public Author(String aId, String aAccount, String aName, boolean aValidated) {
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
