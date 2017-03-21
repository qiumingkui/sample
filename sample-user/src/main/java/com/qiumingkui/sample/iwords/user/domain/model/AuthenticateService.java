package com.qiumingkui.sample.iwords.user.domain.model;

public class AuthenticateService {

	public AuthenticateResult authenticate(User aUser, String aAccount, String aPasswordOriginalText) {
		String passwordCipherText = PasswordServcie.encryptPassword(aPasswordOriginalText);
		if (aUser.account().equals(aAccount) && aUser.password().equals(passwordCipherText)) {
			return new AuthenticateResult(true);
		}
		return new AuthenticateResult(false);
	}

}
