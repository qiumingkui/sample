package com.qiumingkui.sample.imedia.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryData;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryFactory;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryPermissionPolicy;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryRepository;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogReader;

@Service
public class BlogEntryApplicationService {

	@Autowired
	private BlogEntryRepository blogEntryRepository;

	/**
	 * 发表博客
	 * 
	 * @param aTitle
	 * @param aContent
	 * @return
	 * @throws Exception
	 */
	// @Transactional
	public String publishBlog(String aTitle, String aContent, BlogAuthor aAuthor) throws Exception {
		BlogEntry blogEntry = BlogEntryFactory.create(aTitle, aContent, aAuthor);
		if (!BlogEntryPermissionPolicy.hasPublishBlogPermission(blogEntry, aAuthor).isPermit())
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权发布博客！");
		blogEntry.issue();
		blogEntryRepository.save(blogEntry);
		return blogEntry.id().key();
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
	public void modifyBlog(String aBlogId, String aTitle, String aContent, BlogAuthor aAuthor) throws Exception {
		BlogEntry blogEntry = blogEntryRepository.get(new BlogEntryId(aBlogId));

		if (!BlogEntryPermissionPolicy.hasModifyBlogPermission(blogEntry, aAuthor).isPermit())
			throw new Exception(aAuthor.name() + aAuthor.account() + ":你无权修改博客！");

		if (blogEntry != null) {
			Title title = new Title(aTitle);
			Content content = new Content(aContent);
			blogEntry.changeTitle(title);
			blogEntry.changeContent(content);
			blogEntryRepository.save(blogEntry);
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
	public BlogEntryData readBlog(String aBlogId, BlogReader aReader) throws Exception {
		BlogEntryId blogEntryId = new BlogEntryId(aBlogId);
		BlogEntry blogEntry = blogEntryRepository.get(blogEntryId);

		if (!BlogEntryPermissionPolicy.hasReadBlogPermission(blogEntry, aReader).isPermit())
			throw new Exception(aReader.name() + aReader.account() + ":你无权读取博客！");

		BlogEntryData blogEntryData = new BlogEntryData(blogEntry.id().key(), blogEntry.title().titleTxt(), blogEntry.content().contentTxt(),
				blogEntry.status().code());
		return blogEntryData;
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
	 * @throws BlogEntryStatusException
	 */
	// @Transactional
	public void lockBlog(String aBlogId) throws BlogEntryStatusException {
		BlogEntryId blogEntryId = new BlogEntryId(aBlogId);
		BlogEntry blogEntry = blogEntryRepository.get(blogEntryId);
		if (blogEntry != null) {
			blogEntry.lock();
			blogEntryRepository.save(blogEntry);
		}
	}

	/**
	 * 关闭博客
	 * 
	 * @param aBlogId
	 * @throws BlogEntryStatusException
	 */
	// @Transactional
	public void closeBlog(String aBlogId) throws BlogEntryStatusException {
		BlogEntryId blogEntryId = new BlogEntryId(aBlogId);
		BlogEntry blogEntry = blogEntryRepository.get(blogEntryId);
		if (blogEntry != null) {
			blogEntry.close();
			blogEntryRepository.save(blogEntry);
		}
	}

	/**
	 * 重开博客
	 * 
	 * @param aBlogId
	 * @throws BlogEntryStatusException
	 */
	// @Transactional
	public void reopenBlog(String aBlogId) throws BlogEntryStatusException {
		BlogEntryId blogEntryId = new BlogEntryId(aBlogId);
		BlogEntry blogEntry = blogEntryRepository.get(blogEntryId);
		if (blogEntry != null) {
			blogEntry.reopen();
			blogEntryRepository.save(blogEntry);
		}
	}

}
