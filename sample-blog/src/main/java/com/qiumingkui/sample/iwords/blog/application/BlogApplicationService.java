package com.qiumingkui.sample.iwords.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogData;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogId;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogPermissionPolicy;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogStatusException;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.MemberBuilder;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogRepository;
//import com.qiumingkui.sample.iwords.user.domain.model.Person;
//import com.qiumingkui.sample.iwords.user.domain.model.PersonId;
//import com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository.PersonRepository;

@Service
public class BlogApplicationService {

	@Autowired
	private BlogRepository blogRepository;

	// @Autowired
	// private PersonRepository personRepository;

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
		// Person person = personRepository.get(new PersonId(aAuthorId));
		// Author author = MemberBuilder.buildAuthor(person);
		//
		// Blog blog = BlogBuilder.build(aTitle, aContent, author);
		//
		// if (!BlogPermissionPolicy.hasPublishBlogPermission(blog, author))
		// throw new Exception(author.name() + author.account() + ":你无权发布博客！");
		//
		// blogRepository.save(blog);
		// return blog.blogId().id();

		Blog blog = BlogBuilder.build(aTitle, aContent, aAuthor);
		blog.issue();
		if (!BlogPermissionPolicy.hasPublishBlogPermission(blog, aAuthor))
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权发布博客！");

		blogRepository.save(blog);
		return blog.blogId().id();
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
		// Person person = personRepository.get(new PersonId(aPersonId));
		// Author author = MemberBuilder.buildAuthor(person);
		//
		// Blog blog = blogRepository.get(new BlogId(aBlogId));
		//
		// if (!BlogPermissionPolicy.hasModifyBlogPermission(blog, author))
		// throw new Exception(author.name() + author.account() + ":你无权修改博客！");
		//
		// if (blog != null) {
		// Title title = new Title(aTitle);
		// Content content = new Content(aContent);
		// blog.changeTitle(title);
		// blog.changeContent(content);
		// blogRepository.save(blog);
		// }
		Blog blog = blogRepository.get(new BlogId(aBlogId));

		if (!BlogPermissionPolicy.hasModifyBlogPermission(blog, aAuthor))
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权修改博客！");

		if (blog != null) {
			Title title = new Title(aTitle);
			Content content = new Content(aContent);
			blog.changeTitle(title);
			blog.changeContent(content);
			blogRepository.save(blog);
		}
	}

	// /**
	// * 修改博客
	// *
	// * @param aBlogId
	// * @param aTitle
	// * @param aContent
	// */
	// //@Transactional
	// private void modifyBlog(String aBlogId, String aTitle, String aContent) {
	// BlogId blogId = new BlogId(aBlogId);
	// Blog blog = blogRepository.get(blogId);
	// if (blog != null) {
	// Title title = new Title(aTitle);
	// Content content = new Content(aContent);
	// blog.changeTitle(title);
	// blog.changeContent(content);
	// blogRepository.save(blog);
	// }
	// }

	/**
	 * 阅读博客
	 * 
	 * @param aBlogId
	 * @return
	 */
	// @Transactional
	public BlogData readBlog(String aBlogId) {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		BlogData blogData = new BlogData(blog.blogId().id(), blog.title().titleTxt(), blog.content().contentTxt(),
				blog.status().code());
		return blogData;
	}

	/**
	 * 锁定博客
	 * 
	 * @param aBlogId
	 * @throws BlogStatusException
	 */
	// @Transactional
	public void lockBlog(String aBlogId) throws BlogStatusException {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		if (blog != null) {
			blog.lock();
			blogRepository.save(blog);
		}
	}

	/**
	 * 关闭博客
	 * 
	 * @param aBlogId
	 * @throws BlogStatusException
	 */
	// @Transactional
	public void closeBlog(String aBlogId) throws BlogStatusException {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		if (blog != null) {
			blog.close();
			blogRepository.save(blog);
		}
	}

	/**
	 * 重开博客
	 * 
	 * @param aBlogId
	 * @throws BlogStatusException
	 */
	// @Transactional
	public void reopenBlog(String aBlogId) throws BlogStatusException {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		if (blog != null) {
			blog.reopen();
			blogRepository.save(blog);
		}
	}

}
