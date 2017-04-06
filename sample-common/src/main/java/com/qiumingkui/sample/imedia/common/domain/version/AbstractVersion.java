package com.qiumingkui.sample.imedia.common.domain.version;

public abstract class AbstractVersion<T> implements Version<T> {

	private long versionNumber = 0;

	private AbstractVersion() {
		super();
	}

	public AbstractVersion(long aVersionNumber) {
		this();
		this.setVersionNumber(aVersionNumber);
	}

	public long versionNumber() {
		return this.versionNumber;
	}

	// public abstract boolean checkVersion(T aVersion);

	private void setVersionNumber(long versionNumber) {
		this.versionNumber = versionNumber;
	}

}
