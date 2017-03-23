package com.qiumingkui.sample.iwords.blog.port.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiumingkui.sample.iwords.blog.application.PostApplicationService;
import com.qiumingkui.sample.iwords.blog.domain.model.post.PostData;

@RestController
public class PostRest {

	@Autowired
	private PostApplicationService postApplicationService;

	@RequestMapping("/blog")
	public PostData getBlogById(@RequestParam(value = "id") String id) {
		PostData postData = null;
		// blogData = blogApplicationService.readBlog(id);
		return postData;
	}

}
