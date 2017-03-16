package com.qiumingkui.ddd.sample.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogBuilder;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogData;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogPermissionManager;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;
import com.qiumingkui.ddd.sample.blog.domain.model.member.Author;
import com.qiumingkui.ddd.sample.blog.domain.model.member.Person;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.BlogRepository;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.PersonRepository;

@Service
public class BlogApplicationService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private PersonRepository personRepository;

	/**
	 * 发表博客
	 * 
	 * @param aTitle
	 * @param aContent
	 * @return
	 */
	@Transactional
	public String publishBlog(String aTitle, String aContent) {
		Blog blog = BlogBuilder.build(aTitle, aContent);
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
	@Transactional
	public void modifyBlog(String aBlogId, String aTitle, String aContent, String aPersonId) throws Exception {
		Blog blog = blogRepository.get(new BlogId(aBlogId));
		
		Person person = personRepository.get(aPersonId);
		Author author = new Author(person);
		if (!BlogPermissionManager.hasEditBlogPermission(blog, author))
			throw new Exception(author.name()+author.account()+":你无权修改帖子！");
		
		modifyBlog(aBlogId, aTitle, aContent);
	}

	/**
	 * 修改博客
	 * 
	 * @param aBlogId
	 * @param aTitle
	 * @param aContent
	 */
	@Transactional
	private void modifyBlog(String aBlogId, String aTitle, String aContent) {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		if (blog != null) {
			Title title = new Title(aTitle);
			Content content = new Content(aContent);
			blog.changeTitle(title);
			blog.changeContent(content);
			blogRepository.save(blog);
		}
	}

	/**
	 * 阅读博客
	 * 
	 * @param aBlogId
	 * @return
	 */
	@Transactional
	public BlogData readBlog(String aBlogId) {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		BlogData blogData = new BlogData(blog.blogId().id(), blog.title().titleTxt(), blog.content().contentTxt(),
				blog.status().statusVal());
		return blogData;
	}

	/**
	 * 锁定博客
	 * 
	 * @param aBlogId
	 */
	@Transactional
	public void lockBlog(String aBlogId) {
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
	 */
	@Transactional
	public void closeBlog(String aBlogId) {
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
	 */
	@Transactional
	public void reopenBlog(String aBlogId) {
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		if (blog != null) {
			blog.reopen();
			blogRepository.save(blog);
		}
	}

}
