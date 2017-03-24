package com.qiumingkui.sample.imedia.mp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Reader;
import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostBuilder;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostData;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostPermissionPolicy;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatusException;
import com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository.PostRepository;

@Service
public class PostApplicationService {

	@Autowired
	private PostRepository postRepository;

	/**
	 * 发表博客
	 * 
	 * @param aTitle
	 * @param aContent
	 * @return
	 * @throws Exception
	 */
	// @Transactional
	public String publishBlog(String aTitle, String aContent, Author aAuthor) throws Exception {
		Post post = PostBuilder.build(aTitle, aContent, aAuthor);
		if (!PostPermissionPolicy.hasPublishBlogPermission(post, aAuthor).isPermit())
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权发布博客！");
		post.issue();
		postRepository.save(post);
		return post.postId().id();
	}

	/**
	 * 修改博客
	 * 
	 * @param aBlogId
	 * @param aTitle
	 * @param aContent
	 * @param aPersonId
	 * @throws Exception
	 */
	// @Transactional
	public void modifyBlog(String aBlogId, String aTitle, String aContent, Author aAuthor) throws Exception {
		Post post = postRepository.get(new PostId(aBlogId));

		if (!PostPermissionPolicy.hasModifyBlogPermission(post, aAuthor).isPermit())
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权修改博客！");

		if (post != null) {
			Title title = new Title(aTitle);
			Content content = new Content(aContent);
			post.changeTitle(title);
			post.changeContent(content);
			postRepository.save(post);
		}
	}

	/**
	 * 阅读博客
	 * 
	 * @param aBlogId
	 * @param aReader
	 * @return
	 * @throws Exception
	 */
	// @Transactional
	public PostData readBlog(String aBlogId, Reader aReader) throws Exception {
		PostId postId = new PostId(aBlogId);
		Post post = postRepository.get(postId);

		if (!PostPermissionPolicy.hasReadBlogPermission(post, aReader).isPermit())
			throw new Exception(aReader.name() + aReader.account() + ":你无权读取博客！");

		PostData postData = new PostData(post.postId().id(), post.title().titleTxt(), post.content().contentTxt(),
				post.status().code());
		return postData;
	}

	// /**
	// * 阅读博客
	// *
	// * @param aBlogId
	// * @return
	// */
	// // @Transactional
	// public BlogData readBlog(String aBlogId) {
	// BlogId blogId = new BlogId(aBlogId);
	// Blog blog = blogRepository.get(blogId);
	// BlogData blogData = new BlogData(blog.blogId().id(),
	// blog.title().titleTxt(), blog.content().contentTxt(),
	// blog.status().code());
	// return blogData;
	// }

	/**
	 * 锁定博客
	 * 
	 * @param aBlogId
	 * @throws PostStatusException
	 */
	// @Transactional
	public void lockBlog(String aBlogId) throws PostStatusException {
		PostId postId = new PostId(aBlogId);
		Post post = postRepository.get(postId);
		if (post != null) {
			post.lock();
			postRepository.save(post);
		}
	}

	/**
	 * 关闭博客
	 * 
	 * @param aBlogId
	 * @throws PostStatusException
	 */
	// @Transactional
	public void closeBlog(String aBlogId) throws PostStatusException {
		PostId postId = new PostId(aBlogId);
		Post post = postRepository.get(postId);
		if (post != null) {
			post.close();
			postRepository.save(post);
		}
	}

	/**
	 * 重开博客
	 * 
	 * @param aBlogId
	 * @throws PostStatusException
	 */
	// @Transactional
	public void reopenBlog(String aBlogId) throws PostStatusException {
		PostId postId = new PostId(aBlogId);
		Post post = postRepository.get(postId);
		if (post != null) {
			post.reopen();
			postRepository.save(post);
		}
	}

}
