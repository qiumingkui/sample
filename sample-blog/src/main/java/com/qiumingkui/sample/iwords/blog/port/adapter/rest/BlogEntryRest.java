package com.qiumingkui.sample.iwords.blog.port.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiumingkui.sample.iwords.blog.application.BlogEntryApplicationService;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryData;

@RestController
public class BlogEntryRest {

	@Autowired
	private BlogEntryApplicationService blogEntryApplicationService;

	@RequestMapping("/blog")
	public BlogEntryData getBlogById(@RequestParam(value = "id") String id) {
		BlogEntryData blogEntryData = null;
		// blogData = blogApplicationService.readBlog(id);
		return blogEntryData;
	}

}
