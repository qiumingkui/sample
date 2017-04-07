package com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank;

public abstract class BloggerRank {

	public static final int NOVICE = 0;

	public static final int VETERAN = 1;

	public static final int MASTER = 2;

	private int code;

	public int code() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

}
