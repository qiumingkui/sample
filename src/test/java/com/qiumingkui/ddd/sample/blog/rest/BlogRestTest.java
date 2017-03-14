package com.qiumingkui.ddd.sample.blog.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BlogRestTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetBlogById() throws Exception {
		// String title = "aTitle:" + new Date();
		// String content = "aContent:" + new Date();
		// String blogId = blogApplicationService.publishBlog(title, content);
		//
		// this.mockMvc.perform(get("/blog").param("id",
		// blogId)).andDo(print()).andExpect(status().isOk())
		// .andExpect(jsonPath("$.title").value(title));
		this.mockMvc.perform(get("/blog").param("id", "1")).andDo(print()).andExpect(status().isOk());
	}
}
