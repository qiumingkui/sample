package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class MemberBuilder {

	public static Admin buildAdmin(Person aPerson) {
		boolean isPermitted = MemberPermitRule.isAdminPermitted(aPerson);
		Admin admin = new Admin(aPerson.personId().id(), aPerson.account(), aPerson.name(), isPermitted);
		return admin;
	}

	public static Author buildAuthor(Person aPerson) {
		boolean isPermitted = MemberPermitRule.isAuthorPermitted(aPerson);
		Author author = new Author(aPerson.personId().id(), aPerson.account(), aPerson.name(), isPermitted);
		return author;
	}

	public static Reader buildReader(Person aPerson) {
		boolean isPermitted = MemberPermitRule.isReaderPermitted(aPerson);
		Reader reader = new Reader(aPerson.personId().id(), aPerson.account(), aPerson.name(), isPermitted);
		return reader;
	}

	public static Admin buildAdmin(String aId, String aAccount, String aName) {
		Admin admin = new Admin(aId, aAccount, aName, false);
		return admin;
	}

	public static Author buildAuthor(String aId, String aAccount, String aName) {
		Author author = new Author(aId, aAccount, aName, false);
		return author;
	}

	public static Reader buildReader(String aId, String aAccount, String aName) {
		Reader reader = new Reader(aId, aAccount, aName, false);
		return reader;
	}

}
