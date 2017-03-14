package com.qiumingkui.ddd.sample.blog.domain.model;

public class BlogAuthorityManager {

	private boolean isEditable(Blog aBlog){
		return aBlog.isEditable();
	}
}
