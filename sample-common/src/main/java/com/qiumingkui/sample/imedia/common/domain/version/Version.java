package com.qiumingkui.sample.imedia.common.domain.version;

public interface Version<T> {

	public long versionNumber();

	public boolean checkVersion(T aVersion);
}
