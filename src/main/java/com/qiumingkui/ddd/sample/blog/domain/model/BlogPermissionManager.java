package com.qiumingkui.ddd.sample.blog.domain.model;

import com.qiumingkui.ddd.sample.blog.domain.model.member.Author;
import com.qiumingkui.ddd.sample.blog.domain.model.member.Reader;

public class BlogPermissionManager {

	public boolean hasReadBlogPermission(Blog aBlog, Reader aReader) {
		if (aBlog.isReadable() && aReader.permitted()) {
			return true;
		}
		return false;
	}

	public boolean hasWriteBlogPermission(Blog aBlog, Author author) {
		if (aBlog.isEditable() && author.permitted()) {
			return true;
		}
		return false;
	}
}
