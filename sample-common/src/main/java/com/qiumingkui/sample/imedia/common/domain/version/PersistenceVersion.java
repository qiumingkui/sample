package com.qiumingkui.sample.imedia.common.domain.version;

public class PersistenceVersion extends AbstractVersion<PersistenceVersion> {

	public PersistenceVersion(long aVersionNumber) {
		super(aVersionNumber);
	}

	public boolean checkVersion(PersistenceVersion aVersion) {
		if (this.versionNumber() == aVersion.versionNumber()) {
			return true;
		}
		return false;
	}

}
