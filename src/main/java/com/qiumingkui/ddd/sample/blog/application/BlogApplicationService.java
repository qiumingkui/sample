package com.qiumingkui.ddd.sample.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogBuilder;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogData;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.BlogRepository;

@Service
public class BlogApplicationService {

	@Autowired
	private BlogRepository blogRepository;

	@Transactional
	public String publishBlog(String aTitle, String aContent) {
		Blog blog = BlogBuilder.build( aTitle, aContent);
		blogRepository.save(blog);
		return blog.blogId().id();
	}

	@Transactional
	public void modifyBlog(String aBlogId, String aTitle, String aContent) {
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

	@Transactional
	public BlogData findBlog(String aBlogId){
		BlogId blogId = new BlogId(aBlogId);
		Blog blog = blogRepository.get(blogId);
		BlogData blogData = new BlogData(blog.blogId().id(),blog.title().titleTxt(),blog.content().contentTxt());
		return blogData;
	}
}
