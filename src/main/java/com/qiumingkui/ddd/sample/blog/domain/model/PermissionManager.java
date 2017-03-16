package com.qiumingkui.ddd.sample.blog.domain.model;

import com.qiumingkui.ddd.sample.blog.domain.model.member.Author;
import com.qiumingkui.ddd.sample.blog.domain.model.member.Reader;

public class PermissionManager {

	public boolean readBlog(Blog aBlog, Reader aReader) {
		if (aBlog.isReadable() && aReader.permitted()) {
			return true;
		}
		return false;
	}

	public boolean writeBlog(Blog aBlog, Author author) {
		if (aBlog.isEditable() && author.permitted()) {
			return true;
		}
		return false;
	}
}
