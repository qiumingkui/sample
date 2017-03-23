package com.qiumingkui.sample.iwords.blog.domain.model.post;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Reader;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostDraft;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostIssued;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostLocked;
import com.qiumingkui.sample.iwords.common.domain.PolicyDecisionResult;

public class PostPermissionPolicy {

	public static PolicyDecisionResult hasReadBlogPermission(Post aBlogEntry, Reader aReader) {
		if (aReader == null || !aReader.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlogEntry.status() instanceof PostIssued) {
			// return new PolicyDecisionResult(true);
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 帖子锁定后不可修改、评论，但允许查看
		if (aBlogEntry.status() instanceof PostLocked) {
			// return true;
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 在草拟帖子时，只有本人可以查看帖子
		if (aBlogEntry.status() instanceof PostDraft) {
			if (aBlogEntry.author().account().equals(aReader.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasModifyBlogPermission(Post aBlogEntry, Author author) {
		if (author == null || !author.isValidated()) {
			// return false;
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if ((aBlogEntry.status() instanceof PostDraft) || (aBlogEntry.status() instanceof PostIssued)) {
			// 仅允许作者修改博文
			if (aBlogEntry.author().account().equals(author.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		// return false;
		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasPublishBlogPermission(Post aBlogEntry, Author author) {
		if (author == null || !author.isValidated()){
			// return false;
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlogEntry.status() instanceof PostDraft) {
			// 仅允许作者发表博文
			if (aBlogEntry.author().account().equals(author.account())) {
				// return true;
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}
}
