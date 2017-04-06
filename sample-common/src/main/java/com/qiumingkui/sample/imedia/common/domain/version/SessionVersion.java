package com.qiumingkui.sample.imedia.common.domain.version;

/**
 * @author Administrator
 *
 */
public class SessionVersion extends AbstractVersion<SessionVersion> {

	public SessionVersion(long aVersionNumber) {
		super(aVersionNumber);
	}


	public boolean checkVersion(SessionVersion begin) {
		if (this.versionNumber() == begin.versionNumber()) {
			return true;
		}
		return false;
	}

}
