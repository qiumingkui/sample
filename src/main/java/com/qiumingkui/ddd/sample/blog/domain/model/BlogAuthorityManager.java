package com.qiumingkui.ddd.sample.blog.domain.model;

public class BlogAuthorityManager {

	private boolean isEditable(Blog aBlog){
		if (aBlog.status().statusVal() == BlogStatus.CLOSE || aBlog.status().statusVal() == BlogStatus.LOCK)
			return false;
		return true;
	}

}
