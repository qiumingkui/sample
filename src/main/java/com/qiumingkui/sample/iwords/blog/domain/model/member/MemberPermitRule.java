package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class MemberPermitRule {

	public static boolean isAuthorPermitted(Person aPerson) {
		if (aPerson.isAdmin() || aPerson.isCommonUser()) {
			return true;
		}
		return false;
	}

	public static boolean isAdminPermitted(Person aPerson) {
		if (aPerson.isAdmin()) {
			return true;
		}
		return false;
	}

	public static boolean isReaderPermitted(Person aPerson) {

		return true;
	}

}
