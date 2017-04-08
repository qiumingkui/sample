package com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank;

public enum BloggerRank {

	NOVICE(0), VETERAN(1), MASTER(2);

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
