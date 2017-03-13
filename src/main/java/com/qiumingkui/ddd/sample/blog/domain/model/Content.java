package com.qiumingkui.ddd.sample.blog.domain.model;

public class Content {
	private String contentTxt;

	public Content() {
		super();
	}

	public Content(String contentTxt) {
		super();
		setContentTxt(contentTxt);
	}

	public String contentTxt() {
		return this.contentTxt;
	}

	private void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}
	
	
}
