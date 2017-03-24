package com.qiumingkui.sample.imedia.mp.domain.model.member;

public class Admin extends Member {

	public Admin(String aId, String aAccount, String aName, boolean aValidated) {
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
