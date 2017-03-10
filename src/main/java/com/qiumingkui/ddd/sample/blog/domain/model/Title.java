package com.qiumingkui.ddd.sample.blog.domain.model;

public class Title {
	private String titleText;

	public Title() {
		super();
	}

	public Title(String titleText) {
		super();
		setTitleText(titleText);
	}

	public String titleText() {
		return titleText;
	}

	private void setTitleText(String titleText) {
		this.titleText = titleText;
	}
	
	
}
