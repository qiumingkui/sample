package com.qiumingkui.sample.imedia.common.domain.version;

public class ConcurrencyVersion {
	private static final long DEFAULT_NUMBER = -1;

	private long versionNumber = DEFAULT_NUMBER;

	public ConcurrencyVersion() {
		super();
	}

	public ConcurrencyVersion(long aVersionNumber) {
		
		this();
		this.setVersionNumber(aVersionNumber);
	}

	/**
	 * 检查版本
	 * 
	 * @param aConcurrencyVersion
	 * @return
	 */
	public boolean check(ConcurrencyVersion aConcurrencyVersion) {
		if (this.versionNumber() == aConcurrencyVersion.versionNumber()) {
			return true;
		}
		return false;
	}

	public long versionNumber() {
		return versionNumber;
	}

	private void setVersionNumber(long versionNumber) {
		this.versionNumber = versionNumber;
	}

}
