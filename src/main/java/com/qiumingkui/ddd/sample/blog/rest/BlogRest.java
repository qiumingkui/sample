package com.qiumingkui.ddd.sample.blog.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiumingkui.ddd.sample.blog.application.BlogApplicationService;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogData;

@RestController
public class BlogRest {

	@Autowired
	private BlogApplicationService blogApplicationService;

	@RequestMapping("/blog")
	public BlogData getBlogById(@RequestParam(value = "id") String id) {
		BlogData blogData = blogApplicationService.findBlog(id);
		return blogData;
	}

}
