package com.qiumingkui.sample.imedia.common.domain.id;

public class StringId implements SimpleId<String,StringId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	private StringId() {
		super();
	}

	protected StringId(String aKey) {
		this();
		this.setKey(aKey);
	}

	public String key() {
		return key;
	}

	public boolean equals(StringId aId) {
		if (this.key().equals(aId.key())) {
			return true;
		}
		return false;
	}

	protected void setKey(String key) {
		this.key = key;
	}

}
