package com.qiumingkui.sample.iwords.blog.domain.model;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Reader;

public class BlogPermissionPolicy {

	public static boolean hasReadBlogPermission(Blog aBlog, Reader aReader) {
		if (aBlog.isReadable() && aReader.isPermitted()) {
			return true;
		}
		return false;
	}

	public static boolean hasModifyBlogPermission(Blog aBlog, Author author) {
		if (aBlog.isEditable() && author.isPermitted() && aBlog.author().account().equals(author.account())) {
			return true;
		}
		return false;
	}

	public static boolean hasPublishBlogPermission(Blog aBlog, Author author) {
		if (aBlog.isEditable() && author.isPermitted()) {
			return true;
		}
		return false;
	}
}
