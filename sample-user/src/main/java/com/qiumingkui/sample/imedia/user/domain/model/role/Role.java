package com.qiumingkui.sample.imedia.user.domain.model.role;

public abstract class Role {

	public static final int PUBLIC_MP_CODE = 1;

	public static final int INDIVIDUAL_MP_CODE = 0;

	public static final int ADMIN_CODE = -1;

	public static final String PUBLIC_MP_NAME = "PUBLIC_MP";

	public static final String INDIVIDUAL_MP_NAME = "INDIVIDUAL_MP";

	public static final String ADMIN_NAME = "ADMIN";

	private int code = INDIVIDUAL_MP_CODE;

	private String name = INDIVIDUAL_MP_NAME;

	public int code() {
		return this.code;
	}

	public String name() {
		return this.name;
	}

	public boolean isAdmin() {
		if (this instanceof ADMIN) {
			return true;
		}
		return false;
	}

	public boolean isIMP() {
		if (this instanceof IMP) {
			return true;
		}
		return false;
	}

	public boolean isPMP() {
		if (this instanceof PMP) {
			return true;
		}
		return false;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	protected void setCode(int code) {
		this.code = code;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

}
