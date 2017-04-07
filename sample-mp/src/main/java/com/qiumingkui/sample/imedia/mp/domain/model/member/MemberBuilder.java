package com.qiumingkui.sample.imedia.mp.domain.model.member;

//import com.qiumingkui.sample.iwords.user.domain.model.Person;

public class MemberBuilder {

	// public static Admin buildAdmin(Person aPerson) {
	// boolean isPermitted = MemberPermitRule.isAdminPermitted(aPerson);
	// Admin admin = new Admin(aPerson.personId().id(), aPerson.account(),
	// aPerson.name(), isPermitted);
	// return admin;
	// }
	//
	// public static Author buildAuthor(Person aPerson) {
	// boolean isPermitted = MemberPermitRule.isAuthorPermitted(aPerson);
	// Author author = new Author(aPerson.personId().id(), aPerson.account(),
	// aPerson.name(), isPermitted);
	// return author;
	// }
	//
	// public static Reader buildReader(Person aPerson) {
	// boolean isPermitted = MemberPermitRule.isReaderPermitted(aPerson);
	// Reader reader = new Reader(aPerson.personId().id(), aPerson.account(),
	// aPerson.name(), isPermitted);
	// return reader;
	// }
	//
	//
	// public static Admin buildAdmin(String aId, String aAccount, String aName)
	// {
	// Admin admin = new Admin(aId, aAccount, aName, false);
	// return admin;
	// }
	//
	// public static Author buildAuthor(String aId, String aAccount, String
	// aName) {
	// Author author = new Author(aId, aAccount, aName, false);
	// return author;
	// }
	//
	// public static Reader buildReader(String aId, String aAccount, String
	// aName) {
	// Reader reader = new Reader(aId, aAccount, aName, false);
	// return reader;
	// }

	public static Admin buildAdmin(String aId, String aAccount, String aName, boolean aValidated) {
		Admin admin = new Admin(aId, aAccount, aName, aValidated);
		return admin;
	}

	public static Author buildAuthor(String aId, String aAccount, String aName, boolean aValidated) {
		Author author = new Author(aId, aAccount, aName, aValidated);
		return author;
	}

	public static Reader buildReader(String aId, String aAccount, String aName, boolean aValidated) {
		Reader reader = new Reader(aId, aAccount, aName, aValidated);
		return reader;
	}

	public static Owner buildOwner(String aId, String aAccount, String aName, boolean aValidated) {
		Owner owner = new Owner(aId, aAccount, aName, aValidated);
		return owner;
	}
}
