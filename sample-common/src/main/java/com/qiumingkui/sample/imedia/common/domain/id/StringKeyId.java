package com.qiumingkui.sample.imedia.common.domain.id;

public class StringKeyId implements KeyId<String,StringKeyId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	protected StringKeyId() {
		super();
	}

	protected StringKeyId(String aKey) {
		super();
		this.key = aKey;
	}

	public String key() {
		return key;
	}

	public boolean equals(StringKeyId aId) {
		if (this.key().equals(aId.key())) {
			return true;
		}
		return false;
	}

}
