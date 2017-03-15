package com.qiumingkui.ddd.sample.user.domain.model;

public class AuthenticationService {

	public static boolean authenticate(User aUser, String aUserName, String aPassword) {
		if (!aUser.userName().equals(aUserName))
			return false;

		if (aUser.password().equals(aPassword))
			return false;
		return true;
	}

}
