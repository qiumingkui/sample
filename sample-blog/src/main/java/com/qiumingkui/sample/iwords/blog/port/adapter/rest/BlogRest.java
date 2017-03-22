package com.qiumingkui.sample.iwords.blog.port.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiumingkui.sample.iwords.blog.application.BlogApplicationService;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogData;

@RestController
public class BlogRest {

	@Autowired
	private BlogApplicationService blogApplicationService;

	@RequestMapping("/blog")
	public BlogData getBlogById(@RequestParam(value = "id") String id) {
		BlogData blogData = null;
		// blogData = blogApplicationService.readBlog(id);
		return blogData;
	}

}
