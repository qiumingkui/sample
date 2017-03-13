package com.qiumingkui.ddd.sample.blog.domain.model;

public class Title {
	private String titleTxt;

	public Title() {
		super();
	}

	public Title(String titleTxt) {
		super();
		setTitleTxt(titleTxt);
	}

	public String titleTxt() {
		return titleTxt;
	}

	private void setTitleTxt(String titleTxt) {
		this.titleTxt = titleTxt;
	}
	
	
}
