package com.qiumingkui.sample.imedia.blog.port.adapter.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qiumingkui.sample.imedia.blog.application.BlogEntryApplicationService;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.helper.MemberTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BlogEntryRestTest {

	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private PersonRepository personRepository;

	@Autowired
	private BlogEntryApplicationService blogEntryApplicationService;

private BlogAuthor blogAuthor;

	private String aBlogId;

	@Before
	public void init() {
		blogAuthor = MemberTestHelper.buildAuthorExample(true);

		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		try {
			aBlogId = blogEntryApplicationService.publishBlog(title, content,blogAuthor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(aBlogId.isEmpty()).isFalse();
	}

	@Test
	public void testGetBlogById() throws Exception {
		// String title = "aTitle:" + new Date();
		// String content = "aContent:" + new Date();
		// String blogId = blogApplicationService.publishBlog(title, content);
		//
		// this.mockMvc.perform(get("/blog").param("id",
		// blogId)).andDo(print()).andExpect(status().isOk())
		// .andExpect(jsonPath("$.title").value(title));
		this.mockMvc.perform(get("/blog").param("id", aBlogId)).andDo(print()).andExpect(status().isOk());
	}
}
