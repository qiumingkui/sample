package com.qiumingkui.ddd.sample.blog.domain.model;

public class Content {
	private String contentText;

	public Content() {
		super();
	}

	public Content(String contentText) {
		super();
		setContentText(contentText);
	}

	public String contentText() {
		return this.contentText;
	}

	private void setContentText(String contentText) {
		this.contentText = contentText;
	}
	
	
}
