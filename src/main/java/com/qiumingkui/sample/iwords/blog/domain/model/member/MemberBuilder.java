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
}
