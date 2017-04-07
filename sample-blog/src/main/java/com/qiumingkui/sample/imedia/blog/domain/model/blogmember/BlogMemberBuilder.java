package com.qiumingkui.sample.imedia.blog.domain.model.blogmember;

//import com.qiumingkui.sample.iwords.user.domain.model.Person;

public class BlogMemberBuilder {

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

	public static BlogAdmin buildAdmin(String aId, String aAccount, String aName, boolean aValidated) {
		BlogAdmin blogAdmin = new BlogAdmin(aId, aAccount, aName, aValidated);
		return blogAdmin;
	}

	public static BlogAuthor buildAuthor(String aId, String aAccount, String aName, boolean aValidated) {
		BlogAuthor blogAuthor = new BlogAuthor(aId, aAccount, aName, aValidated);
		return blogAuthor;
	}

	public static BlogReader buildReader(String aId, String aAccount, String aName, boolean aValidated) {
		BlogReader blogReader = new BlogReader(aId, aAccount, aName, aValidated);
		return blogReader;
	}

	public static BlogOwner buildOwner(String aId, String aAccount, String aName, boolean aValidated) {
		BlogOwner blogOwner = new BlogOwner(aId, aAccount, aName, aValidated);
		return blogOwner;
	}
}
