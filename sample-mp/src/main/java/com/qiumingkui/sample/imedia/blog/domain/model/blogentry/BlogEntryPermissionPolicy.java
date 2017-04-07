package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.Draft;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.Issued;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.Locked;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogReader;
import com.qiumingkui.sample.imedia.common.domain.policy.PolicyDecisionResult;

public class BlogEntryPermissionPolicy {

	public static PolicyDecisionResult hasReadBlogPermission(BlogEntry aPost, BlogReader aReader) {
		if (aReader == null || !aReader.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aPost.status() instanceof Issued) {
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 帖子锁定后不可修改、评论，但允许查看
		if (aPost.status() instanceof Locked) {
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 在草拟帖子时，只有本人可以查看帖子
		if (aPost.status() instanceof Draft) {
			if (aPost.blogAuthor().account().equals(aReader.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasModifyBlogPermission(BlogEntry aPost, BlogAuthor blogAuthor) {
		if (blogAuthor == null || !blogAuthor.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if ((aPost.status() instanceof Draft) || (aPost.status() instanceof Issued)) {
			// 仅允许作者修改博文
			if (aPost.blogAuthor().account().equals(blogAuthor.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasPublishBlogPermission(BlogEntry aBlogEntry, BlogAuthor blogAuthor) {
		if (blogAuthor == null || !blogAuthor.isValidated()){
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlogEntry.status() instanceof Draft) {
			// 仅允许作者发表博文
			if (aBlogEntry.blogAuthor().account().equals(blogAuthor.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}
}
