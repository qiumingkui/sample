package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;

@Service
public class JdbcBlogRepository implements BlogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional(readOnly = true)
	public Blog get(BlogId blogId) {

		List<Blog> blogList = jdbcTemplate.query("SELECT * FROM blog WHERE id=?", new Object[] { blogId.id() },
				new BlogRowMapper());

		return blogList.size() > 0 ? blogList.get(0) : null;
	}

	@Override
	public BlogId genId() {
		return new BlogId(UUID.randomUUID().toString().toUpperCase());
	}

	@Override
	public void save(Blog blog) {

	}

	@Override
	public void del(Blog blog) {

	}

	class BlogRowMapper implements RowMapper<Blog> {
		@Override
		public Blog mapRow(ResultSet rs, int i) throws SQLException {
			BlogId blogId = new BlogId(rs.getString("id"));
			Title title = new Title(rs.getString("title"));
			Content content = new Content(rs.getString("content_txt"));
			Blog blog = new Blog(blogId, title, content);
			return blog;
		}
	}

}
