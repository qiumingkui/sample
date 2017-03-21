package com.qiumingkui.sample.iwords.user.domain.model;

public class User {
	private UserId userId;

	private String account;

	private String password;

	private String name;

	private boolean isAdmin;

	private boolean isCommonUser;

	private User() {
		super();
	}

	public User(UserId aUserId, String aAccount, String aPassword, String aName, boolean aIsAdmin,
			boolean aIsCommonUser) {
		this();
		// this.userId = aUserId;
		// this.account = aAccount;
		// this.password = aPassword;
		// this.name = aName;
		// this.isAdmin = aIsAdmin;
		// this.isCommonUser = aIsCommonUser;
		
		this.setUserId(aUserId);
		this.setAccount(aAccount);
		this.setPassword(aPassword);
		this.setName(aName);
		this.setAdmin(aIsAdmin);
		this.setCommonUser(aIsCommonUser);
		

		if (aUserId == null || aUserId.id().trim().length() <= 0) {
			// this.account = "anonymous";
			// this.name = "匿名用户";
			// this.isAdmin = false;
			// this.isCommonUser = false;
			//
			this.setAccount("anonymous");
			this.setName("匿名用户");
			this.setAdmin(false);
			this.setCommonUser(false);
		}
	}

	public UserId userId() {
		return userId;
	}

	public String account() {
		return account;
	}

	public String password() {
		return password;
	}

	public String name() {
		return name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean isCommonUser() {
		return isCommonUser;
	}

	public void changeName(String name){
		this.setName(name);
	}
	
	public void changePassword(String aPasswordOriginalText){
		String passwordCipherText = encryptPassword(aPasswordOriginalText);
		this.setPassword(passwordCipherText);
	}
	
	public AuthenticateResult authenticate(String aAccount, String aPasswordOriginalText) {
		String passwordCipherText = encryptPassword(aPasswordOriginalText);
		if (this.account.equals(aAccount) && this.password.equals(passwordCipherText)) {
			return new AuthenticateResult(true);
		}
		return new AuthenticateResult(false);
	}

	/**
	 * 口令加密
	 * 
	 * @param originalText
	 *            口令原文
	 * @return 口令密文
	 */
	private String encryptPassword(String originalText) {
		// 加密过程...
		String cipherText = originalText;
		return cipherText;
	}

	private void setUserId(UserId userId) {
		this.userId = userId;
	}

	private void setAccount(String account) {
		this.account = account;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	private void setCommonUser(boolean isCommonUser) {
		this.isCommonUser = isCommonUser;
	}
	
}
