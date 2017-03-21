package com.qiumingkui.sample.iwords.blog.domain.model.blog;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogDraft;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogIssued;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogLocked;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Reader;
import com.qiumingkui.sample.iwords.common.domain.PolicyDecisionResult;

public class BlogPermissionPolicy {

	public static PolicyDecisionResult hasReadBlogPermission(Blog aBlog, Reader aReader) {
		if (aReader == null || !aReader.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlog.status() instanceof BlogIssued) {
			// return new PolicyDecisionResult(true);
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 帖子锁定后不可修改、评论，但允许查看
		if (aBlog.status() instanceof BlogLocked) {
			// return true;
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 在草拟帖子时，只有本人可以查看帖子
		if (aBlog.status() instanceof BlogDraft) {
			if (aBlog.author().account().equals(aReader.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasModifyBlogPermission(Blog aBlog, Author author) {
		if (author == null || !author.isValidated()) {
			// return false;
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if ((aBlog.status() instanceof BlogDraft) || (aBlog.status() instanceof BlogIssued)) {
			// 仅允许作者修改博文
			if (aBlog.author().account().equals(author.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		// return false;
		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasPublishBlogPermission(Blog aBlog, Author author) {
		if (author == null || !author.isValidated()){
			// return false;
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlog.status() instanceof BlogDraft) {
			// 仅允许作者发表博文
			if (aBlog.author().account().equals(author.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}
}
