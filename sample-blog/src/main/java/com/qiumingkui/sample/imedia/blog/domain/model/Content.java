package com.qiumingkui.sample.imedia.blog.domain.model;

public class Content {
	private String contentTxt;

	private Content() {
		super();
	}

	public Content(String aContentTxt) {
		this();
		setContentTxt(aContentTxt);
	}

	public String contentTxt() {
		return this.contentTxt;
	}

	private void setContentTxt(String aContentTxt) {
		this.contentTxt = aContentTxt;
	}

}
