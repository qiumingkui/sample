package com.qiumingkui.sample.imedia.mp.domain.model;

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
