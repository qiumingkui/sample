package com.qiumingkui.sample.imedia.mp.domain.model.post;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Reader;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostDraft;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostIssued;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostLocked;
import com.qiumingkui.sample.iwords.common.domain.PolicyDecisionResult;

public class PostPermissionPolicy {

	public static PolicyDecisionResult hasReadBlogPermission(Post aPost, Reader aReader) {
		if (aReader == null || !aReader.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aPost.status() instanceof PostIssued) {
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 帖子锁定后不可修改、评论，但允许查看
		if (aPost.status() instanceof PostLocked) {
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}

		// 在草拟帖子时，只有本人可以查看帖子
		if (aPost.status() instanceof PostDraft) {
			if (aPost.author().account().equals(aReader.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasModifyBlogPermission(Post aPost, Author author) {
		if (author == null || !author.isValidated()) {
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if ((aPost.status() instanceof PostDraft) || (aPost.status() instanceof PostIssued)) {
			// 仅允许作者修改博文
			if (aPost.author().account().equals(author.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}

	public static PolicyDecisionResult hasPublishBlogPermission(Post aBlogEntry, Author author) {
		if (author == null || !author.isValidated()){
			PolicyDecisionResult result = new PolicyDecisionResult(false);
			return result;
		}

		if (aBlogEntry.status() instanceof PostDraft) {
			// 仅允许作者发表博文
			if (aBlogEntry.author().account().equals(author.account())) {
				PolicyDecisionResult result = new PolicyDecisionResult(true);
				return result;
			}
		}

		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}
}
