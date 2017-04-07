package com.qiumingkui.sample.imedia.blog.domain.model;

public class Title {
	private String titleTxt;

	private Title() {
		super();
	}

	public Title(String aTitleTxt) {
		this();
		setTitleTxt(aTitleTxt);
	}

	public String titleTxt() {
		return titleTxt;
	}

	private void setTitleTxt(String aTitleTxt) {
		this.titleTxt = aTitleTxt;
	}

}
