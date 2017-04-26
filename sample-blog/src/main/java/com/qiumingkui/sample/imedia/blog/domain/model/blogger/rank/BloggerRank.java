package com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank;

public enum BloggerRank {

	NOVICE(0), VETERAN(1), MASTER(2);

	public static BloggerRank create(int aCode) {
		if (aCode == NOVICE.code)
			return NOVICE;
		if (aCode == VETERAN.code)
			return VETERAN;
		if (aCode == MASTER.code)
			return MASTER;

		return null;
	}

	private BloggerRank(int aCode) {
		this.code = aCode;
	}

	private int code;

	/**
	 * @return the code
	 */
	public int code() {
		return code;
	}

}
